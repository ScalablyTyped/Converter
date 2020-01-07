package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.flavours.CastConversion.TypeRewriterCast
import org.scalablytyped.converter.internal.scalajs.transforms.{Adapter, CleanIllegalNames}

object Flavour {
  abstract class ReactFlavour(val outputPkg: Name) extends Flavour {
    lazy val reactNames =
      new ReactNames(outputPkg)
    def identifyComponents(prettyString: PrettyString) =
      new IdentifyReactComponents(reactNames, prettyString)
    lazy val stdNames =
      new QualifiedName.StdNames(outputPkg)
    lazy val scalaJsDomNames =
      new ScalaJsDomNames(stdNames)
    lazy val findProps =
      new FindProps(new CleanIllegalNames(outputPkg))

    private def involvesReact(scope: TreeScope): Boolean = {
      val react = Name("react")
      scope.libName === react || scope.root.dependencies.contains(react)
    }

    final override def rewrittenTree(scope: TreeScope, tree: PackageTree, prettyString: PrettyString): PackageTree = {
      val withCompanions = genCompanions.foldLeft(tree) {
        case (t, gen) => gen.visitPackageTree(scope)(t)
      }

      val withComponents =
        if (involvesReact(scope)) {
          val components: IArray[Component] =
            identifyComponents(prettyString).oneOfEach(scope / withCompanions, withCompanions)
          Adapter(scope)((t, s) => rewrittenReactTree(s, t, components))(withCompanions)
        } else withCompanions

      conversions match {
        case Some(conversions) => TypeRewriterCast(conversions).visitPackageTree(scope)(withComponents)
        case _                 => withComponents
      }
    }

    def rewrittenReactTree(scope: TreeScope, tree: ContainerTree, components: IArray[Component]): ContainerTree
  }

  class Plain(val outputPkg: Name = Name("typingsPlain")) extends Flavour {
    val projectName  = "PlainlyTyped"
    val repo         = "https://github.com/oyvindberg/PlainlyTyped.git"
    val organization = "org.scalablytyped.plain"

    override val conversions: Option[IArray[CastConversion]] =
      None
    override val dependencies: Set[Dep] =
      Set.empty
    override val genCompanions: Option[GenCompanions] =
      None
    override def rewrittenTree(s: TreeScope, tree: PackageTree, prettyString: PrettyString): PackageTree =
      tree
  }

  class Normal(shouldGenerateCompanions: Boolean, outputPkg: Name = Name("typings")) extends ReactFlavour(outputPkg) {
    val projectName  = "ScalablyTyped"
    val repo         = "https://github.com/oyvindberg/ScalablyTyped.git"
    val organization = "org.scalablytyped"
    val gen          = new GenReactFacadeComponents(reactNames)

    override val conversions: Option[IArray[CastConversion]] =
      None
    override val dependencies: Set[Dep] =
      Set.empty
    override val genCompanions: Option[GenCompanions] =
      if (shouldGenerateCompanions) Some(new GenCompanions(MemberToProp.Default, findProps)) else None

    override def rewrittenReactTree(
        scope:      TreeScope,
        tree:       ContainerTree,
        components: IArray[Component],
    ): ContainerTree =
      gen(scope, tree, components)
  }

  class Slinky(shouldGenerateCompanions: Boolean, outputPkg: Name = Name("typingsSlinky"))
      extends ReactFlavour(outputPkg) {
    val projectName  = "SlinkyTyped"
    val repo         = "https://github.com/oyvindberg/SlinkyTypes.git"
    val organization = "org.scalablytyped.slinky"
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
    override val genCompanions: Option[GenCompanions] =
      if (shouldGenerateCompanions) Some(new GenCompanions(gen.memberToProp, findProps)) else None
    override def rewrittenReactTree(
        scope:      TreeScope,
        tree:       ContainerTree,
        components: IArray[Component],
    ): ContainerTree =
      gen(scope, tree, components)
  }

  class SlinkyNative(shouldGenerateCompanions: Boolean, outputPkg: Name = Name("typingsSlinky"))
      extends ReactFlavour(outputPkg) {
    val projectName  = "SlinkyNativeTyped"
    val repo         = "https://github.com/oyvindberg/SlinkyNativeTypes.git"
    val organization = "org.scalablytyped.slinkynative"
    val gen          = new GenSlinkyComponents(scalaJsDomNames, GenSlinkyComponents.Native(()), stdNames, reactNames, findProps)

    override val conversions: Option[IArray[CastConversion]] =
      Some(gen.conversions)

    override val dependencies: Set[Dep] =
      Set(
        Dep("me.shadaj", "slinky-native", "0.6.2"),
        Dep("org.scala-js", "scalajs-dom", "0.9.8"),
      )

    override val genCompanions: Option[GenCompanions] =
      if (shouldGenerateCompanions) Some(new GenCompanions(gen.memberToProp, findProps)) else None
    override def rewrittenReactTree(
        scope:      TreeScope,
        tree:       ContainerTree,
        components: IArray[Component],
    ): ContainerTree =
      gen(scope, tree, components)
  }

  class Japgolly(shouldGenerateCompanions: Boolean, outputPkg: Name = Name("typingsJapgolly"))
      extends ReactFlavour(outputPkg) {
    val projectName  = "ScalajsReactTyped"
    val repo         = "https://github.com/oyvindberg/ScalajsReactTyped.git"
    val organization = "org.scalablytyped.japgolly"
    val gen          = new GenJapgollyComponents(reactNames, scalaJsDomNames, findProps)

    override val conversions: Option[IArray[CastConversion]] =
      Some(gen.conversions)
    override val dependencies: Set[Dep] =
      Set(Dep("com.github.japgolly.scalajs-react", "core", "1.5.0"))
    override val genCompanions: Option[GenCompanions] =
      if (shouldGenerateCompanions) Some(new GenCompanions(gen.memberToProp, findProps)) else None
    override def rewrittenReactTree(
        scope:      TreeScope,
        tree:       ContainerTree,
        components: IArray[Component],
    ): ContainerTree =
      gen(scope, tree, components)
  }
}

trait Flavour {
  def conversions: Option[IArray[CastConversion]]
  def rewrittenTree(s: TreeScope, tree: PackageTree, prettyString: PrettyString): PackageTree
  val genCompanions: Option[GenCompanions]
  def dependencies: Set[Dep]
  val projectName:  String
  val repo:         String
  val organization: String
  val outputPkg:    Name
  override val toString = getClass.getSimpleName
}
