package typingsJapgolly.materialUi.global

import typingsJapgolly.materialUi.MaterialUI.BottomNavigation.BottomNavigationItemProps
import typingsJapgolly.materialUi.MaterialUI.Styles.MuiTheme
import typingsJapgolly.react.mod.Component
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSGlobal("__MaterialUI")
@js.native
object MaterialUI extends js.Object {
  @js.native
  class SvgIcon ()
    extends Component[js.Object, js.Object]
  
  @js.native
  object BottomNavigation extends js.Object {
    @js.native
    class BottomNavigationItem ()
      extends Component[BottomNavigationItemProps, js.Object]
    
  }
  
  @js.native
  object Styles extends js.Object {
    var Transitions: js.Any = js.native
    var Typography: js.Any = js.native
    var a: js.Any = js.native
    var zIndex: js.Any = js.native
    def getMuiTheme(muiTheme: MuiTheme*): MuiTheme = js.native
  }
  
}

