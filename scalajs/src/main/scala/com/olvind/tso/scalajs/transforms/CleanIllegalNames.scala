package com.olvind.tso
package scalajs
package transforms

case class CleanIllegalNames(OutputPkg: Name) extends TreeTransformation {

  override def enterFieldTree(scope: TreeScope)(s: FieldTree): FieldTree =
    s.name match {
      case Name.js | Name.java | OutputPkg => s.withSuffix("_")
      case _                               => s
    }

  override def enterMethodTree(scope: TreeScope)(s: MethodTree): MethodTree =
    s.name match {
      case Name.js | Name.java | OutputPkg => s.withSuffix("_")
      case _                               => s
    }

  override def enterParamTree(scope: TreeScope)(s: ParamTree): ParamTree =
    s.name match {
      case Name.js | Name.java | OutputPkg => s.copy(name = s.name.withSuffix("_"))
      case _                               => s
    }
}
