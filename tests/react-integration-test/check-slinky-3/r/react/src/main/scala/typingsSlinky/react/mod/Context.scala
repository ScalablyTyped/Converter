package typingsSlinky.react.mod

import slinky.core.ReactComponentClass
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait Context[T] extends StObject {
  
  var Consumer: ReactComponentClass[ConsumerProps[T]]
  
  var Provider: ReactComponentClass[ProviderProps[T]]
  
  var displayName: js.UndefOr[String] = js.undefined
}
object Context {
  
  inline def apply[T](Consumer: ReactComponentClass[ConsumerProps[T]], Provider: ReactComponentClass[ProviderProps[T]]): Context[T] = {
    val __obj = js.Dynamic.literal(Consumer = Consumer.asInstanceOf[js.Any], Provider = Provider.asInstanceOf[js.Any])
    __obj.asInstanceOf[Context[T]]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: Context[?], T] (val x: Self & Context[T]) extends AnyVal {
    
    inline def setConsumer(value: ReactComponentClass[ConsumerProps[T]]): Self = StObject.set(x, "Consumer", value.asInstanceOf[js.Any])
    
    inline def setDisplayName(value: String): Self = StObject.set(x, "displayName", value.asInstanceOf[js.Any])
    
    inline def setDisplayNameUndefined: Self = StObject.set(x, "displayName", js.undefined)
    
    inline def setProvider(value: ReactComponentClass[ProviderProps[T]]): Self = StObject.set(x, "Provider", value.asInstanceOf[js.Any])
  }
}
