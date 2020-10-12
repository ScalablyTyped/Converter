package typings.node

import typings.std.ArrayConstrucor
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/************************************************
*                                               *
*               GLOBAL INTERFACES               *
*                                               *
************************************************/
object NodeJS {
  
  @js.native
  trait EventEmitter extends js.Object {
    
    def on(event: String, listener: js.Function1[/* repeated */ js.Any, Unit]): this.type = js.native
    def on(event: js.Symbol, listener: js.Function1[/* repeated */ js.Any, Unit]): this.type = js.native
  }
  
  @js.native
  trait Global extends js.Object {
    
    var Array: ArrayConstrucor = js.native
    
    var global: Global = js.native
  }
  object Global {
    
    @scala.inline
    def apply(Array: ArrayConstrucor, global: Global): Global = {
      val __obj = js.Dynamic.literal(Array = Array.asInstanceOf[js.Any], global = global.asInstanceOf[js.Any])
      __obj.asInstanceOf[Global]
    }
    
    @scala.inline
    implicit class GlobalOps[Self <: Global] (val x: Self) extends AnyVal {
      
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
      def setArray(value: ArrayConstrucor): Self = this.set("Array", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setGlobal(value: Global): Self = this.set("global", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait ReadableStream extends EventEmitter {
    
    def read(): String | Buffer = js.native
    def read(size: Double): String | Buffer = js.native
  }
  
  @js.native
  trait WritableStream extends EventEmitter {
    
    def end(str: String): Unit = js.native
    def end(str: String, encoding: js.UndefOr[scala.Nothing], cb: js.Function): Unit = js.native
    def end(str: String, encoding: String): Unit = js.native
    def end(str: String, encoding: String, cb: js.Function): Unit = js.native
    
    var writable: Boolean = js.native
  }
}
