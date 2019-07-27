package typings.phaserLib.PIXINs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
sealed trait blendModes extends js.Object

@JSGlobal("PIXI.blendModes")
@js.native
object blendModes extends js.Object {
  @js.native
  sealed trait ADD extends blendModes
  
  @js.native
  sealed trait NORMAL extends blendModes
  
  /* 1 */ val ADD: typings.phaserLib.PIXINs.blendModes.ADD with Double = js.native
  /* 0 */ val NORMAL: typings.phaserLib.PIXINs.blendModes.NORMAL with Double = js.native
  @JSBracketAccess
  def apply(value: Double): js.UndefOr[blendModes with Double] = js.native
}

