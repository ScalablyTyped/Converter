package typings
package phaserLib.PIXINs

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
    extends phaserLib.PIXINs.scaleModes
  
  @js.native
  sealed trait LINEAR
    extends phaserLib.PIXINs.scaleModes
  
  @js.native
  sealed trait NEAREST
    extends phaserLib.PIXINs.scaleModes
  
  val DEFAULT: DEFAULT with java.lang.String = js.native
  val LINEAR: LINEAR with java.lang.String = js.native
  val NEAREST: NEAREST with java.lang.String = js.native
  @JSBracketAccess
  def apply(value: java.lang.String): js.UndefOr[phaserLib.PIXINs.scaleModes with java.lang.String] = js.native
}

