package typings.reactDashSelect.slinky

import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.reactDashSelect.reactDashSelectMod.ReactSelectProps
import typings.reactDashSelect.reactDashSelectMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ReactDashSelect
  extends ExternalComponentWithAttributesWithRefType[tag.type, default[js.Any]] {
  override val component: String | js.Object = js.constructorOf[typings.reactDashSelect.reactDashSelectMod.default[js.Any]].asInstanceOf[String | js.Object]
  def apply[TValue](addLabelText: String = null): BuildingComponent[tag.type, default[js.Any]] = {
    val __obj = js.Dynamic.literal()
    if (addLabelText != null) __obj.updateDynamic("addLabelText")(addLabelText)
    super.apply(__obj.asInstanceOf[Props]).asInstanceOf[slinky.core.BuildingComponent[
  slinky.web.html.`*`.tag.type, 
  typings.reactDashSelect.reactDashSelectMod.default[js.Any]]]
  }
  type Props = ReactSelectProps[js.Any]
}

