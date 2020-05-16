package org.scalablytyped.converter.internal.scalajs.flavours

import org.scalablytyped.converter.internal.IArray
import org.scalablytyped.converter.internal.scalajs.flavours.CastConversion.TypeRewriterCast
import org.scalablytyped.converter.internal.scalajs.transforms.{Adapter, CleanIllegalNames}
import org.scalablytyped.converter.internal.scalajs._

case class SlinkyNativeFlavour(outputPkg: Name, enableImplicitOps: Boolean) extends FlavourImplReact {

  override val dependencies: Set[Dep] =
    Set(Versions.runtime, Versions.slinkyNative, Versions.scalaJsDom)

  val rewriter      = new TypeRewriterCast(SlinkyTypeConversions(scalaJsDomNames, reactNames, isWeb = false))
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
