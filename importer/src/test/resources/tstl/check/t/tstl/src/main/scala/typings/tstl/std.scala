package typings.tstl

import org.scalablytyped.runtime.Instantiable0
import typings.tstl.std.Queue
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSGlobal("std")
@js.native
object std extends js.Object {
  @js.native
  class Queue[T] () extends js.Object {
    def this(container: Queue[T]) = this()
    var container_ : js.Any = js.native
    def empty(): Boolean = js.native
  }
  
  var queue: Instantiable0[Queue[js.Object]] = js.native
  type queue[T] = Queue[T]
}

