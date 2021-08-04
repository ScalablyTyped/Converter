package org.scalablytyped.converter.internal
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
object CleanupTrivial extends TreeTransformation {
  override def leaveModuleTree(scope: TreeScope)(s: ModuleTree): ModuleTree =
    s.copy(members = clearEmptyContainers(removeTrivial(s.members)))

  override def leavePackageTree(scope: TreeScope)(s: PackageTree): PackageTree =
    s.copy(members = clearEmptyContainers(removeTrivial(s.members)))

  def clearEmptyContainers(members: IArray[Tree]): IArray[Tree] =
    members.filter {
      case x: ModuleTree =>
        x.parents.nonEmpty ||
          x.members.nonEmpty ||
          x.name === Name.namespaced ||
          x.comments.has[Marker.ManglerLeaveAlone.type] // keeps the require object and hence the whole library if empty
      case x: PackageTree =>
        x.members.nonEmpty
      case _ => true
    }

  def removeTrivial(members: IArray[Tree]): IArray[Tree] =
    members.filterNot(_.comments.has[Marker.IsTrivial.type])
}
