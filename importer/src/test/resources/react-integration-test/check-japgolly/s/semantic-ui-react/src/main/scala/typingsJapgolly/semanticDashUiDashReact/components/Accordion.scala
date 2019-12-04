package typingsJapgolly.semanticDashUiDashReact.components

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import typingsJapgolly.semanticDashUiDashReact.distCommonjsGenericMod.SemanticShorthandCollection
import typingsJapgolly.semanticDashUiDashReact.distCommonjsModulesAccordionAccordionMod.AccordionProps
import typingsJapgolly.semanticDashUiDashReact.distCommonjsModulesAccordionAccordionPanelMod.AccordionPanelProps
import typingsJapgolly.semanticDashUiDashReact.distCommonjsModulesAccordionAccordionTitleMod.AccordionTitleProps
import typingsJapgolly.semanticDashUiDashReact.distCommonjsModulesAccordionMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Accordion {
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    activeIndex: Double | js.Array[Double] = null,
    as: js.Any = null,
    className: String = null,
    defaultActiveIndex: Double | js.Array[Double] = null,
    exclusive: js.UndefOr[Boolean] = js.undefined,
    fluid: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    onTitleClick: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback = null,
    panels: SemanticShorthandCollection[AccordionPanelProps] = null,
    styled: js.UndefOr[Boolean] = js.undefined,
    key: js.UndefOr[Key] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[AccordionProps, default, Unit, AccordionProps] = {
    val __obj = js.Dynamic.literal()
  
      if (StringDictionary != null) js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (activeIndex != null) __obj.updateDynamic("activeIndex")(activeIndex.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (defaultActiveIndex != null) __obj.updateDynamic("defaultActiveIndex")(defaultActiveIndex.asInstanceOf[js.Any])
    if (!js.isUndefined(exclusive)) __obj.updateDynamic("exclusive")(exclusive.asInstanceOf[js.Any])
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid.asInstanceOf[js.Any])
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted.asInstanceOf[js.Any])
    if (onTitleClick != null) __obj.updateDynamic("onTitleClick")(js.Any.fromFunction2((t0: /* event */ japgolly.scalajs.react.ReactMouseEventFrom[org.scalajs.dom.raw.HTMLDivElement], t1: /* data */ typingsJapgolly.semanticDashUiDashReact.distCommonjsModulesAccordionAccordionTitleMod.AccordionTitleProps) => onTitleClick(t0, t1).runNow()))
    if (panels != null) __obj.updateDynamic("panels")(panels.asInstanceOf[js.Any])
    if (!js.isUndefined(styled)) __obj.updateDynamic("styled")(styled.asInstanceOf[js.Any])
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  typingsJapgolly.semanticDashUiDashReact.distCommonjsModulesAccordionAccordionMod.AccordionProps, 
  japgolly.scalajs.react.Children.Varargs, 
  typingsJapgolly.semanticDashUiDashReact.distCommonjsModulesAccordionMod.default](this.componentImport)
    f(__obj.asInstanceOf[typingsJapgolly.semanticDashUiDashReact.distCommonjsModulesAccordionAccordionMod.AccordionProps])(children: _*)
  }
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion", JSImport.Default)
  @js.native
  object componentImport extends js.Object
  
}

