package typings.reactDashBootstrap.Slinky

import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typings.react.reactStrings.foo
import typings.reactDashBootstrap.libButtonGroupMod.ButtonGroupProps
import typings.reactDashBootstrap.reactDashBootstrapMod.Sizes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: accept, acceptCharset, children, dangerouslySetInnerHTML, defaultChecked */
object ButtonGroup
  extends ExternalComponentWithAttributesWithRefType[tag.type, typings.reactDashBootstrap.libMod.ButtonGroup] {
  override val component: String | js.Object = js.constructorOf[typings.reactDashBootstrap.libMod.ButtonGroup].asInstanceOf[String | js.Object]
  type dummy = typings.reactDashBootstrap.libMod.ButtonGroup
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
  ): BuildingComponent[tag.type, typings.reactDashBootstrap.libMod.ButtonGroup] = {
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

