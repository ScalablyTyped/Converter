package typings
package nodeLib.eventsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("events", "EventEmitter")
@js.native
class EventEmitter () extends internal

/* static members */
@JSImport("events", "EventEmitter")
@js.native
object EventEmitter extends js.Object {
  def listenerCount(emitter: nodeLib.eventsMod.EventEmitter, event: java.lang.String): scala.Double = js.native
  def listenerCount(emitter: nodeLib.eventsMod.EventEmitter, event: js.Symbol): scala.Double = js.native
}

