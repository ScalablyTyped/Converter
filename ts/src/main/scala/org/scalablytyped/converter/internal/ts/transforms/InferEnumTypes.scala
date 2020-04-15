package org.scalablytyped.converter.internal
package ts
package transforms

object InferEnumTypes extends TreeTransformationScopedChanges {
  override def enterTsDeclEnum(scope: TsTreeScope)(e: TsDeclEnum): TsDeclEnum =
    e.copy(members = replaceReferences(initializeMembers(e.members)))

  def initializeMembers(members: IArray[TsEnumMember]): IArray[TsEnumMember] = {
    var lastUnspecifiedIndex = 0
    members.map {
      case em @ TsEnumMember(_, _, None) =>
        val ret = em.copy(expr = Some(TsExpr.Literal(TsLiteralNumber(lastUnspecifiedIndex.toString))))
        lastUnspecifiedIndex += 1
        ret
      case other => other
    }
  }

  def replaceReferences(members: IArray[TsEnumMember]): IArray[TsEnumMember] = {
    lazy val byName = members.groupBy(_.name)

    members.map {
      case em @ TsEnumMember(_, _, Some(expr)) =>
        val newExpr = TsExpr.visit(expr) {
          case TsExpr.Ref(TsQIdent(IArray.exactlyOne(name: TsIdentSimple))) if byName.contains(name) =>
            byName(name).head.expr.get
          case other => other
        }
        em.copy(expr = Some(newExpr))
      case other => other
    }
  }
}
