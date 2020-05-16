package org.scalablytyped.converter.internal.scalajs

import org.scalablytyped.converter.internal.IArray

package object flavours {
  /* We have a hack in the printer which comments out bounds for javascript types.
   * Here we generate a scala class, so just imitate same behaviour
   */
  def stripBounds(tparams: IArray[TypeParamTree]): IArray[TypeParamTree] =
    tparams.map(_.copy(upperBound = None))

  def nameFor(tpe: TypeRef): String =
    tpe match {
      case tr if Name.Internal(tr.name) => tr.targs.map(nameFor).mkString("")
      case other                        => other.name.unescaped
    }

}
