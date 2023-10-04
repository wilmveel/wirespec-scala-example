package community.flock.wirespec.example.scala.generated

import java.lang.reflect.Type
import java.lang.reflect.ParameterizedType

object Wirespec {
  sealed abstract class Method(val label: String)
  object Method {
    final case object GET extends Method(label = "GET")
    final case object PUT extends Method(label = "PUT")
    final case object POST extends Method(label = "POST")
    final case object DELETE extends Method(label = "DELETE")
    final case object OPTIONS extends Method(label = "OPTIONS")
    final case object HEAD extends Method(label = "HEAD")
    final case object PATCH extends Method(label = "PATCH")
    final case object TRACE extends Method(label = "TRACE")
  }

  case class Content[T] (`type`:String, body:T )
  trait Request[T] { val path:String; val method: Method; val query: Map[String, List[Any]]; val headers: Map[String, List[Any]]; val content:Content[T] }
  trait Response[T] { val status: Int; val headers: Map[String, List[Any]]; val content:Content[T] }
  trait ContentMapper[B, T] { def read(content: Content[B], valueType: Type): Content[T]; def write(content: Content[T]): Content[B] }
  def getType(`type`: Class[_], isIterable: Boolean): Type = {
    if (isIterable) {
      new ParameterizedType {
        override def getRawType():Class[List[_]] = classOf[List[_]]
        override def getActualTypeArguments():Array[Type] = Array(`type`)
        override def getOwnerType() = null
      }
    } else {
      `type`
    }
  }
}