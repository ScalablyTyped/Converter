package typingsJapgolly.reactDashBootstrap.components

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.react.reactMod.AllHTMLAttributes
import typingsJapgolly.react.reactMod.ClassAttributes
import typingsJapgolly.reactDashBootstrap.libButtonGroupMod.ButtonGroupProps
import typingsJapgolly.reactDashBootstrap.reactDashBootstrapMod.Sizes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ButtonGroup {
  def apply(
    AllHTMLAttributes: AllHTMLAttributes[typingsJapgolly.reactDashBootstrap.libButtonGroupMod.ButtonGroup] = null,
    ClassAttributes: ClassAttributes[typingsJapgolly.reactDashBootstrap.libButtonGroupMod.ButtonGroup] = null,
    block: js.UndefOr[Boolean] = js.undefined,
    bsSize: Sizes = null,
    bsStyle: String = null,
    justified: js.UndefOr[Boolean] = js.undefined,
    vertical: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[Key] = js.undefined,
    _overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[
    ButtonGroupProps, 
    typingsJapgolly.reactDashBootstrap.libMod.ButtonGroup, 
    Unit, 
    ButtonGroupProps
  ] = {
    val __obj = js.Dynamic.literal()
  
      if (AllHTMLAttributes != null) js.Dynamic.global.Object.assign(__obj, AllHTMLAttributes)
    if (ClassAttributes != null) js.Dynamic.global.Object.assign(__obj, ClassAttributes)
    if (!js.isUndefined(block)) __obj.updateDynamic("block")(block.asInstanceOf[js.Any])
    if (bsSize != null) __obj.updateDynamic("bsSize")(bsSize.asInstanceOf[js.Any])
    if (bsStyle != null) __obj.updateDynamic("bsStyle")(bsStyle.asInstanceOf[js.Any])
    if (!js.isUndefined(justified)) __obj.updateDynamic("justified")(justified.asInstanceOf[js.Any])
    if (!js.isUndefined(vertical)) __obj.updateDynamic("vertical")(vertical.asInstanceOf[js.Any])
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typingsJapgolly.reactDashBootstrap.libButtonGroupMod.ButtonGroupProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typingsJapgolly.reactDashBootstrap.libMod.ButtonGroup](this.componentImport)
    f(__obj.asInstanceOf[typingsJapgolly.reactDashBootstrap.libButtonGroupMod.ButtonGroupProps])(children: _*)
  }
  @JSImport("react-bootstrap/lib", "ButtonGroup")
  @js.native
  object componentImport extends js.Object
  
}

