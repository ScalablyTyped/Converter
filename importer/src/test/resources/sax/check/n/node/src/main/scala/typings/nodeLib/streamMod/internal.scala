package typings.nodeLib.streamMod

import typings.nodeLib.Anon_End
import typings.nodeLib.NodeJSNs.WritableStream
import typings.nodeLib.eventsMod.EventEmitter
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait internal extends EventEmitter {
  def pipe[T /* <: WritableStream */](destination: T): T = js.native
  def pipe[T /* <: WritableStream */](destination: T, options: Anon_End): T = js.native
}

