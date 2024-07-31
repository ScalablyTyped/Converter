package typings.monacoEditor

import _root_.typings.monacoEditor.monaco.Promise
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  trait Key[T] extends StObject {
    
    var key: String
    
    var value: Promise[T, Any]
  }
  object Key {
    
    inline def apply[T](key: String, value: Promise[T, Any]): Key[T] = {
      val __obj = js.Dynamic.literal(key = key.asInstanceOf[js.Any], value = value.asInstanceOf[js.Any])
      __obj.asInstanceOf[Key[T]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Key[?], T] (val x: Self & Key[T]) extends AnyVal {
      
      inline def setKey(value: String): Self = StObject.set(x, "key", value.asInstanceOf[js.Any])
      
      inline def setValue(value: Promise[T, Any]): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
    }
  }
}
