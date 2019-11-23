package typingsSlinky.reactDashBootstrap.components

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typingsSlinky.reactDashBootstrap.libToggleButtonGroupMod.ToggleButtonGroupProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* This component has complicated props, you'll have to assemble it yourself using js.Dynamic.literal(...) or similar */
object ToggleButtonGroup
  extends ExternalComponentWithAttributesWithRefType[tag.type, typingsSlinky.reactDashBootstrap.libMod.ToggleButtonGroup] {
  override val component: String | js.Object = js.constructorOf[typingsSlinky.reactDashBootstrap.libMod.ToggleButtonGroup].asInstanceOf[String | js.Object]
  def apply(props: ToggleButtonGroupProps with js.Object, overrides: StringDictionary[js.Any] = null): BuildingComponent[tag.type, typingsSlinky.reactDashBootstrap.libMod.ToggleButtonGroup] = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, props)
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = js.Object
}

