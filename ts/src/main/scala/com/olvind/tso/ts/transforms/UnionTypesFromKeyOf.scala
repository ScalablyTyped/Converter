package com.olvind.tso
package ts
package transforms

object UnionTypesFromKeyOf extends TreeTransformationScopedChanges {
  override def enterTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case TsTypeKeyOf(TsTypeRef(_, key, Nil)) if !scope.isAbstract(key) =>
        scope.lookup(key).headOption match {
          case Some(TsDeclInterface(_, _, _, _, _, members, _)) =>
            scope.logger.info(s"Expanded keyof $key")

            val literals = members.collect {
              case TsMemberProperty(_, _, TsIdent(name), _, _, _, _, _) =>
                TsTypeLiteral(TsLiteralString(name))
            }

            literals.size match {
              case 0 => x
              case _ => TsTypeUnion.simplified(literals)
            }
          case other =>
            scope.logger.info(s"Could not expand keyof $key: $other")
            x
        }
      case other => other
    }
}
