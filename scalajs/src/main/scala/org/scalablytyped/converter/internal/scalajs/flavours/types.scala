package org.scalablytyped.converter.internal
package scalajs
package flavours

sealed trait ComponentType

object ComponentType {
  case object Class extends ComponentType
  case object Function extends ComponentType
  case object Field extends ComponentType
}

final case class Component(
    location:        LocationAnnotation,
    scalaRef:        TypeRef,
    fullName:        Name,
    tparams:         IArray[TypeParamTree],
    props:           Option[TypeRef],
    isGlobal:        Boolean,
    componentType:   ComponentType,
    isAbstractProps: Boolean,
) {
  val shortenedPropsName = Name(fullName.unescaped + "Props")

  val referenceTo: Option[TypeRef] =
    componentType match {
      case ComponentType.Class    => Some(scalaRef)
      case ComponentType.Function => None
      case ComponentType.Field    => None
    }

  def rewritten(scope: TreeScope, t: TreeTransformation): Component =
    copy( // don't rewrite scalaRef
      tparams = tparams.map(t.visitTypeParamTree(scope)),
      props   = props.map(t.visitTypeRef(scope)),
    )
}
