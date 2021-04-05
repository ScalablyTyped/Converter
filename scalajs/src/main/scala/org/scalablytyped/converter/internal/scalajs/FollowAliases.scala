package org.scalablytyped.converter.internal
package scalajs

object FollowAliases {
  def apply(scope: TreeScope)(tpe: TypeRef): TypeRef =
    tpe match {
      case TypeRef.Wildcard    => TypeRef.Any
      case TypeRef.TopLevel(x) => apply(scope)(x)
      case TypeRef.Union(types, cs) =>
        TypeRef.Union(types.map(FollowAliases(scope)), cs, sort = false)
      case TypeRef.Intersection(types, cs) =>
        TypeRef.Intersection(types.map(FollowAliases(scope)), cs)
      case other if TypeRef.Primitive(other) => other
      case other if scope.isAbstract(other)  => other
      case ref =>
        scope
          ._lookup(ref.typeName.parts)
          .collectFirst {
            case (ta: TypeAliasTree, newScope) =>
              apply(newScope)(FillInTParams(ta, scope, ref.targs, Empty).alias)
            case (_cls: ClassTree, newScope) if _cls.comments.has[Marker.WasUnion] =>
              val cls = FillInTParams(_cls, newScope, ref.targs, Empty)
              cls.comments.extract { case Marker.WasUnion(types) => types } match {
                case Some((types, _)) => TypeRef.Union(types, NoComments, sort = true)
                case None             => ref
              }
          }
          .getOrElse(ref)
    }
}
