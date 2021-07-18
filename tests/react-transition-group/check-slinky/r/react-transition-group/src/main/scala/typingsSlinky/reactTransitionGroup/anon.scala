package typingsSlinky.reactTransitionGroup

import slinky.core.facade.ReactElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  trait ChildFactory extends StObject {
    
    var childFactory: js.UndefOr[js.Function1[/* child */ ReactElement, ReactElement]] = js.undefined
  }
  object ChildFactory {
    
    inline def apply(): ChildFactory = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ChildFactory]
    }
    
    extension [Self <: ChildFactory](x: Self) {
      
      inline def setChildFactory(value: /* child */ ReactElement => ReactElement): Self = StObject.set(x, "childFactory", js.Any.fromFunction1(value))
      
      inline def setChildFactoryUndefined: Self = StObject.set(x, "childFactory", js.undefined)
    }
  }
}
