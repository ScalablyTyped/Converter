package org.scalablytyped.converter.internal
package ts
package transforms

object VarToNamespace extends TreeTransformationScopedChanges {
  override def enterTsDecl(scope: TsTreeScope)(decl: TsDecl): TsDecl = decl match {
    case TsDeclVar(cs1, declared, _, name, Some(TsTypeObject(cs2, members)), None, jsLocation, codePath) =>
      val hoistedMembers = members.mapNotNone(Hoisting.memberToDecl(codePath, jsLocation))
      TsDeclNamespace(cs1 ++ cs2, declared, name, hoistedMembers, codePath, jsLocation)
    case other => other
  }
}
