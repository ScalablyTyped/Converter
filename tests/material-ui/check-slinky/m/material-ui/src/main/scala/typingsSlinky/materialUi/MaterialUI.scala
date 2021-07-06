package typingsSlinky.materialUi

import slinky.core.ReactComponentClass
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object MaterialUI {
  
  object BottomNavigation {
    
    type BottomNavigationItem = ReactComponentClass[BottomNavigationItemProps]
    
    @js.native
    trait BottomNavigationItemProps extends StObject {
      
      var children: Double = js.native
      
      var className: js.UndefOr[String] = js.native
    }
    object BottomNavigationItemProps {
      
      @scala.inline
      def apply(children: Double): BottomNavigationItemProps = {
        val __obj = js.Dynamic.literal(children = children.asInstanceOf[js.Any])
        __obj.asInstanceOf[BottomNavigationItemProps]
      }
      
      @scala.inline
      implicit class BottomNavigationItemPropsMutableBuilder[Self <: BottomNavigationItemProps] (val x: Self) extends AnyVal {
        
        @scala.inline
        def setChildren(value: Double): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setClassName(value: String): Self = StObject.set(x, "className", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setClassNameUndefined: Self = StObject.set(x, "className", js.undefined)
      }
    }
  }
  
  object Styles {
    
    @js.native
    trait MuiTheme extends StObject {
      
      var spacing: js.UndefOr[js.Any] = js.native
    }
    object MuiTheme {
      
      @scala.inline
      def apply(): MuiTheme = {
        val __obj = js.Dynamic.literal()
        __obj.asInstanceOf[MuiTheme]
      }
      
      @scala.inline
      implicit class MuiThemeMutableBuilder[Self <: MuiTheme] (val x: Self) extends AnyVal {
        
        @scala.inline
        def setSpacing(value: js.Any): Self = StObject.set(x, "spacing", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setSpacingUndefined: Self = StObject.set(x, "spacing", js.undefined)
      }
    }
  }
  
  type SvgIcon = ReactComponentClass[js.Object]
}
