package typings.node

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("stream", JSImport.Namespace)
@js.native
object streamMod extends js.Object {
  /* import warning: transforms.RemoveMultipleInheritance#findNewParents newComments Dropped parents 
  - typings.node.NodeJS.EventEmitter because Already inherited
  - typings.node.NodeJS.WritableStream because var conflicts: writable. Inlined 
  - typings.node.streamMod.Stream because Already inherited
  - typings.node.streamMod.Writable because Inheritance from two classes. Inlined writable, emit, emit, end, end, end */ @js.native
  class Duplex () extends Readable {
    var writable: Boolean = js.native
    def end(): Unit = js.native
    def end(cb: js.Function): Unit = js.native
    def end(chunk: js.Any): Unit = js.native
    def end(chunk: js.Any, cb: js.Function): Unit = js.native
    def end(chunk: js.Any, encoding: String): Unit = js.native
    def end(chunk: js.Any, encoding: String, cb: js.Function): Unit = js.native
    def end(str: String): Unit = js.native
    def end(str: String, encoding: String): Unit = js.native
    def end(str: String, encoding: String, cb: js.Function): Unit = js.native
  }
  
  /* import warning: transforms.RemoveMultipleInheritance#findNewParents newComments Dropped parents 
  - typings.node.NodeJS.EventEmitter because Inheritance from two classes. Inlined emit, emit
  - typings.node.NodeJS.ReadableStream because Inheritance from two classes. Inlined readable */ @js.native
  class Readable () extends Stream {
    var readable: Boolean = js.native
    def emit(event: String, args: js.Any*): Boolean = js.native
    def emit(event: js.Symbol, args: js.Any*): Boolean = js.native
    def read(): String = js.native
    def read(size: Double): String = js.native
  }
  
  @js.native
  class Stream () extends js.Object
  
  /* import warning: transforms.RemoveMultipleInheritance#findNewParents newComments Dropped parents 
  - typings.node.NodeJS.EventEmitter because Inheritance from two classes. Inlined emit, emit
  - typings.node.NodeJS.WritableStream because Inheritance from two classes. Inlined writable */ @js.native
  class Writable () extends Stream {
    var writable: Boolean = js.native
    def emit(event: String, args: js.Any*): Boolean = js.native
    def emit(event: js.Symbol, args: js.Any*): Boolean = js.native
    def end(str: String): Unit = js.native
    def end(str: String, encoding: String): Unit = js.native
    def end(str: String, encoding: String, cb: js.Function): Unit = js.native
  }
  
}

