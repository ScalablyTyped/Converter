package org.scalablytyped.converter.internal
package scalajs

package object flavours {
  /* We have a hack in the printer which comments out bounds for javascript types.
   * Sine we generate a scala classes, so just imitate same behaviour
   */
  def stripBounds(tparams: IArray[TypeParamTree]): IArray[TypeParamTree] =
    tparams.map {
      case tpt @ TypeParamTree(_, _, Some(bound), comments) =>
        tpt.copy(upperBound = None, comments = comments + Comment(s"/* <: ${Printer.formatTypeRef(0)(bound)} */"))
      case unBounded => unBounded
    }

  def nameFor(tpe: TypeRef): String =
    tpe match {
      case TypeRef(QualifiedName.REPEATED, _, _) => "Varargs"
      case tr if Name.Internal(tr.name)          => tr.targs.map(nameFor).mkString("")
      case other                                 => other.name.unescaped
    }

}
