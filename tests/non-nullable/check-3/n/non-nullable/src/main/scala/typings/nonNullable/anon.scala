package typings.nonNullable

import typings.nonNullable.mod.BadgeSlotProps
import typings.nonNullable.mod.RootSlotProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  trait Badge extends StObject {
    
    var badge: js.UndefOr[BadgeSlotProps] = js.undefined
    
    var root: js.UndefOr[RootSlotProps] = js.undefined
  }
  object Badge {
    
    inline def apply(): Badge = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Badge]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Badge] (val x: Self) extends AnyVal {
      
      inline def setBadge(value: BadgeSlotProps): Self = StObject.set(x, "badge", value.asInstanceOf[js.Any])
      
      inline def setBadgeUndefined: Self = StObject.set(x, "badge", js.undefined)
      
      inline def setRoot(value: RootSlotProps): Self = StObject.set(x, "root", value.asInstanceOf[js.Any])
      
      inline def setRootUndefined: Self = StObject.set(x, "root", js.undefined)
    }
  }
}
