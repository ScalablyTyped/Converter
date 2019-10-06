package com.olvind.tso.importer

import com.olvind.tso.Set
import com.olvind.tso.scalajs.transforms.{GenerateReactComponentsObject, ScalaJsReactComponents, SlinkyComponents}
import com.olvind.tso.scalajs.{ContainerTree, TreeScope}

object ReactBinding {
  val slinky = new ReactBinding {
    override def dependencies: Set[FacadeJson.Dep] =
      Set(FacadeJson.Dep("me.shadaj", "slinky-web", "0.6.2"))
    override def generateReactComponents(s: TreeScope, tree: ContainerTree): ContainerTree =
      SlinkyComponents(s, GenerateReactComponentsObject(s, tree))
  }
  val scalajsReact = new ReactBinding {
    override def dependencies: Set[FacadeJson.Dep] =
      Set(FacadeJson.Dep("com.github.japgolly.scalajs-react", "core", "1.4.2"))
    override def generateReactComponents(s: TreeScope, tree: ContainerTree): ContainerTree =
      ScalaJsReactComponents(s, GenerateReactComponentsObject(s, tree))
  }
}

sealed trait ReactBinding {
  def generateReactComponents(s: TreeScope, tree: ContainerTree): ContainerTree
  def dependencies: Set[FacadeJson.Dep]
}
