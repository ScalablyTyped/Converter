package com.olvind.tso.ts

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

  object NotModules extends Picker[Renameable] {
    override def unapply(t: TsNamedDecl): Option[Renameable] =
      t match {
        case _:     TsDeclModule => None
        case other: Renameable   => Some(other)
        case _ => None
      }
  }

  object NotOrNamespaceModules extends Picker[Renameable] {
    override def unapply(t: TsNamedDecl): Option[Renameable] =
      t match {
        case _:     TsDeclModule    => None
        case _:     TsDeclNamespace => None
        case other: Renameable      => Some(other)
        case _ => None
      }
  }

  object NamedValues extends Picker[TsNamedDecl with Renameable] {
    override def unapply(t: TsNamedDecl): Option[TsNamedDecl with Renameable] =
      t match {
        case other: TsNamedValueDecl with Renameable                             => Some(other)
        case x:     TsNamedDecl with Renameable if x.name === TsIdent.namespaced => Some(x)
        case _ => None
      }
  }

  object Modules extends Picker[TsDeclModule] {
    override def unapply(t: TsNamedDecl): Option[TsDeclModule] = t match {
      case x: TsDeclModule => Some(x)
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

  def ButNot[T <: TsNamedDecl](picker: Picker[T], exclude: T): Picker[T] =
    (t: TsNamedDecl) => picker.unapply(t).filter(_ ne exclude)
}
