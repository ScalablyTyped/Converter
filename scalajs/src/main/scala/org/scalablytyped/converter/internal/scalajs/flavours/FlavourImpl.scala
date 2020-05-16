package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.flavours.CastConversion.TypeRewriterCast
import org.scalablytyped.converter.internal.scalajs.transforms.{Adapter, CleanIllegalNames}

object FlavourImpl {

  trait ReactFlavourImpl extends FlavourImpl {
    val stdNames           = new QualifiedName.StdNames(outputPkg)
    val scalaJsDomNames    = new ScalaJsDomNames(stdNames)
    val reactNames         = new ReactNames(outputPkg)
    val identifyComponents = new IdentifyReactComponents(reactNames)

    def involvesReact(scope: TreeScope): Boolean = {
      val react = Name("react")
      scope.libName === react || scope.root.dependencies.contains(react)
    }
  }

  case class Normal(
      shouldGenerateComponents: Boolean,
      shouldUseScalaJsDomTypes: Boolean,
      enableImplicitOps:        Boolean,
      outputPkg:                Name,
  ) extends ReactFlavourImpl {
    override val dependencies =
      if (shouldUseScalaJsDomTypes) Set(Versions.scalaJsDom, Versions.runtime) else Set(Versions.runtime)
    val genComponentsOpt = if (shouldGenerateComponents) Some(new GenReactFacadeComponents(reactNames)) else None
    val rewriterOpt      = if (shouldUseScalaJsDomTypes) Some(TypeRewriterCast(scalaJsDomNames.All)) else None
    val memberToProp     = new MemberToProp.Default(rewriterOpt)
    val findProps        = new FindProps(new CleanIllegalNames(outputPkg), memberToProp)
    val genCompanions    = new GenCompanions(findProps, enableImplicitOps)

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

      rewriterOpt match {
        case Some(rewriter) => rewriter.visitPackageTree(scope)(withComponents)
        case _              => withComponents
      }
    }
  }

  case class SlinkyNative(outputPkg: Name, enableImplicitOps: Boolean) extends ReactFlavourImpl {

    override val dependencies: Set[Dep] =
      Set(Versions.runtime, Versions.slinkyNative, Versions.scalaJsDom)

    val rewriter      = SlinkyTypeConversions(scalaJsDomNames, reactNames, isWeb = false)
    val memberToProp  = new MemberToProp.Default(Some(rewriter))
    val findProps     = new FindProps(new CleanIllegalNames(outputPkg), memberToProp)
    val gen           = new SlinkyGenComponents(SlinkyGenComponents.Native(()), findProps)
    val genCompanions = new GenCompanions(findProps, enableImplicitOps)

    final override def rewrittenTree(scope: TreeScope, tree: PackageTree): PackageTree = {
      val withCompanions = genCompanions.visitPackageTree(scope)(tree)

      val withComponents: PackageTree =
        if (involvesReact(scope)) {
          val components: IArray[Component] =
            identifyComponents.oneOfEach(scope / withCompanions, withCompanions)
          Adapter(scope)((t, s) => gen(s, t, components))(withCompanions)
        } else withCompanions

      rewriter.visitPackageTree(scope)(withComponents)
    }
  }

  case class Japgolly(outputPkg: Name, enableImplicitOps: Boolean) extends ReactFlavourImpl {
    override val dependencies = Set(Versions.runtime, Versions.scalajsReact)
    val rewriter              = JapgollyTypeConversions(reactNames, scalaJsDomNames)
    val memberToProp          = new JapgollyMemberToProp(reactNames, rewriter)
    val findProps             = new FindProps(new CleanIllegalNames(outputPkg), memberToProp)
    val gen                   = new JapgollyGenComponents(reactNames, findProps)
    val genCompanions         = new GenCompanions(findProps, enableImplicitOps)

    final override def rewrittenTree(scope: TreeScope, tree: PackageTree): PackageTree = {
      val withCompanions = genCompanions.visitPackageTree(scope)(tree)

      val withComponents: PackageTree =
        if (involvesReact(scope)) {
          val components: IArray[Component] =
            identifyComponents.oneOfEach(scope / withCompanions, withCompanions)
          Adapter(scope)((t, s) => gen(s, t, components))(withCompanions)
        } else withCompanions

      rewriter.visitPackageTree(scope)(withComponents)
    }
  }
}

sealed trait FlavourImpl {
  def rewrittenTree(s: TreeScope, tree: PackageTree): PackageTree
  def dependencies: Set[Dep]
  val outputPkg: Name

  override val toString = getClass.getSimpleName
}
