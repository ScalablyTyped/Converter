package typingsSlinky.atStardustDashUiReactDashComponentDashRef.components

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typingsSlinky.atStardustDashUiReactDashComponentDashRef.distEsTypesMod.RefProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Ref
  extends ExternalComponentWithAttributesWithRefType[tag.type, js.Object] {
  override val component: String | js.Object = typingsSlinky.atStardustDashUiReactDashComponentDashRef.distEsRefMod.default.asInstanceOf[String | js.Object]
  def apply(innerRef: typingsSlinky.react.reactMod.Ref[_] = null, overrides: StringDictionary[js.Any] = null): BuildingComponent[tag.type, js.Object] = {
    val __obj = js.Dynamic.literal()
    if (innerRef != null) __obj.updateDynamic("innerRef")(innerRef.asInstanceOf[js.Any])
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = RefProps
}

