package com.olvind.tso.scalajs
package transforms

object UseExistingTypes extends SymbolVisitor {
  val Substitutions: Map[QualifiedName, QualifiedName] =
    Map(
      QualifiedName.Array -> QualifiedName.Array
    )

  override def enterTypeRef(scope: SymbolScope)(s: TypeRef): TypeRef =
    if (isParent(scope, s)) s
    else Substitutions.get(s.typeName).fold(s)(rewritten => s.copy(typeName = rewritten))

  private def isParent(scope: SymbolScope, s: TypeRef): Boolean =
    scope.stack match {
      case _ :: ClassSymbol(_, _, _, ps, _, _, _, _, _) :: _ => ps.contains(s)
      case _                                                 => false
    }
}
