package com.olvind.tso.ts.transforms

import com.olvind.tso.ts._
import scala.collection.Map

class TypeRewriter(base: TsTree) extends TreeTransformation[Map[TsType, TsType]] {
  override def leaveTsType(replacements: Map[TsType, TsType])(x: TsType): TsType =
    replacements.getOrElse(x, x)

  override def withTree(t: Map[TsType, TsType], tree: TsTree): Map[TsType, TsType] =
    if (tree === base) t
    else
      tree match {
        /* Handle if the current tree introduces a new type parameter which shadows what we are trying to inline */
        case HasTParams(tparams) =>
          t.filterKeys {
            case TsTypeRef(TsQIdent(Seq(one)), _) if tparams.exists(_.name === one) => false
            case _                                                                  => true
          }
        case _ => t
      }
}
