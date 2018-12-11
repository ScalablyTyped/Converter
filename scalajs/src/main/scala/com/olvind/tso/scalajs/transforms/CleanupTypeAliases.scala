package com.olvind.tso
package scalajs
package transforms

import com.olvind.tso.seqs.TraversableOps

/**
  * This is the second part of a two step process to rid ourselves of the myriad of
  *  type aliases resulting from the resolution of modules.
  *
  *  The first part is done in typescript, `InlineTrivialTypeAlias`, where we inline all trivial
  *  type aliases. We need to do the removal here in scala.js to ensure that all dependencies
  *  can also resolve all their uses of the intermediate type aliases.
  */
object CleanupTypeAliases extends SymbolTransformation {
  private def clearEmptyContainers(members: Seq[Symbol]): Seq[Symbol] =
    members.filter {
      case x: ModuleSymbol =>
        x.comments.cs.nonEmpty || x.parents.nonEmpty || clearEmptyContainers(x.members).nonEmpty
      case x: PackageSymbol =>
        x.comments.cs.nonEmpty || clearEmptyContainers(x.members).nonEmpty
      case _ => true
    }

  private def removeTrivialTypeAlias(scope: SymbolScope, members: Seq[Symbol]): Seq[Symbol] =
    members.flatMap {
      case ta: TypeAliasSymbol =>
        ta.comments.cs.partitionCollect { case constants.MagicComments.TrivialTypeAlias => () } match {
          case (Nil, _)       => Some(ta)
          case (_, Nil)       => None
          case (_, remaining) => Some(ta.copy(comments = Comments(remaining)))
        }
      case other => Some(other)
    }

  override def enterModuleSymbol(scope: SymbolScope)(s: ModuleSymbol): ModuleSymbol =
    s.copy(members = removeTrivialTypeAlias(scope, s.members))

  override def enterPackageSymbol(scope: SymbolScope)(s: PackageSymbol): PackageSymbol =
    s.copy(members = removeTrivialTypeAlias(scope, s.members))

  override def leaveModuleSymbol(scope: SymbolScope)(s: ModuleSymbol): ModuleSymbol =
    s.copy(members = clearEmptyContainers(s.members))

  override def leavePackageSymbol(scope: SymbolScope)(s: PackageSymbol): PackageSymbol =
    s.copy(members = clearEmptyContainers(s.members))
}
