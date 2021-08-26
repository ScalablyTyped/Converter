package typings.node

import typings.node.NodeJS.ReadableStream
import typings.node.NodeJS.WritableStream
import typings.node.anon.End
import typings.node.eventsMod.EventEmitter
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object streamMod {
  
  @JSImport("stream", JSImport.Namespace)
  @js.native
  class ^ () extends internal
  
  /* import warning: transforms.RemoveMultipleInheritance#findNewParents newComments Dropped parents 
  - typings.node.NodeJS.EventEmitter because Already inherited
  - typings.node.eventsMod.EventEmitter because Already inherited
  - typings.node.NodeJS.EventEmitter because Already inherited
  - typings.node.streamMod.internal because Already inherited
  - typings.node.NodeJS.WritableStream because var conflicts: writable. Inlined 
  - typings.node.streamMod.Stream because Already inherited
  - typings.node.streamMod.Writable because Inheritance from two classes. Inlined writable, end, end, end, end, end, end, end, on, on_close */ @JSImport("stream", "Duplex")
  @js.native
  class Duplex () extends Readable {
    def this(opts: DuplexOptions) = this()
    
    def end(): Unit = js.native
    def end(cb: js.Function): Unit = js.native
    def end(chunk: js.Any): Unit = js.native
    def end(chunk: js.Any, cb: js.Function): Unit = js.native
    def end(chunk: js.Any, encoding: String): Unit = js.native
    def end(chunk: js.Any, encoding: String, cb: js.Function): Unit = js.native
    def end(chunk: js.Any, encoding: Unit, cb: js.Function): Unit = js.native
    
    var writable: Boolean = js.native
  }
  
  @JSImport("stream", "Readable")
  @js.native
  class Readable ()
    extends Stream
       with ReadableStream {
    
    @JSName("on")
    def on_close(event: "close", listener: js.Function0[Unit]): this.type = js.native
  }
  
  @JSImport("stream", "Stream")
  @js.native
  class Stream () extends internal
  
  @JSImport("stream", "Writable")
  @js.native
  class Writable ()
    extends Stream
       with WritableStream {
    def this(opts: WritableOptions) = this()
    
    def end(): Unit = js.native
    def end(cb: js.Function): Unit = js.native
    def end(chunk: js.Any): Unit = js.native
    def end(chunk: js.Any, cb: js.Function): Unit = js.native
    def end(chunk: js.Any, encoding: String): Unit = js.native
    def end(chunk: js.Any, encoding: String, cb: js.Function): Unit = js.native
    def end(chunk: js.Any, encoding: Unit, cb: js.Function): Unit = js.native
    
    @JSName("on")
    def on_close(event: "close", listener: js.Function0[Unit]): this.type = js.native
  }
  
  trait DuplexOptions
    extends StObject
       with ReadableOptions
       with WritableOptions {
    
    var allowHalfOpen: js.UndefOr[Boolean] = js.undefined
  }
  object DuplexOptions {
    
    inline def apply(): DuplexOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DuplexOptions]
    }
    
    extension [Self <: DuplexOptions](x: Self) {
      
      inline def setAllowHalfOpen(value: Boolean): Self = StObject.set(x, "allowHalfOpen", value.asInstanceOf[js.Any])
      
      inline def setAllowHalfOpenUndefined: Self = StObject.set(x, "allowHalfOpen", js.undefined)
    }
  }
  
  trait ReadableOptions extends StObject {
    
    var destroy: js.UndefOr[js.Function1[/* error */ js.UndefOr[Error], js.Any]] = js.undefined
    
    var encoding: js.UndefOr[String] = js.undefined
    
    var highWaterMark: js.UndefOr[Double] = js.undefined
    
    var objectMode: js.UndefOr[Boolean] = js.undefined
    
    var read: js.UndefOr[js.ThisFunction1[/* this */ Readable, /* size */ js.UndefOr[Double], js.Any]] = js.undefined
  }
  object ReadableOptions {
    
    inline def apply(): ReadableOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ReadableOptions]
    }
    
    extension [Self <: ReadableOptions](x: Self) {
      
      inline def setDestroy(value: /* error */ js.UndefOr[Error] => js.Any): Self = StObject.set(x, "destroy", js.Any.fromFunction1(value))
      
      inline def setDestroyUndefined: Self = StObject.set(x, "destroy", js.undefined)
      
      inline def setEncoding(value: String): Self = StObject.set(x, "encoding", value.asInstanceOf[js.Any])
      
      inline def setEncodingUndefined: Self = StObject.set(x, "encoding", js.undefined)
      
      inline def setHighWaterMark(value: Double): Self = StObject.set(x, "highWaterMark", value.asInstanceOf[js.Any])
      
      inline def setHighWaterMarkUndefined: Self = StObject.set(x, "highWaterMark", js.undefined)
      
      inline def setObjectMode(value: Boolean): Self = StObject.set(x, "objectMode", value.asInstanceOf[js.Any])
      
      inline def setObjectModeUndefined: Self = StObject.set(x, "objectMode", js.undefined)
      
      inline def setRead(value: js.ThisFunction1[/* this */ Readable, /* size */ js.UndefOr[Double], js.Any]): Self = StObject.set(x, "read", value.asInstanceOf[js.Any])
      
      inline def setReadUndefined: Self = StObject.set(x, "read", js.undefined)
    }
  }
  
  trait WritableOptions extends StObject {
    
    var `final`: js.UndefOr[
        js.Function1[/* callback */ js.Function1[/* error */ js.UndefOr[Error], Unit], Unit]
      ] = js.undefined
  }
  object WritableOptions {
    
    inline def apply(): WritableOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[WritableOptions]
    }
    
    extension [Self <: WritableOptions](x: Self) {
      
      inline def setFinal(value: /* callback */ js.Function1[/* error */ js.UndefOr[Error], Unit] => Unit): Self = StObject.set(x, "final", js.Any.fromFunction1(value))
      
      inline def setFinalUndefined: Self = StObject.set(x, "final", js.undefined)
    }
  }
  
  @js.native
  trait internal extends EventEmitter {
    
    def pipe[T /* <: WritableStream */](destination: T): T = js.native
    def pipe[T /* <: WritableStream */](destination: T, options: End): T = js.native
  }
}
