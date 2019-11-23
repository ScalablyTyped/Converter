package typingsSlinky.reactDashSelect.components

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typingsSlinky.reactDashSelect.reactDashSelectMod.ReactSelectProps
import typingsSlinky.reactDashSelect.reactDashSelectMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ReactDashSelect
  extends ExternalComponentWithAttributesWithRefType[tag.type, default[js.Any]] {
  override val component: String | js.Object = js.constructorOf[typingsSlinky.reactDashSelect.reactDashSelectMod.default[js.Any]].asInstanceOf[String | js.Object]
  def apply[TValue](addLabelText: String = null, overrides: StringDictionary[js.Any] = null): BuildingComponent[tag.type, default[js.Any]] = {
    val __obj = js.Dynamic.literal()
    if (addLabelText != null) __obj.updateDynamic("addLabelText")(addLabelText.asInstanceOf[js.Any])
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
    super.apply(__obj.asInstanceOf[Props]).asInstanceOf[slinky.core.BuildingComponent[
  slinky.web.html.`*`.tag.type, 
  typingsSlinky.reactDashSelect.reactDashSelectMod.default[js.Any]]]
  }
  type Props = ReactSelectProps[js.Any]
}

