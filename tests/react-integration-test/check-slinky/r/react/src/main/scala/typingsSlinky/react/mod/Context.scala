package typingsSlinky.react.mod

import slinky.core.ReactComponentClass
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Context[T] extends StObject {
  
  var Consumer: ReactComponentClass[ConsumerProps[T]] = js.native
  
  var Provider: ReactComponentClass[ProviderProps[T]] = js.native
  
  var displayName: js.UndefOr[String] = js.native
}
object Context {
  
  @scala.inline
  def apply[T](Consumer: ReactComponentClass[ConsumerProps[T]], Provider: ReactComponentClass[ProviderProps[T]]): Context[T] = {
    val __obj = js.Dynamic.literal(Consumer = Consumer.asInstanceOf[js.Any], Provider = Provider.asInstanceOf[js.Any])
    __obj.asInstanceOf[Context[T]]
  }
  
  @scala.inline
  implicit class ContextMutableBuilder[Self <: Context[_], T] (val x: Self with Context[T]) extends AnyVal {
    
    @scala.inline
    def setConsumer(value: ReactComponentClass[ConsumerProps[T]]): Self = StObject.set(x, "Consumer", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setDisplayName(value: String): Self = StObject.set(x, "displayName", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setDisplayNameUndefined: Self = StObject.set(x, "displayName", js.undefined)
    
    @scala.inline
    def setProvider(value: ReactComponentClass[ProviderProps[T]]): Self = StObject.set(x, "Provider", value.asInstanceOf[js.Any])
  }
}
