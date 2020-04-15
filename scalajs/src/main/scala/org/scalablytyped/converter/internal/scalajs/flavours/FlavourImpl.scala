package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.flavours.CastConversion.TypeRewriterCast
import org.scalablytyped.converter.internal.scalajs.transforms.{Adapter, CleanIllegalNames}

object FlavourImpl {

  trait ReactFlavourImpl extends FlavourImpl {
    lazy val reactNames =
      new ReactNames(outputPkg)
    lazy val identifyComponents =
      new IdentifyReactComponents(reactNames)

    def involvesReact(scope: TreeScope): Boolean = {
      val react = Name("react")
      scope.libName === react || scope.root.dependencies.contains(react)
    }
  }

  case class Normal(
      shouldGenerateComponents: Boolean,
      shouldUseScalaJsDomTypes: Boolean,
      outputPkg:                Name,
  ) extends ReactFlavourImpl {
    val genComponentsOpt = if (shouldGenerateComponents) Some(new GenReactFacadeComponents(reactNames)) else None

    val conversions: Option[IArray[CastConversion]] =
      if (shouldUseScalaJsDomTypes)
        Some(scalaJsDomNames.All)
      else None

    override val dependencies: Set[Dep] =
      Set(Versions.runtime) ++ (if (shouldUseScalaJsDomTypes) Set(Versions.scalaJsDom) else Set.empty)

    val genCompanions: GenCompanions =
      new GenCompanions(MemberToProp.Default, findProps)

    final override def rewrittenTree(scope: TreeScope, tree: PackageTree): PackageTree = {
      val withCompanions = genCompanions.visitPackageTree(scope)(tree)

      val withComponents: PackageTree =
        genComponentsOpt match {
          case Some(genComponents) if involvesReact(scope) =>
            val components: IArray[Component] =
              identifyComponents.oneOfEach(scope / withCompanions, withCompanions)

            Adapter(scope)((t, s) => genComponents(s, t, components))(withCompanions)
          case _ => withCompanions
        }

      conversions match {
        case Some(conversions) => TypeRewriterCast(conversions).visitPackageTree(scope)(withComponents)
        case _                 => withComponents
      }
    }
  }

  case class SlinkyNative(outputPkg: Name) extends ReactFlavourImpl {

    override val dependencies: Set[Dep] =
      Set(Versions.runtime, Versions.slinkyNative, Versions.scalaJsDom)

    val gen = new GenSlinkyComponents(GenSlinkyComponents.Native(()), MemberToProp.Default, findProps)

    val genCompanions: GenCompanions =
      new GenCompanions(MemberToProp.Default, findProps)

    final override def rewrittenTree(scope: TreeScope, tree: PackageTree): PackageTree = {
      val withCompanions = genCompanions.visitPackageTree(scope)(tree)

      val withComponents: PackageTree =
        if (involvesReact(scope)) {
          val components: IArray[Component] =
            identifyComponents.oneOfEach(scope / withCompanions, withCompanions)
          Adapter(scope)((t, s) => gen(s, t, components))(withCompanions)
        } else withCompanions

      SlinkyTypeConversions(scalaJsDomNames, reactNames, isWeb = false).visitPackageTree(scope)(withComponents)
    }
  }

  case class Japgolly(outputPkg: Name) extends ReactFlavourImpl {
    val gen = new GenJapgollyComponents(reactNames, scalaJsDomNames, findProps)

    override val dependencies: Set[Dep] =
      Set(Versions.runtime, Versions.scalajsReact)
    val genCompanions: GenCompanions =
      new GenCompanions(gen.memberToProp, findProps)

    final override def rewrittenTree(scope: TreeScope, tree: PackageTree): PackageTree = {
      val withCompanions = genCompanions.visitPackageTree(scope)(tree)

      val withComponents: PackageTree =
        if (involvesReact(scope)) {
          val components: IArray[Component] =
            identifyComponents.oneOfEach(scope / withCompanions, withCompanions)
          Adapter(scope)((t, s) => gen(s, t, components))(withCompanions)
        } else withCompanions

      gen.ToJapgollyTypes.visitPackageTree(scope)(withComponents)
    }
  }
}

sealed trait FlavourImpl {
  def rewrittenTree(s: TreeScope, tree: PackageTree): PackageTree
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
