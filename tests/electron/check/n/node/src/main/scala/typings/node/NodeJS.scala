package typings.node

import typings.node.nodeStrings.foo
import scala.scalajs.js
import scala.scalajs.js.`|`
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
    implicit class ErrnoExceptionOps[Self <: ErrnoException] (val x: Self) extends AnyVal {
      
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
      def setCode(value: String): Self = this.set("code", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteCode: Self = this.set("code", js.undefined)
      
      @scala.inline
      def setErrno(value: Double): Self = this.set("errno", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteErrno: Self = this.set("errno", js.undefined)
      
      @scala.inline
      def setPath(value: String): Self = this.set("path", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deletePath: Self = this.set("path", js.undefined)
      
      @scala.inline
      def setSyscall(value: String): Self = this.set("syscall", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteSyscall: Self = this.set("syscall", js.undefined)
    }
  }
  
  @js.native
  trait EventEmitter extends js.Object {
    
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
