package typings.semanticUiReact.modulesAccordionAccordionMod

import org.scalablytyped.runtime.StringDictionary
import typings.react.NativeMouseEvent
import typings.react.reactMod.MouseEvent
import typings.react.reactMod.ReactNode
import typings.semanticUiReact.genericMod.SemanticShorthandCollection
import typings.semanticUiReact.modulesAccordionAccordionPanelMod.AccordionPanelProps
import typings.semanticUiReact.modulesAccordionAccordionTitleMod.AccordionTitleProps
import typings.std.HTMLDivElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait AccordionProps
  extends StrictAccordionProps
     with /* key */ StringDictionary[js.Any]

object AccordionProps {
  @scala.inline
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    activeIndex: Double | js.Array[Double] = null,
    as: js.Any = null,
    children: ReactNode = null,
    className: String = null,
    defaultActiveIndex: Double | js.Array[Double] = null,
    exclusive: js.UndefOr[Boolean] = js.undefined,
    fluid: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    onTitleClick: (/* event */ MouseEvent[HTMLDivElement, NativeMouseEvent], /* data */ AccordionTitleProps) => Unit = null,
    panels: SemanticShorthandCollection[AccordionPanelProps] = null,
    styled: js.UndefOr[Boolean] = js.undefined
  ): AccordionProps = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (activeIndex != null) __obj.updateDynamic("activeIndex")(activeIndex.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as)
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className)
    if (defaultActiveIndex != null) __obj.updateDynamic("defaultActiveIndex")(defaultActiveIndex.asInstanceOf[js.Any])
    if (!js.isUndefined(exclusive)) __obj.updateDynamic("exclusive")(exclusive)
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid)
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted)
    if (onTitleClick != null) __obj.updateDynamic("onTitleClick")(js.Any.fromFunction2(onTitleClick))
    if (panels != null) __obj.updateDynamic("panels")(panels)
    if (!js.isUndefined(styled)) __obj.updateDynamic("styled")(styled)
    __obj.asInstanceOf[AccordionProps]
  }
}
