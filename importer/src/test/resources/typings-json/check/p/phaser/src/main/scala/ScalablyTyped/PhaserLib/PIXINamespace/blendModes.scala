package ScalablyTyped
package PhaserLib.PIXINamespace

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
  
  val ADD: PhaserLib.PIXINamespace.blendModes.ADD with java.lang.String = js.native
  val NORMAL: PhaserLib.PIXINamespace.blendModes.NORMAL with java.lang.String = js.native
  @JSBracketAccess
  def apply(value: java.lang.String): js.UndefOr[blendModes with java.lang.String] = js.native
}

