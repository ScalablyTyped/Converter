package com.olvind.tso
package ts

import com.olvind.tso.ts.TsTreeScope.LoopDetector

object Hoisting {
  val declared = false

  def fromType(
      scope:    TsTreeScope,
      ownerCp:  CodePath,
      ownerLoc: JsLocation,
      ld:       LoopDetector,
      tpe:      TsType,
  ): Seq[TsNamedValueDecl] =
    tpe match {
      case ref: TsTypeRef => fromRef(scope, ownerCp, ownerLoc, ld, ref)
      case TsTypeObject(_, ms) => ms.flatMap(memberToDecl(ownerCp, ownerLoc))
      case _                   => Nil
    }

  def fromRef(
      scope:    TsTreeScope,
      ownerCp:  CodePath,
      ownerLoc: JsLocation,
      ld:       LoopDetector,
      typeRef:  TsTypeRef,
  ): Seq[TsNamedValueDecl] =
    AllMembersFor(scope, ld)(typeRef) flatMap memberToDecl(ownerCp, ownerLoc)

  def memberToDecl(ownerCp: CodePath, ownerLoc: JsLocation)(x: TsMember): Option[TsNamedValueDecl] =
    x match {
      case TsMemberCall(cs, _, sig) =>
        Some(TsDeclFunction(cs, declared, TsIdent.Apply, sig, ownerLoc, ownerCp + TsIdent.Apply))
      case TsMemberFunction(cs, _, name: TsIdent, sig, _, _, _) =>
        Some(TsDeclFunction(cs, declared, name, sig, ownerLoc + name, ownerCp + name))
      case TsMemberProperty(cs, _, name, tpe, lit, _, isReadOnly, isOptional) =>
        Some(TsDeclVar(cs, declared, isReadOnly, name, tpe, lit, JsLocation.Zero, ownerCp + name, isOptional))
      case _ => None
    }
}
