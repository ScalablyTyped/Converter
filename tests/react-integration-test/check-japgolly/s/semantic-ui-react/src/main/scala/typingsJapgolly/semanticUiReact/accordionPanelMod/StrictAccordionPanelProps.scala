package typingsJapgolly.semanticUiReact.accordionPanelMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import org.scalajs.dom.raw.HTMLDivElement
import typingsJapgolly.react.mod.ReactNodeArray
import typingsJapgolly.react.mod.ReactType
import typingsJapgolly.semanticUiReact.accordionContentMod.AccordionContentProps
import typingsJapgolly.semanticUiReact.accordionTitleMod.AccordionTitleProps
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandItem
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait StrictAccordionPanelProps extends js.Object {
  /** Whether or not the title is in the open state. */
  var active: js.UndefOr[Boolean] = js.native
  /** A shorthand for Accordion.Content. */
  var content: js.UndefOr[SemanticShorthandItem[AccordionContentProps]] = js.native
  /** A panel index. */
  var index: js.UndefOr[Double | String] = js.native
  /**
    * Called when a panel title is clicked.
    *
    * @param {SyntheticEvent} event - React's original SyntheticEvent.
    * @param {AccordionTitleProps} data - All item props.
    */
  var onTitleClick: js.UndefOr[
    js.Function2[
      /* event */ ReactMouseEventFrom[HTMLDivElement], 
      /* data */ AccordionTitleProps, 
      Unit
    ]
  ] = js.native
  /** A shorthand for Accordion.Title. */
  var title: js.UndefOr[SemanticShorthandItem[AccordionTitleProps]] = js.native
}

object StrictAccordionPanelProps {
  @scala.inline
  def apply(): StrictAccordionPanelProps = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[StrictAccordionPanelProps]
  }
  @scala.inline
  implicit class StrictAccordionPanelPropsOps[Self <: StrictAccordionPanelProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setActive(value: Boolean): Self = this.set("active", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteActive: Self = this.set("active", js.undefined)
    @scala.inline
    def setContentVdomElement(value: VdomElement): Self = this.set("content", value.rawElement.asInstanceOf[js.Any])
    @scala.inline
    def setContentFunction3(
      value: (/* component */ ReactType[AccordionContentProps], AccordionContentProps, /* children */ js.UndefOr[Node | ReactNodeArray]) => Element | Null
    ): Self = this.set("content", js.Any.fromFunction3(value))
    @scala.inline
    def setContent(value: SemanticShorthandItem[AccordionContentProps]): Self = this.set("content", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteContent: Self = this.set("content", js.undefined)
    @scala.inline
    def setIndex(value: Double | String): Self = this.set("index", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteIndex: Self = this.set("index", js.undefined)
    @scala.inline
    def setOnTitleClick(
      value: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback
    ): Self = this.set("onTitleClick", js.Any.fromFunction2((t0: /* event */ ReactMouseEventFrom[HTMLDivElement], t1: /* data */ AccordionTitleProps) => (value(t0, t1)).runNow()))
    @scala.inline
    def deleteOnTitleClick: Self = this.set("onTitleClick", js.undefined)
    @scala.inline
    def setTitleVdomElement(value: VdomElement): Self = this.set("title", value.rawElement.asInstanceOf[js.Any])
    @scala.inline
    def setTitleFunction3(
      value: (/* component */ ReactType[AccordionTitleProps], AccordionTitleProps, /* children */ js.UndefOr[Node | ReactNodeArray]) => Element | Null
    ): Self = this.set("title", js.Any.fromFunction3(value))
    @scala.inline
    def setTitle(value: SemanticShorthandItem[AccordionTitleProps]): Self = this.set("title", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteTitle: Self = this.set("title", js.undefined)
  }
  
}

