package typings
package nodeLib.eventsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("events", "EventEmitter")
@js.native
class EventEmitter ()
  extends nodeLib.eventsMod.internalNs.EventEmitter

@JSImport("events", "EventEmitter")
@js.native
object EventEmitter extends js.Object {
  def listenerCount(emitter: nodeLib.eventsMod.internalNs.EventEmitter, event: java.lang.String): scala.Double = js.native
  def listenerCount(emitter: nodeLib.eventsMod.internalNs.EventEmitter, event: js.Symbol): scala.Double = js.native
}

