package typingsJapgolly.materialUi.components

import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.materialUi.MaterialUI.BottomNavigation.BottomNavigationItemProps
import typingsJapgolly.materialUi.mod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object BottomNavigationItem {
  def apply(
    className: String = null,
    key: js.UndefOr[Key] = js.undefined,
    _overrides: StringDictionary[js.Any] = null
  )(
    children: Double
  ): UnmountedWithRoot[BottomNavigationItemProps, default, Unit, BottomNavigationItemProps] = {
    val __obj = js.Dynamic.literal(children = children.asInstanceOf[js.Any])
  
      if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typingsJapgolly.materialUi.MaterialUI.BottomNavigation.BottomNavigationItemProps, 
  japgolly.scalajs.react.Children.None, 
  typingsJapgolly.materialUi.mod.default](this.componentImport)
    f(__obj.asInstanceOf[typingsJapgolly.materialUi.MaterialUI.BottomNavigation.BottomNavigationItemProps])
  }
  @JSImport("material-ui/BottomNavigation/BottomNavigationItem", JSImport.Default)
  @js.native
  object componentImport extends js.Object
  
}

