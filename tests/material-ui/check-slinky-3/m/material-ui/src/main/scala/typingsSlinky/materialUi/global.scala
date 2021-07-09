package typingsSlinky.materialUi

import typingsSlinky.materialUi.MaterialUI.BottomNavigation.BottomNavigationItemProps
import typingsSlinky.materialUi.MaterialUI.Styles.MuiTheme
import typingsSlinky.react.mod.Component
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  object MaterialUI {
    
    object BottomNavigation {
      
      @JSGlobal("__MaterialUI.BottomNavigation.BottomNavigationItem")
      @js.native
      class BottomNavigationItem ()
        extends StObject
           with Component[BottomNavigationItemProps, js.Object]
    }
    
    object Styles {
      
      @JSGlobal("__MaterialUI.Styles")
      @js.native
      val ^ : js.Any = js.native
      
      @JSGlobal("__MaterialUI.Styles.Transitions")
      @js.native
      def Transitions: js.Any = js.native
      @scala.inline
      def Transitions_=(x: js.Any): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("Transitions")(x.asInstanceOf[js.Any])
      
      @JSGlobal("__MaterialUI.Styles.Typography")
      @js.native
      def Typography: js.Any = js.native
      @scala.inline
      def Typography_=(x: js.Any): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("Typography")(x.asInstanceOf[js.Any])
      
      @JSGlobal("__MaterialUI.Styles.a")
      @js.native
      def a: js.Any = js.native
      @scala.inline
      def a_=(x: js.Any): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("a")(x.asInstanceOf[js.Any])
      
      @scala.inline
      def getMuiTheme(muiTheme: MuiTheme*): MuiTheme = ^.asInstanceOf[js.Dynamic].applyDynamic("getMuiTheme")(muiTheme.asInstanceOf[js.Any]).asInstanceOf[MuiTheme]
      
      @JSGlobal("__MaterialUI.Styles.zIndex")
      @js.native
      def zIndex: js.Any = js.native
      @scala.inline
      def zIndex_=(x: js.Any): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("zIndex")(x.asInstanceOf[js.Any])
    }
    
    @JSGlobal("__MaterialUI.SvgIcon")
    @js.native
    class SvgIcon ()
      extends StObject
         with Component[js.Object, js.Object]
  }
}
