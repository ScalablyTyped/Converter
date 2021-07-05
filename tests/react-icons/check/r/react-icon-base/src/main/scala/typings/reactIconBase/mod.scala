package typings.reactIconBase

import typings.react.mod.ClassAttributes
import typings.react.mod.Component
import typings.react.mod.ReactSVGElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("react-icon-base", JSImport.Default)
  @js.native
  class default ()
    extends StObject
       with Component[IconBaseProps, js.Object]
  
  type IconBaseClass = Component[IconBaseProps, js.Object]
  
  @js.native
  trait IconBaseProps
    extends StObject
       with ClassAttributes[ReactSVGElement] {
    
    var size: js.UndefOr[String | Double] = js.native
  }
  object IconBaseProps {
    
    @scala.inline
    def apply(): IconBaseProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[IconBaseProps]
    }
    
    @scala.inline
    implicit class IconBasePropsMutableBuilder[Self <: IconBaseProps] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setSize(value: String | Double): Self = StObject.set(x, "size", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setSizeUndefined: Self = StObject.set(x, "size", js.undefined)
    }
  }
}
