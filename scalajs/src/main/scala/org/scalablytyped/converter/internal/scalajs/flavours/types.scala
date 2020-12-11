package org.scalablytyped.converter.internal
package scalajs
package flavours

sealed trait ComponentType

object ComponentType {
  case object Class extends ComponentType
  case object Function extends ComponentType
  case object Field extends ComponentType
  case object Intrinsic extends ComponentType
}

case class PropsRef(ref: TypeRef) extends AnyVal

final case class Component(
    location:      Either[ExprTree.StringLit, LocationAnnotation],
    scalaRef:      TypeRef,
    fullName:      Name,
    tparams:       IArray[TypeParamTree],
    propsRef:      PropsRef,
    componentType: ComponentType,
    nested:        IArray[Component],
) {

  def isGlobal: Boolean =
    location match {
      case Left(_) => false
      case Right(loc) =>
        loc match {
          case Annotation.JsImport(_, _, _) => false
          case Annotation.JsGlobalScope     => true
          case Annotation.JsGlobal(_)       => true
        }
    }

  val shortenedPropsName = Name(fullName.unescaped + "Props")

  val referenceTo: Option[TypeRef] =
    componentType match {
      case ComponentType.Class | ComponentType.Intrinsic => Some(scalaRef)
      case ComponentType.Function | ComponentType.Field  => None
    }

  def rewritten(scope: TreeScope, t: TreeTransformation): Component =
    copy( // don't rewrite scalaRef
      tparams  = tparams.map(t.visitTypeParamTree(scope)),
      propsRef = PropsRef(t.visitTypeRef(scope)(propsRef.ref)),
      nested   = nested.map(_.rewritten(scope, t)),
    )

  def withNested(nested: IArray[Component]): Component =
    copy(nested = nested)
}
