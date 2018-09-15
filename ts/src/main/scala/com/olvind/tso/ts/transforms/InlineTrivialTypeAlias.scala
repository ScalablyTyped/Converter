package com.olvind.tso
package ts
package transforms

object InlineTrivialTypeAlias extends TreeVisitorScopedChanges {
  def canExplodeCodeSize(x: TsTypeRef): Boolean =
    x.tparams.exists {
      case _: TsTypeUnion => true
      case _ => false
    }

  /**
    *
    * @param originalTParams Keep track of these to handle type aliases like this:
    *                        ```typescript
    *                        Type U&lt;P&gt> = T[P]
    *                        type T&lt;A&gt> = A
    *                        ```
    *                        If we inline `U` and lookup `P` within `T`, the lookup will fail
    */
  def simplify(scope: TreeScope, originalTParams: Set[TsQIdent])(tr: TsTypeRef): Option[TsTypeRef] =
    tr match {
      case TsTypeRef(target: TsQIdent, providedTparams: Seq[TsType])
          if !TsQIdent.Primitive(target) && !TsQIdent.BuiltIn(target) & !originalTParams(target) =>
        val ret: Option[Option[TsTypeRef]] =
          scope lookupBase (Picker.Types, target) collectFirst {
            case (next: TsDeclTypeAlias, newScope) if next.tparams.forall(_.upperBound.isEmpty) =>
              FillInTParams(next, providedTparams).alias match {
                case trNext: TsTypeRef
                    if !canExplodeCodeSize(trNext) // you won't believe what happens next!
                      && trNext.name =/= target // avoid SOE on invalid code
                      && trNext.name.parts.last === target.parts.last // keep renames, as they may add semantic value
                    =>
                  simplify(newScope, originalTParams)(trNext)
                case _ => Some(tr)
              }
            case _ => Some(tr)
          }

        ret.flatten
      case _ => None
    }

  override def leaveTsTypeRef(scope: TreeScope)(x: TsTypeRef): TsTypeRef = {
    val tparams = x.tparams
      .collect {
        case TsTypeRef(target, _) => target
      }
      .to[Set]
    simplify(scope, tparams)(x).getOrElse(x)
  }
}
