package typings.monacoEditor

import typings.monacoEditor.monaco.Promise
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  trait Key[T] extends StObject {
    
    var key: String
    
    var value: Promise[T, js.Any]
  }
  object Key {
    
    inline def apply[T](key: String, value: Promise[T, js.Any]): Key[T] = {
      val __obj = js.Dynamic.literal(key = key.asInstanceOf[js.Any], value = value.asInstanceOf[js.Any])
      __obj.asInstanceOf[Key[T]]
    }
    
    extension [Self <: Key[?], T](x: Self & Key[T]) {
      
      inline def setKey(value: String): Self = StObject.set(x, "key", value.asInstanceOf[js.Any])
      
      inline def setValue(value: Promise[T, js.Any]): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
    }
  }
}
