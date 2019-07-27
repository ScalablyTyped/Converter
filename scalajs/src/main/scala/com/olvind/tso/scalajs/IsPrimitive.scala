package com.olvind.tso.scalajs

/* primitives can not be `null` in Scala */
object IsPrimitive {
  def apply(tpe: TypeRef, scope: TreeScope): Boolean =
    if (scope.tparams.contains(tpe.typeName.parts.last)) false
    else if (TypeRef.Primitive(tpe)) true
    else {
      scope.lookup(tpe.typeName) collectFirst {
        case (TypeAliasTree(_, _, alias, _, _), newScope) => IsPrimitive(alias, newScope)
      } getOrElse false
    }
}
