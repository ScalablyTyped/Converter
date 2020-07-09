package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.transforms.{Adapter, CleanIllegalNames}

case class JapgollyFlavour(outputPkg: Name) extends FlavourImplReact {
  override val dependencies  = Set(Versions.runtime, Versions.scalajsReact)
  val rewriter               = new CastConversion.TypeRewriterCast(JapgollyTypeConversions(reactNames, scalaJsDomNames))
  val memberToPro            = new JapgollyMemberToProp(reactNames, rewriter)
  val findProps              = new FindProps(new CleanIllegalNames(outputPkg), memberToPro, parentsResolver)
  val genComponents          = new JapgollyGenComponents(reactNames, findProps)
  val genCompanions          = new GenCompanions(findProps)
  val genStBuildingComponent = new JapgollyGenStBuildingComponent(outputPkg)

  final override def rewrittenTree(scope: TreeScope, tree: PackageTree): PackageTree = {
    val withCompanions = genCompanions.visitPackageTree(scope)(tree)

    val withComponents: PackageTree =
      if (involvesReact(scope)) {
        val components: IArray[Component] =
          identifyComponents.oneOfEach(scope / withCompanions, withCompanions)
        val ret = Adapter(scope)((t, s) => genComponents(s, t, components))(withCompanions)

        if (isReact(scope))
          ret.copy(members = ret.members ++ IArray(genStBuildingComponent.Trait, genStBuildingComponent.Object))
        else ret

      } else withCompanions

    rewriter.visitPackageTree(scope)(withComponents)
  }

  override val rewritesOpt: Option[CastConversion.TypeRewriterCast] = Some(rewriter)
}
