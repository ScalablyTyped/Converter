package typings.slinky.reactSelect

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.reactSelect.reactSelectMod.ReactSelectProps
import typings.reactSelect.reactSelectMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ReactSelect
  extends ExternalComponentWithAttributesWithRefType[tag.type, default[js.Any]] {
  override val component: String | js.Object = js.constructorOf[typings.reactSelect.reactSelectMod.default[js.Any]].asInstanceOf[String | js.Object]
  def apply[TValue](addLabelText: String = null, overrides: StringDictionary[js.Any] = null): BuildingComponent[tag.type, default[js.Any]] = {
    val __obj = js.Dynamic.literal()
    if (addLabelText != null) __obj.updateDynamic("addLabelText")(addLabelText)
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
    super.apply(__obj.asInstanceOf[Props]).asInstanceOf[slinky.core.BuildingComponent[slinky.web.html.`*`.tag.type, typings.reactSelect.reactSelectMod.default[js.Any]]]
  }
  type Props = ReactSelectProps[js.Any]
}

