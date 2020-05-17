package org.scalablytyped.converter.internal
package scalajs

import org.scalablytyped.converter.internal.scalajs.transforms.UnionToInheritance

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
      case ref =>
        scope
          ._lookup(ref.typeName.parts)
          .collectFirst {
            case (UnionToInheritance.RewrittenTypeUnion(x), newScope) =>
              val rewriter = TypeRewriter(TypeParamTree.asTypeArgs(x.tparams).zip(ref.targs).toMap)
              TypeRef.Union(
                x.all.map(tr => FollowAliases(newScope)(rewriter.visitTypeRef(newScope)(tr))),
                NoComments,
                sort = false,
              )
            case (ta: TypeAliasTree, newScope) =>
              apply(newScope)(FillInTParams(ta, scope, ref.targs, Empty).alias)
          }
          .getOrElse(ref)
    }
}
