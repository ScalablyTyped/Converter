package typings
package phaserLib.PIXINs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
sealed trait blendModes extends js.Object

@JSGlobal("PIXI.blendModes")
@js.native
object blendModes extends js.Object {
  @js.native
  sealed trait ADD
    extends phaserLib.PIXINs.blendModes
  
  @js.native
  sealed trait NORMAL
    extends phaserLib.PIXINs.blendModes
  
  /* 1 */ val ADD: ADD with scala.Double = js.native
  /* 0 */ val NORMAL: NORMAL with scala.Double = js.native
  @JSBracketAccess
  def apply(value: scala.Double): js.UndefOr[phaserLib.PIXINs.blendModes with scala.Double] = js.native
}

