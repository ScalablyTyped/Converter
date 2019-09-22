package typings.semanticDashUiDashReact.elementsInputInputMod

import typings.react.HTMLInputElement
import typings.react.reactMod.ChangeEvent
import typings.react.reactMod.ReactNode
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`left corner`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.`right corner`
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.big
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.huge
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.large
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.left
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.massive
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.mini
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.right
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.small
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait InputOnChangeData extends InputProps {
  var value: String
}

object InputOnChangeData {
  @scala.inline
  def apply(
    value: String,
    action: js.Any | Boolean = null,
    actionPosition: left = null,
    as: js.Any = null,
    children: ReactNode = null,
    className: String = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    error: js.UndefOr[Boolean] = js.undefined,
    fluid: js.UndefOr[Boolean] = js.undefined,
    focus: js.UndefOr[Boolean] = js.undefined,
    icon: js.Any = null,
    iconPosition: left = null,
    input: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify SemanticShorthandItem<HtmlInputrops> */ js.Any = null,
    inverted: js.UndefOr[Boolean] = js.undefined,
    label: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify SemanticShorthandItem<LabelProps> */ js.Any = null,
    labelPosition: left | right | (`left corner`) | (`right corner`) = null,
    loading: js.UndefOr[Boolean] = js.undefined,
    onChange: (/* event */ ChangeEvent[HTMLInputElement], /* data */ InputOnChangeData) => Unit = null,
    size: mini | small | large | big | huge | massive = null,
    tabIndex: Double | String = null,
    transparent: js.UndefOr[Boolean] = js.undefined,
    `type`: String = null
  ): InputOnChangeData = {
    val __obj = js.Dynamic.literal(value = value)
    if (action != null) __obj.updateDynamic("action")(action.asInstanceOf[js.Any])
    if (actionPosition != null) __obj.updateDynamic("actionPosition")(actionPosition)
    if (as != null) __obj.updateDynamic("as")(as)
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className)
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (!js.isUndefined(error)) __obj.updateDynamic("error")(error)
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid)
    if (!js.isUndefined(focus)) __obj.updateDynamic("focus")(focus)
    if (icon != null) __obj.updateDynamic("icon")(icon)
    if (iconPosition != null) __obj.updateDynamic("iconPosition")(iconPosition)
    if (input != null) __obj.updateDynamic("input")(input)
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted)
    if (label != null) __obj.updateDynamic("label")(label)
    if (labelPosition != null) __obj.updateDynamic("labelPosition")(labelPosition.asInstanceOf[js.Any])
    if (!js.isUndefined(loading)) __obj.updateDynamic("loading")(loading)
    if (onChange != null) __obj.updateDynamic("onChange")(js.Any.fromFunction2(onChange))
    if (size != null) __obj.updateDynamic("size")(size.asInstanceOf[js.Any])
    if (tabIndex != null) __obj.updateDynamic("tabIndex")(tabIndex.asInstanceOf[js.Any])
    if (!js.isUndefined(transparent)) __obj.updateDynamic("transparent")(transparent)
    if (`type` != null) __obj.updateDynamic("type")(`type`)
    __obj.asInstanceOf[InputOnChangeData]
  }
}

