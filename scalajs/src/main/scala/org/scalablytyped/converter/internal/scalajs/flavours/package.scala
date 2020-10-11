package org.scalablytyped.converter.internal
package scalajs

package object flavours {
  def nameFor(tpe: TypeRef): String =
    tpe match {
      case TypeRef(QualifiedName.REPEATED, _, _) => "Varargs"
      case tr if Name.Internal(tr.name)          => tr.targs.map(nameFor).mkString("")
      case other                                 => other.name.unescaped
    }

}
