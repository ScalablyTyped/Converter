package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.Selection
import org.scalablytyped.converter.internal.scalajs.flavours.CastConversion.TypeRewriterCast
import org.scalablytyped.converter.internal.scalajs.transforms.{Adapter, CleanIllegalNames}

case class SlinkyNativeFlavour(
    outputPkg:              Name,
    enableLongApplyMethod:  Boolean,
    scalaVersion:           Versions.Scala,
    enableReactTreeShaking: Selection[Name],
) extends FlavourImplReact {

  override val dependencies: Set[Dep] =
    Set(Versions.runtime, Versions.slinkyNative, Versions.scalaJsDom)

  val rewriter               = new TypeRewriterCast(SlinkyTypeConversions(scalaJsDomNames, reactNames, isWeb = false))
  val memberToProp           = new MemberToProp.Default(Some(rewriter))
  val findProps              = new FindProps(new CleanIllegalNames(outputPkg), memberToProp, parentsResolver)
  val genStBuildingComponent = new SlinkyGenStBuildingComponent(outputPkg, scalaVersion)
  val gen                    = new SlinkyGenComponents(SlinkyGenComponents.Native(()), findProps, genStBuildingComponent, reactNames)
  val genCompanions          = new GenCompanions(findProps, enableLongApplyMethod)

  final override def rewrittenTree(scope: TreeScope, tree: PackageTree): PackageTree = {
    val withCompanions = genCompanions.visitPackageTree(scope)(tree)

    val withComponents = if (involvesReact(scope)) {
      val components: IArray[Component] =
        identifyComponents.oneOfEach(scope / withCompanions, withCompanions)

      val ret = Adapter(scope)((t, s) => gen(s, t, components))(withCompanions)

      if (isReact(scope))
        ret.copy(members = ret.members ++ IArray(genStBuildingComponent.Trait, genStBuildingComponent.Object.tree))
      else ret

    } else withCompanions

    rewriter.visitPackageTree(scope)(withComponents)
  }

  override val rewritesOpt: Option[CastConversion.TypeRewriterCast] = Some(rewriter)
}
