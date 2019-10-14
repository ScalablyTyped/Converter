package typings.materialDashUi.ScalaJsReact

import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.materialDashUi.__MaterialUI.BottomNavigation.BottomNavigationItemProps
import typings.materialDashUi.bottomNavigationBottomNavigationItemMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object BottomNavigationItem {
  def apply(className: String = null): UnmountedWithRoot[BottomNavigationItemProps, default, Unit, BottomNavigationItemProps] = {
    val __obj = js.Dynamic.literal()
  
      if (className != null) __obj.updateDynamic("className")(className)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent[
  typings.materialDashUi.__MaterialUI.BottomNavigation.BottomNavigationItemProps, 
  japgolly.scalajs.react.Children.None, 
  typings.materialDashUi.bottomNavigationBottomNavigationItemMod.default](js.constructorOf[typings.materialDashUi.bottomNavigationBottomNavigationItemMod.default])
    f(__obj.asInstanceOf[typings.materialDashUi.__MaterialUI.BottomNavigation.BottomNavigationItemProps])
  }
}

