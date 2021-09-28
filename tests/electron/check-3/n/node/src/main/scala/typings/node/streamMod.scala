package typings.node

import typings.node.NodeJS.ReadableStream
import typings.node.NodeJS.WritableStream
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object streamMod {
  
  /* import warning: transforms.RemoveMultipleInheritance#findNewParents newComments Dropped parents 
  - typings.node.NodeJS.EventEmitter because Already inherited
  - typings.node.NodeJS.WritableStream because var conflicts: writable. Inlined 
  - typings.node.streamMod.Stream because Already inherited
  - typings.node.streamMod.Writable because Inheritance from two classes. Inlined writable, emit, emit, end, end, end, end */ @JSImport("stream", "Duplex")
  @js.native
  open class Duplex () extends Readable {
    
    def end(): Unit = js.native
    def end(cb: js.Function): Unit = js.native
    def end(chunk: Any): Unit = js.native
    def end(chunk: Any, cb: js.Function): Unit = js.native
    def end(chunk: Any, encoding: String): Unit = js.native
    def end(chunk: Any, encoding: String, cb: js.Function): Unit = js.native
    def end(chunk: Any, encoding: Unit, cb: js.Function): Unit = js.native
    def end(str: String): Unit = js.native
    def end(str: String, encoding: String): Unit = js.native
    def end(str: String, encoding: String, cb: js.Function): Unit = js.native
    def end(str: String, encoding: Unit, cb: js.Function): Unit = js.native
    
    var writable: Boolean = js.native
  }
  
  @JSImport("stream", "Readable")
  @js.native
  open class Readable ()
    extends Stream
       with ReadableStream {
    
    def read(): String = js.native
    def read(size: Double): String = js.native
  }
  
  @JSImport("stream", "Stream")
  @js.native
  open class Stream () extends StObject
  
  @JSImport("stream", "Writable")
  @js.native
  open class Writable ()
    extends Stream
       with WritableStream {
    
    def end(str: String): Unit = js.native
    def end(str: String, encoding: String): Unit = js.native
    def end(str: String, encoding: String, cb: js.Function): Unit = js.native
    def end(str: String, encoding: Unit, cb: js.Function): Unit = js.native
  }
}
