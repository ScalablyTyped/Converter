package org.scalablytyped.converter.internal
package ts

object HasTParams {
  def apply(t: TsTree): IArray[TsTypeParam] = unapply(t).getOrElse(Empty)

  def unapply(t: TsTree): Option[IArray[TsTypeParam]] =
    t match {
      case x: TsDeclClass => Some(x.tparams)
      case x: TsDeclInterface => Some(x.tparams)
      case x: TsDeclTypeAlias => Some(x.tparams)
      case x: TsDeclFunction => Some(x.signature.tparams)
      case x: TsMemberFunction => Some(x.signature.tparams)
      case x: TsMemberCall => Some(x.signature.tparams)
      case x: TsMemberCtor => Some(x.signature.tparams)
      case x: TsTypeFunction => Some(x.signature.tparams)
      case x: TsFunSig => Some(x.tparams)
      case x: TsTypeConditional =>
        val found = TsTreeTraverse.collect(x.pred) {
          case TsTypeInfer(tparam) => tparam
        }
        if (found.nonEmpty) Some(found) else None
      case _ => None
    }
}
