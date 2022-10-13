package org.scalablytyped.converter.internal
package scalajs

import io.circe013.{Decoder, Encoder}

sealed trait Annotation extends Product with Serializable
sealed trait LocationAnnotation extends Annotation

sealed trait Imported
object Imported {
  case object Namespace extends Imported
  case object Default extends Imported
  case class Named(name: IArray[Name]) extends Imported

  implicit val encodes: Encoder[Imported] = io.circe013.generic.semiauto.deriveEncoder
  implicit val decodes: Decoder[Imported] = io.circe013.generic.semiauto.deriveDecoder
}

object Annotation {
  case object JsBracketAccess extends Annotation
  case object JsBracketCall extends Annotation
  case object JsNative extends Annotation
  case object ScalaJSDefined extends Annotation
  case object JsGlobalScope extends LocationAnnotation
  case object Inline extends Annotation
  case class TargetName(owner: Name, suffix: String) extends Annotation {
    def name =
      owner match {
        case Name.APPLY      => s"apply_$suffix"
        case Name.namespaced => s"_$suffix"
        case other           => s"${other.unescaped}_$suffix"
      }
  }

  case class JsName(name:       Name) extends Annotation
  case class JsNameSymbol(name: QualifiedName) extends Annotation
  case class JsImport(module:   String, imported: Imported, global: Option[JsGlobal]) extends LocationAnnotation
  case class JsGlobal(name:     QualifiedName) extends LocationAnnotation

  object JsGlobal {
    implicit val encodes: Encoder[JsGlobal] = io.circe013.generic.semiauto.deriveEncoder
    implicit val decodes: Decoder[JsGlobal] = io.circe013.generic.semiauto.deriveDecoder
  }

  def renamedFrom(newName: Name)(oldAnnotations: IArray[Annotation]): IArray[Annotation] = {
    val (names, targetNames, others) =
      oldAnnotations.partitionCollect2(
        {
          case x: JsName       => x
          case x: JsNameSymbol => x
          case x @ JsBracketCall => x
          case x: LocationAnnotation => x
        },
        { case x: TargetName => x },
      )

    val updatedTargetNames = targetNames.map {
      case Annotation.TargetName(_, suffix) => Annotation.TargetName(newName, suffix)
    }

    val updatedNames: IArray[Annotation] =
      (names, newName) match {
        case (Empty, n @ (Name.APPLY | Name.namespaced)) => sys.error(s"Cannot rename `$n`")
        case (Empty, old)                                => IArray(JsName(old))
        case (existing, _)                               => existing
      }

    others ++ updatedTargetNames ++ updatedNames
  }

  implicit lazy val encodes: Encoder[Annotation] = io.circe013.generic.semiauto.deriveEncoder
  implicit lazy val decodes: Decoder[Annotation] = io.circe013.generic.semiauto.deriveDecoder
}
