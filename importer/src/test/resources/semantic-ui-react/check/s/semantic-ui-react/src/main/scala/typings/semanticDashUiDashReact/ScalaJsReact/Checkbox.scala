package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLInputElement
import typings.react.reactMod.FormEvent
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.checkbox
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.radio
import typings.semanticDashUiDashReact.srcGenericMod.HtmlLabelProps
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandItem
import typings.semanticDashUiDashReact.srcModulesCheckboxCheckboxMod.CheckboxProps
import typings.semanticDashUiDashReact.srcModulesCheckboxMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: checked, className, defaultChecked, disabled, name, readOnly, value */
object Checkbox {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    as: js.Any = null,
    defaultIndeterminate: js.UndefOr[Boolean] = js.undefined,
    fitted: js.UndefOr[Boolean] = js.undefined,
    id: Double | String = null,
    indeterminate: js.UndefOr[Boolean] = js.undefined,
    label: SemanticShorthandItem[HtmlLabelProps] = null,
    onChange: (/* event */ FormEvent[HTMLInputElement], /* data */ CheckboxProps) => Callback = null,
    onClick: (/* event */ ReactMouseEventFrom[HTMLInputElement], /* data */ CheckboxProps) => Callback = null,
    onMouseDown: (/* event */ ReactMouseEventFrom[HTMLInputElement], /* data */ CheckboxProps) => Callback = null,
    onMouseUp: (/* event */ ReactMouseEventFrom[HTMLInputElement], /* data */ CheckboxProps) => Callback = null,
    radio: js.UndefOr[Boolean] = js.undefined,
    slider: js.UndefOr[Boolean] = js.undefined,
    tabIndex: Double | String = null,
    toggle: js.UndefOr[Boolean] = js.undefined,
    `type`: checkbox | radio = null
  )(
    
  ): UnmountedWithRoot[CheckboxProps, default, Unit, CheckboxProps] = {
    import japgolly.scalajs.react.Children
    import japgolly.scalajs.react.JsForwardRefComponent
  
    val __obj = js.Dynamic.literal()
  
    type CheckboxType = typings.semanticDashUiDashReact.srcModulesCheckboxMod.default
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (as != null) __obj.updateDynamic("as")(as)
    if (!js.isUndefined(defaultIndeterminate)) __obj.updateDynamic("defaultIndeterminate")(defaultIndeterminate)
    if (!js.isUndefined(fitted)) __obj.updateDynamic("fitted")(fitted)
    if (id != null) __obj.updateDynamic("id")(id.asInstanceOf[js.Any])
    if (!js.isUndefined(indeterminate)) __obj.updateDynamic("indeterminate")(indeterminate)
    if (label != null) __obj.updateDynamic("label")(label.asInstanceOf[js.Any])
        if (onChange != null) __obj.updateDynamic("onChange")(js.Any.fromFunction2(((t0: /* event */ typings.react.reactMod.FormEvent[org.scalajs.dom.raw.HTMLInputElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesCheckboxCheckboxMod.CheckboxProps) => onChange(t0, t1).runNow())))
        if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesCheckboxCheckboxMod.CheckboxProps) => onClick(t0, t1).runNow())))
        if (onMouseDown != null) __obj.updateDynamic("onMouseDown")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesCheckboxCheckboxMod.CheckboxProps) => onMouseDown(t0, t1).runNow())))
        if (onMouseUp != null) __obj.updateDynamic("onMouseUp")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLInputElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesCheckboxCheckboxMod.CheckboxProps) => onMouseUp(t0, t1).runNow())))
    if (!js.isUndefined(radio)) __obj.updateDynamic("radio")(radio)
    if (!js.isUndefined(slider)) __obj.updateDynamic("slider")(slider)
    if (tabIndex != null) __obj.updateDynamic("tabIndex")(tabIndex.asInstanceOf[js.Any])
    if (!js.isUndefined(toggle)) __obj.updateDynamic("toggle")(toggle)
    if (`type` != null) __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.None, CheckboxType](js.constructorOf[CheckboxType])
  
    f(props)
  }
  type Props = CheckboxProps
}

