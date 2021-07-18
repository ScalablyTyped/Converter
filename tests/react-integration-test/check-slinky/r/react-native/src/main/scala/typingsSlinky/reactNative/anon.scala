package typingsSlinky.reactNative

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  trait Changed extends StObject {
    
    var changed: js.Array[ViewToken]
    
    var viewableItems: js.Array[ViewToken]
  }
  object Changed {
    
    inline def apply(changed: js.Array[ViewToken], viewableItems: js.Array[ViewToken]): Changed = {
      val __obj = js.Dynamic.literal(changed = changed.asInstanceOf[js.Any], viewableItems = viewableItems.asInstanceOf[js.Any])
      __obj.asInstanceOf[Changed]
    }
    
    extension [Self <: Changed](x: Self) {
      
      inline def setChanged(value: js.Array[ViewToken]): Self = StObject.set(x, "changed", value.asInstanceOf[js.Any])
      
      inline def setChangedVarargs(value: ViewToken*): Self = StObject.set(x, "changed", js.Array(value :_*))
      
      inline def setViewableItems(value: js.Array[ViewToken]): Self = StObject.set(x, "viewableItems", value.asInstanceOf[js.Any])
      
      inline def setViewableItemsVarargs(value: ViewToken*): Self = StObject.set(x, "viewableItems", js.Array(value :_*))
    }
  }
}
