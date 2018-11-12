package typings
package nodeLib.streamMod.internalNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Duplex
  extends Readable
     with Writable {
  def end(): scala.Unit = js.native
  def end(cb: js.Function): scala.Unit = js.native
  def end(chunk: js.Any): scala.Unit = js.native
  def end(chunk: js.Any, cb: js.Function): scala.Unit = js.native
  def end(chunk: js.Any, encoding: java.lang.String): scala.Unit = js.native
  def end(chunk: js.Any, encoding: java.lang.String, cb: js.Function): scala.Unit = js.native
}

