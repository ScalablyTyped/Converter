package org.scalablytyped.converter.internal
package ts
package transforms

/**
  *  Given
  *  ```typescript
  *  interface A {}
  *  interface B1 extends A {}
  *  interface B2 extends A {foo: number}
  *  class C implements B1, B2
  *  ```
  *  We simplify to `class C implements A, B2` because `B2` adds information.
  *  `A` remains extended twice, but that isn't a problem on the typescript side, and it will be taken care of later.
  */
object InlineTrivialParents extends TreeTransformationScopedChanges {
  override def enterTsDeclClass(scope: TsTreeScope)(x: TsDeclClass): TsDeclClass = {
    val newInheritance = IArray.fromOption(x.parent) ++ x.implements flatMap shortenParent(scope)
    x.copy(parent = newInheritance.headOption, implements = newInheritance.drop(1))
  }

  override def enterTsDeclInterface(scope: TsTreeScope)(x: TsDeclInterface): TsDeclInterface =
    x.copy(inheritance = x.inheritance flatMap shortenParent(scope))

  def shortenParent(scope: TsTreeScope)(p: TsTypeRef): IArray[TsTypeRef] =
    FollowAliases(scope)(p) match {
      case pp: TsTypeRef =>
        val replacedOpt = scope lookupIncludeScope pp.name collectFirst {
          case (i: TsDeclInterface, newScope) if i.members.isEmpty && i.inheritance.nonEmpty =>
            FillInTParams(i, pp.tparams).inheritance flatMap shortenParent(newScope)
          case (c: TsDeclClass, newScope) if c.members.isEmpty && (c.parent.nonEmpty || c.implements.nonEmpty) =>
            val cc = FillInTParams(c, pp.tparams)
            IArray.fromOption(cc.parent) ++ cc.implements flatMap shortenParent(newScope)
        }

        replacedOpt.getOrElse(IArray(p))
      case _ => IArray(p)
    }
}
