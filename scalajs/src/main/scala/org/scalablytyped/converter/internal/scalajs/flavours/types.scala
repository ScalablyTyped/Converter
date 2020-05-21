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

object Component {
  import ExprTree._
  def formatReferenceTo(ref: TypeRef, componentType: ComponentType): ExprTree =
    componentType match {
      case ComponentType.Class =>
        TApply(Ref(QualifiedName.constructorOf), IArray(ref))
      case ComponentType.Field =>
        Ref(ref)
      case ComponentType.Function =>
        ref.typeName.parts match {
          case IArray.initLast(ownerQName, name) =>
            Call(
              Select(Cast(Ref(QualifiedName(ownerQName)), TypeRef.Dynamic), Name("selectDynamic")),
              IArray(IArray(StringLit(name.unescaped))),
            )
        }
    }
}
