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
object CleanupTypeAliases extends TreeTransformation {
  override def enterModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
    s.copy(members = removeTrivialTypeAlias(scope, s.members))

  override def enterPackageTree(scope: TreeScope)(s: PackageTree): PackageTree =
    s.copy(members = removeTrivialTypeAlias(scope, s.members))

  override def leaveModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
    s.copy(members = clearEmptyContainers(s.members))

  override def leavePackageTree(scope: TreeScope)(s: PackageTree): PackageTree =
    s.copy(members = clearEmptyContainers(s.members))

  def clearEmptyContainers(members: Seq[Tree]): Seq[Tree] =
    members.filter {
      case x: ModuleTree =>
        x.comments.cs.nonEmpty || x.parents.nonEmpty || clearEmptyContainers(x.members).nonEmpty
      case x: PackageTree =>
        x.comments.cs.nonEmpty || clearEmptyContainers(x.members).nonEmpty
      case _ => true
    }

  def removeTrivialTypeAlias(scope: TreeScope, members: Seq[Tree]): Seq[Tree] =
    members.flatMap {
      case ta: TypeAliasTree =>
        ta.comments.cs.partitionCollect { case constants.MagicComments.TrivialTypeAlias => () } match {
          case (Nil, _)       => Some(ta)
          case (_, Nil)       => None
          case (_, remaining) => Some(ta.copy(comments = Comments(remaining)))
        }
      case other => Some(other)
    }
}
