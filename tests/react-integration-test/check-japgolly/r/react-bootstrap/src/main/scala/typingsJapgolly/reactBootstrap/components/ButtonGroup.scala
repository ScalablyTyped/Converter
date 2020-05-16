package typingsJapgolly.reactBootstrap.components

import japgolly.scalajs.react.Children.Varargs
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.JsForwardRefComponent.force
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.react.mod.AllHTMLAttributes
import typingsJapgolly.react.mod.ClassAttributes
import typingsJapgolly.reactBootstrap.buttonGroupMod.ButtonGroupProps
import typingsJapgolly.reactBootstrap.mod.Sizes
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ButtonGroup {
  def apply(
    AllHTMLAttributes: AllHTMLAttributes[typingsJapgolly.reactBootstrap.buttonGroupMod.ButtonGroup] = null,
    ClassAttributes: ClassAttributes[typingsJapgolly.reactBootstrap.buttonGroupMod.ButtonGroup] = null,
    block: js.UndefOr[Boolean] = js.undefined,
    bsSize: Sizes = null,
    bsStyle: String = null,
    justified: js.UndefOr[Boolean] = js.undefined,
    vertical: js.UndefOr[Boolean] = js.undefined,
    key: Key = null,
    _overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[
    ButtonGroupProps, 
    typingsJapgolly.reactBootstrap.mod.ButtonGroup, 
    Unit, 
    ButtonGroupProps
  ] = {
    val __obj = js.Dynamic.literal()
    if (AllHTMLAttributes != null) js.Dynamic.global.Object.assign(__obj, AllHTMLAttributes)
    if (ClassAttributes != null) js.Dynamic.global.Object.assign(__obj, ClassAttributes)
    if (!js.isUndefined(block)) __obj.updateDynamic("block")(block.get.asInstanceOf[js.Any])
    if (bsSize != null) __obj.updateDynamic("bsSize")(bsSize.asInstanceOf[js.Any])
    if (bsStyle != null) __obj.updateDynamic("bsStyle")(bsStyle.asInstanceOf[js.Any])
    if (!js.isUndefined(justified)) __obj.updateDynamic("justified")(justified.get.asInstanceOf[js.Any])
    if (!js.isUndefined(vertical)) __obj.updateDynamic("vertical")(vertical.get.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    val f = force[ButtonGroupProps, Varargs, typingsJapgolly.reactBootstrap.mod.ButtonGroup](this.componentImport)
    f(__obj.asInstanceOf[ButtonGroupProps])(children :_*)
  }
  @JSImport("react-bootstrap", "ButtonGroup")
  @js.native
  object componentImport extends js.Object
  
}

