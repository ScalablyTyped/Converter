package typings.semanticDashUiDashReact.srcModulesAccordionAccordionPanelMod

import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import slinky.web.SyntheticMouseEvent
import typings.semanticDashUiDashReact.srcGenericMod.SemanticShorthandItem
import typings.semanticDashUiDashReact.srcModulesAccordionAccordionContentMod.AccordionContentProps
import typings.semanticDashUiDashReact.srcModulesAccordionAccordionTitleMod.AccordionTitleProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait AccordionPanelProps
  extends StrictAccordionPanelProps
     with /* key */ StringDictionary[js.Any]

object AccordionPanelProps {
  @scala.inline
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    active: js.UndefOr[Boolean] = js.undefined,
    content: SemanticShorthandItem[AccordionContentProps] = null,
    index: Double | String = null,
    onTitleClick: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit = null,
    title: SemanticShorthandItem[AccordionTitleProps] = null
  ): AccordionPanelProps = {
    val __obj = js.Dynamic.literal()
    if (StringDictionary != null) js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active)
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (index != null) __obj.updateDynamic("index")(index.asInstanceOf[js.Any])
    if (onTitleClick != null) __obj.updateDynamic("onTitleClick")(js.Any.fromFunction2(onTitleClick))
    if (title != null) __obj.updateDynamic("title")(title.asInstanceOf[js.Any])
    __obj.asInstanceOf[AccordionPanelProps]
  }
}

