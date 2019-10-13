package typings.semanticDashUiDashReact.ScalaJsReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandItem
import typings.semanticDashUiDashReact.srcModulesAccordionAccordionContentMod.AccordionContentProps
import typings.semanticDashUiDashReact.srcModulesAccordionAccordionPanelMod.AccordionPanelProps
import typings.semanticDashUiDashReact.srcModulesAccordionAccordionPanelMod.default
import typings.semanticDashUiDashReact.srcModulesAccordionAccordionTitleMod.AccordionTitleProps
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
    title: SemanticShorthandItem[AccordionTitleProps] = null
  )(
    
  ): UnmountedWithRoot[AccordionPanelProps, default, Unit, AccordionPanelProps] = {
    import japgolly.scalajs.react.Children
    import japgolly.scalajs.react.JsForwardRefComponent
  
    val __obj = js.Dynamic.literal()
  
    type AccordionPanelType = typings.semanticDashUiDashReact.srcModulesAccordionAccordionPanelMod.default
  
      js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (index != null) __obj.updateDynamic("index")(index.asInstanceOf[js.Any])
        if (onTitleClick != null) __obj.updateDynamic("onTitleClick")(js.Any.fromFunction2(((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLDivElement], t1: /* data */ typings.semanticDashUiDashReact.srcModulesAccordionAccordionTitleMod.AccordionTitleProps) => onTitleClick(t0, t1).runNow())))
    if (title != null) __obj.updateDynamic("title")(title.asInstanceOf[js.Any])
  
    val props = __obj.asInstanceOf[Props]
    val f = JsForwardRefComponent.force[Props, Children.None, AccordionPanelType](js.constructorOf[AccordionPanelType])
  
    f(props)
  }
  type Props = AccordionPanelProps
}

