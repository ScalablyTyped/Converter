package com.olvind.tso
package ts

import com.olvind.tso.ts.TreeScope.LoopDetector

object Hoisting {
  val declared = false

  def hoistedMembersFrom(scope: TreeScope, cp: CodePath, ld: LoopDetector)(typeRef: TsTypeRef): Seq[TsNamedValueDecl] =
    AllMembersFor(scope, ld)(typeRef) flatMap memberToDecl(cp)

  def add(codePath: CodePath, ident: TsIdent) =
    codePath match {
      case x: CodePath.HasPath => x + ident
      case noPath => noPath
    }

  def memberToDecl(codePath: CodePath)(x: TsMember): Option[TsNamedValueDecl] =
    x match {
      case TsMemberCall(cs, _, sig) =>
        Some(TsDeclFunction(cs, declared, TsIdent.Apply, sig, JsLocation.Zero, add(codePath, TsIdent.Apply)))
      case TsMemberFunction(cs, _, name: TsIdent, sig, _, _, _) =>
        Some(TsDeclFunction(cs, declared, name, sig, JsLocation.Zero, add(codePath, name)))
      case TsMemberProperty(cs, _, name, tpe, _, isReadOnly, isOptional) =>
        Some(TsDeclVar(cs, declared, isReadOnly, name, tpe, None, JsLocation.Zero, add(codePath, name), isOptional))
      case _ => None
    }

}
