package com.olvind.tso
package scalajs
package transforms

/**
  * This is the second part of a two step process to rid ourselves of the myriad of
  *  type aliases resulting from the resolution of modules.
  *
  *  The first part is done in typescript, `InlineTrivialTypeAlias`, where we inline all trivial
  *  type aliases. We need to do the removal here in scala.js to ensure that all dependencies
  *  can also resolve all their uses of the intermediate type aliases.
  */
object CleanupTypeAliases extends TreeTransformation {
  override def leaveModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
    s.copy(members = clearEmptyContainers(removeTrivialTypeAlias(scope, s.members)))

  override def leavePackageTree(scope: TreeScope)(s: PackageTree): PackageTree =
    s.copy(members = clearEmptyContainers(removeTrivialTypeAlias(scope, s.members)))

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
        ta.comments.extract { case Markers.IsTrivial => () } match {
          case None => Some(ta)
          case Some((_, restCs)) =>
            if (restCs.cs.nonEmpty)
              Some(ta.copy(comments = restCs))
            None
        }

      case x: FieldTree =>
        x.comments.extract { case Markers.IsTrivial => () } match {
          case Some(_) => None
          case None    => Some(x)
        }
      case other => Some(other)
    }
}
