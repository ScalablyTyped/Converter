package typingsSlinky.materialUi.components

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.core.ExternalPropsWriterProvider
import slinky.web.html.`*`.tag
import typingsSlinky.materialUi.__MaterialUI.BottomNavigation.BottomNavigationItemProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

abstract class SharedApply_BottomNavigationItemProps_865109371[ComponentRef <: js.Object] () {
  abstract class Raw (implicit pw: ExternalPropsWriterProvider)
    extends ExternalComponentWithAttributesWithRefType[tag.type, ComponentRef] {
    type Props = BottomNavigationItemProps
  }
  
  val raw: Raw
  def apply(className: String = null, _overrides: StringDictionary[js.Any] = null): BuildingComponent[tag.type, ComponentRef] = {
    val __obj = js.Dynamic.literal()
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    this.raw.apply(__obj.asInstanceOf[this.raw.Props])
  }
}

