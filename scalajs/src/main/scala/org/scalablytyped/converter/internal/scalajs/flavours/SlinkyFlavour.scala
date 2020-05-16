package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.flavours.FlavourImpl.ReactFlavourImpl
import org.scalablytyped.converter.internal.scalajs.transforms.{Adapter, CleanIllegalNames}

case class SlinkyFlavour(outputPkg: Name, enableImplicitOps: Boolean) extends ReactFlavourImpl {

  override val dependencies = Set(Versions.runtime, Versions.slinkyWeb)
  val rewriter              = SlinkyTypeConversions(scalaJsDomNames, reactNames, isWeb = true)
  val memberToProp          = new MemberToProp.Default(Some(rewriter))
  val findProps             = new FindProps(new CleanIllegalNames(outputPkg), memberToProp)
  val genCompanions         = new GenCompanions(findProps, enableImplicitOps)

  private var cached = Option.empty[SlinkyWeb]

  final override def rewrittenTree(scope: TreeScope, tree: PackageTree): PackageTree = {
    val slinkyWebOpt: Option[SlinkyWeb] =
      cached match {
        case _ if !involvesReact(scope) => None
        case existing @ Some(_)         => existing
        case None =>
          val tags      = SlinkyTagsLoader(stdNames, reactNames, scalaJsDomNames, scope / tree)
          val slinkyWeb = Some(new SlinkyWeb(reactNames, tags))
          cached = slinkyWeb
          slinkyWeb
      }

    val withCompanions = genCompanions.visitPackageTree(scope)(tree)

    val withComponents = if (involvesReact(scope)) {
      val components: IArray[Component] =
        identifyComponents.oneOfEach(scope / withCompanions, withCompanions)

      val gen = new SlinkyGenComponents(SlinkyGenComponents.Web(slinkyWebOpt), findProps)

      Adapter(scope)((t, s) => gen(s, t, components))(withCompanions)
    } else withCompanions

    rewriter.visitPackageTree(scope)(withComponents)
  }
}
