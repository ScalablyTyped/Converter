package com.olvind.tso
package scalajs

object Optional {
  /* Until we run `InferFromUnion` we use a union type with this marker and/or `TypeRef.Null` to indicate optionality */
  val UndefinedMarker: TypeRef = TypeRef(Name.UNDEFINED)

  val NullUndefOr: QualifiedName = QualifiedName.Runtime + Name("NullUndefOr")
  val NullOr:      QualifiedName = QualifiedName.Runtime + Name("NullOr")
  val UndefOr:     QualifiedName = QualifiedName.Runtime + Name("UndefOr")
  val Required:    QualifiedName = QualifiedName.Runtime + Name("Required")

  val Nullable: Set[QualifiedName] = Set(NullUndefOr, NullOr, UndefOr, Required)

  object InferFromUnion extends TreeTransformation {
    override def leaveTypeRef(scope: TreeScope)(s: TypeRef): TypeRef =
      s match {
        case IsNullableAndUndefined(tpe) =>
          TypeRef(NullUndefOr, List(tpe), NoComments)
        case IsNullable(tpe) =>
          TypeRef(NullOr, List(tpe), NoComments)
        case IsUndefined(tpe) =>
          TypeRef(UndefOr, List(tpe), NoComments)
        case other => other
      }
  }

  object IsNullable extends Extractor(matchAll             = false, nulls = Set(TypeRef.Null))
  object IsUndefined extends Extractor(matchAll            = false, nulls = Set(UndefinedMarker))
  object IsNullableOrUndefined extends Extractor(matchAll  = false, nulls = Set(TypeRef.Null, UndefinedMarker))
  object IsNullableAndUndefined extends Extractor(matchAll = true, nulls  = Set(TypeRef.Null, UndefinedMarker))

  sealed abstract class Extractor(matchAll: Boolean, val nulls: Set[TypeRef]) {

    private def matchesOptionals(types: Seq[TypeRef]) =
      if (matchAll) nulls forall types.contains
      else nulls exists types.contains

    def unapply(tpe: TypeRef): Option[TypeRef] =
      tpe match {
        case TypeRef(NullUndefOr, Seq(one), _)                                => Some(one)
        case TypeRef(NullOr, Seq(one), _) if nulls.contains(TypeRef.Null)     => Some(one)
        case TypeRef(UndefOr, Seq(one), _) if nulls.contains(UndefinedMarker) => Some(one)

        case TypeRef.Union(types) if matchesOptionals(types) =>
          val rest = types.filterNot(x => nulls(x) || x === TypeRef.Nothing) match {
            case Nil      => TypeRef.Nothing
            case Seq(one) => one
            case more     => TypeRef.Union(more, sort = false)
          }
          Some(rest)

        case _ => None
      }
  }
}
