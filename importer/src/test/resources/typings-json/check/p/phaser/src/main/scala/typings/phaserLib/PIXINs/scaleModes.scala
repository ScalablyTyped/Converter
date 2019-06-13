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
  
  /* 0 */ val DEFAULT: DEFAULT with scala.Double = js.native
  /* 1 */ val LINEAR: LINEAR with scala.Double = js.native
  /* 2 */ val NEAREST: NEAREST with scala.Double = js.native
  @JSBracketAccess
  def apply(value: scala.Double): js.UndefOr[phaserLib.PIXINs.scaleModes with scala.Double] = js.native
}

