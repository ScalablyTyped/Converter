package mylib.internal.baz.materialUi

import japgolly.scalajs.react.facade.React.Component
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

private[internal] object MaterialUI {
  
  object BottomNavigation {
    
    type BottomNavigationItem = Component[BottomNavigationItemProps & js.Object, js.Object]
    
    trait BottomNavigationItemProps extends StObject {
      
      var children: Double
      
      var className: js.UndefOr[String] = js.undefined
    }
    object BottomNavigationItemProps {
      
      inline def apply(children: Double): BottomNavigationItemProps = {
        val __obj = js.Dynamic.literal(children = children.asInstanceOf[js.Any])
        __obj.asInstanceOf[BottomNavigationItemProps]
      }
      
      @scala.inline
      implicit open class MutableBuilder[Self <: BottomNavigationItemProps] (val x: Self) extends AnyVal {
        
        inline def setChildren(value: Double): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
        
        inline def setClassName(value: String): Self = StObject.set(x, "className", value.asInstanceOf[js.Any])
        
        inline def setClassNameUndefined: Self = StObject.set(x, "className", js.undefined)
      }
    }
  }
  
  object Styles {
    
    trait MuiTheme extends StObject {
      
      var spacing: js.UndefOr[Any] = js.undefined
    }
    object MuiTheme {
      
      inline def apply(): MuiTheme = {
        val __obj = js.Dynamic.literal()
        __obj.asInstanceOf[MuiTheme]
      }
      
      @scala.inline
      implicit open class MutableBuilder[Self <: MuiTheme] (val x: Self) extends AnyVal {
        
        inline def setSpacing(value: Any): Self = StObject.set(x, "spacing", value.asInstanceOf[js.Any])
        
        inline def setSpacingUndefined: Self = StObject.set(x, "spacing", js.undefined)
      }
    }
  }
  
  type SvgIcon = Component[js.Object, js.Object]
}
