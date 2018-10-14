package ScalablyTyped
package NodeLib.StreamModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait internal
  extends NodeLib.EventsModule.EventEmitter {
  def pipe[T /* <: NodeLib.NodeJSNamespace.WritableStream */](destination: T): T = js.native
  def pipe[T /* <: NodeLib.NodeJSNamespace.WritableStream */](destination: T, options: NodeLib.Anon_End): T = js.native
}

