package typings
package nodeLib.streamMod.internalNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Readable
  extends nodeLib.NodeJSNs.ReadableStream
     with Stream {
  def read(): java.lang.String = js.native
  def read(size: scala.Double): java.lang.String = js.native
}

