package org.scalablytyped.converter.internal
package ts
package transforms

/**
  * This is the first part of a two step process to rid ourselves of the myriad of
  *  type aliases and interfaces resulting from the resolution of modules.
  *
  *  We need to do the removal in scala.js (`CleanupTypeAliases`) to ensure that
  *  all dependencies can also resolve all their uses of the intermediate type aliases.
  */
object InlineTrivial extends TreeTransformationScopedChanges {
  override def enterTsTypeRef(scope: TsTreeScope)(x: TsTypeRef): TsTypeRef =
    rewritten(scope, x).getOrElse(x)

  def rewritten(scope: TsTreeScope, x: TsTypeRef): Option[TsTypeRef] =
    x match {
      case ref @ TsTypeRef(_, target, tparams) if !TsQIdent.Primitive(target) =>
        scope.lookupTypeIncludeScope(target).firstDefined {
          case (TsDeclEnum(_, _, _, _, _, _, Some(exportedFrom), _, _), _) if tparams.isEmpty =>
            Some(ref.copy(name = exportedFrom.name))
          case (next: TsDeclTypeAlias, newScope) =>
            followTrivial(newScope)(next).map(newName => ref.copy(name = newName))
          case (next: TsDeclInterface, newScope) =>
            followTrivial(newScope)(next).map(newName => ref.copy(name = newName))
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

  def followTrivial(scope: TsTreeScope)(cur: TsDecl): Option[TsQIdent] =
    cur match {
      case TsDeclInterface(cs, _, _, _, IArray.first(EffectiveTypeRef(TsTypeRef(_, nextName, _))), _, codePath)
          if cs.has[Marker.IsTrivial.type] =>
        scope
          .lookupTypeIncludeScope(nextName)
          .firstDefined {
            case (next: TsNamedDecl, newScope) if next.codePath =/= codePath => // avoid SOE on invalid code
              followTrivial(newScope)(next)
            case _ => None
          }
          .orElse(Some(nextName))
      case TsDeclTypeAlias(cs, _, _, _, EffectiveTypeRef(TsTypeRef(_, nextName, _)), codePath)
          if cs.has[Marker.IsTrivial.type] =>
        scope
          .lookupTypeIncludeScope(nextName)
          .firstDefined {
            case (next: TsNamedDecl, newScope) if next.codePath =/= codePath => // avoid SOE on invalid code
              followTrivial(newScope)(next)
            case _ => None
          }
          .orElse(Some(nextName))
      case _ => None
    }
}
