package typings.materialUi.japgolly

import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typings.materialUi.__MaterialUI.BottomNavigation.BottomNavigationItemProps
import typings.materialUi.bottomNavigationBottomNavigationItemMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object BottomNavigationItem {
  def apply(
    className: String = null,
    key: js.UndefOr[Key] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  )(
    children: Double
  ): UnmountedWithRoot[BottomNavigationItemProps, default, Unit, BottomNavigationItemProps] = {
    val __obj = js.Dynamic.literal(children = children)
  
      if (className != null) __obj.updateDynamic("className")(className)
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.materialUi.__MaterialUI.BottomNavigation.BottomNavigationItemProps, 
  japgolly.scalajs.react.Children.None, 
  typings.materialUi.bottomNavigationBottomNavigationItemMod.default](js.constructorOf[typings.materialUi.bottomNavigationBottomNavigationItemMod.default])
    f(__obj.asInstanceOf[typings.materialUi.__MaterialUI.BottomNavigation.BottomNavigationItemProps])
  }
}

