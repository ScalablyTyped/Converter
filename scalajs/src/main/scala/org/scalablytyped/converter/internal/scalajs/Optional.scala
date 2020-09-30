package org.scalablytyped.converter
package internal
package scalajs

object Optional {
  val isOptional: Set[TypeRef] = Set(TypeRef.Null, TypeRef.undefined)

  def unapply(tpe: TypeRef): Option[TypeRef] =
    tpe match {
      case TypeRef.Union(types, cs) =>
        types.partition(isOptional) match {
          case (IArray.Empty, _) => None
          case (_, remaining)    => Some(TypeRef.Union(remaining, cs, sort = false))
        }
      case _ => None
    }

}

sealed trait Optionality

object Optionality {
  case object No extends Optionality
  case object Null extends Optionality
  case object Undef extends Optionality
  case object NullOrUndef extends Optionality

  val All: IArray[Optionality] = IArray(No, Null, Undef, NullOrUndef)

  implicit val ordering: Ordering[Optionality] =
    Ordering.by(All.indexOf)

  def unapply(tpe: TypeRef): Some[(Optionality, TypeRef)] =
    Some(apply(tpe))

  def apply(tpe: TypeRef): (Optionality, TypeRef) =
    tpe match {
      case TypeRef.Union(types, cs) =>
        types.partition(Optional.isOptional) match {
          case (foundNulls, remaining) =>
            val opt = (foundNulls contains TypeRef.Null, foundNulls contains TypeRef.undefined) match {
              case (true, true)   => NullOrUndef
              case (true, false)  => Null
              case (false, true)  => Undef
              case (false, false) => No
            }
            (opt, TypeRef.Union(remaining, cs, sort = false))
        }
      case tpe => (No, tpe)
    }
}
