package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.bottom
import typings.semanticDashUiDashReact.semanticDashUiDashReactStrings.top
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typings.semanticDashUiDashReact.srcModulesDimmerDimmerInnerMod.DimmerInnerProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The following DOM/SVG props were specified: children, className, disabled */
object Inner {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    content: SemanticShorthandContent = null,
    inverted: js.UndefOr[Boolean] = js.undefined,
    onClick: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ DimmerInnerProps) => Callback = null,
    onClickOutside: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ DimmerInnerProps) => Callback = null,
    page: js.UndefOr[Boolean] = js.undefined,
    simple: js.UndefOr[Boolean] = js.undefined,
    verticalAlign: bottom | top = null
  )(
    children: /** Primary content. */
  ChildArg*
  ): UnmountedWithRoot[
    DimmerInnerProps, 
    typings.semanticDashUiDashReact.srcModulesDimmerMod.default.Inner, 
    Unit, 
    DimmerInnerProps
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted)
        if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLDivElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesDimmerDimmerInnerMod.DimmerInnerProps) => onClick(t0, t1).runNow())))
        if (onClickOutside != null) __obj.updateDynamic("onClickOutside")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLDivElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesDimmerDimmerInnerMod.DimmerInnerProps) => onClickOutside(t0, t1).runNow())))
    if (!js.isUndefined(page)) __obj.updateDynamic("page")(page)
    if (!js.isUndefined(simple)) __obj.updateDynamic("simple")(simple)
    if (verticalAlign != null) __obj.updateDynamic("verticalAlign")(verticalAlign.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent[
  typings.semanticDashUiDashReact.srcModulesDimmerDimmerInnerMod.DimmerInnerProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticDashUiDashReact.srcModulesDimmerMod.default.Inner](js.constructorOf[typings.semanticDashUiDashReact.srcModulesDimmerMod.default.Inner])
    f(__obj.asInstanceOf[typings.semanticDashUiDashReact.srcModulesDimmerDimmerInnerMod.DimmerInnerProps])(children: _*)
  }
}

