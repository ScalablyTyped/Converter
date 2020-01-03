package org.scalablytyped.converter.internal
package ts
package transforms

object TypeAliasToConstEnum extends TreeTransformationScopedChanges {
  override def enterTsDecl(scope: TsTreeScope)(x: TsDecl): TsDecl =
    x match {
      case TsDeclTypeAlias(comments, declared, name, Empty, _, codePath)
          if scope.surroundingTsContainer.fold(false)(_.membersByName(name).length === 1) =>
        extractOnlyLiterals(scope, x) match {
          case Some(allLits) =>
            val members = allLits.map(lit =>
              TsEnumMember(
                NoComments,
                TsIdentSimple(lit.literal),
                Some(TsExpr.Literal(lit)),
              ),
            )
            TsDeclEnum(
              comments,
              declared,
              isConst = true,
              name,
              members,
              isValue = false,
              None,
              JsLocation.Zero,
              codePath,
            )
          case None => x
        }
      case _ => x
    }

  def extractOnlyLiterals(scope: TsTreeScope, x: TsDecl): Option[IArray[TsLiteral]] =
    x match {
      case TsDeclTypeAlias(_, _, _, Empty, TsTypeUnion(types), _) =>
        types.partitionCollect2({ case lit: TsTypeLiteral => lit.literal }, { case TsTypeRef(_, name, Empty) => name }) match {
          case (lits, refs, Empty) =>
            /* All type refs must also be to type unions with type literals */
            val nested: IArray[Option[IArray[TsLiteral]]] =
              refs.map(ref =>
                scope.lookupTypeIncludeScope(ref).firstDefined { case (xx, s) => extractOnlyLiterals(s, xx) },
              )

            nested.partitionCollect2({ case Some(valid) => valid }, { case None => null }) match {
              case (fromRefs, Empty, Empty) => Some((lits ++ fromRefs.flatten).sortBy(_.asString))
              case _                        => None
            }

          case _ => None
        }
      case _ => None
    }
}
