package typings.semanticUiReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import typings.semanticUiReact.elementsIconIconMod.IconProps
import typings.semanticUiReact.genericMod.SemanticShorthandContent
import typings.semanticUiReact.genericMod.SemanticShorthandItem
import typings.semanticUiReact.modulesAccordionAccordionTitleMod.AccordionTitleProps
import typings.semanticUiReact.modulesAccordionAccordionTitleMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object AccordionTitle {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    className: String = null,
    content: SemanticShorthandContent = null,
    icon: SemanticShorthandItem[IconProps] = null,
    index: Double | String = null,
    onClick: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[AccordionTitleProps, default, Unit, AccordionTitleProps] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (icon != null) __obj.updateDynamic("icon")(icon.asInstanceOf[js.Any])
    if (index != null) __obj.updateDynamic("index")(index.asInstanceOf[js.Any])
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLDivElement], t1: /* data */ typings.semanticUiReact.modulesAccordionAccordionTitleMod.AccordionTitleProps) => onClick(t0, t1).runNow())))
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.modulesAccordionAccordionTitleMod.AccordionTitleProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.modulesAccordionAccordionTitleMod.default](js.constructorOf[typings.semanticUiReact.modulesAccordionAccordionTitleMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesAccordionAccordionTitleMod.AccordionTitleProps])(children: _*)
  }
}

