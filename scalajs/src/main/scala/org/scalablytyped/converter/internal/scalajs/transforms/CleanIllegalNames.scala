package org.scalablytyped.converter.internal
package scalajs
package transforms

class CleanIllegalNames(outputPkg: Name) extends TreeTransformation {
  val Dash = Name("-") // `def `-`(d: Double) = d; `-`(d) doesn't do what you would think

  val Illegal: Set[Name] = Set(Name.js, Name.java, Name.scala, outputPkg, Dash, Name.org, Name.com)

  override def leaveFieldTree(scope: TreeScope)(s: FieldTree): FieldTree =
    if (Illegal(s.name)) s.withSuffix("") else s

  override def leaveMethodTree(scope: TreeScope)(s: MethodTree): MethodTree =
    if (Illegal(s.name)) s.withSuffix("") else s

  override def leaveParamTree(scope: TreeScope)(s: ParamTree): ParamTree =
    if (Illegal(s.name)) s.copy(name = s.name.withSuffix("")) else s
}
