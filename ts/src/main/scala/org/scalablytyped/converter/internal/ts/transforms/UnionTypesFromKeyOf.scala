package org.scalablytyped.converter.internal
package ts
package transforms

object UnionTypesFromKeyOf extends TreeTransformationScopedChanges {
  override def enterTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case TsTypeKeyOf(TsTypeRef(_, key, Empty)) if !scope.isAbstract(key) =>
        scope.lookup(key).headOption match {
          case Some(TsDeclInterface(_, _, _, _, _, members, _)) =>
            val literals = members.collect {
              case TsMemberProperty(_, _, TsIdent(name), _, _, _, _) =>
                TsTypeLiteral(TsLiteralString(name))
            }

            literals.length match {
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
