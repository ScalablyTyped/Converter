package typings.node.global

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/************************************************
*                                               *
*               GLOBAL INTERFACES               *
*                                               *
************************************************/
@JSGlobal("NodeJS")
@js.native
object NodeJS extends js.Object {
  @js.native
  class EventEmitter ()
    extends typings.node.NodeJS.EventEmitter
  
}

