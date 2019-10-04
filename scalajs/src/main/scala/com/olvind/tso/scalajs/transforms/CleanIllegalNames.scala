package com.olvind.tso
package scalajs
package transforms

object CleanIllegalNames extends TreeTransformation {

  override def leaveFieldTree(scope: TreeScope)(s: FieldTree): FieldTree =
    s.name match {
      case Name.js | Name.java | ScalaConfig.outputPkg => s.withSuffix("")
      case _                                           => s
    }

  override def leaveMethodTree(scope: TreeScope)(s: MethodTree): MethodTree =
    s.name match {
      case Name.js | Name.java | ScalaConfig.outputPkg => s.withSuffix("")
      case _                                           => s
    }

  override def leaveParamTree(scope: TreeScope)(s: ParamTree): ParamTree =
    s.name match {
      case Name.js | Name.java | ScalaConfig.outputPkg => s.copy(name = s.name.withSuffix(""))
      case _                                           => s
    }
}
