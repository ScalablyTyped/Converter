package typings.node

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object NodeJS {
  
  trait ErrnoException
    extends StObject
       with Error {
    
    var code: js.UndefOr[String] = js.undefined
    
    var errno: js.UndefOr[Double] = js.undefined
    
    var path: js.UndefOr[String] = js.undefined
    
    var syscall: js.UndefOr[String] = js.undefined
  }
  object ErrnoException {
    
    inline def apply(): ErrnoException = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ErrnoException]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: ErrnoException] (val x: Self) extends AnyVal {
      
      inline def setCode(value: String): Self = StObject.set(x, "code", value.asInstanceOf[js.Any])
      
      inline def setCodeUndefined: Self = StObject.set(x, "code", js.undefined)
      
      inline def setErrno(value: Double): Self = StObject.set(x, "errno", value.asInstanceOf[js.Any])
      
      inline def setErrnoUndefined: Self = StObject.set(x, "errno", js.undefined)
      
      inline def setPath(value: String): Self = StObject.set(x, "path", value.asInstanceOf[js.Any])
      
      inline def setPathUndefined: Self = StObject.set(x, "path", js.undefined)
      
      inline def setSyscall(value: String): Self = StObject.set(x, "syscall", value.asInstanceOf[js.Any])
      
      inline def setSyscallUndefined: Self = StObject.set(x, "syscall", js.undefined)
    }
  }
  
  @js.native
  trait EventEmitter extends StObject {
    
    def emit(event: String, args: Any*): Boolean = js.native
    def emit(event: js.Symbol, args: Any*): Boolean = js.native
  }
  
  @js.native
  trait Process
    extends StObject
       with EventEmitter {
    
    var bar: "foo" = js.native
  }
  
  @js.native
  trait ReadWriteStream
    extends StObject
       with ReadableStream
       with WritableStream
  
  @js.native
  trait ReadableStream
    extends StObject
       with EventEmitter {
    
    var readable: Boolean = js.native
  }
  
  @js.native
  trait WritableStream
    extends StObject
       with EventEmitter {
    
    var writable: Boolean = js.native
  }
}
