package org.scalablytyped.converter.internal
package ts

object TypeParamsReferencedInTree {
  def apply(inScope: Map[TsIdent, TsTypeParam], tree: TsTree): IArray[TsTypeParam] = {
    val referencedInTree: IArray[TsIdent] = {
      val referenced = IArray.Builder.empty[TsIdent]

      object Visitor extends TreeTransformation[Map[TsIdent, TsTypeParam]] {
        override def enterTsTypeRef(inScope: Map[TsIdent, TsTypeParam])(x: TsTypeRef): TsTypeRef = {
          x match {
            case TsTypeRef(_, TsQIdent(IArray.exactlyOne(unprefixedName)), _) if inScope.contains(unprefixedName) =>
              referenced += unprefixedName
            case _ => ()
          }
          x
        }

        override def withTree(inScope: Map[TsIdent, TsTypeParam], tree: TsTree): Map[TsIdent, TsTypeParam] =
          tree match {
            case HasTParams(tparams) => inScope.filterNot { case (name, _) => tparams.exists(tp => name === tp.name) }
            case _                   => inScope
          }
      }

      Visitor.visitTsTree(inScope)(tree)
      referenced.result().distinct
    }

    /* the bound of one of the referenced tparams might refer to other tparams */
    val fromBounds: IArray[TsIdent] =
      TsTreeTraverse.collectIArray(IArray.fromOptions(inScope.collect {
        case (k, v) if referencedInTree.contains(k) => v.upperBound
      }.toSeq: _*)) {
        case TsTypeRef(_, TsQIdent(IArray.exactlyOne(unprefixedName)), _) if inScope.contains(unprefixedName) =>
          unprefixedName
      }

    (referencedInTree ++ fromBounds).distinct.map(inScope)
  }
}
