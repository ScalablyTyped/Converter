package typingsJapgolly.componentstest

import japgolly.scalajs.react.facade.React.ElementType
import typingsJapgolly.componentstest.anon.Component
import typingsJapgolly.componentstest.mod.FooProps
import typingsJapgolly.react.mod.global.JSX.Element
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object keptOverloadsMod {
  
  @JSImport("componentstest/KeptOverloads", "KeptOverloads")
  @js.native
  val KeptOverloads: KeptOverloadsComponent = js.native
  
  @js.native
  trait KeptOverloadsComponent extends StObject {
    
    def apply(props: KeptOverloadsProps): Element | Null = js.native
    def apply[C /* <: ElementType */](props: Component[C] & FooProps): Element | Null = js.native
  }
  
  trait KeptOverloadsProps
    extends StObject
       with FooProps {
    
    var kept: js.UndefOr[Boolean] = js.undefined
  }
  object KeptOverloadsProps {
    
    inline def apply(): KeptOverloadsProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[KeptOverloadsProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: KeptOverloadsProps] (val x: Self) extends AnyVal {
      
      inline def setKept(value: Boolean): Self = StObject.set(x, "kept", value.asInstanceOf[js.Any])
      
      inline def setKeptUndefined: Self = StObject.set(x, "kept", js.undefined)
    }
  }
}
