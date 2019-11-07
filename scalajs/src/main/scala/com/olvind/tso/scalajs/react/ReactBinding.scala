package com.olvind.tso
package scalajs
package react

import com.olvind.tso.scalajs.transforms.Adapter

object ReactBinding {
  val native = new ReactBinding {
    override def dependencies: Set[Dep] = Set.empty
    override def generateReactComponents(scope: TreeScope, tree: PackageTree, components: Seq[Component]): PackageTree =
      Adapter(scope)((t, s) => GenerateReactComponentsObject(s, t, components))(tree)
  }

  val slinky = new ReactBinding {
    override def dependencies: Set[Dep] =
      Set(Dep("me.shadaj", "slinky-web", "0.6.2"))
    override def generateReactComponents(s: TreeScope, tree: PackageTree, components: Seq[Component]): PackageTree =
      SlinkyComponents(s, tree, components)
  }
  val japgolly = new ReactBinding {
    override def dependencies: Set[Dep] =
      Set(Dep("com.github.japgolly.scalajs-react", "core", "1.4.2"))
    override def generateReactComponents(s: TreeScope, tree: PackageTree, components: Seq[Component]): PackageTree =
      JapgollyComponents(s, tree, components)
  }
  val all = List(native, slinky, japgolly)
}

sealed trait ReactBinding {
  def generateReactComponents(s: TreeScope, tree: PackageTree, components: Seq[Component]): PackageTree
  def dependencies: Set[Dep]
}
