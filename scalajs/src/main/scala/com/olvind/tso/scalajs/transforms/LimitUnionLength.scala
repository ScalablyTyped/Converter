package com.olvind.tso
package scalajs
package transforms

/**
  * Error:scalac: Error while emitting ScalablyTyped/AtBabelTypesLib/AtBabelTypesModule/AtBabelTypesModuleMembers$
  * Maximum String literal length exceeded
  */
object LimitUnionLength extends TreeTransformation {
  override def enterTypeRef(scope: TreeScope)(s: TypeRef): TypeRef =
    s match {
      case TypeRef.Union(types) if types.length > 50 =>
        val base =
          if (types.forall(x => TypeRef.Literal.unapply(x).exists(_.startsWith("\"")))) TypeRef.String else TypeRef.Any
        base.withComments(Comments(s"/* LimitUnionLength: was union type with length ${types.length} */"))
      case other => other
    }
}
