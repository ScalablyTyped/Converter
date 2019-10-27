package typings.reactDashBootstrap.japgolly

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typings.react.Anon_Html
import typings.react.reactStrings.foo
import typings.reactDashBootstrap.libButtonGroupMod.ButtonGroupProps
import typings.reactDashBootstrap.reactDashBootstrapMod.Sizes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ButtonGroup {
  def apply(
    defaultValue: foo,
    onChange: foo,
    value: foo,
    `type`: foo,
    accept: String = null,
    acceptCharset: String = null,
    block: js.UndefOr[Boolean] = js.undefined,
    bsSize: Sizes = null,
    bsStyle: String = null,
    dangerouslySetInnerHTML: Anon_Html = null,
    defaultChecked: js.UndefOr[Boolean] = js.undefined,
    justified: js.UndefOr[Boolean] = js.undefined,
    vertical: js.UndefOr[Boolean] = js.undefined
  )(
    children: ChildArg*
  ): UnmountedWithRoot[
    ButtonGroupProps, 
    typings.reactDashBootstrap.libMod.ButtonGroup, 
    Unit, 
    ButtonGroupProps
  ] = {
    val __obj = js.Dynamic.literal(defaultValue = defaultValue, onChange = onChange, value = value)
  
      __obj.updateDynamic("type")(`type`)
    if (accept != null) __obj.updateDynamic("accept")(accept)
    if (acceptCharset != null) __obj.updateDynamic("acceptCharset")(acceptCharset)
    if (!js.isUndefined(block)) __obj.updateDynamic("block")(block)
    if (bsSize != null) __obj.updateDynamic("bsSize")(bsSize)
    if (bsStyle != null) __obj.updateDynamic("bsStyle")(bsStyle)
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML)
    if (!js.isUndefined(defaultChecked)) __obj.updateDynamic("defaultChecked")(defaultChecked)
    if (!js.isUndefined(justified)) __obj.updateDynamic("justified")(justified)
    if (!js.isUndefined(vertical)) __obj.updateDynamic("vertical")(vertical)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.reactDashBootstrap.libButtonGroupMod.ButtonGroupProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.reactDashBootstrap.libMod.ButtonGroup](js.constructorOf[typings.reactDashBootstrap.libMod.ButtonGroup])
    f(__obj.asInstanceOf[typings.reactDashBootstrap.libButtonGroupMod.ButtonGroupProps])(children: _*)
  }
}

