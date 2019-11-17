package com.olvind.tso
package scalajs
package transforms

class CleanIllegalNames(outputPkg: Name) extends TreeTransformation {
  val Illegal = Set(Name.js, Name.java, outputPkg)

  override def leaveFieldTree(scope: TreeScope)(s: FieldTree): FieldTree =
    if (Illegal(s.name)) s.withSuffix("") else s

  override def leaveMethodTree(scope: TreeScope)(s: MethodTree): MethodTree =
    if (Illegal(s.name)) s.withSuffix("") else s

  override def leaveParamTree(scope: TreeScope)(s: ParamTree): ParamTree =
    if (Illegal(s.name)) s.copy(name = s.name.withSuffix("")) else s
}
