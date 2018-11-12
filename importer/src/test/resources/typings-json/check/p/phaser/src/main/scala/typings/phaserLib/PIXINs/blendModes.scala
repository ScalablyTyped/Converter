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
  
  val ADD: ADD with java.lang.String = js.native
  val NORMAL: NORMAL with java.lang.String = js.native
  @JSBracketAccess
  def apply(value: java.lang.String): js.UndefOr[phaserLib.PIXINs.blendModes with java.lang.String] = js.native
}

