package typingsSlinky.reactTransitionGroup

import slinky.core.facade.ReactElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait ChildFactory extends StObject {
    
    var childFactory: js.UndefOr[js.Function1[/* child */ ReactElement, ReactElement]] = js.native
  }
  object ChildFactory {
    
    @scala.inline
    def apply(): ChildFactory = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ChildFactory]
    }
    
    @scala.inline
    implicit class ChildFactoryMutableBuilder[Self <: ChildFactory] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setChildFactory(value: /* child */ ReactElement => ReactElement): Self = StObject.set(x, "childFactory", js.Any.fromFunction1(value))
      
      @scala.inline
      def setChildFactoryUndefined: Self = StObject.set(x, "childFactory", js.undefined)
    }
  }
}
