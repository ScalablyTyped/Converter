package org.scalablytyped.converter.internal
package scalajs
package flavours

import org.scalablytyped.converter.Selection

trait FlavourImpl {
  def rewrittenTree(s: TreeScope, tree: PackageTree): PackageTree
  def dependencies: Set[Dep]
  val outputPkg: Name
  val rewrites:  IArray[CastConversion]

  override val toString = getClass.getSimpleName
}

trait FlavourImplReact extends FlavourImpl {
  val enableReactTreeShaking: Selection[Name]

  lazy val parentsResolver    = new ParentsResolver
  lazy val stdNames           = new QualifiedName.StdNames(outputPkg)
  lazy val scalaJsLibNames    = new ScalaJsLibNames(stdNames)
  lazy val scalaJsDomNames    = new ScalaJsDomNames(stdNames)
  lazy val reactNames         = new ReactNames(outputPkg)
  lazy val reactNamesProxy    = new ReactNamesProxy(reactNames, rewrites)
  lazy val identifyComponents = new IdentifyReactComponents(reactNamesProxy, parentsResolver, enableReactTreeShaking)

  def involvesReact(scope: TreeScope): Boolean = {
    val react = Name("react")
    scope.libName === react || scope.root.dependencies.contains(react)
  }

  def isReact(scope: TreeScope): Boolean =
    scope.libName === Name("react")
}
