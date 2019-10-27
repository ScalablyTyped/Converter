package typings.reactBootstrap.Slinky

import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.react.reactStrings.foo
import typings.reactBootstrap.libButtonGroupMod.ButtonGroupProps
import typings.reactBootstrap.reactBootstrapMod.Sizes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: accept, acceptCharset, children, dangerouslySetInnerHTML, defaultChecked */
object ButtonGroup
  extends ExternalComponentWithAttributesWithRefType[tag.type, typings.reactBootstrap.libMod.ButtonGroup] {
  override val component: String | js.Object = js.constructorOf[typings.reactBootstrap.libMod.ButtonGroup].asInstanceOf[String | js.Object]
  def apply(
    defaultValue: foo,
    onChange: foo,
    value: foo,
    `type`: foo,
    block: js.UndefOr[Boolean] = js.undefined,
    bsSize: Sizes = null,
    bsStyle: String = null,
    justified: js.UndefOr[Boolean] = js.undefined,
    vertical: js.UndefOr[Boolean] = js.undefined
  ): BuildingComponent[tag.type, typings.reactBootstrap.libMod.ButtonGroup] = {
    val __obj = js.Dynamic.literal(defaultValue = defaultValue, onChange = onChange, value = value)
    __obj.updateDynamic("type")(`type`)
    if (!js.isUndefined(block)) __obj.updateDynamic("block")(block)
    if (bsSize != null) __obj.updateDynamic("bsSize")(bsSize)
    if (bsStyle != null) __obj.updateDynamic("bsStyle")(bsStyle)
    if (!js.isUndefined(justified)) __obj.updateDynamic("justified")(justified)
    if (!js.isUndefined(vertical)) __obj.updateDynamic("vertical")(vertical)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = ButtonGroupProps
}

