package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.flavours.CastConversion.TypeRewriterCast
import org.scalablytyped.converter.internal.scalajs.transforms.{Adapter, CleanIllegalNames}

case class NormalFlavour(
    shouldGenerateComponents: Boolean,
    shouldUseScalaJsDomTypes: Boolean,
    enableImplicitOps:        Boolean,
    outputPkg:                Name,
) extends FlavourImplReact {

  override val dependencies =
    if (shouldUseScalaJsDomTypes) Set(Versions.scalaJsDom, Versions.runtime) else Set(Versions.runtime)
  val genComponentsOpt = if (shouldGenerateComponents) Some(new GenReactFacadeComponents(reactNames)) else None
  val rewriterOpt      = if (shouldUseScalaJsDomTypes) Some(new TypeRewriterCast(scalaJsDomNames.All)) else None
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
