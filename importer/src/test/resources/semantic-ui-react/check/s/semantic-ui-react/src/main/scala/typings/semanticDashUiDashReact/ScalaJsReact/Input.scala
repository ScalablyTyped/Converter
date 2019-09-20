package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.ExternalComponentWithAttributesWithRefType
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.component.Component
import japgolly.scalajs.web.html.`*`.tag
import org.scalablytyped.runtime.StringDictionary
import typings.semanticDashUiDashReact.inputInputMod.InputOnChangeData
import typings.semanticDashUiDashReact.inputInputMod.InputProps
import typings.semanticDashUiDashReact.inputMod.default
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

/* The following DOM/SVG props were specified: children */
object Input
  extends ExternalComponentWithAttributesWithRefType[tag.type, default] {
  override val component: String | js.Object = js.constructorOf[typings.semanticDashUiDashReact.inputMod.default].asInstanceOf[String | js.Object]
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    action: js.Any | Boolean = null,
    actionPosition: left = null,
    as: js.Any = null,
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
    onChange: (/* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify React.ChangeEvent<HTMLInputElement> */ /* event */ js.Any, /* data */ InputOnChangeData) => Unit = null,
    size: mini | small | large | big | huge | massive = null,
    tabIndex: Double | String = null,
    transparent: js.UndefOr[Boolean] = js.undefined,
    `type`: String = null
  )(
    /** Primary content. */
  children: ChildArg
  ): Component[tag.type, default] = {
    import japgolly.scalajs.react._
  
    val __obj = js.Dynamic.literal()
  
    type InputType = typings.semanticDashUiDashReact.inputMod.default
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (action != null) __obj.updateDynamic("action")(action.asInstanceOf[js.Any])
    if (actionPosition != null) __obj.updateDynamic("actionPosition")(actionPosition)
    if (as != null) __obj.updateDynamic("as")(as)
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
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.Varargs, InputType](js.constructorOf[InputType])
  
    f(props)(children: _*)
  }
  type Props = InputProps
}

