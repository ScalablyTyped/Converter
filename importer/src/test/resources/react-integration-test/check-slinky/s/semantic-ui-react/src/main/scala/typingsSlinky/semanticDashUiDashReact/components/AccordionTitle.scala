package typingsSlinky.semanticDashUiDashReact.components

import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.SyntheticMouseEvent
import slinky.web.html.`*`.tag
import typingsSlinky.semanticDashUiDashReact.srcGenericMod.SemanticShorthandContent
import typingsSlinky.semanticDashUiDashReact.srcGenericMod.SemanticShorthandItem
import typingsSlinky.semanticDashUiDashReact.srcModulesAccordionAccordionTitleMod.AccordionTitleProps
import typingsSlinky.semanticDashUiDashReact.srcModulesAccordionAccordionTitleMod.default
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object AccordionTitle
  extends ExternalComponentWithAttributesWithRefType[tag.type, default] {
  override val component: String | js.Object = js.constructorOf[typingsSlinky.semanticDashUiDashReact.srcModulesAccordionAccordionTitleMod.default].asInstanceOf[String | js.Object]
  /* The following DOM/SVG props were specified: className */
  def apply(
    active: js.UndefOr[Boolean] = js.undefined,
    as: js.Any = null,
    content: SemanticShorthandContent = null,
    icon: SemanticShorthandItem[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify IconProps */ _
    ] = null,
    index: Double | String = null,
    onClick: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit = null,
    overrides: StringDictionary[js.Any] = null
  ): BuildingComponent[tag.type, default] = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as.asInstanceOf[js.Any])
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (icon != null) __obj.updateDynamic("icon")(icon.asInstanceOf[js.Any])
    if (index != null) __obj.updateDynamic("index")(index.asInstanceOf[js.Any])
    if (onClick != null) __obj.updateDynamic("onClick")(js.Any.fromFunction2(onClick))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = AccordionTitleProps
}

