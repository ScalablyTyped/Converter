package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.flavours.CastConversion.TypeRewriterCast
import org.scalablytyped.converter.internal.scalajs.transforms.{Adapter, CleanIllegalNames}

object FlavourImpl {

  sealed trait ReactFlavourImpl extends FlavourImpl {
    lazy val reactNames =
      new ReactNames(outputPkg)
    lazy val identifyComponents =
      new IdentifyReactComponents(reactNames)

    private def involvesReact(scope: TreeScope): Boolean = {
      val react = Name("react")
      scope.libName === react || scope.root.dependencies.contains(react)
    }

    final override def rewrittenTree(scope: TreeScope, tree: PackageTree): PackageTree = {
      val withCompanions = genCompanions.visitPackageTree(scope)(tree)

      val withComponents =
        if (involvesReact(scope)) {
          val components: IArray[Component] =
            identifyComponents.oneOfEach(scope / withCompanions, withCompanions)
          Adapter(scope)((t, s) => rewrittenReactTree(s, t, components))(withCompanions)
        } else withCompanions

      conversions match {
        case Some(conversions) => TypeRewriterCast(conversions).visitPackageTree(scope)(withComponents)
        case _                 => withComponents
      }
    }

    def rewrittenReactTree(scope: TreeScope, tree: ContainerTree, components: IArray[Component]): ContainerTree
  }

  case class Normal(
      shouldGenerateComponents: Boolean,
      shouldUseScalaJsDomTypes: Boolean,
      outputPkg:                Name,
  ) extends ReactFlavourImpl {
    val genComponentsOpt = if (shouldGenerateComponents) Some(new GenReactFacadeComponents(reactNames)) else None

    override val conversions: Option[IArray[CastConversion]] =
      if (shouldUseScalaJsDomTypes)
        Some(scalaJsDomNames.AllExceptDeprecated)
      else None

    override val dependencies: Set[Dep] =
      if (shouldUseScalaJsDomTypes)
        Set(Dep("org.scala-js", "scalajs-dom", "0.9.8"))
      else Set.empty

    override val genCompanions: GenCompanions =
      new GenCompanions(MemberToProp.Default, findProps)

    override def rewrittenReactTree(
        scope:      TreeScope,
        tree:       ContainerTree,
        components: IArray[Component],
    ): ContainerTree =
      genComponentsOpt.foldLeft(tree) { case (t, gen) => gen(scope, t, components) }
  }

  case class Slinky(outputPkg: Name) extends ReactFlavourImpl {
    val gen = new GenSlinkyComponents(
      scalaJsDomNames,
      GenSlinkyComponents.Web(new SlinkyWeb(reactNames)),
      stdNames,
      reactNames,
      findProps,
    )

    override val conversions: Option[IArray[CastConversion]] =
      Some(gen.conversions)
    override val dependencies: Set[Dep] =
      Set(Dep("me.shadaj", "slinky-web", "0.6.2"))
    override val genCompanions: GenCompanions =
      new GenCompanions(gen.memberToProp, findProps)
    override def rewrittenReactTree(
        scope:      TreeScope,
        tree:       ContainerTree,
        components: IArray[Component],
    ): ContainerTree =
      gen(scope, tree, components)
  }

  case class SlinkyNative(outputPkg: Name) extends ReactFlavourImpl {
    val gen = new GenSlinkyComponents(scalaJsDomNames, GenSlinkyComponents.Native(()), stdNames, reactNames, findProps)

    override val conversions: Option[IArray[CastConversion]] =
      Some(gen.conversions)

    override val dependencies: Set[Dep] =
      Set(
        Dep("me.shadaj", "slinky-native", "0.6.2"),
        Dep("org.scala-js", "scalajs-dom", "0.9.8"),
      )

    override val genCompanions: GenCompanions =
      new GenCompanions(gen.memberToProp, findProps)

    override def rewrittenReactTree(
        scope:      TreeScope,
        tree:       ContainerTree,
        components: IArray[Component],
    ): ContainerTree =
      gen(scope, tree, components)
  }

  case class Japgolly(outputPkg: Name) extends ReactFlavourImpl {
    val gen = new GenJapgollyComponents(reactNames, scalaJsDomNames, findProps)

    override val conversions: Option[IArray[CastConversion]] =
      Some(gen.conversions)
    override val dependencies: Set[Dep] =
      Set(Dep("com.github.japgolly.scalajs-react", "core", "1.5.0"))
    override val genCompanions: GenCompanions =
      new GenCompanions(gen.memberToProp, findProps)
    override def rewrittenReactTree(
        scope:      TreeScope,
        tree:       ContainerTree,
        components: IArray[Component],
    ): ContainerTree =
      gen(scope, tree, components)
  }
}

sealed trait FlavourImpl {
  def conversions: Option[IArray[CastConversion]]
  def rewrittenTree(s: TreeScope, tree: PackageTree): PackageTree
  val genCompanions: GenCompanions
  def dependencies: Set[Dep]
  val outputPkg: Name

  lazy val stdNames =
    new QualifiedName.StdNames(outputPkg)
  lazy val scalaJsDomNames =
    new ScalaJsDomNames(stdNames)
  lazy val findProps =
    new FindProps(new CleanIllegalNames(outputPkg))

  override val toString = getClass.getSimpleName
}
