package typings.node.mod.events

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("events", "EventEmitter")
@js.native
class EventEmitter ()
  extends typings.node.NodeJS.EventEmitter

/* static members */
@JSImport("events", "EventEmitter")
@js.native
object EventEmitter extends js.Object {
  def listenerCount(emitter: EventEmitter, event: String): Double = js.native
  def listenerCount(emitter: EventEmitter, event: js.Symbol): Double = js.native
}

