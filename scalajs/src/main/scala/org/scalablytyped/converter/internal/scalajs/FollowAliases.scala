package org.scalablytyped.converter.internal
package scalajs

object FollowAliases {
  def apply(scope: TreeScope)(tpe: TypeRef): TypeRef =
    tpe match {
      case TypeRef.TopLevel(x) => apply(scope)(x)
      case TypeRef.Union(types, cs) =>
        TypeRef.Union(types.map(FollowAliases(scope)), cs, sort = false)
      case TypeRef.Intersection(types, cs) =>
        TypeRef.Intersection(types.map(FollowAliases(scope)), cs)
      case other if scope.isAbstract(other) => other
      case ref =>
        scope.stack match {
          case _ :: TypeRef.Literal() :: _ => ref
          case _ =>
            scope
              .lookup(ref.typeName)
              .collectFirst {
                case (_ta: TypeAliasTree, _) =>
                  val ta = FillInTParams(_ta, scope, ref.targs, Empty)
                  apply(scope / ta)(ta.alias)
                case (_cls: ClassTree, _) if _cls.comments.has[Marker.WasUnion] =>
                  val cls = FillInTParams(_cls, scope, ref.targs, Empty)
                  cls.comments.extract { case Marker.WasUnion(types) => types } match {
                    case Some((types, _)) => TypeRef.Union(types, NoComments, sort = true)
                    case None             => ref
                  }
              }
              .getOrElse(ref)
        }
    }
}
