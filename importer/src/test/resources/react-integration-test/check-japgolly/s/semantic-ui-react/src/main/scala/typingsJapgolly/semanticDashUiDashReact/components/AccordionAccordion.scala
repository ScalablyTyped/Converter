package typingsJapgolly.semanticDashUiDashReact.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import typingsJapgolly.semanticDashUiDashReact.srcGenericMod.SemanticShorthandCollection
import typingsJapgolly.semanticDashUiDashReact.srcModulesAccordionAccordionAccordionMod.AccordionAccordionProps
import typingsJapgolly.semanticDashUiDashReact.srcModulesAccordionAccordionAccordionMod.default
import typingsJapgolly.semanticDashUiDashReact.srcModulesAccordionAccordionPanelMod.AccordionPanelProps
import typingsJapgolly.semanticDashUiDashReact.srcModulesAccordionAccordionTitleMod.AccordionTitleProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object AccordionAccordion {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    activeIndex: Double | js.Array[Double] = null,
    as: js.Any = null,
    className: String = null,
    defaultActiveIndex: Double | js.Array[Double] = null,
    exclusive: js.UndefOr[Boolean] = js.undefined,
    onTitleClick: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback = null,
    panels: SemanticShorthandCollection[AccordionPanelProps] = null,
    key: js.UndefOr[Key] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[AccordionAccordionProps, default, Unit, AccordionAccordionProps] = {
    val __obj = js.Dynamic.literal()
  
      if (StringDictionary != null) js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (activeIndex != null) __obj.updateDynamic("activeIndex")(activeIndex.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (defaultActiveIndex != null) __obj.updateDynamic("defaultActiveIndex")(defaultActiveIndex.asInstanceOf[js.Any])
    if (!js.isUndefined(exclusive)) __obj.updateDynamic("exclusive")(exclusive.asInstanceOf[js.Any])
    if (onTitleClick != null) __obj.updateDynamic("onTitleClick")(js.Any.fromFunction2((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLDivElement], t1: /* data */ typingsJapgolly.semanticDashUiDashReact.srcModulesAccordionAccordionTitleMod.AccordionTitleProps) => onTitleClick(t0, t1).runNow()))
    if (panels != null) __obj.updateDynamic("panels")(panels.asInstanceOf[js.Any])
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typingsJapgolly.semanticDashUiDashReact.srcModulesAccordionAccordionAccordionMod.AccordionAccordionProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typingsJapgolly.semanticDashUiDashReact.srcModulesAccordionAccordionAccordionMod.default](js.constructorOf[typingsJapgolly.semanticDashUiDashReact.srcModulesAccordionAccordionAccordionMod.default])
    f(__obj.asInstanceOf[typingsJapgolly.semanticDashUiDashReact.srcModulesAccordionAccordionAccordionMod.AccordionAccordionProps])(children: _*)
  }
}

