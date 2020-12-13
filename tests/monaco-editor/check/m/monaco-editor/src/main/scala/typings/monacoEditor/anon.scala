package typings.monacoEditor

import typings.monacoEditor.monaco.Promise
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait Key[T] extends StObject {
    
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
    implicit class KeyMutableBuilder[Self <: Key[_], T] (val x: Self with Key[T]) extends AnyVal {
      
      @scala.inline
      def setKey(value: String): Self = StObject.set(x, "key", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setValue(value: Promise[T, _]): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
    }
  }
}
