package typings.semanticUiReact.japgolly

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
    key: js.UndefOr[Key] = js.undefined,
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    content: SemanticShorthandItem[AccordionContentProps] = null,
    index: Double | String = null,
    onTitleClick: js.UndefOr[
      (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback
    ] = js.undefined,
    title: SemanticShorthandItem[AccordionTitleProps] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[AccordionPanelProps, default, Unit, AccordionPanelProps] = {
    val __obj = js.Dynamic.literal()
  
      key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (index != null) __obj.updateDynamic("index")(index.asInstanceOf[js.Any])
    onTitleClick.foreach(p => __obj.updateDynamic("onTitleClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLDivElement], t1: /* data */ typings.semanticUiReact.modulesAccordionAccordionTitleMod.AccordionTitleProps) => p(t0, t1).runNow()))))
    if (title != null) __obj.updateDynamic("title")(title.asInstanceOf[js.Any])
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typings.semanticUiReact.modulesAccordionAccordionPanelMod.AccordionPanelProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typings.semanticUiReact.modulesAccordionAccordionPanelMod.default](js.constructorOf[typings.semanticUiReact.modulesAccordionAccordionPanelMod.default])
    f(__obj.asInstanceOf[typings.semanticUiReact.modulesAccordionAccordionPanelMod.AccordionPanelProps])(children: _*)
  }
}

