package ScalablyTyped
package NodeLib
package EventsModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("events", "EventEmitter")
@js.native
class EventEmitter () extends NodeLib.EventsModule.internalNamespace.EventEmitter

@JSImport("events", "EventEmitter")
@js.native
object EventEmitter extends js.Object {
  def listenerCount(emitter: NodeLib.EventsModule.internalNamespace.EventEmitter, event: java.lang.String): scala.Double = js.native
  def listenerCount(emitter: NodeLib.EventsModule.internalNamespace.EventEmitter, event: js.Symbol): scala.Double = js.native
}

