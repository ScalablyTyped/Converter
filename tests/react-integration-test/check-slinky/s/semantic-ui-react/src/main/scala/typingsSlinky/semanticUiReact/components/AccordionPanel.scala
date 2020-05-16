package typingsSlinky.semanticUiReact.components

import org.scalajs.dom.raw.HTMLDivElement
import slinky.core.ReactComponentClass
import slinky.core.TagMod
import slinky.core.facade.ReactElement
import slinky.web.SyntheticMouseEvent
import slinky.web.html.div.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.react.mod.ReactNodeArray
import typingsSlinky.semanticUiReact.accordionContentMod.AccordionContentProps
import typingsSlinky.semanticUiReact.accordionPanelMod.AccordionPanelProps
import typingsSlinky.semanticUiReact.accordionPanelMod.default
import typingsSlinky.semanticUiReact.accordionTitleMod.AccordionTitleProps
import typingsSlinky.semanticUiReact.genericMod.SemanticShorthandItem
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object AccordionPanel {
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/AccordionPanel", JSImport.Default)
  @js.native
  object component extends js.Object
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[tag.type, default] {
    @scala.inline
    def active(value: Boolean): this.type = set("active", value.asInstanceOf[js.Any])
    @scala.inline
    def contentReactElement(value: ReactElement): this.type = set("content", value.asInstanceOf[js.Any])
    @scala.inline
    def contentFunction3(
      value: (/* component */ ReactComponentClass[AccordionContentProps], AccordionContentProps, /* children */ js.UndefOr[TagMod[Any] | ReactNodeArray]) => ReactElement | Null
    ): this.type = set("content", js.Any.fromFunction3(value))
    @scala.inline
    def content(value: SemanticShorthandItem[AccordionContentProps]): this.type = set("content", value.asInstanceOf[js.Any])
    @scala.inline
    def index(value: Double | String): this.type = set("index", value.asInstanceOf[js.Any])
    @scala.inline
    def onTitleClick(value: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit): this.type = set("onTitleClick", js.Any.fromFunction2(value))
    @scala.inline
    def titleReactElement(value: ReactElement): this.type = set("title", value.asInstanceOf[js.Any])
    @scala.inline
    def titleFunction3(
      value: (/* component */ ReactComponentClass[AccordionTitleProps], AccordionTitleProps, /* children */ js.UndefOr[TagMod[Any] | ReactNodeArray]) => ReactElement | Null
    ): this.type = set("title", js.Any.fromFunction3(value))
    @scala.inline
    def title(value: SemanticShorthandItem[AccordionTitleProps]): this.type = set("title", value.asInstanceOf[js.Any])
  }
  
  def withProps(p: AccordionPanelProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
  implicit def make(companion: AccordionPanel.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
}

