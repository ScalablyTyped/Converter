package org.scalablytyped.converter.internal.ts

trait Picker[T] {
  def unapply(t: TsNamedDecl): Option[T]
}

object Picker {
  object All extends Picker[TsNamedDecl] {
    override def unapply(t: TsNamedDecl): Some[TsNamedDecl] = Some(t)
  }

  object Vars extends Picker[TsDeclVar] {
    override def unapply(t: TsNamedDecl): Option[TsDeclVar] =
      t match {
        case v: TsDeclVar => Some(v)
        case _ => None
      }
  }

  object NamedValues extends Picker[TsNamedValueDecl] {
    override def unapply(t: TsNamedDecl): Option[TsNamedValueDecl] =
      t match {
        case other: TsNamedValueDecl => Some(other)
        case _ => None
      }
  }

  object NotModules extends Picker[TsNamedDecl] {
    override def unapply(t: TsNamedDecl): Option[TsNamedDecl] =
      t match {
        case _:     TsDeclModule => None
        case other: TsNamedDecl  => Some(other)
        case _ => None
      }
  }

  object NotClasses extends Picker[TsNamedDecl] {
    override def unapply(t: TsNamedDecl): Option[TsNamedDecl] =
      t match {
        case _:     TsDeclClass => None
        case other: TsNamedDecl => Some(other)
        case _ => None
      }
  }

  object HasClassMemberss extends Picker[TsNamedDecl with HasClassMembers] {
    override def unapply(t: TsNamedDecl): Option[TsNamedDecl with HasClassMembers] = t match {
      case x: TsNamedDecl with HasClassMembers => Some(x)
      case _ => None
    }
  }

  object Namespaces extends Picker[TsDeclNamespace] {
    override def unapply(t: TsNamedDecl): Option[TsDeclNamespace] = t match {
      case x: TsDeclNamespace => Some(x)
      case _ => None
    }
  }

  object Types extends Picker[TsNamedDecl] {
    def unapply(d: TsNamedDecl): Option[TsNamedDecl] =
      d match {
        case x: TsDeclClass     => Some(x)
        case x: TsDeclInterface => Some(x)
        case x: TsDeclTypeAlias => Some(x)
        case x: TsDeclEnum      => Some(x)
        case _ => None
      }
  }

  def ButNot[T <: TsNamedDecl](picker: Picker[T], excludes: T*): Picker[T] =
    (decl: TsNamedDecl) => picker.unapply(decl).filter(t => excludes.exists(_ ne t))
}
