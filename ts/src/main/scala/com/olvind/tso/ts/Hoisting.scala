package com.olvind.tso
package ts

import com.olvind.tso.ts.TreeScope.LoopDetector

object Hoisting {
  val declared = false

  def hoistedMembersFrom(scope: TreeScope, codePath: CodePath.HasPath, loopDetector: LoopDetector)(
      typeRef:                  TsTypeRef
  ): Seq[TsNamedValueDecl] =
    //
    scope lookupInternal (Picker.Types, typeRef.name.parts, loopDetector) flatMap {
      case (_x: TsDeclInterface, newScope) =>
        val x           = FillInTParams(_x, typeRef.tparams)
        val fromThis    = x.members flatMap Hoisting.memberToDecl(codePath)
        val fromParents = x.inheritance flatMap hoistedMembersFrom(newScope, codePath, loopDetector)
        fromThis ++ fromParents

      case (_x: TsDeclClass, newScope) =>
        val x              = FillInTParams(_x, typeRef.tparams)
        val fromThis       = x.members flatMap Hoisting.memberToDecl(codePath)
        val fromParent     = x.parent.to[Seq] flatMap hoistedMembersFrom(newScope, codePath, loopDetector)
        val fromImplements = x.implements flatMap hoistedMembersFrom(newScope, codePath, loopDetector)
        fromThis ++ fromParent ++ fromImplements

      case (_x: TsDeclTypeAlias, newScope) =>
        val x = FillInTParams(_x, typeRef.tparams)
        val fromThis = x.alias match {
          case tr: TsTypeRef if tr.name =/= typeRef.name => hoistedMembersFrom(newScope, codePath, loopDetector)(tr)
          case TsTypeObject(members) => members flatMap memberToDecl(codePath)
          case _                     => Nil
        }
        fromThis
      case _ => Nil
    }

  def memberToDecl(codePath: CodePath.HasPath)(x: TsMember): Option[TsNamedValueDecl] =
    x match {
      case TsMemberCall(cs, _, sig) =>
        Some(TsDeclFunction(cs, declared, TsIdent.Apply, sig, JsLocation.Zero, codePath + TsIdent.Apply))
      case TsMemberFunction(cs, _, name: TsIdent, sig, _, _, _) =>
        Some(TsDeclFunction(cs, declared, name, sig, JsLocation.Zero, codePath + name))
      case TsMemberProperty(cs, _, name, tpe, _, isReadOnly, isOptional) =>
        Some(TsDeclVar(cs, declared, isReadOnly, name, tpe, None, JsLocation.Zero, codePath + name, isOptional))
      case _ => None
    }

}
