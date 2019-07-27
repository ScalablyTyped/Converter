package typings.phaserLib.PIXINs

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
  
  /* 0 */ val DEFAULT: typings.phaserLib.PIXINs.scaleModes.DEFAULT with Double = js.native
  /* 1 */ val LINEAR: typings.phaserLib.PIXINs.scaleModes.LINEAR with Double = js.native
  /* 2 */ val NEAREST: typings.phaserLib.PIXINs.scaleModes.NEAREST with Double = js.native
  @JSBracketAccess
  def apply(value: Double): js.UndefOr[scaleModes with Double] = js.native
}

