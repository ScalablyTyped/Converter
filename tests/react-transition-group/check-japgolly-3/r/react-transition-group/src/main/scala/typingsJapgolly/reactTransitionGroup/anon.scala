package typingsJapgolly.reactTransitionGroup

import japgolly.scalajs.react.facade.React.Element
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  trait ChildFactory extends StObject {
    
    var childFactory: js.UndefOr[js.Function1[/* child */ Element, Element]] = js.undefined
  }
  object ChildFactory {
    
    inline def apply(childFactory: /* child */ Element => Element = null): ChildFactory = {
      val __obj = js.Dynamic.literal()
      if (childFactory != null) __obj.updateDynamic("childFactory")(js.Any.fromFunction1(childFactory))
      __obj.asInstanceOf[ChildFactory]
    }
  }
}
