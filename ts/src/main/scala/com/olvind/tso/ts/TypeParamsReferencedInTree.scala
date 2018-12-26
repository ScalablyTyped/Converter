package com.olvind.tso
package ts

object TypeParamsReferencedInTree {
  def apply(inScope: Map[TsIdent, TsTypeParam], tree: TsTree): Seq[TsTypeParam] = {

    val locallyDefined: Seq[TsIdent] =
      TreeTraverse
        .collect(tree) {
          case HasTParams(tparams) => tparams.map(_.name)
        }
        .flatten

    val referencedInTree: Set[TsIdent] =
      TreeTraverse
        .collect(tree) {
          case TsTypeRef(_, TsQIdent(List(unprefixedName)), _) if inScope.contains(unprefixedName) => unprefixedName
        }
        .to[Set]

    (referencedInTree -- locallyDefined).map(inScope).to[Seq]
  }
}
