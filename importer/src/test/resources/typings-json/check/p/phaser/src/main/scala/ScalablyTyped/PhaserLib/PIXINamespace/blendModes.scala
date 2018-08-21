package ScalablyTyped
package PhaserLib
package PIXINamespace

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
  
  @JSBracketAccess
  def apply(value: blendModes): java.lang.String = js.native
  @js.native
  object ADD extends ADD
  
  @js.native
  object NORMAL extends NORMAL
  
}

