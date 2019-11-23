package com.olvind.tso
package scalajs
package react

sealed trait ComponentType

object ComponentType {
  case object Class extends ComponentType
  case object Function extends ComponentType
  case object Field extends ComponentType
}

final case class Component(
    scalaRef:         TypeRef,
    fullName:         Name,
    tparams:          Seq[TypeParamTree],
    props:            Option[TypeRef],
    isGlobal:         Boolean,
    componentType:    ComponentType,
    isAbstractProps:  Boolean,
    componentMembers: Seq[MemberTree],
) {
  val shortenedPropsName = Name(fullName.unescaped + "Props")
  val knownRef: Option[TypeRef] =
    componentType match {
      case ComponentType.Class    => Some(scalaRef)
      case ComponentType.Function => None
      case ComponentType.Field    => None
    }
}

object Component {
  def formatReferenceTo(ref: TypeRef, componentType: ComponentType): String = {
    val loc = Printer.formatTypeRef(0)(ref)

    componentType match {
      case ComponentType.Class => s"js.constructorOf[$loc]"
      case ComponentType.Field => loc
      case ComponentType.Function =>
        ref.typeName.parts match {
          case ownerQName :+ name =>
            val owner = Printer.formatQN(QualifiedName(ownerQName))
            s"""$owner.asInstanceOf[js.Dynamic].selectDynamic("${name.unescaped}")"""
        }
    }
  }
}
