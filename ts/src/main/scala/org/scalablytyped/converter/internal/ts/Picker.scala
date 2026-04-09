package org.scalablytyped.converter.internal.ts

import org.scalablytyped.converter.internal.{HasStableHash, StableHash}

abstract class Picker[T](val repr: Product) extends HasStableHash {
  def unapply(t: TsNamedDecl): Option[T]

  override def hashCode: Int = StableHash(repr)
  override def equals(obj: Any): Boolean = obj match {
    case other: Picker[_] => this.repr == other.repr
    case _ => false
  }
}

object Picker {
  object All extends Picker[TsNamedDecl](Tuple1("All")) {
    override def unapply(t: TsNamedDecl): Some[TsNamedDecl] = Some(t)
  }

  object Vars extends Picker[TsDeclVar](Tuple1("Vars")) {
    override def unapply(t: TsNamedDecl): Option[TsDeclVar] =
      t match {
        case v: TsDeclVar => Some(v)
        case _ => None
      }
  }

  object NamedValues extends Picker[TsNamedValueDecl](Tuple1("NamedValues")) {
    override def unapply(t: TsNamedDecl): Option[TsNamedValueDecl] =
      t match {
        case other: TsNamedValueDecl => Some(other)
        case _ => None
      }
  }

  object NotModules extends Picker[TsNamedDecl](Tuple1("NotModules")) {
    override def unapply(t: TsNamedDecl): Option[TsNamedDecl] =
      t match {
        case _:     TsDeclModule => None
        case other: TsNamedDecl  => Some(other)
        case _ => None
      }
  }

  object NotClasses extends Picker[TsNamedDecl](Tuple1("NotClasses")) {
    override def unapply(t: TsNamedDecl): Option[TsNamedDecl] =
      t match {
        case _:     TsDeclClass => None
        case other: TsNamedDecl => Some(other)
        case _ => None
      }
  }

  object HasClassMemberss extends Picker[TsNamedDecl with HasClassMembers](Tuple1("HasClassMemberss")) {
    override def unapply(t: TsNamedDecl): Option[TsNamedDecl with HasClassMembers] = t match {
      case x: TsNamedDecl with HasClassMembers => Some(x)
      case _ => None
    }
  }

  object Namespaces extends Picker[TsDeclNamespace](Tuple1("Namespaces")) {
    override def unapply(t: TsNamedDecl): Option[TsDeclNamespace] = t match {
      case x: TsDeclNamespace => Some(x)
      case _ => None
    }
  }

  object Types extends Picker[TsNamedDecl](Tuple1("Types")) {
    def unapply(d: TsNamedDecl): Option[TsNamedDecl] =
      d match {
        case x: TsDeclClass     => Some(x)
        case x: TsDeclInterface => Some(x)
        case x: TsDeclTypeAlias => Some(x)
        case x: TsDeclEnum      => Some(x)
        case _ => None
      }
  }

  def ButNot[T <: TsNamedDecl](picker: Picker[T], excludes: T*): Picker[T] = new Picker[T](("ButNot", picker.repr)) {
    override def unapply(decl: TsNamedDecl): Option[T] = picker.unapply(decl).filter(t => excludes.exists(_ ne t))
  }
}
