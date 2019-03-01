package typings
package reactDashBootstrapLib.libButtonGroupMod.ButtonGroupNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ButtonGroupProps
  extends reactLib.reactMod.ReactNs.HTMLProps[reactDashBootstrapLib.libButtonGroupMod.ButtonGroup] {
  var block: js.UndefOr[scala.Boolean] = js.undefined
  var bsSize: js.UndefOr[reactDashBootstrapLib.reactDashBootstrapMod.Sizes] = js.undefined
  var bsStyle: js.UndefOr[java.lang.String] = js.undefined
  var justified: js.UndefOr[scala.Boolean] = js.undefined
  var vertical: js.UndefOr[scala.Boolean] = js.undefined
}

object ButtonGroupProps {
  @scala.inline
  def apply(
    defaultValue: reactLib.reactLibStrings.foo,
    onChange: reactLib.reactLibStrings.foo,
    `type`: reactLib.reactLibStrings.foo,
    value: reactLib.reactLibStrings.foo,
    accept: java.lang.String = null,
    acceptCharset: java.lang.String = null,
    block: js.UndefOr[scala.Boolean] = js.undefined,
    bsSize: reactDashBootstrapLib.reactDashBootstrapMod.Sizes = null,
    bsStyle: java.lang.String = null,
    children: reactLib.reactMod.ReactNs.ReactNode = null,
    dangerouslySetInnerHTML: reactLib.Anon_Html = null,
    defaultChecked: js.UndefOr[scala.Boolean] = js.undefined,
    justified: js.UndefOr[scala.Boolean] = js.undefined,
    key: reactLib.reactMod.ReactNs.Key = null,
    ref: reactLib.reactMod.ReactNs.Ref[reactDashBootstrapLib.libButtonGroupMod.ButtonGroup] = null,
    vertical: js.UndefOr[scala.Boolean] = js.undefined
  ): ButtonGroupProps = {
    val __obj = js.Dynamic.literal(defaultValue = defaultValue, onChange = onChange, value = value)
    __obj.updateDynamic("type")(`type`)
    if (accept != null) __obj.updateDynamic("accept")(accept)
    if (acceptCharset != null) __obj.updateDynamic("acceptCharset")(acceptCharset)
    if (!js.isUndefined(block)) __obj.updateDynamic("block")(block)
    if (bsSize != null) __obj.updateDynamic("bsSize")(bsSize)
    if (bsStyle != null) __obj.updateDynamic("bsStyle")(bsStyle)
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML)
    if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked)
    if (!js.isUndefined(justified)) __obj.updateDynamic("justified")(justified)
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
    if (!js.isUndefined(vertical)) __obj.updateDynamic("vertical")(vertical)
    __obj.asInstanceOf[ButtonGroupProps]
  }
}

