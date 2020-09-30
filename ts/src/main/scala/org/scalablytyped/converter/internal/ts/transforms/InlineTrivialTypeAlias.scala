package org.scalablytyped.converter.internal
package ts
package transforms

/**
  * This is the first part of a two step process to rid ourselves of the myriad of
  *  type aliases resulting from the resolution of modules.
  *
  *  Here, we inline all trivial type aliases.
  *  We need to do the removal in scala.js (`CleanupTypeAliases`) to ensure that
  *  all dependencies can also resolve all their uses of the intermediate type aliases.
  */
object InlineTrivialTypeAlias extends TreeTransformationScopedChanges {
  override def enterTsTypeRef(scope: TsTreeScope)(x: TsTypeRef): TsTypeRef =
    rewritten(scope, x).getOrElse(x)

  def rewritten(scope: TsTreeScope, x: TsTypeRef): Option[TsTypeRef] =
    x match {
      case ref @ TsTypeRef(_, target, tparams) if !TsQIdent.Primitive(target) =>
        scope.lookupTypeIncludeScope(target).firstDefined {
          case (TsDeclEnum(_, _, _, _, _, _, Some(exportedFrom), _, _), _) if tparams.isEmpty =>
            Some(ref.copy(name = exportedFrom.name))
          case (next: TsDeclTypeAlias, newScope) =>
            followTrivialAliases(newScope)(next).map(newName => ref.copy(name = newName))
          case _ => None
        }
      case _ => None
    }

  /* bugfix for a case where we have ended up combining two types which are structurally equal */
  object EffectiveTypeRef {
    def unapply(tpe: TsType): Option[TsTypeRef] =
      tpe match {
        case tr: TsTypeRef => Some(tr)
        case TsTypeIntersect(types) =>
          types.partitionCollect { case x: TsTypeRef => x } match {
            case (all, Empty) if all.map(_.name.parts.last).distinct.length === 1 => Some(all.head)
            case _                                                                => None
          }
        case _ => None
      }
  }

  def followTrivialAliases(scope: TsTreeScope)(cur: TsDeclTypeAlias): Option[TsQIdent] =
    cur match {
      case TsDeclTypeAlias(cs, _, _, _, EffectiveTypeRef(TsTypeRef(_, nextName, _)), codePath)
          if cs.has[Markers.IsTrivial.type] =>
        scope
          .lookupTypeIncludeScope(nextName)
          .firstDefined {
            case (next: TsDeclTypeAlias, newScope) if next.codePath =/= codePath => // avoid SOE on invalid code
              followTrivialAliases(newScope)(next)
            case _ => None
          }
          .orElse(Some(nextName))
      case _ => None
    }
}
