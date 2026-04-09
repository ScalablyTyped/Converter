package org.scalablytyped.converter.internal

import io.circe.{Decoder, Encoder}
import org.scalablytyped.converter.internal.scalajs.{ExprTree, QualifiedName, TypeRef}
import org.scalablytyped.converter.internal.ts.TsIdentModule

sealed trait Comment

/* We need a few pieces of out of band information bundled within the tree,
  to be used like annotations. Instead of actually inventing annotations on
  the typescript side we rather just work with special comments.
 */
sealed trait Marker extends Comment

object Marker {
  case object CouldBeScalaJsDefined extends Marker
  case object IsTrivial extends Marker
  case object ExpandedCallables extends Marker
  case object ExpandedClass extends Marker
  case object EnumObject extends Marker
  case object HasClassParent extends Marker

  case class NameHint(value:        String) extends Marker
  case class ModuleAliases(aliases: IArray[TsIdentModule]) extends Marker
  case class WasLiteral(lit:        ExprTree.Lit) extends Marker
  case class WasUnion(related:      IArray[TypeRef]) extends Marker

  /* Disable the minimizer for object with this marker */
  final case class MinimizationKeep(related: IArray[TypeRef]) extends Marker

  /* Similar to above, but it's conditional. If the object with this marker is included, only then include the related objects as well */
  final case class MinimizationRelated(related: IArray[TypeRef]) extends Marker

  case class WasDefaulted(among: Set[QualifiedName]) extends Marker

  case object ManglerLeaveAlone extends Marker
  case object ManglerWasJsNative extends Marker
}

object Comment {
  final case class Raw(raw: String) extends Comment

  def apply(raw: String): Comment = Comment.Raw(raw)

  def warning(s: String)(implicit e: sourcecode.Enclosing): Comment =
    Comment(s"/* import warning: ${e.value.split("\\.").takeRight(2).mkString(".")} $s */")

  implicit lazy val encodes: Encoder[Comment] = io.circe.generic.semiauto.deriveEncoder
  implicit lazy val decodes: Decoder[Comment] = io.circe.generic.semiauto.deriveDecoder
}
