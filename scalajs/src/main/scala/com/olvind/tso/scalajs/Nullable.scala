package com.olvind.tso.scalajs

object Nullable {
  val nulls: Set[TypeRef] = Set(TypeRef.Null)

  def unapply(tpe: TypeRef): Option[TypeRef] =
    tpe match {
      case TypeRef.UndefOr(tpe) =>
        tpe match {
          case Nullable(tpe2) => Some(tpe2)
          case _              => Some(tpe)
        }

      case TypeRef.Union(types) =>
        types partition nulls match {
          case (Nil, _)       => None
          case (_, remaining) => Some(TypeRef.Union(remaining, sort = false))
        }
      case _ => None
    }
}

object Optional {
  val nulls: Set[TypeRef] = Set(TypeRef.Null, TypeRef.undefined)

  def unapply(tpe: TypeRef): Option[TypeRef] =
    tpe match {
      case TypeRef.UndefOr(tpe) =>
        tpe match {
          case Nullable(tpe2) => Some(tpe2)
          case _              => Some(tpe)
        }

      case TypeRef.Union(types) =>
        types partition nulls match {
          case (Nil, _)       => None
          case (_, remaining) => Some(TypeRef.Union(remaining, sort = false))
        }
      case _ => None
    }
}
