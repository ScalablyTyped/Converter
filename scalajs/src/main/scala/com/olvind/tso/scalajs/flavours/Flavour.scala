package com.olvind.tso
package scalajs
package flavours

import com.olvind.tso.scalajs.transforms.Adapter

object Flavour {
  trait ReactFlavour extends Flavour {
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

    def rewrittenReactTree(scope: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree
  }

  case object Plain extends Flavour {
    override def conversions: Option[Seq[CastConversion]] =
      None
    override def rewrittenTree(s: TreeScope, tree: PackageTree): PackageTree =
      tree
    override def memberToParamOpt: Option[MemberToParam] =
      None
    override def dependencies: Set[Dep] =
      Set.empty

    val projectName  = "PlainlyTyped"
    val repo         = "https://github.com/oyvindberg/PlainlyTyped.git"
    val organization = "org.plainlytyped"
  }

  case object ReactFacade extends ReactFlavour {
    override def conversions: Option[Seq[CastConversion]] =
      None
    override def dependencies: Set[Dep] =
      Set.empty
    override def memberToParamOpt: Option[MemberToParam] =
      Some(MemberToParam.Default)
    override def rewrittenReactTree(scope: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree =
      GenReactFacadeComponents(scope, tree, components)

    val projectName  = "ScalablyTyped"
    val repo         = "https://github.com/oyvindberg/ScalablyTyped.git"
    val organization = "org.scalablytyped"
  }

  case object Slinky extends ReactFlavour {
    override def conversions: Option[Seq[CastConversion]] =
      Some(GenSlinkyComponents.names.conversions)
    override def dependencies: Set[Dep] =
      Set(Dep("me.shadaj", "slinky-web", "0.6.2"))
    override def memberToParamOpt: Some[MemberToParam] =
      Some(GenSlinkyComponents.memberToParameter)
    override def rewrittenReactTree(scope: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree =
      GenSlinkyComponents(scope, tree, components)
    val projectName  = "SlicklyTyped"
    val repo         = "https://github.com/oyvindberg/SlicklyTyped.git"
    val organization = "org.slicklytyped"
  }

  case object Japgolly extends ReactFlavour {
    override def conversions: Option[Seq[CastConversion]] =
      Some(GenJapgollyComponents.japgolly.conversions)
    override def dependencies: Set[Dep] =
      Set(Dep("com.github.japgolly.scalajs-react", "core", "1.4.2"))
    override def rewrittenReactTree(scope: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree =
      GenJapgollyComponents(scope, tree, components)
    override def memberToParamOpt =
      Some(GenJapgollyComponents.memberToParam)
    val projectName  = "GulliblyTyped"
    val repo         = "https://github.com/oyvindberg/GulliblyTyped.git"
    val organization = "org.gulliblytyped"
  }
}

trait Flavour {
  def conversions:      Option[Seq[CastConversion]]
  def memberToParamOpt: Option[MemberToParam]
  def rewrittenTree(s: TreeScope, tree: PackageTree): PackageTree
  def dependencies: Set[Dep]
  val projectName:  String
  val repo:         String
  val organization: String
}
