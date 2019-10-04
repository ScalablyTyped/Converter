package com.olvind.tso
package scalajs
package transforms

/**
  * Error:scalac: Error while emitting ScalablyTyped/AtBabelTypesLib/AtBabelTypesModule/AtBabelTypesModuleMembers$
  * Maximum String literal length exceeded
  */
object LimitUnionLength extends TreeTransformation {
  override def leaveTypeRef(scope: TreeScope)(s: TypeRef): TypeRef =
    s match {
      case TypeRef.Union(types) if types.length > 50 =>
        val (undefineds, rest) = types.partition(_ === TypeRef.undefined)

        val base =
          if (rest.forall(x => TypeRef.Literal.unapply(x).exists(_.startsWith("\"")))) TypeRef.String else TypeRef.Any

        base
          .withComments(Comments(Comment.warning(s"Was union type with length ${types.length}")))
          .withOptional(undefineds.nonEmpty)
      case other => other
    }
}
