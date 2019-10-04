package com.olvind.tso
package ts
package transforms

import com.olvind.tso.seqs._

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
        scope lookupTypeIncludeScope target firstDefined {
          case (TsDeclEnum(_, _, _, _, _, _, Some(exportedFrom), _, _), _) if tparams.isEmpty =>
            Some(ref.copy(name = exportedFrom.name))
          case (next: TsDeclTypeAlias, newScope) =>
            followTrivialAliases(newScope)(next).map(newName => ref.copy(name = newName))
          case _ => Some(x)
        }
      case _ => None
    }

  def followTrivialAliases(scope: TsTreeScope)(cur: TsDeclTypeAlias): Option[TsQIdent] =
    cur match {
      case TsDeclTypeAlias(cs, _, _, _, currentAlias @ TsTypeRef(_, nextName, _), codePath)
          if cs has Markers.IsTrivial =>
        scope
          .lookupTypeIncludeScope(nextName)
          .collectFirst {
            case (next: TsDeclTypeAlias, newScope) if next.codePath =/= codePath => // avoid SOE on invalid code
              followTrivialAliases(newScope)(next).getOrElse(currentAlias.name)
            case (other, _) =>
              other.codePath.forceHasPath.codePath
          }
          .orElse(Some(currentAlias.name))

      case TsDeclTypeAlias(_, _, _, _, _, codePath) =>
        Some(codePath.forceHasPath.codePath)
      case _ => None
    }
}
