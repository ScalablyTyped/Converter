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
  
  @JSBracketAccess
  def apply(value: scaleModes): java.lang.String = js.native
  @js.native
  object DEFAULT extends DEFAULT
  
  @js.native
  object LINEAR extends LINEAR
  
  @js.native
  object NEAREST extends NEAREST
  
}

