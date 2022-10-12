package org.scalablytyped.converter.internal
package scalajs
package transforms

/**
  * Error:scalac: Error while emitting ScalablyTyped/AtBabelTypesLib/AtBabelTypesModule/AtBabelTypesModuleMembers$
  * Maximum String literal length exceeded
  */
object LimitUnionLength extends TreeTransformation {
  override def leaveTypeRef(scope: TreeScope)(s: TypeRef): TypeRef =
    s match {
      case TypeRef.Union(types, cs) if types.length > 50 =>
        val (undefineds, rest) = types.partition(_ === TypeRef.undefined)

        val base =
          if (rest.forall(x => TypeRef.StringLiteral.unapply(x).isDefined)) TypeRef.String else TypeRef.Any

        val formattedTypes = types.take(3).map(Printer.formatTypeRef(0)).mkString(", ")
        val msg            = s"Was union type with length ${types.length}, starting with $formattedTypes"
        base.withComments(cs + Comment.warning(msg)).withOptional(undefineds.nonEmpty)
      case other => other
    }
}
