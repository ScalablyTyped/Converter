package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.Selection
import org.scalablytyped.converter.internal.scalajs.flavours.CastConversion.TypeRewriterCast
import org.scalablytyped.converter.internal.scalajs.transforms.CleanIllegalNames

case class NormalFlavour(
    shouldUseScalaJsDomTypes: Boolean,
    enableLongApplyMethod:    Boolean,
    outputPkg:                Name,
) extends FlavourImplReact {

  override val enableReactTreeShaking: Selection[Name] =
    Selection.None

  override val dependencies: Set[Dep] =
    if (shouldUseScalaJsDomTypes) Set(Versions.scalaJsDom, Versions.runtime) else Set(Versions.runtime)

  override val rewritesOpt: Option[TypeRewriterCast] =
    if (shouldUseScalaJsDomTypes) Some(new TypeRewriterCast(scalaJsDomNames.All)) else None

  val memberToProp  = new MemberToProp.Default(rewritesOpt)
  val findProps     = new FindProps(new CleanIllegalNames(outputPkg), memberToProp, parentsResolver)
  val genCompanions = new GenCompanions(findProps, enableLongApplyMethod)

  final override def rewrittenTree(scope: TreeScope, tree: PackageTree): PackageTree = {
    val withCompanions = genCompanions.visitPackageTree(scope)(tree)

    rewritesOpt match {
      case Some(rewriter) => rewriter.visitPackageTree(scope)(withCompanions)
      case _              => withCompanions
    }
  }

}
