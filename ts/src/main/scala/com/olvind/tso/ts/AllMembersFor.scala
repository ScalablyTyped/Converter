package com.olvind.tso
package ts

import com.olvind.tso.ts.TreeScope.LoopDetector

object AllMembersFor {
  def apply(scope: TreeScope, loopDetector: LoopDetector)(typeRef: TsTypeRef): Seq[TsMember] =
    scope lookupInternal (Picker.Types, typeRef.name.parts, loopDetector) flatMap {
      case (x: TsDeclInterface, newScope) =>
        forInterface(loopDetector, x, newScope, typeRef.tparams)

      case (x: TsDeclClass, newScope) =>
        FillInTParams(x, typeRef.tparams) match {
          case TsDeclClass(_, _, _, _, _, parent, implements, members, _, _) =>
            members ++ (implements ++ parent flatMap apply(newScope, loopDetector))
        }
      case (x: TsDeclTypeAlias, newScope) =>
        FillInTParams(x, typeRef.tparams).alias match {
          case tr: TsTypeRef if tr.name =/= typeRef.name => apply(newScope, loopDetector)(tr)
          case TsTypeObject(members) => members
          case _                     => Nil
        }
      case _ => Nil
    }

  def forInterface(loopDetector: TreeScope.LoopDetector,
                   x:            TsDeclInterface,
                   newScope:     TreeScope,
                   tparams:      Seq[TsType]): Seq[TsMember] =
    FillInTParams(x, tparams) match {
      case TsDeclInterface(_, _, _, _, inheritance, members, _) =>
        members ++ (inheritance flatMap AllMembersFor(newScope, loopDetector))
    }
}
