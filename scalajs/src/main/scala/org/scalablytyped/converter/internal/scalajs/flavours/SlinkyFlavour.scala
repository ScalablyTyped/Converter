package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.internal.scalajs.flavours.FlavourImpl.ReactFlavourImpl
import org.scalablytyped.converter.internal.scalajs.transforms.Adapter

case class SlinkyFlavour(outputPkg: Name) extends ReactFlavourImpl {

  override val dependencies: Set[Dep] =
    Set(Versions.runtime, Versions.slinkyWeb)

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

    val toSlinkyTypes = SlinkyTypeConversions(scalaJsDomNames, reactNames, isWeb = true)

    val memberToProp: MemberToProp =
      (scope, tree) =>
        MemberToProp
          .Default(scope, toSlinkyTypes.visitMemberTree(scope)(tree))
          .map(prop => prop.copy(original = Right(tree)))

    val withCompanions = new GenCompanions(memberToProp, findProps).visitPackageTree(scope)(tree)

    val foo = if (involvesReact(scope)) {
      val components: IArray[Component] =
        identifyComponents.oneOfEach(scope / withCompanions, withCompanions)

      val gen = new GenSlinkyComponents(GenSlinkyComponents.Web(slinkyWebOpt), toSlinkyTypes, memberToProp, findProps)

      Adapter(scope)((t, s) => gen(s, t, components))(withCompanions)
    } else withCompanions

    toSlinkyTypes.visitPackageTree(scope)(foo)
  }
}
