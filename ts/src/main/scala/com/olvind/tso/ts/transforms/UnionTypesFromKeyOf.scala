package com.olvind.tso
package ts
package transforms

object UnionTypesFromKeyOf extends TreeVisitorScopedChanges {
  override def enterTsType(t: TreeScope)(x: TsType): TsType =
    x match {
      case TsTypeKeyOf(TsTypeRef(key, Nil)) if key.parts.lengthCompare(1) > 0 || !t.tparams.contains(key.parts.head) =>
        t.lookup(key).headOption match {
          case Some(TsDeclInterface(_, _, _, _, _, members, _)) =>
            t.logger.info(s"Expanded keyof $key")

            val literals = members.collect {
              case TsMemberProperty(_, _, TsIdent(name), _, _, _, _) =>
                TsTypeLiteral(TsLiteralString(name))
            }

            literals.size match {
              case 0 => x
              case _ => TsTypeUnion.simplified(literals)
            }
          case other =>
            t.logger.info(s"Could not expand keyof $key: $other")
            x
        }
      case other => other
    }
}
