package typingsJapgolly.reactBootstrap

import typingsJapgolly.react.mod.Component
import typingsJapgolly.react.mod.HTMLProps
import typingsJapgolly.reactBootstrap.mod.Sizes
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object buttonGroupMod {
  
  @JSImport("react-bootstrap/lib/ButtonGroup", JSImport.Namespace)
  @js.native
  class ^ ()
    extends Component[ButtonGroupProps, js.Object, js.Any]
  
  @js.native
  trait ButtonGroup
    extends Component[ButtonGroupProps, js.Object, js.Any]
  
  trait ButtonGroupProps
    extends StObject
       with HTMLProps[ButtonGroup] {
    
    var block: js.UndefOr[Boolean] = js.undefined
    
    var bsSize: js.UndefOr[Sizes] = js.undefined
    
    var bsStyle: js.UndefOr[String] = js.undefined
    
    var justified: js.UndefOr[Boolean] = js.undefined
    
    var vertical: js.UndefOr[Boolean] = js.undefined
  }
  object ButtonGroupProps {
    
    inline def apply(): ButtonGroupProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ButtonGroupProps]
    }
    
    extension [Self <: ButtonGroupProps](x: Self) {
      
      inline def setBlock(value: Boolean): Self = StObject.set(x, "block", value.asInstanceOf[js.Any])
      
      inline def setBlockUndefined: Self = StObject.set(x, "block", js.undefined)
      
      inline def setBsSize(value: Sizes): Self = StObject.set(x, "bsSize", value.asInstanceOf[js.Any])
      
      inline def setBsSizeUndefined: Self = StObject.set(x, "bsSize", js.undefined)
      
      inline def setBsStyle(value: String): Self = StObject.set(x, "bsStyle", value.asInstanceOf[js.Any])
      
      inline def setBsStyleUndefined: Self = StObject.set(x, "bsStyle", js.undefined)
      
      inline def setJustified(value: Boolean): Self = StObject.set(x, "justified", value.asInstanceOf[js.Any])
      
      inline def setJustifiedUndefined: Self = StObject.set(x, "justified", js.undefined)
      
      inline def setVertical(value: Boolean): Self = StObject.set(x, "vertical", value.asInstanceOf[js.Any])
      
      inline def setVerticalUndefined: Self = StObject.set(x, "vertical", js.undefined)
    }
  }
}
