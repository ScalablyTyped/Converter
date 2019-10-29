package typings.semanticUiReact.japgolly

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import typings.semanticUiReact.genericMod.SemanticShorthandCollection
import typings.semanticUiReact.modulesAccordionAccordionAccordionMod.AccordionAccordionProps
import typings.semanticUiReact.modulesAccordionAccordionAccordionMod.default
import typings.semanticUiReact.modulesAccordionAccordionPanelMod.AccordionPanelProps
import typings.semanticUiReact.modulesAccordionAccordionTitleMod.AccordionTitleProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object AccordionAccordion {
  def apply(
    key: js.UndefOr[Key] = js.undefined,
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    activeIndex: Double | js.Array[Double] = null,
    as: js.Any = null,
    className: String = null,
    defaultActiveIndex: Double | js.Array[Double] = null,
    exclusive: js.UndefOr[Boolean] = js.undefined,
    onTitleClick: js.UndefOr[
      (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback
    ] = js.undefined,
    panels: SemanticShorthandCollection[AccordionPanelProps] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[AccordionAccordionProps, default, Unit, AccordionAccordionProps] = {
    val __obj = js.Dynamic.literal()
  
      key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (activeIndex != null) __obj.updateDynamic("activeIndex")(activeIndex.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (defaultActiveIndex != null) __obj.updateDynamic("defaultActiveIndex")(defaultActiveIndex.asInstanceOf[js.Any])
    if (!js.isUndefined(exclusive)) __obj.updateDynamic("exclusive")(exclusive)
    onTitleClick.foreach(p => __obj.updateDynamic("onTitleClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLDivElement], t1: /* data */ typings.semanticUiReact.modulesAccordionAccordionTitleMod.AccordionTitleProps) => p(t0, t1).runNow()))))
    if (panels != null) __obj.updateDynamic("panels")(panels)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.modulesAccordionAccordionAccordionMod.AccordionAccordionProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.modulesAccordionAccordionAccordionMod.default](js.constructorOf[typings.semanticUiReact.modulesAccordionAccordionAccordionMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesAccordionAccordionAccordionMod.AccordionAccordionProps])(children: _*)
  }
}

