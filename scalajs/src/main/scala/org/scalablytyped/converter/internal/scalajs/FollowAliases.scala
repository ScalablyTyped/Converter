package org.scalablytyped.converter.internal
package scalajs

object FollowAliases {
  def apply(scope: TreeScope)(tpe: TypeRef): TypeRef =
    tpe match {
      case TypeRef.Union(types) =>
        TypeRef.Union(types map FollowAliases(scope), sort = false)
      case TypeRef.Intersection(types) =>
        TypeRef.Intersection(types map FollowAliases(scope))
      case other if TypeRef.Primitive(other) => other
      case other if scope.isAbstract(other)  => other
      case TypeRef.undefined                 => TypeRef.undefined
      case TypeRef.`null`                    => TypeRef.`null`
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
