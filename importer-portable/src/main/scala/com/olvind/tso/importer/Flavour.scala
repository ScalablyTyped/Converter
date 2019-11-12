package com.olvind.tso
package importer

import com.olvind.tso.scalajs.react._
import com.olvind.tso.scalajs.transforms.Adapter
import com.olvind.tso.scalajs.{ContainerTree, Dep, Name, PackageTree, TreeScope}

object Flavour {
  sealed trait ReactFlavour extends Flavour {
    private def involvesReact(scope: TreeScope): Boolean = {
      val react = Name("react")
      def findRoot(scope: TreeScope): TreeScope.Root[_] =
        scope match {
          case root: TreeScope.Root[_] => root
          case TreeScope.Scoped(_, outer, _) => findRoot(outer)
        }
      scope.libName === react || findRoot(scope).dependencies.contains(react)
    }

    final override def rewrittenTree(scope: TreeScope, tree: PackageTree): PackageTree =
      if (involvesReact(scope)) {
        val components: Seq[Component] =
          IdentifyReactComponents.oneOfEach(scope / tree, tree)
        Adapter(scope)((t, s) => rewrittenReactTree(s, t, components))(tree)
      } else tree

    def rewrittenReactTree(scope: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree =
      GenReactFacadeComponents(scope, tree, components)
  }

  case object normal extends Flavour {
    override def conversions: Option[Seq[CastConversion]] = None
    override def rewrittenTree(s: TreeScope, tree: PackageTree): PackageTree = tree
    override def dependencies: Set[Dep] = Set.empty
  }

  case object reactFacade extends ReactFlavour {
    override def conversions:  Option[Seq[CastConversion]] = None
    override def dependencies: Set[Dep]                    = Set.empty
    override def rewrittenReactTree(scope: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree =
      GenReactFacadeComponents(scope, tree, components)
  }

  case object reactSlinky extends ReactFlavour {
    override def conversions: Option[Seq[CastConversion]] =
      Some(GenSlinkyComponents.names.conversions)
    override def dependencies: Set[Dep] =
      Set(Dep("me.shadaj", "slinky-web", "0.6.2"))
    override def rewrittenReactTree(scope: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree =
      GenSlinkyComponents(scope, tree, components)
  }

  case object reactJapgolly extends ReactFlavour {
    override def conversions: Option[Seq[CastConversion]] =
      Some(GenJapgollyComponents.japgolly.conversions)
    override def dependencies: Set[Dep] =
      Set(Dep("com.github.japgolly.scalajs-react", "core", "1.4.2"))
    override def rewrittenReactTree(scope: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree =
      GenJapgollyComponents(scope, tree, components)
  }
}

sealed trait Flavour {
  def conversions: Option[Seq[CastConversion]]
  def rewrittenTree(s: TreeScope, tree: PackageTree): PackageTree
  def dependencies: Set[Dep]
}
