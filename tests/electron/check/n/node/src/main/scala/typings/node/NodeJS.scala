package typings.node

import typings.node.nodeStrings.foo
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object NodeJS {
  
  @js.native
  trait ErrnoException extends Error {
    
    var code: js.UndefOr[String] = js.native
    
    var errno: js.UndefOr[Double] = js.native
    
    var path: js.UndefOr[String] = js.native
    
    var syscall: js.UndefOr[String] = js.native
  }
  object ErrnoException {
    
    @scala.inline
    def apply(): ErrnoException = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ErrnoException]
    }
    
    @scala.inline
    implicit class ErrnoExceptionMutableBuilder[Self <: ErrnoException] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setCode(value: String): Self = StObject.set(x, "code", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setCodeUndefined: Self = StObject.set(x, "code", ())
      
      @scala.inline
      def setErrno(value: Double): Self = StObject.set(x, "errno", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setErrnoUndefined: Self = StObject.set(x, "errno", ())
      
      @scala.inline
      def setPath(value: String): Self = StObject.set(x, "path", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPathUndefined: Self = StObject.set(x, "path", ())
      
      @scala.inline
      def setSyscall(value: String): Self = StObject.set(x, "syscall", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setSyscallUndefined: Self = StObject.set(x, "syscall", ())
    }
  }
  
  @js.native
  trait EventEmitter extends StObject {
    
    def emit(event: String, args: js.Any*): Boolean = js.native
    def emit(event: js.Symbol, args: js.Any*): Boolean = js.native
  }
  
  @js.native
  trait Process extends EventEmitter {
    
    var bar: foo = js.native
  }
  
  @js.native
  trait ReadWriteStream
    extends ReadableStream
       with WritableStream
  
  @js.native
  trait ReadableStream extends EventEmitter {
    
    var readable: Boolean = js.native
  }
  
  @js.native
  trait WritableStream extends EventEmitter {
    
    var writable: Boolean = js.native
  }
}
