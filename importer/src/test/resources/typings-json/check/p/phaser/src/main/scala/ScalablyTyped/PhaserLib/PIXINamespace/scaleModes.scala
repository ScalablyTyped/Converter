package ScalablyTyped
package PhaserLib.PIXINamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
sealed trait scaleModes extends js.Object

@JSGlobal("PIXI.scaleModes")
@js.native
object scaleModes extends js.Object {
  @js.native
  sealed trait DEFAULT extends scaleModes
  
  @js.native
  sealed trait LINEAR extends scaleModes
  
  @js.native
  sealed trait NEAREST extends scaleModes
  
  val DEFAULT: PhaserLib.PIXINamespace.scaleModes.DEFAULT with java.lang.String = js.native
  val LINEAR: PhaserLib.PIXINamespace.scaleModes.LINEAR with java.lang.String = js.native
  val NEAREST: PhaserLib.PIXINamespace.scaleModes.NEAREST with java.lang.String = js.native
  @JSBracketAccess
  def apply(value: java.lang.String): js.UndefOr[scaleModes with java.lang.String] = js.native
}

