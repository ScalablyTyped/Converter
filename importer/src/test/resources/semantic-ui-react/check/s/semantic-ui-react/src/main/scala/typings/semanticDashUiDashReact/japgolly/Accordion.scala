package typings.semanticUiReact.japgolly

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import typings.semanticUiReact.genericMod.SemanticShorthandCollection
import typings.semanticUiReact.modulesAccordionAccordionMod.AccordionProps
import typings.semanticUiReact.modulesAccordionAccordionPanelMod.AccordionPanelProps
import typings.semanticUiReact.modulesAccordionAccordionTitleMod.AccordionTitleProps
import typings.semanticUiReact.modulesAccordionMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Accordion {
  def apply(
    key: js.UndefOr[Key] = js.undefined,
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    activeIndex: Double | js.Array[Double] = null,
    as: js.Any = null,
    className: String = null,
    defaultActiveIndex: Double | js.Array[Double] = null,
    exclusive: js.UndefOr[Boolean] = js.undefined,
    fluid: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    onTitleClick: js.UndefOr[
      (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback
    ] = js.undefined,
    panels: SemanticShorthandCollection[AccordionPanelProps] = null,
    styled: js.UndefOr[Boolean] = js.undefined
  )(
    children: ChildArg*
  ): UnmountedWithRoot[AccordionProps, default, Unit, AccordionProps] = {
    val __obj = js.Dynamic.literal()
  
    
      key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (activeIndex != null) __obj.updateDynamic("activeIndex")(activeIndex.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as)
    if (className != null) __obj.updateDynamic("className")(className)
    if (defaultActiveIndex != null) __obj.updateDynamic("defaultActiveIndex")(defaultActiveIndex.asInstanceOf[js.Any])
    if (!js.isUndefined(exclusive)) __obj.updateDynamic("exclusive")(exclusive)
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid)
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted)
    onTitleClick.foreach(p => __obj.updateDynamic("onTitleClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLDivElement], t1: /* data */ typings.semanticUiReact.modulesAccordionAccordionTitleMod.AccordionTitleProps) => p(t0, t1).runNow()))))
    if (panels != null) __obj.updateDynamic("panels")(panels)
    if (!js.isUndefined(styled)) __obj.updateDynamic("styled")(styled)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.modulesAccordionAccordionMod.AccordionProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.modulesAccordionMod.default](js.constructorOf[typings.semanticUiReact.modulesAccordionMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesAccordionAccordionMod.AccordionProps])(children: _*)
  }
}

