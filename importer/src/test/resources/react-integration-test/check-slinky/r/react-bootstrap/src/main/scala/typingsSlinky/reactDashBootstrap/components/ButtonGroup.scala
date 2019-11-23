package typingsSlinky.reactDashBootstrap.components

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typingsSlinky.react.reactMod.AllHTMLAttributes
import typingsSlinky.react.reactMod.ClassAttributes
import typingsSlinky.reactDashBootstrap.libButtonGroupMod.ButtonGroupProps
import typingsSlinky.reactDashBootstrap.reactDashBootstrapMod.Sizes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ButtonGroup
  extends ExternalComponentWithAttributesWithRefType[tag.type, typingsSlinky.reactDashBootstrap.libMod.ButtonGroup] {
  override val component: String | js.Object = js.constructorOf[typingsSlinky.reactDashBootstrap.libMod.ButtonGroup].asInstanceOf[String | js.Object]
  def apply(
    AllHTMLAttributes: AllHTMLAttributes[typingsSlinky.reactDashBootstrap.libButtonGroupMod.ButtonGroup] = null,
    ClassAttributes: ClassAttributes[typingsSlinky.reactDashBootstrap.libButtonGroupMod.ButtonGroup] = null,
    block: js.UndefOr[Boolean] = js.undefined,
    bsSize: Sizes = null,
    bsStyle: String = null,
    justified: js.UndefOr[Boolean] = js.undefined,
    vertical: js.UndefOr[Boolean] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  ): BuildingComponent[tag.type, typingsSlinky.reactDashBootstrap.libMod.ButtonGroup] = {
    val __obj = js.Dynamic.literal()
    if (AllHTMLAttributes != null) js.Dynamic.global.Object.assign(__obj, AllHTMLAttributes)
    if (ClassAttributes != null) js.Dynamic.global.Object.assign(__obj, ClassAttributes)
    if (!js.isUndefined(block)) __obj.updateDynamic("block")(block.asInstanceOf[js.Any])
    if (bsSize != null) __obj.updateDynamic("bsSize")(bsSize.asInstanceOf[js.Any])
    if (bsStyle != null) __obj.updateDynamic("bsStyle")(bsStyle.asInstanceOf[js.Any])
    if (!js.isUndefined(justified)) __obj.updateDynamic("justified")(justified.asInstanceOf[js.Any])
    if (!js.isUndefined(vertical)) __obj.updateDynamic("vertical")(vertical.asInstanceOf[js.Any])
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = ButtonGroupProps
}

