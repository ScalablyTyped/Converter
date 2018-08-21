package com.olvind.tso
package ts
package transforms

/* Type mappings, inheritance from sealed types, etc.
 *
 * Naturally, this begs for a proper implementation of type mappings. We'll get there... soon.
 */
object RemoveDifficultInheritance extends TreeVisitorScopedChanges {
  private val Unary       = Set[TsIdent](TsIdent("Partial"), TsIdent("ReadOnly"), TsIdent("Required"), TsIdent("NonNullable"))
  private val Binary      = Set[TsIdent](TsIdent("Pick"), TsIdent("Omit"))
  private val isDifficult = Set[TsIdent](TsIdent("Record"))

  private def cleanType(scope: TreeScope)(tpe: TsType): Option[Seq[TsTypeRef]] =
    tpe match {
      case tr: TsTypeRef => Some(cleanTypeRef(scope)(tr))
      case TsTypeIntersect(types) =>
        Some(types flatMap {
          case tr: TsTypeRef => cleanTypeRef(scope)(tr)
          case _ => Nil
        })
      case TsTypeUnion(_)    => Some(Nil)
      case TsTypeFunction(_) => None
      case _                 => Some(Nil)
    }

  private def cleanTypeRef(scope: TreeScope)(tpe: TsTypeRef): Seq[TsTypeRef] =
    tpe match {
      case TsTypeRef(x, Seq(one)) if Unary(x.parts.last)     => cleanType(scope)(one) getOrElse Nil
      case TsTypeRef(x, Seq(one, _)) if Binary(x.parts.last) => cleanType(scope)(one) getOrElse Nil
      case TsTypeRef(x, _) if isDifficult(x.parts.last)      => Nil

      /* We could solve this by using the types in the generated stdlib instead of scala.js types, but we don't for now */
      case TsTypeRef.string              => Nil
      case TsTypeRef.String              => Nil
      case TsTypeRef.number              => Nil
      case TsTypeRef.boolean             => Nil
      case TsTypeRef.Boolean             => Nil
      case TsTypeRef(TsQIdent.symbol, _) => Nil

      /* this causes issues since it's a class*/
      case TsTypeRef.`object` => Nil

      /* inline type aliases just to make things simpler */
      case tr: TsTypeRef =>
        scope.lookupTypeIncludeScope(tr.name).collectFirst {
          case (found: TsDeclTypeAlias, newScope) =>
            cleanType(newScope)(FillInTParams(found, tr.tparams).alias) getOrElse Seq(tr)
        } getOrElse (tr :: Nil)
      case _ =>
        Nil
    }

  override def enterTsDeclClass(scope: TreeScope)(s: TsDeclClass): TsDeclClass = {
    val original   = s.parent.to[Seq] ++ s.implements
    val newParents = (original flatMap cleanTypeRef(scope)).distinct

    val diff = original.filterNot(newParents.contains)
    if (diff.nonEmpty) {
      s.copy(parent     = newParents.headOption,
             implements = newParents.drop(1),
             comments   = s.comments + Comment(s"/* RemoveDifficultInheritance */"))
    } else {
      s
    }
  }
  override def enterTsDeclInterface(scope: TreeScope)(s: TsDeclInterface): TsDeclInterface = {
    val newParents = (s.inheritance flatMap cleanTypeRef(scope)).distinct
    val diff       = s.inheritance filterNot newParents.contains
    if (diff.nonEmpty) {
      s.copy(inheritance = newParents, comments = s.comments + Comment(s"/* RemoveDifficultStuff */"))
    } else {
      s
    }
  }
}
