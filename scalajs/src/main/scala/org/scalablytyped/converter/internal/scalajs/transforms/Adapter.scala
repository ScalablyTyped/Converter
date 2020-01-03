package org.scalablytyped.converter.internal
package scalajs
package transforms

import seqs._

/** Some of the transformations were written before we added the `typings` outermost package.
  *  This maintains that somewhat simpler world view */
object Adapter {
  def apply(scope: TreeScope)(f: (ContainerTree, TreeScope) => ContainerTree): PackageTree => PackageTree = {
    case pkg @ PackageTree(_, _, members, _, _) =>
      members.partitionCollect { case x: ContainerTree if x.name === scope.libName => x } match {
        case (Seq(one), rest) => pkg.copy(members = rest ++ List(f(one, scope / pkg)))
        case notFound         => sys.error(s"Expected library package, got: ${notFound}")
      }

    case other =>
      sys.error(s"Expected top level package, got: ${other}")
  }
}
