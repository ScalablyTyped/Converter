package org.scalablytyped.converter.internal
package ts
package transforms

object TypeAliasIntersection extends TreeTransformationScopedChanges {
  override def enterTsDecl(scope: TsTreeScope)(x: TsDecl): TsDecl =
    x match {
      case TsDeclTypeAlias(comments, declared, name, tparams, TsTypeIntersect(types), codePath) =>
        types.partitionCollect2(
          // avoid inheritance of union types for instance
          { case x: TsTypeRef if !scope.isAbstract(x.name) && legalInheritance(FollowAliases(scope)(x)) => x },
          { case x: TsTypeObject if legalInheritance(x)                                                 => x },
        ) match {
          // note: this is too broad, but in part reverted by `PreferTypeAlias`
          case (inheritance, objects, Empty) =>
            TsDeclInterface(comments, declared, name, tparams, inheritance, objects.flatMap(_.members), codePath)
          case _ => x
        }
      case _ => x
    }

  def legalInheritance(x: TsType): Boolean =
    x match {
      case TsTypeRef(_, _, _)       => true
      case TsTypeObject(_, members) => !ExtractInterfaces.isTypeMapping(members)
      case TsTypeFunction(_)        => true
      case _                        => false
    }
}
