package typings.reactIconBase

import _root_.typings.react.mod.ClassAttributes
import _root_.typings.react.mod.Component
import _root_.typings.react.mod.ReactSVGElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("react-icon-base", JSImport.Default)
  @js.native
  open class default ()
    extends StObject
       with Component[IconBaseProps, js.Object]
  
  type IconBaseClass = Component[IconBaseProps, js.Object]
  
  trait IconBaseProps
    extends StObject
       with ClassAttributes[ReactSVGElement] {
    
    var size: js.UndefOr[String | Double] = js.undefined
  }
  object IconBaseProps {
    
    inline def apply(): IconBaseProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[IconBaseProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: IconBaseProps] (val x: Self) extends AnyVal {
      
      inline def setSize(value: String | Double): Self = StObject.set(x, "size", value.asInstanceOf[js.Any])
      
      inline def setSizeUndefined: Self = StObject.set(x, "size", js.undefined)
    }
  }
}
