package com.olvind.tso
package ts

import com.olvind.tso.ts.TsTreeScope.LoopDetector

object Hoisting {
  val declared = false

  def fromType(scope:    TsTreeScope,
               ownerCp:  CodePath,
               ownerLoc: JsLocation,
               ld:       LoopDetector,
               tpe:      TsType): Seq[TsNamedValueDecl] =
    tpe match {
      case ref: TsTypeRef => fromRef(scope, ownerCp, ownerLoc, ld, ref)
      case TsTypeObject(ms) => ms.flatMap(memberToDecl(ownerCp, ownerLoc))
      case _                => Nil
    }

  def fromRef(scope:    TsTreeScope,
              ownerCp:  CodePath,
              ownerLoc: JsLocation,
              ld:       LoopDetector,
              typeRef:  TsTypeRef): Seq[TsNamedValueDecl] =
    AllMembersFor(scope, ld)(typeRef) flatMap memberToDecl(ownerCp, ownerLoc)

  private def add(codePath: CodePath, ident: TsIdent): CodePath =
    codePath match {
      case x: CodePath.HasPath => x + ident
      case noPath => noPath
    }

  private def add(location: JsLocation, ident: TsIdent): JsLocation =
    location match {
      case JsLocation.Zero => JsLocation.Zero
      case other           => other.specifyMore(ident)
    }

  def memberToDecl(ownerCp: CodePath, ownerLoc: JsLocation)(x: TsMember): Option[TsNamedValueDecl] =
    x match {
      case TsMemberCall(cs, _, sig) =>
        Some(TsDeclFunction(cs, declared, TsIdent.Apply, sig, ownerLoc, add(ownerCp, TsIdent.Apply)))
      case TsMemberFunction(cs, _, name: TsIdent, sig, _, _, _) =>
        Some(TsDeclFunction(cs, declared, name, sig, add(ownerLoc, name), add(ownerCp, name)))
      case TsMemberProperty(cs, _, name, tpe, lit, _, isReadOnly, isOptional) =>
        Some(TsDeclVar(cs, declared, isReadOnly, name, tpe, lit, JsLocation.Zero, add(ownerCp, name), isOptional))
      case _ => None
    }
}
