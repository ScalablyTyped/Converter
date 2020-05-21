package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.transforms.{Adapter, CleanIllegalNames}

case class JapgollyFlavour(outputPkg: Name, enableImplicitOps: Boolean) extends FlavourImplReact {
  override val dependencies = Set(Versions.runtime, Versions.scalajsReact)
  val rewriter              = new CastConversion.TypeRewriterCast(JapgollyTypeConversions(reactNames, scalaJsDomNames))
  val memberToPro           = new JapgollyMemberToProp(reactNames, rewriter)
  val findProps             = new FindProps(new CleanIllegalNames(outputPkg), memberToPro, parentsResolver)
  val genComponents         = new JapgollyGenComponents(reactNames, findProps)
  val genCompanions         = new GenCompanions(findProps, enableImplicitOps)

  final override def rewrittenTree(scope: TreeScope, tree: PackageTree): PackageTree = {
    val withCompanions = genCompanions.visitPackageTree(scope)(tree)

    val withComponents: PackageTree =
      if (involvesReact(scope)) {
        val components: IArray[Component] =
          identifyComponents.oneOfEach(scope / withCompanions, withCompanions)
        Adapter(scope)((t, s) => genComponents(s, t, components))(withCompanions)
      } else withCompanions

    rewriter.visitPackageTree(scope)(withComponents)
  }
}
