package org.scalablytyped.converter.internal
package ts
package transforms

object InlineConstEnum extends TreeTransformationScopedChanges {

  override def enterTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case TsTypeRef(_, TsQIdent(parts), Empty) =>
        val inlinedEnumMember: Option[TsType] =
          if (parts.length < 3) None /* libName + enumName + enumMember */
          else
            scope.lookupType(TsQIdent(parts.init), skipValidation = true).firstDefined {
              case e: TsDeclEnum if e.isConst =>
                val memberName = parts.last
                e.members.collectFirst {
                  case TsEnumMember(_, `memberName`, exprOpt) =>
                    val ret = TsExpr.typeOfOpt(exprOpt)
                    scope.logger.info(s"Inlining const enum type ${TsTypeFormatter(x)} => ${TsTypeFormatter(ret)}")
                    ret
                }
              case _ => None
            }

        inlinedEnumMember.getOrElse(x)

      case other => other
    }
}
