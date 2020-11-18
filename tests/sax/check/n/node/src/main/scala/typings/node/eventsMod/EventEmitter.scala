package typings.node.eventsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("events", "EventEmitter")
@js.native
class EventEmitter ()
  extends typings.node.NodeJS.EventEmitter
/* static members */
@JSImport("events", "EventEmitter")
@js.native
object EventEmitter extends js.Object {
  
  def listenerCount(emitter: internal, event: String): Double = js.native
  def listenerCount(emitter: internal, event: js.Symbol): Double = js.native
}
