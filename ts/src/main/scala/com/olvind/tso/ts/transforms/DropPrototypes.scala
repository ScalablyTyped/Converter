package com.olvind.tso
package ts.transforms

import com.olvind.tso.ts._

object DropPrototypes extends TreeTransformationScopedChanges {
  def newMembers(ms: Seq[TsMember]): Seq[TsMember] =
    ms.filter {
      case TsMemberProperty(_, _, TsIdent.prototype, _, _, _, _, _) => false
      case _                                                        => true
    }

  override def enterTsTypeObject(t: TsTreeScope)(x: TsTypeObject) =
    x.copy(members = newMembers(x.members))

  override def enterTsDeclClass(t: TsTreeScope)(x: TsDeclClass) =
    x.copy(members = newMembers(x.members))

  override def enterTsDeclInterface(t: TsTreeScope)(x: TsDeclInterface) =
    x.copy(members = newMembers(x.members))
}
