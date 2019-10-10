package com.olvind.tso
package scalajs
package react

object ReactBinding {
  val native = new ReactBinding {
    override def dependencies: Set[Dep] = Set.empty
    override def generateReactComponents(s: TreeScope, tree: ContainerTree): ContainerTree =
      GenerateReactComponentsObject(s, tree)
  }

  val slinky = new ReactBinding {
    override def dependencies: Set[Dep] =
      Set(Dep("me.shadaj", "slinky-web", "0.6.2"))
    override def generateReactComponents(s: TreeScope, tree: ContainerTree): ContainerTree =
      SlinkyComponents(s, GenerateReactComponentsObject(s, tree))
  }
  val scalajsReact = new ReactBinding {
    override def dependencies: Set[Dep] =
      Set(Dep("com.github.japgolly.scalajs-react", "core", "1.4.2"))
    override def generateReactComponents(s: TreeScope, tree: ContainerTree): ContainerTree =
      ScalaJsReactComponents(s, scalajs.react.GenerateReactComponentsObject(s, tree))
  }
}

sealed trait ReactBinding {
  def generateReactComponents(s: TreeScope, tree: ContainerTree): ContainerTree
  def dependencies: Set[Dep]
}
