package typings.semanticUiReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import typings.semanticUiReact.modulesDimmerDimmerInnerMod.DimmerInnerProps
import typings.semanticUiReact.modulesDimmerDimmerInnerMod.default
import typings.semanticUiReact.semanticUiReactStrings.bottom
import typings.semanticUiReact.semanticUiReactStrings.top
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object DimmerInner {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    disabled: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    onClick: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ DimmerInnerProps) => Callback = null,
    onClickOutside: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ DimmerInnerProps) => Callback = null,
    page: js.UndefOr[Boolean] = js.undefined,
    simple: js.UndefOr[Boolean] = js.undefined,
    verticalAlign: bottom | top = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[DimmerInnerProps, default, Unit, DimmerInnerProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(disabled)) __obj.updateDynamic("disabled")(disabled)
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted)
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLDivElement], t1: /* data */ typings.semanticUiReact.modulesDimmerDimmerInnerMod.DimmerInnerProps) => onClick(t0, t1).runNow())))
    if (onClickOutside != null) __obj.updateDynamic("onClickOutside")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLDivElement], t1: /* data */ typings.semanticUiReact.modulesDimmerDimmerInnerMod.DimmerInnerProps) => onClickOutside(t0, t1).runNow())))
    if (!js.isUndefined(page)) __obj.updateDynamic("page")(page)
    if (!js.isUndefined(simple)) __obj.updateDynamic("simple")(simple)
    if (verticalAlign != null) __obj.updateDynamic("verticalAlign")(verticalAlign.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.modulesDimmerDimmerInnerMod.DimmerInnerProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.modulesDimmerDimmerInnerMod.default](js.constructorOf[typings.semanticUiReact.modulesDimmerDimmerInnerMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesDimmerDimmerInnerMod.DimmerInnerProps])(children: _*)
  }
}

