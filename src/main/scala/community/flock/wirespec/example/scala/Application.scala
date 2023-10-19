package community.flock.wirespec.example.scala

import community.flock.wirespec.example.scala.generated.{Tag, _}
import zio._
import zio.http._
import zio.json._

import java.lang.reflect.Type
import scala.language.higherKinds

trait PetStoreClient[F[_]] extends AddPet[F] with UpdatePet[F]


object Main extends ZIOAppDefault {

  implicit val petStatusCodec: JsonCodec[PetStatus] = JsonCodec[PetStatus](
    JsonEncoder[String].contramap[PetStatus](_.label),
    JsonDecoder[String].mapOrFail[PetStatus] {
      case PetStatus.SOLD.label => Right(PetStatus.SOLD)
      case PetStatus.PENDING.label => Right(PetStatus.SOLD)
      case PetStatus.AVAILABLE.label => Right(PetStatus.AVAILABLE)
      case _ => Left(s"Cannot map PetStatus")
    }
  )
  implicit val categoryCodec: JsonCodec[Category] = DeriveJsonCodec.gen[Category]
  implicit val tagCodec: JsonCodec[Tag] = DeriveJsonCodec.gen[Tag]
  implicit val petCodec: JsonCodec[Pet] = DeriveJsonCodec.gen[Pet]


  implicit def contentMapper[T: JsonCodec]: Wirespec.ContentMapper[String, T] = new Wirespec.ContentMapper[String, T] {
    override def read(content: Wirespec.Content[String], valueType: Type): Wirespec.Content[T] =
      content.body.fromJson[T].fold(str =>
        throw new IllegalArgumentException(str),
        body => Wirespec.Content[T](content.`type`, body))

    override def write(content: Wirespec.Content[T]): Wirespec.Content[String] = content.copy(body = content.body.toJson)
  }

  private def handle[Req <: Wirespec.Request[_], Res <: Wirespec.Response[_]](request: Req, mapper: (Int, Map[String, List[Any]], Wirespec.Content[String]) => Res): ZIO[Client, Throwable, Res] = {
    val url = "https://petstore3.swagger.io/api/v3"
    val method = Method.fromString(request.method.label)
    val content = request.content.body match {
      case pet: Pet => Wirespec.Content[String](request.content.`type`, pet.toJson)
    }
    val body = Body.fromString(content.body)
    val headers = Headers(Header.ContentType(MediaType.forContentType(content.`type`).orNull))
    val client = for {
      res <- Client.request(url + request.path, method, headers, body)
      data <- res.body.asString
      headers = res.headers.map(x => x.headerName -> List(x.renderedValue)).toMap
      content = res.headers.get("Content-Type").map(`type` => Wirespec.Content(`type`, data)).orNull
    } yield mapper(res.status.code, headers, content)
    client
  }

  private val client = new PetStoreClient[Task]() {
    override def addPet(request: AddPet.Request[_]): Task[AddPet.Response[_]] = handle(request, AddPet.RESPONSE_MAPPER[String]).provide(Client.default)
    override def updatePet(request: UpdatePet.Request[_]): Task[UpdatePet.Response[_]] = handle(request, UpdatePet.RESPONSE_MAPPER[String]).provide(Client.default)
  }

  override val run = {
    val random = new scala.util.Random()
    val pet = Pet(
      id = Option.apply(random.nextInt(1000000)),
      name = "Test Diertje",
      photoUrls = List(),
      category = Option.empty,
      tags = Option.empty,
      status = Option.apply(PetStatus.AVAILABLE)
    )
    val req = new AddPet.RequestApplicationJson(pet)

    val res: ZIO[Any, Throwable, Pet] = client.addPet(req).map {
      case req: AddPet.Response200ApplicationJson => req.content.body
      case req: AddPet.Response200ApplicationXml => throw new IllegalArgumentException()
      case req: AddPet.Response405Unit => throw new IllegalArgumentException()
    }

    res.map(x => println(x))
  }
}
