package typingsJapgolly.react

import japgolly.scalajs.react.Callback
import typingsJapgolly.react.anon.Changed
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait ViewabilityConfigCallbackPair extends StObject {
  
  var onViewableItemsChanged: (js.Function1[/* info */ Changed, Unit]) | Null
  
  var viewabilityConfig: ViewabilityConfig
}
object ViewabilityConfigCallbackPair {
  
  inline def apply(viewabilityConfig: ViewabilityConfig): ViewabilityConfigCallbackPair = {
    val __obj = js.Dynamic.literal(viewabilityConfig = viewabilityConfig.asInstanceOf[js.Any], onViewableItemsChanged = null)
    __obj.asInstanceOf[ViewabilityConfigCallbackPair]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: ViewabilityConfigCallbackPair] (val x: Self) extends AnyVal {
    
    inline def setOnViewableItemsChanged(value: /* info */ Changed => Callback): Self = StObject.set(x, "onViewableItemsChanged", js.Any.fromFunction1((t0: /* info */ Changed) => value(t0).runNow()))
    
    inline def setOnViewableItemsChangedNull: Self = StObject.set(x, "onViewableItemsChanged", null)
    
    inline def setViewabilityConfig(value: ViewabilityConfig): Self = StObject.set(x, "viewabilityConfig", value.asInstanceOf[js.Any])
  }
}
