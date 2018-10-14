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
  sealed trait DEFAULT
    extends PhaserLib.PIXINamespace.scaleModes
  
  @js.native
  sealed trait LINEAR
    extends PhaserLib.PIXINamespace.scaleModes
  
  @js.native
  sealed trait NEAREST
    extends PhaserLib.PIXINamespace.scaleModes
  
  val DEFAULT: DEFAULT with java.lang.String = js.native
  val LINEAR: LINEAR with java.lang.String = js.native
  val NEAREST: NEAREST with java.lang.String = js.native
  @JSBracketAccess
  def apply(value: java.lang.String): js.UndefOr[PhaserLib.PIXINamespace.scaleModes with java.lang.String] = js.native
}

