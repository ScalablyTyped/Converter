package org.scalablytyped.converter.internal
package ts
package transforms

object TypeAliasIntersection extends TreeTransformationScopedChanges {
  override def enterTsDecl(scope: TsTreeScope)(x: TsDecl): TsDecl =
    x match {
      case TsDeclTypeAlias(comments, declared, name, tparams, TsTypeIntersect(types), codePath) =>
        types.partitionCollect2({ case x: TsTypeRef if !scope.isAbstract(x.name) => x }, { case x: TsTypeObject => x }) match {
          case (inheritance, objects, Empty) =>
            TsDeclInterface(comments, declared, name, tparams, inheritance, objects.flatMap(_.members), codePath)
          case _ => x
        }
      case _ => x
    }
}
