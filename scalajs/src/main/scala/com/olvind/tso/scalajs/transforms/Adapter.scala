package com.olvind.tso
package scalajs
package transforms

/** Some of the transformations were written before we added the `typings` outermost package.
  *  This maintains that somewhat simpler world view */
object Adapter {
  def apply(scope: TreeScope)(f: (ContainerTree, TreeScope) => ContainerTree): PackageTree => PackageTree = {
    case pkg @ PackageTree(_, _, Seq(one: ContainerTree), _, _) =>
      pkg.copy(members = List(f(one, scope / pkg)))
    case other =>
      sys.error(s"Expected top level package, got: ${other}")
  }
}
