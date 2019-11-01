package com.olvind.tso.ts.transforms

import com.olvind.tso.ts.{
  TreeTransformationScopedChanges,
  TsMemberCall,
  TsTreeScope,
  TsType,
  TsTypeFunction,
  TsTypeObject,
}

object Simplify extends TreeTransformationScopedChanges {
  override def enterTsType(scope: TsTreeScope)(x: TsType): TsType =
    x match {
      case TsTypeObject(_, Seq(TsMemberCall(_, _, sig))) =>
        TsTypeFunction(sig)
      case other => other
    }
}
