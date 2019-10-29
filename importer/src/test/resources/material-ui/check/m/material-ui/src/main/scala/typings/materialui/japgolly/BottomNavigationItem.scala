package typings.materialUi.japgolly

import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.materialUi.__MaterialUI.BottomNavigation.BottomNavigationItemProps
import typings.materialUi.bottomNavigationBottomNavigationItemMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object BottomNavigationItem {
  def apply(key: js.UndefOr[Key] = js.undefined, className: String = null)(children: Double): UnmountedWithRoot[BottomNavigationItemProps, default, Unit, BottomNavigationItemProps] = {
    val __obj = js.Dynamic.literal()
  
      key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (className != null) __obj.updateDynamic("className")(className)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.materialUi.__MaterialUI.BottomNavigation.BottomNavigationItemProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.materialUi.bottomNavigationBottomNavigationItemMod.default](js.constructorOf[typings.materialUi.bottomNavigationBottomNavigationItemMod.default])
    f(__obj.asInstanceOf[typings.materialUi.__MaterialUI.BottomNavigation.BottomNavigationItemProps])(japgolly.scalajs.react.vdom.VdomNode.cast(children))
  }
}

