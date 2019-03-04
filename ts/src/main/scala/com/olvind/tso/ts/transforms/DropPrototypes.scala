package com.olvind.tso
package ts.transforms

import com.olvind.tso.ts._

object DropPrototypes extends TransformClassMembers {
  override def newClassMembers(scope: TsTreeScope, x: HasClassMembers): Seq[TsMember] =
    x.members.filter {
      case TsMemberProperty(_, _, TsIdent.prototype, _, _, _, _, _)                      => false
      case TsMemberProperty(_, _, ident, _, _, _, _, _) if ident.value.startsWith("\\u") => false
      case _                                                                             => true
    }
}
