package com.olvind.tso
package ts

import com.olvind.tso.ts.TsTreeScope.LoopDetector

object Hoisting {
  val declared = false

  def fromType(scope: TsTreeScope, cp: CodePath, ld: LoopDetector, tpe: TsType): Seq[TsNamedValueDecl] =
    tpe match {
      case ref: TsTypeRef => fromRef(scope, cp, ld, ref)
      case TsTypeObject(ms) => ms.flatMap(memberToDecl(cp))
      case _                => Nil
    }

  def fromRef(scope: TsTreeScope, cp: CodePath, ld: LoopDetector, typeRef: TsTypeRef): Seq[TsNamedValueDecl] =
    AllMembersFor(scope, ld)(typeRef) flatMap memberToDecl(cp)

  private def add(codePath: CodePath, ident: TsIdent): CodePath =
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
      case TsMemberProperty(cs, _, name, tpe, lit, _, isReadOnly, isOptional) =>
        Some(TsDeclVar(cs, declared, isReadOnly, name, tpe, lit, JsLocation.Zero, add(codePath, name), isOptional))
      case _ => None
    }

}
