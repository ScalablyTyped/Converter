package com.olvind.tso
package ts
package transforms

/**
  * This is the first part of a two step process to rid ourselves of the myriad of
  *  type aliases resulting from the resolution of modules.
  *
  *  Here, we inline all trivial type aliases.
  *  We need to do the removal  in scala.js (`CleanupTypeAliases`) to ensure that
  *  all dependencies can also resolve all their uses of the intermediate type aliases.
  */
object InlineTrivialTypeAlias extends TreeVisitorScopedChanges {

  /* changing this? also change `Cleanup`. We need to do it in two stages */
  def followTrivialAliases(scope: TreeScope)(cur: TsDeclTypeAlias): Option[TsQIdent] =
    cur match {
      case TsDeclTypeAlias(cs, _, _, _, currentAlias @ TsTypeRef(nextName, _), codePath)
          if cs.cs.exists(_ === constants.MagicComments.TrivialTypeAlias) =>
        scope
          .lookupIncludeScope(nextName)
          .collectFirst {
            case (next: TsDeclTypeAlias, newScope) if next.codePath =/= codePath => // avoid SOE on invalid code
              followTrivialAliases(newScope)(next).getOrElse(currentAlias.name)
            case (other, _) =>
              require(currentAlias.name === other.codePath.forceHasPath.codePath)
              currentAlias.name
          }
      case _ => None
    }

  override def enterTsTypeRef(scope: TreeScope)(x: TsTypeRef): TsTypeRef =
    handleRef(scope, x)

  private def handleRef(scope: TreeScope, x: TsTypeRef): TsTypeRef = {
    val simplifiedOpt = x match {
      case ref @ TsTypeRef(target: TsQIdent, tparams) if !TsQIdent.Primitive(target) && !TsQIdent.BuiltIn(target) =>
        val ret: Option[Option[TsTypeRef]] =
          scope lookupBase (Picker.Types, target) collectFirst {
            case (TsDeclEnum(_, _, _, _, _, Some(exportedFrom), _, _), _) if tparams.isEmpty =>
              Some(ref.copy(name = exportedFrom.name))
            case (next: TsDeclTypeAlias, newScope) =>
              followTrivialAliases(newScope)(next).map(newName => ref.copy(name = newName))
            case (x: TsNamedDecl, _) =>
              Some(ref.copy(name = x.codePath.forceHasPath.codePath))
            case _ => Some(x)
          }

        ret.flatten
      case _ => None
    }
    simplifiedOpt.getOrElse(x)
  }
}
