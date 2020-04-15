package org.scalablytyped.converter.internal
package ts

object TypeParamsReferencedInTree {
  def apply(inScope: Map[TsIdent, TsTypeParam], tree: TsTree): IArray[TsTypeParam] = {

    val locallyDefined: Set[TsIdent] =
      TsTreeTraverse
        .collect(tree) {
          case HasTParams(tparams) => tparams.map(_.name)
        }
        .flatten
        .toSet

    val referencedInTree: IArray[TsIdent] =
      TsTreeTraverse
        .collect(tree) {
          case TsTypeRef(_, TsQIdent(IArray.exactlyOne(unprefixedName)), _) if inScope.contains(unprefixedName) =>
            unprefixedName
        }
        .distinct

    /* the bound of one of the referenced tparams might refer to other tparams */
    val fromBounds: IArray[TsIdent] =
      TsTreeTraverse.collectIArray(IArray.fromOptions(inScope.collect {
        case (k, v) if referencedInTree.contains(k) => v.upperBound
      }.toSeq: _*)) {
        case TsTypeRef(_, TsQIdent(IArray.exactlyOne(unprefixedName)), _) if inScope.contains(unprefixedName) =>
          unprefixedName
      }

    (referencedInTree ++ fromBounds).distinct.filterNot(locallyDefined).map(inScope)
  }
}
