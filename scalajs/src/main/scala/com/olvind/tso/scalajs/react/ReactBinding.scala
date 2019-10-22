package com.olvind.tso
package scalajs
package react

object ReactBinding {
  val native = new ReactBinding {
    override def dependencies: Set[Dep] = Set.empty
    override def generateReactComponents(s: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree =
      GenerateReactComponentsObject(s, tree, components)
  }

  val slinky = new ReactBinding {
    override def dependencies: Set[Dep] =
      Set(Dep("me.shadaj", "slinky-web", "0.6.2"))
    override def generateReactComponents(s: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree =
      SlinkyComponents(s, tree, components)
  }
  val jagpolly = new ReactBinding {
    override def dependencies: Set[Dep] =
      Set(Dep("com.github.japgolly.scalajs-react", "core", "1.4.2"))
    override def generateReactComponents(s: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree =
      JagpollyComponents(s, tree, components)
  }
  val all = List(native, slinky, jagpolly)
}

sealed trait ReactBinding {
  def generateReactComponents(s: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree
  def dependencies: Set[Dep]
}
