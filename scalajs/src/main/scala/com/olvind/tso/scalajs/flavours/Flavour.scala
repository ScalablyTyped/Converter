package com.olvind.tso
package scalajs
package flavours

import com.olvind.tso.scalajs.transforms.{Adapter, CleanIllegalNames}

object Flavour {
  trait ReactFlavour extends Flavour {
    lazy val reactNames =
      new ReactNames(outputPkg)
    lazy val identifyComponents =
      new IdentifyReactComponents(reactNames)
    lazy val stdNames =
      new QualifiedName.StdNames(outputPkg)
    lazy val scalaJsDomNames =
      new ScalaJsDomNames(stdNames)
    lazy val params =
      new Params(new CleanIllegalNames(outputPkg))

    private def involvesReact(scope: TreeScope): Boolean = {
      val react = Name("react")
      scope.libName === react || scope.root.dependencies.contains(react)
    }

    final override def rewrittenTree(scope: TreeScope, tree: PackageTree): PackageTree =
      if (involvesReact(scope)) {
        val components: Seq[Component] = identifyComponents.oneOfEach(scope / tree, tree)
        Adapter(scope)((t, s) => rewrittenReactTree(s, t, components))(tree)
      } else tree

    def rewrittenReactTree(scope: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree
  }

  case object Plain extends Flavour {
    val projectName  = "PlainlyTyped"
    val repo         = "https://github.com/oyvindberg/PlainlyTyped.git"
    val organization = "org.plainlytyped"
    val outputPkg    = Name("typingsPlain")

    override def conversions: Option[Seq[CastConversion]] =
      None
    override def rewrittenTree(s: TreeScope, tree: PackageTree): PackageTree =
      tree
    override def memberToParamOpt: Option[MemberToParam] =
      None
    override def dependencies: Set[Dep] =
      Set.empty
  }

  case object ReactFacade extends ReactFlavour {
    val projectName  = "ScalablyTyped"
    val repo         = "https://github.com/oyvindberg/ScalablyTyped.git"
    val organization = "org.scalablytyped"
    val outputPkg    = Name("typings")
    val gen          = new GenReactFacadeComponents(reactNames)

    override def conversions: Option[Seq[CastConversion]] =
      None
    override def dependencies: Set[Dep] =
      Set.empty
    override def memberToParamOpt: Option[MemberToParam] =
      Some(MemberToParam.Default)
    override def rewrittenReactTree(scope: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree =
      gen(scope, tree, components)
  }

  case object Slinky extends ReactFlavour {
    val projectName  = "SlicklyTyped"
    val repo         = "https://github.com/oyvindberg/SlicklyTyped.git"
    val organization = "org.slicklytyped"
    val outputPkg    = Name("typingsSlinky")
    val gen          = new GenSlinkyComponents(scalaJsDomNames, stdNames, reactNames, params)

    override def conversions: Option[Seq[CastConversion]] =
      Some(gen.conversions)
    override def dependencies: Set[Dep] =
      Set(Dep("me.shadaj", "slinky-web", "0.6.2"))
    override def memberToParamOpt: Some[MemberToParam] =
      Some(gen.memberToParameter)
    override def rewrittenReactTree(scope: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree =
      gen(scope, tree, components)
  }

  case object Japgolly extends ReactFlavour {
    val projectName  = "GulliblyTyped"
    val repo         = "https://github.com/oyvindberg/GulliblyTyped.git"
    val organization = "org.gulliblytyped"
    val outputPkg    = Name("typingsJapgolly")
    val gen          = new GenJapgollyComponents(reactNames, scalaJsDomNames, params)

    override def conversions: Option[Seq[CastConversion]] =
      Some(gen.conversions)
    override def dependencies: Set[Dep] =
      Set(Dep("com.github.japgolly.scalajs-react", "core", "1.4.2"))
    override def rewrittenReactTree(scope: TreeScope, tree: ContainerTree, components: Seq[Component]): ContainerTree =
      gen(scope, tree, components)
    override def memberToParamOpt =
      Some(gen.memberToParam)
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
  val outputPkg:    Name
}
