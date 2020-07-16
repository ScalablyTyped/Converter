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

final case class Component(
    location:        Either[ExprTree.StringLit, LocationAnnotation],
    scalaRef:        TypeRef,
    fullName:        Name,
    tparams:         IArray[TypeParamTree],
    propsRef:        Option[TypeRef],
    isGlobal:        Boolean,
    componentType:   ComponentType,
    isAbstractProps: Boolean,
) {
  val shortenedPropsName = Name(fullName.unescaped + "Props")

  val referenceTo: Option[TypeRef] =
    componentType match {
      case ComponentType.Class | ComponentType.Intrinsic => Some(scalaRef)
      case ComponentType.Function | ComponentType.Field  => None
    }

  def rewritten(scope: TreeScope, t: TreeTransformation): Component =
    copy( // don't rewrite scalaRef
      tparams  = tparams.map(t.visitTypeParamTree(scope)),
      propsRef = propsRef.map(t.visitTypeRef(scope)),
    )
}
