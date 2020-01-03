package org.scalablytyped.converter.internal
package ts
package transforms

object InferEnumTypes extends TreeTransformationScopedChanges {
  override def enterTsDeclEnum(scope: TsTreeScope)(e: TsDeclEnum): TsDeclEnum =
    e.copy(members = replaceReferences(initializeMembers(e.members)))

  def initializeMembers(members: Seq[TsEnumMember]): Seq[TsEnumMember] = {
    var lastUnspecifiedIndex = 0
    members.map {
      case em @ TsEnumMember(_, _, None) =>
        val ret = em.copy(expr = Some(TsExpr.Literal(TsLiteralNumber(lastUnspecifiedIndex.toString))))
        lastUnspecifiedIndex += 1
        ret
      case other => other
    }
  }

  def replaceReferences(members: Seq[TsEnumMember]): Seq[TsEnumMember] = {
    lazy val byName = members.groupBy(_.name)

    members.map {
      case em @ TsEnumMember(_, _, Some(expr)) =>
        val newExpr = TsExpr.visit(expr) {
          case TsExpr.Ref(TsTypeRef(_, TsQIdent(List(name: TsIdentSimple)), Nil)) if byName.contains(name) =>
            byName(name).head.expr.get
          case other => other
        }
        em.copy(expr = Some(newExpr))
      case other => other
    }
  }
}
