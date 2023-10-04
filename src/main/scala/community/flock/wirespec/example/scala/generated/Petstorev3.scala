package community.flock.wirespec.example.scala.generated

import scala.language.higherKinds

trait AddPet[F[_]] {
  def addPet(request: AddPet.Request[_]): F[AddPet.Response[_]]
}
object AddPet {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestApplicationJson(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Pet]) extends Request[Pet] { def this(body: Pet){ this(path = "/pet", method = Wirespec.Method.POST, query = Map(), headers = Map(), content = Wirespec.Content("application/json", body))}}
  class RequestApplicationXml(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Pet]) extends Request[Pet] { def this(body: Pet){ this(path = "/pet", method = Wirespec.Method.POST, query = Map(), headers = Map(), content = Wirespec.Content("application/xml", body))}}
  class RequestApplicationXWwwFormUrlencoded(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Pet]) extends Request[Pet] { def this(body: Pet){ this(path = "/pet", method = Wirespec.Method.POST, query = Map(), headers = Map(), content = Wirespec.Content("application/x-www-form-urlencoded", body))}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait Response2XX[T] extends Response[T]
  sealed trait Response4XX[T] extends Response[T]
  sealed trait Response200[T] extends Response2XX[T]
  sealed trait Response405[T] extends Response4XX[T]
  class Response200ApplicationXml (override val headers: Map[String, List[Any]], body: Pet ) extends Response200[Pet] { override val status = 200; override val content = Wirespec.Content("application/xml", body)}
  class Response200ApplicationJson (override val headers: Map[String, List[Any]], body: Pet ) extends Response200[Pet] { override val status = 200; override val content = Wirespec.Content("application/json", body)}
  class Response405Unit (override val headers: Map[String, List[Any]] ) extends Response405[Unit] { override val status = 405; override val content = null}

  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B])( implicit contentMapper: Wirespec.ContentMapper[B, Pet] ) =
    (status, content.`type`) match {
      case (200, "application/xml") => {
        new Response200ApplicationXml(headers, contentMapper.read(content, Wirespec.getType(classOf[Pet], false)).body)
      }
      case (200, "application/json") => {
        new Response200ApplicationJson(headers, contentMapper.read(content, Wirespec.getType(classOf[Pet], false)).body)
      }
      case (405, null) => new Response405Unit(headers)

      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

trait UpdatePet[F[_]] {
  def updatePet(request: UpdatePet.Request[_]): F[UpdatePet.Response[_]]
}
object UpdatePet {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestApplicationJson(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Pet]) extends Request[Pet] { def this(body: Pet){ this(path = "/pet", method = Wirespec.Method.PUT, query = Map(), headers = Map(), content = Wirespec.Content("application/json", body))}}
  class RequestApplicationXml(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Pet]) extends Request[Pet] { def this(body: Pet){ this(path = "/pet", method = Wirespec.Method.PUT, query = Map(), headers = Map(), content = Wirespec.Content("application/xml", body))}}
  class RequestApplicationXWwwFormUrlencoded(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Pet]) extends Request[Pet] { def this(body: Pet){ this(path = "/pet", method = Wirespec.Method.PUT, query = Map(), headers = Map(), content = Wirespec.Content("application/x-www-form-urlencoded", body))}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait Response2XX[T] extends Response[T]
  sealed trait Response4XX[T] extends Response[T]
  sealed trait Response200[T] extends Response2XX[T]
  sealed trait Response400[T] extends Response4XX[T]
  sealed trait Response404[T] extends Response4XX[T]
  sealed trait Response405[T] extends Response4XX[T]
  class Response200ApplicationXml (override val headers: Map[String, List[Any]], body: Pet ) extends Response200[Pet] { override val status = 200; override val content = Wirespec.Content("application/xml", body)}
  class Response200ApplicationJson (override val headers: Map[String, List[Any]], body: Pet ) extends Response200[Pet] { override val status = 200; override val content = Wirespec.Content("application/json", body)}
  class Response400Unit (override val headers: Map[String, List[Any]] ) extends Response400[Unit] { override val status = 400; override val content = null}
  class Response404Unit (override val headers: Map[String, List[Any]] ) extends Response404[Unit] { override val status = 404; override val content = null}
  class Response405Unit (override val headers: Map[String, List[Any]] ) extends Response405[Unit] { override val status = 405; override val content = null}

  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B])( implicit contentMapper: Wirespec.ContentMapper[B, Pet] ) =
    (status, content.`type`) match {
      case (200, "application/xml") => {
        new Response200ApplicationXml(headers, contentMapper.read(content, Wirespec.getType(classOf[Pet], false)).body)
      }
      case (200, "application/json") => {
        new Response200ApplicationJson(headers, contentMapper.read(content, Wirespec.getType(classOf[Pet], false)).body)
      }
      case (400, null) => new Response400Unit(headers)
      case (404, null) => new Response404Unit(headers)
      case (405, null) => new Response405Unit(headers)

      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

trait FindPetsByStatus[F[_]] {
  def findPetsByStatus(request: FindPetsByStatus.Request[_]): F[FindPetsByStatus.Response[_]]
}
object FindPetsByStatus {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestUnit(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Unit]) extends Request[Unit] { def this(status: Option[FindPetsByStatusParameterStatus]){ this(path = "/pet/findByStatus", method = Wirespec.Method.GET, query = Map("status" -> List(status)), headers = Map(), content = null)}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait Response2XX[T] extends Response[T]
  sealed trait Response4XX[T] extends Response[T]
  sealed trait Response200[T] extends Response2XX[T]
  sealed trait Response400[T] extends Response4XX[T]
  class Response200ApplicationXml (override val headers: Map[String, List[Any]], body: List[Pet] ) extends Response200[List[Pet]] { override val status = 200; override val content = Wirespec.Content("application/xml", body)}
  class Response200ApplicationJson (override val headers: Map[String, List[Any]], body: List[Pet] ) extends Response200[List[Pet]] { override val status = 200; override val content = Wirespec.Content("application/json", body)}
  class Response400Unit (override val headers: Map[String, List[Any]] ) extends Response400[Unit] { override val status = 400; override val content = null}

  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B])( implicit contentMapper: Wirespec.ContentMapper[B, List[Pet]] ) =
    (status, content.`type`) match {
      case (200, "application/xml") => {
        new Response200ApplicationXml(headers, contentMapper.read(content, Wirespec.getType(classOf[Pet], true)).body)
      }
      case (200, "application/json") => {
        new Response200ApplicationJson(headers, contentMapper.read(content, Wirespec.getType(classOf[Pet], true)).body)
      }
      case (400, null) => new Response400Unit(headers)

      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

trait FindPetsByTags[F[_]] {
  def findPetsByTags(request: FindPetsByTags.Request[_]): F[FindPetsByTags.Response[_]]
}
object FindPetsByTags {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestUnit(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Unit]) extends Request[Unit] { def this(tags: Option[List[String]]){ this(path = "/pet/findByTags", method = Wirespec.Method.GET, query = Map("tags" -> List(tags)), headers = Map(), content = null)}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait Response2XX[T] extends Response[T]
  sealed trait Response4XX[T] extends Response[T]
  sealed trait Response200[T] extends Response2XX[T]
  sealed trait Response400[T] extends Response4XX[T]
  class Response200ApplicationXml (override val headers: Map[String, List[Any]], body: List[Pet] ) extends Response200[List[Pet]] { override val status = 200; override val content = Wirespec.Content("application/xml", body)}
  class Response200ApplicationJson (override val headers: Map[String, List[Any]], body: List[Pet] ) extends Response200[List[Pet]] { override val status = 200; override val content = Wirespec.Content("application/json", body)}
  class Response400Unit (override val headers: Map[String, List[Any]] ) extends Response400[Unit] { override val status = 400; override val content = null}

  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B])( implicit contentMapper: Wirespec.ContentMapper[B, List[Pet]] ) =
    (status, content.`type`) match {
      case (200, "application/xml") => {
        new Response200ApplicationXml(headers, contentMapper.read(content, Wirespec.getType(classOf[Pet], true)).body)
      }
      case (200, "application/json") => {
        new Response200ApplicationJson(headers, contentMapper.read(content, Wirespec.getType(classOf[Pet], true)).body)
      }
      case (400, null) => new Response400Unit(headers)

      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

trait GetPetById[F[_]] {
  def getPetById(request: GetPetById.Request[_]): F[GetPetById.Response[_]]
}
object GetPetById {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestUnit(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Unit]) extends Request[Unit] { def this(petId: Int){ this(path = "/pet/${petId}", method = Wirespec.Method.GET, query = Map(), headers = Map(), content = null)}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait Response2XX[T] extends Response[T]
  sealed trait Response4XX[T] extends Response[T]
  sealed trait Response200[T] extends Response2XX[T]
  sealed trait Response400[T] extends Response4XX[T]
  sealed trait Response404[T] extends Response4XX[T]
  class Response200ApplicationXml (override val headers: Map[String, List[Any]], body: Pet ) extends Response200[Pet] { override val status = 200; override val content = Wirespec.Content("application/xml", body)}
  class Response200ApplicationJson (override val headers: Map[String, List[Any]], body: Pet ) extends Response200[Pet] { override val status = 200; override val content = Wirespec.Content("application/json", body)}
  class Response400Unit (override val headers: Map[String, List[Any]] ) extends Response400[Unit] { override val status = 400; override val content = null}
  class Response404Unit (override val headers: Map[String, List[Any]] ) extends Response404[Unit] { override val status = 404; override val content = null}

  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B])( implicit contentMapper: Wirespec.ContentMapper[B, Pet] ) =
    (status, content.`type`) match {
      case (200, "application/xml") => {
        new Response200ApplicationXml(headers, contentMapper.read(content, Wirespec.getType(classOf[Pet], false)).body)
      }
      case (200, "application/json") => {
        new Response200ApplicationJson(headers, contentMapper.read(content, Wirespec.getType(classOf[Pet], false)).body)
      }
      case (400, null) => new Response400Unit(headers)
      case (404, null) => new Response404Unit(headers)

      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

trait UpdatePetWithForm[F[_]] {
  def updatePetWithForm(request: UpdatePetWithForm.Request[_]): F[UpdatePetWithForm.Response[_]]
}
object UpdatePetWithForm {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestUnit(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Unit]) extends Request[Unit] { def this(petId: Int, name: Option[String], status: Option[String]){ this(path = "/pet/${petId}", method = Wirespec.Method.POST, query = Map("name" -> List(name), "status" -> List(status)), headers = Map(), content = null)}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait Response4XX[T] extends Response[T]
  sealed trait Response405[T] extends Response4XX[T]
  class Response405Unit (override val headers: Map[String, List[Any]] ) extends Response405[Unit] { override val status = 405; override val content = null}

  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B]) =
    (status, content.`type`) match {
      case (405, null) => new Response405Unit(headers)

      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

trait DeletePet[F[_]] {
  def deletePet(request: DeletePet.Request[_]): F[DeletePet.Response[_]]
}
object DeletePet {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestUnit(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Unit]) extends Request[Unit] { def this(petId: Int, api_key: Option[String]){ this(path = "/pet/${petId}", method = Wirespec.Method.DELETE, query = Map(), headers = Map("api_key" -> List(api_key)), content = null)}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait Response4XX[T] extends Response[T]
  sealed trait Response400[T] extends Response4XX[T]
  class Response400Unit (override val headers: Map[String, List[Any]] ) extends Response400[Unit] { override val status = 400; override val content = null}

  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B]) =
    (status, content.`type`) match {
      case (400, null) => new Response400Unit(headers)

      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

trait UploadFile[F[_]] {
  def uploadFile(request: UploadFile.Request[_]): F[UploadFile.Response[_]]
}
object UploadFile {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestApplicationOctetStream(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[String]) extends Request[String] { def this(petId: Int, additionalMetadata: Option[String], body: String){ this(path = "/pet/${petId}/uploadImage", method = Wirespec.Method.POST, query = Map("additionalMetadata" -> List(additionalMetadata)), headers = Map(), content = Wirespec.Content("application/octet-stream", body))}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait Response2XX[T] extends Response[T]
  sealed trait Response200[T] extends Response2XX[T]
  class Response200ApplicationJson (override val headers: Map[String, List[Any]], body: ApiResponse ) extends Response200[ApiResponse] { override val status = 200; override val content = Wirespec.Content("application/json", body)}

  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B])( implicit contentMapper: Wirespec.ContentMapper[B, ApiResponse] ) =
    (status, content.`type`) match {
      case (200, "application/json") => {
        new Response200ApplicationJson(headers, contentMapper.read(content, Wirespec.getType(classOf[ApiResponse], false)).body)
      }

      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

trait GetInventory[F[_]] {
  def getInventory(request: GetInventory.Request[_]): F[GetInventory.Response[_]]
}
object GetInventory {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestUnit(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Unit]) extends Request[Unit] { def this(){ this(path = "/store/inventory", method = Wirespec.Method.GET, query = Map(), headers = Map(), content = null)}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait Response2XX[T] extends Response[T]
  sealed trait Response200[T] extends Response2XX[T]
  class Response200ApplicationJson (override val headers: Map[String, List[Any]], body: Map[String, Int] ) extends Response200[Map[String, Int]] { override val status = 200; override val content = Wirespec.Content("application/json", body)}

  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B])( implicit contentMapper: Wirespec.ContentMapper[B, Map[String, Int]] ) =
    (status, content.`type`) match {
      case (200, "application/json") => {
        new Response200ApplicationJson(headers, contentMapper.read(content, Wirespec.getType(classOf[Int], false)).body)
      }

      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

trait PlaceOrder[F[_]] {
  def placeOrder(request: PlaceOrder.Request[_]): F[PlaceOrder.Response[_]]
}
object PlaceOrder {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestApplicationJson(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Order]) extends Request[Order] { def this(body: Order){ this(path = "/store/order", method = Wirespec.Method.POST, query = Map(), headers = Map(), content = Wirespec.Content("application/json", body))}}
  class RequestApplicationXml(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Order]) extends Request[Order] { def this(body: Order){ this(path = "/store/order", method = Wirespec.Method.POST, query = Map(), headers = Map(), content = Wirespec.Content("application/xml", body))}}
  class RequestApplicationXWwwFormUrlencoded(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Order]) extends Request[Order] { def this(body: Order){ this(path = "/store/order", method = Wirespec.Method.POST, query = Map(), headers = Map(), content = Wirespec.Content("application/x-www-form-urlencoded", body))}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait Response2XX[T] extends Response[T]
  sealed trait Response4XX[T] extends Response[T]
  sealed trait Response200[T] extends Response2XX[T]
  sealed trait Response405[T] extends Response4XX[T]
  class Response200ApplicationJson (override val headers: Map[String, List[Any]], body: Order ) extends Response200[Order] { override val status = 200; override val content = Wirespec.Content("application/json", body)}
  class Response405Unit (override val headers: Map[String, List[Any]] ) extends Response405[Unit] { override val status = 405; override val content = null}

  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B])( implicit contentMapper: Wirespec.ContentMapper[B, Order] ) =
    (status, content.`type`) match {
      case (200, "application/json") => {
        new Response200ApplicationJson(headers, contentMapper.read(content, Wirespec.getType(classOf[Order], false)).body)
      }
      case (405, null) => new Response405Unit(headers)

      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

trait GetOrderById[F[_]] {
  def getOrderById(request: GetOrderById.Request[_]): F[GetOrderById.Response[_]]
}
object GetOrderById {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestUnit(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Unit]) extends Request[Unit] { def this(orderId: Int){ this(path = "/store/order/${orderId}", method = Wirespec.Method.GET, query = Map(), headers = Map(), content = null)}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait Response2XX[T] extends Response[T]
  sealed trait Response4XX[T] extends Response[T]
  sealed trait Response200[T] extends Response2XX[T]
  sealed trait Response400[T] extends Response4XX[T]
  sealed trait Response404[T] extends Response4XX[T]
  class Response200ApplicationXml (override val headers: Map[String, List[Any]], body: Order ) extends Response200[Order] { override val status = 200; override val content = Wirespec.Content("application/xml", body)}
  class Response200ApplicationJson (override val headers: Map[String, List[Any]], body: Order ) extends Response200[Order] { override val status = 200; override val content = Wirespec.Content("application/json", body)}
  class Response400Unit (override val headers: Map[String, List[Any]] ) extends Response400[Unit] { override val status = 400; override val content = null}
  class Response404Unit (override val headers: Map[String, List[Any]] ) extends Response404[Unit] { override val status = 404; override val content = null}

  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B])( implicit contentMapper: Wirespec.ContentMapper[B, Order] ) =
    (status, content.`type`) match {
      case (200, "application/xml") => {
        new Response200ApplicationXml(headers, contentMapper.read(content, Wirespec.getType(classOf[Order], false)).body)
      }
      case (200, "application/json") => {
        new Response200ApplicationJson(headers, contentMapper.read(content, Wirespec.getType(classOf[Order], false)).body)
      }
      case (400, null) => new Response400Unit(headers)
      case (404, null) => new Response404Unit(headers)

      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

trait DeleteOrder[F[_]] {
  def deleteOrder(request: DeleteOrder.Request[_]): F[DeleteOrder.Response[_]]
}
object DeleteOrder {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestUnit(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Unit]) extends Request[Unit] { def this(orderId: Int){ this(path = "/store/order/${orderId}", method = Wirespec.Method.DELETE, query = Map(), headers = Map(), content = null)}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait Response4XX[T] extends Response[T]
  sealed trait Response400[T] extends Response4XX[T]
  sealed trait Response404[T] extends Response4XX[T]
  class Response400Unit (override val headers: Map[String, List[Any]] ) extends Response400[Unit] { override val status = 400; override val content = null}
  class Response404Unit (override val headers: Map[String, List[Any]] ) extends Response404[Unit] { override val status = 404; override val content = null}

  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B]) =
    (status, content.`type`) match {
      case (400, null) => new Response400Unit(headers)
      case (404, null) => new Response404Unit(headers)

      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

trait CreateUser[F[_]] {
  def createUser(request: CreateUser.Request[_]): F[CreateUser.Response[_]]
}
object CreateUser {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestApplicationJson(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[User]) extends Request[User] { def this(body: User){ this(path = "/user", method = Wirespec.Method.POST, query = Map(), headers = Map(), content = Wirespec.Content("application/json", body))}}
  class RequestApplicationXml(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[User]) extends Request[User] { def this(body: User){ this(path = "/user", method = Wirespec.Method.POST, query = Map(), headers = Map(), content = Wirespec.Content("application/xml", body))}}
  class RequestApplicationXWwwFormUrlencoded(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[User]) extends Request[User] { def this(body: User){ this(path = "/user", method = Wirespec.Method.POST, query = Map(), headers = Map(), content = Wirespec.Content("application/x-www-form-urlencoded", body))}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait ResponseDefault[T] extends Response[T]


  class ResponseDefaultApplicationJson (override val status: Int, override val headers: Map[String, List[Any]], body: User ) extends ResponseDefault[User] { override val content = Wirespec.Content("application/json", body)}
  class ResponseDefaultApplicationXml (override val status: Int, override val headers: Map[String, List[Any]], body: User ) extends ResponseDefault[User] { override val content = Wirespec.Content("application/xml", body)}
  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B])( implicit contentMapper: Wirespec.ContentMapper[B, User] ) =
    (status, content.`type`) match {

      case (_, "application/json") => {
        new ResponseDefaultApplicationJson(status, headers, contentMapper.read(content, Wirespec.getType(classOf[User], false)).body)
      }
      case (_, "application/xml") => {
        new ResponseDefaultApplicationXml(status, headers, contentMapper.read(content, Wirespec.getType(classOf[User], false)).body)
      }
      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

trait CreateUsersWithListInput[F[_]] {
  def createUsersWithListInput(request: CreateUsersWithListInput.Request[_]): F[CreateUsersWithListInput.Response[_]]
}
object CreateUsersWithListInput {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestApplicationJson(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[List[User]]) extends Request[List[User]] { def this(body: List[User]){ this(path = "/user/createWithList", method = Wirespec.Method.POST, query = Map(), headers = Map(), content = Wirespec.Content("application/json", body))}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait Response2XX[T] extends Response[T]
  sealed trait ResponseDefault[T] extends Response[T]
  sealed trait Response200[T] extends Response2XX[T]
  class Response200ApplicationXml (override val headers: Map[String, List[Any]], body: User ) extends Response200[User] { override val status = 200; override val content = Wirespec.Content("application/xml", body)}
  class Response200ApplicationJson (override val headers: Map[String, List[Any]], body: User ) extends Response200[User] { override val status = 200; override val content = Wirespec.Content("application/json", body)}
  class ResponseDefaultUnit (override val status: Int, override val headers: Map[String, List[Any]] ) extends ResponseDefault[Unit] { override val content = null}
  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B])( implicit contentMapper: Wirespec.ContentMapper[B, User] ) =
    (status, content.`type`) match {
      case (200, "application/xml") => {
        new Response200ApplicationXml(headers, contentMapper.read(content, Wirespec.getType(classOf[User], false)).body)
      }
      case (200, "application/json") => {
        new Response200ApplicationJson(headers, contentMapper.read(content, Wirespec.getType(classOf[User], false)).body)
      }
      case (_, null) => new ResponseDefaultUnit(status, headers)
      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

trait LoginUser[F[_]] {
  def loginUser(request: LoginUser.Request[_]): F[LoginUser.Response[_]]
}
object LoginUser {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestUnit(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Unit]) extends Request[Unit] { def this(username: Option[String], password: Option[String]){ this(path = "/user/login", method = Wirespec.Method.GET, query = Map("username" -> List(username), "password" -> List(password)), headers = Map(), content = null)}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait Response2XX[T] extends Response[T]
  sealed trait Response4XX[T] extends Response[T]
  sealed trait Response200[T] extends Response2XX[T]
  sealed trait Response400[T] extends Response4XX[T]
  class Response200ApplicationXml (override val headers: Map[String, List[Any]], body: String ) extends Response200[String] { override val status = 200; override val content = Wirespec.Content("application/xml", body)}
  class Response200ApplicationJson (override val headers: Map[String, List[Any]], body: String ) extends Response200[String] { override val status = 200; override val content = Wirespec.Content("application/json", body)}
  class Response400Unit (override val headers: Map[String, List[Any]] ) extends Response400[Unit] { override val status = 400; override val content = null}

  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B])( implicit contentMapper: Wirespec.ContentMapper[B, String] ) =
    (status, content.`type`) match {
      case (200, "application/xml") => {
        new Response200ApplicationXml(headers, contentMapper.read(content, Wirespec.getType(classOf[String], false)).body)
      }
      case (200, "application/json") => {
        new Response200ApplicationJson(headers, contentMapper.read(content, Wirespec.getType(classOf[String], false)).body)
      }
      case (400, null) => new Response400Unit(headers)

      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

trait LogoutUser[F[_]] {
  def logoutUser(request: LogoutUser.Request[_]): F[LogoutUser.Response[_]]
}
object LogoutUser {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestUnit(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Unit]) extends Request[Unit] { def this(){ this(path = "/user/logout", method = Wirespec.Method.GET, query = Map(), headers = Map(), content = null)}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait ResponseDefault[T] extends Response[T]


  class ResponseDefaultUnit (override val status: Int, override val headers: Map[String, List[Any]] ) extends ResponseDefault[Unit] { override val content = null}
  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B]) =
    (status, content.`type`) match {

      case (_, null) => new ResponseDefaultUnit(status, headers)
      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

trait GetUserByName[F[_]] {
  def getUserByName(request: GetUserByName.Request[_]): F[GetUserByName.Response[_]]
}
object GetUserByName {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestUnit(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Unit]) extends Request[Unit] { def this(username: String){ this(path = "/user/${username}", method = Wirespec.Method.GET, query = Map(), headers = Map(), content = null)}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait Response2XX[T] extends Response[T]
  sealed trait Response4XX[T] extends Response[T]
  sealed trait Response200[T] extends Response2XX[T]
  sealed trait Response400[T] extends Response4XX[T]
  sealed trait Response404[T] extends Response4XX[T]
  class Response200ApplicationXml (override val headers: Map[String, List[Any]], body: User ) extends Response200[User] { override val status = 200; override val content = Wirespec.Content("application/xml", body)}
  class Response200ApplicationJson (override val headers: Map[String, List[Any]], body: User ) extends Response200[User] { override val status = 200; override val content = Wirespec.Content("application/json", body)}
  class Response400Unit (override val headers: Map[String, List[Any]] ) extends Response400[Unit] { override val status = 400; override val content = null}
  class Response404Unit (override val headers: Map[String, List[Any]] ) extends Response404[Unit] { override val status = 404; override val content = null}

  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B])( implicit contentMapper: Wirespec.ContentMapper[B, User] ) =
    (status, content.`type`) match {
      case (200, "application/xml") => {
        new Response200ApplicationXml(headers, contentMapper.read(content, Wirespec.getType(classOf[User], false)).body)
      }
      case (200, "application/json") => {
        new Response200ApplicationJson(headers, contentMapper.read(content, Wirespec.getType(classOf[User], false)).body)
      }
      case (400, null) => new Response400Unit(headers)
      case (404, null) => new Response404Unit(headers)

      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

trait UpdateUser[F[_]] {
  def updateUser(request: UpdateUser.Request[_]): F[UpdateUser.Response[_]]
}
object UpdateUser {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestApplicationJson(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[User]) extends Request[User] { def this(username: String, body: User){ this(path = "/user/${username}", method = Wirespec.Method.PUT, query = Map(), headers = Map(), content = Wirespec.Content("application/json", body))}}
  class RequestApplicationXml(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[User]) extends Request[User] { def this(username: String, body: User){ this(path = "/user/${username}", method = Wirespec.Method.PUT, query = Map(), headers = Map(), content = Wirespec.Content("application/xml", body))}}
  class RequestApplicationXWwwFormUrlencoded(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[User]) extends Request[User] { def this(username: String, body: User){ this(path = "/user/${username}", method = Wirespec.Method.PUT, query = Map(), headers = Map(), content = Wirespec.Content("application/x-www-form-urlencoded", body))}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait ResponseDefault[T] extends Response[T]


  class ResponseDefaultUnit (override val status: Int, override val headers: Map[String, List[Any]] ) extends ResponseDefault[Unit] { override val content = null}
  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B]) =
    (status, content.`type`) match {

      case (_, null) => new ResponseDefaultUnit(status, headers)
      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

trait DeleteUser[F[_]] {
  def deleteUser(request: DeleteUser.Request[_]): F[DeleteUser.Response[_]]
}
object DeleteUser {
  sealed trait Request[T] extends Wirespec.Request[T]
  class RequestUnit(override val path:String, override val method: Wirespec.Method, override val query: Map[String, List[Any]], override val headers: Map[String, List[Any]], override val content:Wirespec.Content[Unit]) extends Request[Unit] { def this(username: String){ this(path = "/user/${username}", method = Wirespec.Method.DELETE, query = Map(), headers = Map(), content = null)}}
  sealed trait Response[T] extends Wirespec.Response[T]
  sealed trait Response4XX[T] extends Response[T]
  sealed trait Response400[T] extends Response4XX[T]
  sealed trait Response404[T] extends Response4XX[T]
  class Response400Unit (override val headers: Map[String, List[Any]] ) extends Response400[Unit] { override val status = 400; override val content = null}
  class Response404Unit (override val headers: Map[String, List[Any]] ) extends Response404[Unit] { override val status = 404; override val content = null}

  def RESPONSE_MAPPER[B](status: Int, headers:Map[String, List[Any]], content: Wirespec.Content[B]) =
    (status, content.`type`) match {
      case (400, null) => new Response400Unit(headers)
      case (404, null) => new Response404Unit(headers)

      case _ => throw new Exception(s"Cannot map response with status $status")
    }
}

sealed abstract class FindPetsByStatusParameterStatus(val label: String)
object FindPetsByStatusParameterStatus {
  final case object AVAILABLE extends FindPetsByStatusParameterStatus(label = "available")
  final case object PENDING extends FindPetsByStatusParameterStatus(label = "pending")
  final case object SOLD extends FindPetsByStatusParameterStatus(label = "sold")
}

case class Order(
                  val id: Option[Int],
                  val petId: Option[Int],
                  val quantity: Option[Int],
                  val shipDate: Option[String],
                  val status: Option[OrderStatus],
                  val complete: Option[Boolean]
                )


sealed abstract class OrderStatus(val label: String)
object OrderStatus {
  final case object PLACED extends OrderStatus(label = "placed")
  final case object APPROVED extends OrderStatus(label = "approved")
  final case object DELIVERED extends OrderStatus(label = "delivered")
}

case class Customer(
                     val id: Option[Int],
                     val username: Option[String],
                     val address: Option[List[Address]]
                   )


case class Address(
                    val street: Option[String],
                    val city: Option[String],
                    val state: Option[String],
                    val zip: Option[String]
                  )


case class Category(
                     val id: Option[Int],
                     val name: Option[String]
                   )


case class User(
                 val id: Option[Int],
                 val username: Option[String],
                 val firstName: Option[String],
                 val lastName: Option[String],
                 val email: Option[String],
                 val password: Option[String],
                 val phone: Option[String],
                 val userStatus: Option[Int]
               )


case class Tag(
                val id: Option[Int],
                val name: Option[String]
              )


case class Pet(
                val id: Option[Int],
                val name: String,
                val category: Option[Category],
                val photoUrls: List[String],
                val tags: Option[List[Tag]],
                val status: Option[PetStatus]
              )


sealed abstract class PetStatus(val label: String)
object PetStatus {
  final case object AVAILABLE extends PetStatus(label = "available")
  final case object PENDING extends PetStatus(label = "pending")
  final case object SOLD extends PetStatus(label = "sold")
}

case class ApiResponse(
                        val code: Option[Int],
                        val `type`: Option[String],
                        val message: Option[String]
                      )

