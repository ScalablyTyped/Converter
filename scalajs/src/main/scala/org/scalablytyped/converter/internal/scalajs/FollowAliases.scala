package org.scalablytyped.converter.internal
package scalajs

object FollowAliases {
  def apply(scope: TreeScope)(tpe: TypeRef): TypeRef =
    tpe match {
      case TypeRef.Wildcard    => TypeRef.Any
      case TypeRef.TopLevel(x) => apply(scope)(x)
      case TypeRef.Union(types, cs) =>
        TypeRef.Union(types map FollowAliases(scope), cs, sort = false)
      case TypeRef.Intersection(types, cs) =>
        TypeRef.Intersection(types map FollowAliases(scope), cs)
      case other if TypeRef.Primitive(other) => other
      case other if scope.isAbstract(other)  => other
      case TypeRef.undefined                 => TypeRef.undefined
      case ref =>
        scope
          .lookup(ref.typeName)
          .collectFirst {
            case (ta: TypeAliasTree, newScope) =>
              apply(newScope)(FillInTParams(ta, scope, ref.targs, Empty).alias)
          }
          .getOrElse(ref)
    }
}
