package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.maps._
import org.scalablytyped.converter.internal.scalajs.flavours.SlinkyWeb.{CombinedTag, TagName}

final class SlinkyWeb(val reactNames: ReactNames, val tags: Map[TagName, CombinedTag]) {
  val tagsByStdRef: Map[TypeRef, IArray[CombinedTag]] =
    tags.groupBy(_._2.stdRef).map { case (stdRef, maps) => stdRef -> maps.toIArrayValues }

  val uniqueTagsByStdRef: Map[TypeRef, CombinedTag] =
    tagsByStdRef.collect {
      case (tr, IArray.exactlyOne(ct)) => tr -> ct
    }
}

object SlinkyWeb {
  /* either `a`, `div` and so on, or unspecified (`Any`) */
  sealed trait TagName {
    def asName: Name =
      this match {
        case TagName.Concrete(value) => Name(value)
        case TagName.Any             => Name("*")
      }
  }

  object TagName {
    def apply(name:   Name) = Concrete(name.unescaped)
    def unapply(name: Name): Some[Concrete] = Some(apply(name))

    case class Concrete(value: String) extends TagName
    case object Any extends TagName
  }

  /* info about a react tag which exists both in typescript and in slinky */
  case class CombinedTag(tagName: TagName, slinkyTagRef: TypeRef, stdRef: TypeRef, attributes: Map[Name, TypeRef])
}
