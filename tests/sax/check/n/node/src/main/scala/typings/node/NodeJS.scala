package typings.node

import typings.std.ArrayConstrucor
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/************************************************
*                                               *
*               GLOBAL INTERFACES               *
*                                               *
************************************************/
object NodeJS {
  
  @js.native
  trait EventEmitter extends StObject {
    
    def on(event: String, listener: js.Function1[/* repeated */ js.Any, Unit]): this.type = js.native
    def on(event: js.Symbol, listener: js.Function1[/* repeated */ js.Any, Unit]): this.type = js.native
  }
  
  @js.native
  trait Global extends StObject {
    
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
    implicit class GlobalMutableBuilder[Self <: Global] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setArray(value: ArrayConstrucor): Self = StObject.set(x, "Array", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setGlobal(value: Global): Self = StObject.set(x, "global", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait ReadableStream
    extends StObject
       with EventEmitter {
    
    def read(): String | Buffer = js.native
    def read(size: Double): String | Buffer = js.native
  }
  
  @js.native
  trait WritableStream
    extends StObject
       with EventEmitter {
    
    def end(str: String): Unit = js.native
    def end(str: String, encoding: String): Unit = js.native
    def end(str: String, encoding: String, cb: js.Function): Unit = js.native
    def end(str: String, encoding: Unit, cb: js.Function): Unit = js.native
    
    var writable: Boolean = js.native
  }
}
