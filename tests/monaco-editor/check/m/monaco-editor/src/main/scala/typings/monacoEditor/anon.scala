package typings.monacoEditor

import typings.monacoEditor.monaco.Promise
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait Key[T] extends js.Object {
    
    var key: String = js.native
    
    var value: Promise[T, _] = js.native
  }
  object Key {
    
    @scala.inline
    def apply[T](key: String, value: Promise[T, _]): Key[T] = {
      val __obj = js.Dynamic.literal(key = key.asInstanceOf[js.Any], value = value.asInstanceOf[js.Any])
      __obj.asInstanceOf[Key[T]]
    }
    
    @scala.inline
    implicit class KeyOps[Self <: Key[_], T] (val x: Self with Key[T]) extends AnyVal {
      
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
      def setKey(value: String): Self = this.set("key", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setValue(value: Promise[T, _]): Self = this.set("value", value.asInstanceOf[js.Any])
    }
  }
}
