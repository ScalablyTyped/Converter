package org.scalablytyped.converter.internal
package ts

import org.scalablytyped.converter.internal.ts.TsTreeScope.LoopDetector

object Hoisting {
  val declared = false

  def fromType(
      scope:    TsTreeScope,
      ownerCp:  CodePath,
      ownerLoc: JsLocation,
      ld:       LoopDetector,
      tpe:      TsType,
  ): IArray[TsNamedValueDecl] =
    tpe match {
      case ref: TsTypeRef => fromRef(scope, ownerCp, ownerLoc, ld, ref)
      case TsTypeObject(_, ms) => ms.mapNotNone(memberToDecl(ownerCp, ownerLoc))
      case _                   => Empty
    }

  def fromRef(
      scope:    TsTreeScope,
      ownerCp:  CodePath,
      ownerLoc: JsLocation,
      ld:       LoopDetector,
      typeRef:  TsTypeRef,
  ): IArray[TsNamedValueDecl] =
    AllMembersFor(scope, ld)(typeRef).mapNotNone(memberToDecl(ownerCp, ownerLoc))

  def memberToDecl(ownerCp: CodePath, ownerLoc: JsLocation)(x: TsMember): Option[TsNamedValueDecl] =
    x match {
      case TsMemberCall(cs, _, sig) =>
        Some(TsDeclFunction(cs, declared, TsIdent.Apply, sig, ownerLoc, ownerCp + TsIdent.Apply))
      case TsMemberFunction(cs, _, name, MethodType.Normal, sig, _, _) =>
        Some(TsDeclFunction(cs, declared, name, sig, ownerLoc + name, ownerCp + name))
      case TsMemberProperty(cs, _, name, tpe, lit, _, isReadOnly) =>
        Some(TsDeclVar(cs, declared, isReadOnly, name, tpe, lit, ownerLoc + name, ownerCp + name))
      case _ => None
    }
}
