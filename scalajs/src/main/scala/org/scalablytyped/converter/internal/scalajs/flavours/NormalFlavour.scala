package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.Selection
import org.scalablytyped.converter.internal.scalajs.transforms.CleanIllegalNames

case class NormalFlavour(
    shouldUseScalaJsDomTypes: Boolean,
    enableLongApplyMethod:    Boolean,
    outputPkg:                Name,
    versions:                 Versions,
) extends FlavourImplReact {

  override val enableReactTreeShaking: Selection[Name] =
    Selection.None

  override val dependencies: Set[Dep] =
    if (shouldUseScalaJsDomTypes) Set(versions.scalaJsDom, versions.runtime) else Set(versions.runtime)

  override val rewrites: IArray[CastConversion] =
    scalaJsLibNames.All ++ (if (shouldUseScalaJsDomTypes) scalaJsDomNames.All else Empty)

  val memberToProp  = new MemberToProp.Default(rewrites)
  val findProps     = new FindProps(new CleanIllegalNames(outputPkg), memberToProp, parentsResolver)
  val genCompanions = new GenCompanions(findProps, enableLongApplyMethod) >> GenPromiseOps

  final override def rewrittenTree(scope: TreeScope, tree: PackageTree): PackageTree =
    genCompanions.visitPackageTree(scope)(tree)
}
