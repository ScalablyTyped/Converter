package typings.node

import typings.node.NodeJS.ReadableStream
import typings.node.NodeJS.WritableStream
import typings.node.anon.End
import typings.node.eventsMod.EventEmitter
import typings.node.nodeStrings.close
import scala.scalajs.js
import scala.scalajs.js.`|`
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
    def end(chunk: js.Any, encoding: js.UndefOr[scala.Nothing], cb: js.Function): Unit = js.native
    def end(chunk: js.Any, encoding: String): Unit = js.native
    def end(chunk: js.Any, encoding: String, cb: js.Function): Unit = js.native
    
    var writable: Boolean = js.native
  }
  
  @js.native
  trait DuplexOptions
    extends ReadableOptions
       with WritableOptions {
    
    var allowHalfOpen: js.UndefOr[Boolean] = js.native
  }
  object DuplexOptions {
    
    @scala.inline
    def apply(): DuplexOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DuplexOptions]
    }
    
    @scala.inline
    implicit class DuplexOptionsOps[Self <: DuplexOptions] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setAllowHalfOpen(value: Boolean): Self = this.set("allowHalfOpen", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteAllowHalfOpen: Self = this.set("allowHalfOpen", js.undefined)
    }
  }
  
  @JSImport("stream", "Readable")
  @js.native
  class Readable ()
    extends Stream
       with ReadableStream {
    
    @JSName("on")
    def on_close(event: close, listener: js.Function0[Unit]): this.type = js.native
  }
  
  @js.native
  trait ReadableOptions extends js.Object {
    
    var destroy: js.UndefOr[js.Function1[/* error */ js.UndefOr[Error], _]] = js.native
    
    var encoding: js.UndefOr[String] = js.native
    
    var highWaterMark: js.UndefOr[Double] = js.native
    
    var objectMode: js.UndefOr[Boolean] = js.native
    
    var read: js.UndefOr[js.ThisFunction1[/* this */ Readable, /* size */ js.UndefOr[Double], _]] = js.native
  }
  object ReadableOptions {
    
    @scala.inline
    def apply(): ReadableOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ReadableOptions]
    }
    
    @scala.inline
    implicit class ReadableOptionsOps[Self <: ReadableOptions] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setDestroy(value: /* error */ js.UndefOr[Error] => _): Self = this.set("destroy", js.Any.fromFunction1(value))
      
      @scala.inline
      def deleteDestroy: Self = this.set("destroy", js.undefined)
      
      @scala.inline
      def setEncoding(value: String): Self = this.set("encoding", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteEncoding: Self = this.set("encoding", js.undefined)
      
      @scala.inline
      def setHighWaterMark(value: Double): Self = this.set("highWaterMark", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteHighWaterMark: Self = this.set("highWaterMark", js.undefined)
      
      @scala.inline
      def setObjectMode(value: Boolean): Self = this.set("objectMode", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteObjectMode: Self = this.set("objectMode", js.undefined)
      
      @scala.inline
      def setRead(value: js.ThisFunction1[/* this */ Readable, /* size */ js.UndefOr[Double], _]): Self = this.set("read", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteRead: Self = this.set("read", js.undefined)
    }
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
    def end(chunk: js.Any, encoding: js.UndefOr[scala.Nothing], cb: js.Function): Unit = js.native
    def end(chunk: js.Any, encoding: String): Unit = js.native
    def end(chunk: js.Any, encoding: String, cb: js.Function): Unit = js.native
    
    @JSName("on")
    def on_close(event: close, listener: js.Function0[Unit]): this.type = js.native
  }
  
  @js.native
  trait WritableOptions extends js.Object {
    
    var `final`: js.UndefOr[
        js.Function1[/* callback */ js.Function1[/* error */ js.UndefOr[Error], Unit], Unit]
      ] = js.native
  }
  object WritableOptions {
    
    @scala.inline
    def apply(): WritableOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[WritableOptions]
    }
    
    @scala.inline
    implicit class WritableOptionsOps[Self <: WritableOptions] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setFinal(value: /* callback */ js.Function1[/* error */ js.UndefOr[Error], Unit] => Unit): Self = this.set("final", js.Any.fromFunction1(value))
      
      @scala.inline
      def deleteFinal: Self = this.set("final", js.undefined)
    }
  }
  
  @js.native
  trait internal extends EventEmitter {
    
    def pipe[T /* <: WritableStream */](destination: T): T = js.native
    def pipe[T /* <: WritableStream */](destination: T, options: End): T = js.native
  }
}
