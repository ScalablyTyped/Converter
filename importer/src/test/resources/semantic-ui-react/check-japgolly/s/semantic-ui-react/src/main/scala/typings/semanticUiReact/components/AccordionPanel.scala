package typings.semanticUiReact.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import typings.semanticUiReact.genericMod.SemanticShorthandItem
import typings.semanticUiReact.modulesAccordionAccordionContentMod.AccordionContentProps
import typings.semanticUiReact.modulesAccordionAccordionPanelMod.AccordionPanelProps
import typings.semanticUiReact.modulesAccordionAccordionPanelMod.default
import typings.semanticUiReact.modulesAccordionAccordionTitleMod.AccordionTitleProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object AccordionPanel {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    content: SemanticShorthandItem[AccordionContentProps] = null,
    index: Double | String = null,
    onTitleClick: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback = null,
    title: SemanticShorthandItem[AccordionTitleProps] = null,
    key: js.UndefOr[Key] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[AccordionPanelProps, default, Unit, AccordionPanelProps] = {
    val __obj = js.Dynamic.literal()
  
      if (StringDictionary != null) js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active.asInstanceOf[js.Any])
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (index != null) __obj.updateDynamic("index")(index.asInstanceOf[js.Any])
    if (onTitleClick != null) __obj.updateDynamic("onTitleClick")(js.Any.fromFunction2((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLDivElement], t1: /* data */ typings.semanticUiReact.modulesAccordionAccordionTitleMod.AccordionTitleProps) => onTitleClick(t0, t1).runNow()))
    if (title != null) __obj.updateDynamic("title")(title.asInstanceOf[js.Any])
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.modulesAccordionAccordionPanelMod.AccordionPanelProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.modulesAccordionAccordionPanelMod.default](js.constructorOf[typings.semanticUiReact.modulesAccordionAccordionPanelMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesAccordionAccordionPanelMod.AccordionPanelProps])(children: _*)
  }
}

