package mylib.internal.baz.materialUi

import _root_.mylib.internal.baz.materialUi.MaterialUI.BottomNavigation.BottomNavigationItemProps
import _root_.mylib.internal.baz.materialUi.MaterialUI.Styles.MuiTheme
import _root_.mylib.internal.baz.react.mod.Component
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

private[internal] object global {
  
  object MaterialUI {
    
    object BottomNavigation {
      
      @JSGlobal("__MaterialUI.BottomNavigation.BottomNavigationItem")
      @js.native
      open class BottomNavigationItem ()
        extends StObject
           with Component[BottomNavigationItemProps, js.Object]
    }
    
    object Styles {
      
      @JSGlobal("__MaterialUI.Styles")
      @js.native
      val ^ : js.Any = js.native
      
      @JSGlobal("__MaterialUI.Styles.Transitions")
      @js.native
      def Transitions: Any = js.native
      inline def Transitions_=(x: Any): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("Transitions")(x.asInstanceOf[js.Any])
      
      @JSGlobal("__MaterialUI.Styles.Typography")
      @js.native
      def Typography: Any = js.native
      inline def Typography_=(x: Any): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("Typography")(x.asInstanceOf[js.Any])
      
      @JSGlobal("__MaterialUI.Styles.a")
      @js.native
      def a: Any = js.native
      inline def a_=(x: Any): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("a")(x.asInstanceOf[js.Any])
      
      inline def getMuiTheme(muiTheme: MuiTheme*): MuiTheme = ^.asInstanceOf[js.Dynamic].applyDynamic("getMuiTheme")(muiTheme.asInstanceOf[Seq[js.Any]]*).asInstanceOf[MuiTheme]
      
      @JSGlobal("__MaterialUI.Styles.zIndex")
      @js.native
      def zIndex: Any = js.native
      inline def zIndex_=(x: Any): Unit = ^.asInstanceOf[js.Dynamic].updateDynamic("zIndex")(x.asInstanceOf[js.Any])
    }
    
    @JSGlobal("__MaterialUI.SvgIcon")
    @js.native
    open class SvgIcon ()
      extends StObject
         with Component[js.Object, js.Object]
  }
}
