package org.scalablytyped.converter.internal
package scalajs
package flavours

trait FlavourImpl {
  def rewrittenTree(s: TreeScope, tree: PackageTree): PackageTree
  def dependencies: Set[Dep]
  val outputPkg: Name

  override val toString = getClass.getSimpleName
}

trait FlavourImplReact extends FlavourImpl {
  lazy val parentsResolver    = new ParentsResolver
  lazy val stdNames           = new QualifiedName.StdNames(outputPkg)
  lazy val scalaJsDomNames    = new ScalaJsDomNames(stdNames)
  lazy val reactNames         = new ReactNames(outputPkg)
  lazy val identifyComponents = new IdentifyReactComponents(reactNames, parentsResolver)

  def involvesReact(scope: TreeScope): Boolean = {
    val react = Name("react")
    scope.libName === react || scope.root.dependencies.contains(react)
  }
}
