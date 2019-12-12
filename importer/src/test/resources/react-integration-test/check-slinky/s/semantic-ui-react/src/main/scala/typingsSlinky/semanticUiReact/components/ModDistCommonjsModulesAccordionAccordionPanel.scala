package typingsSlinky.semanticUiReact.components

import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.SyntheticMouseEvent
import slinky.web.html.`*`.tag
import typingsSlinky.semanticUiReact.mod.dist.commonjs.generic.SemanticShorthandItem
import typingsSlinky.semanticUiReact.mod.dist.commonjs.modules.Accordion.AccordionContent.AccordionContentProps
import typingsSlinky.semanticUiReact.mod.dist.commonjs.modules.Accordion.AccordionPanel.AccordionPanelProps
import typingsSlinky.semanticUiReact.mod.dist.commonjs.modules.Accordion.AccordionPanel.default
import typingsSlinky.semanticUiReact.mod.dist.commonjs.modules.Accordion.AccordionTitle.AccordionTitleProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object ModDistCommonjsModulesAccordionAccordionPanel {
  object raw
    extends ExternalComponentWithAttributesWithRefType[tag.type, default] {
    @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/AccordionPanel", JSImport.Default)
    @js.native
    object componentImport extends js.Object
    
    override val component: String | js.Object = this.componentImport
    type Props = AccordionPanelProps
  }
  
  def apply(
    active: js.UndefOr[Boolean] = js.undefined,
    content: SemanticShorthandItem[AccordionContentProps] = null,
    index: Double | String = null,
    onTitleClick: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit = null,
    title: SemanticShorthandItem[AccordionTitleProps] = null,
    _overrides: StringDictionary[js.Any] = null
  ): BuildingComponent[tag.type, default] = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(active)) __obj.updateDynamic("active")(active.asInstanceOf[js.Any])
    if (content != null) __obj.updateDynamic("content")(content.asInstanceOf[js.Any])
    if (index != null) __obj.updateDynamic("index")(index.asInstanceOf[js.Any])
    if (onTitleClick != null) __obj.updateDynamic("onTitleClick")(js.Any.fromFunction2(onTitleClick))
    if (title != null) __obj.updateDynamic("title")(title.asInstanceOf[js.Any])
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    this.raw.apply(__obj.asInstanceOf[this.raw.Props])
  }
}

