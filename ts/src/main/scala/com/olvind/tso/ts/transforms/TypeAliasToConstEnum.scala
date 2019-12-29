package com.olvind.tso
package ts
package transforms

import com.olvind.tso.seqs._

object TypeAliasToConstEnum extends TreeTransformationScopedChanges {
  override def enterTsDecl(scope: TsTreeScope)(x: TsDecl): TsDecl =
    x match {
      case TsDeclTypeAlias(comments, declared, name, Nil, _, codePath)
          if scope.surroundingTsContainer.fold(false)(_.membersByName(name).length === 1) =>
        extractOnlyLiterals(scope, x) match {
          case Some(allLits) =>
            val members = allLits.map(
              lit =>
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

  def extractOnlyLiterals(scope: TsTreeScope, x: TsDecl): Option[Seq[TsLiteral]] =
    x match {
      case TsDeclTypeAlias(_, _, _, Nil, TsTypeUnion(types), _) =>
        types.partitionCollect2({ case lit: TsTypeLiteral => lit.literal }, { case TsTypeRef(_, name, Nil) => name }) match {
          case (lits, refs, Nil) =>
            /* All type refs must also be to type unions with type literals */
            val nested: Seq[Option[Seq[TsLiteral]]] =
              refs.map(
                ref => scope.lookupTypeIncludeScope(ref).firstDefined { case (xx, s) => extractOnlyLiterals(s, xx) },
              )

            nested.partitionCollect2({ case Some(valid) => valid }, { case None => () }) match {
              case (fromRefs, Nil, Nil) => Some((lits ++ fromRefs.flatten).sortBy(_.asString))
              case _                    => None
            }

          case _ => None
        }
      case _ => None
    }
}
