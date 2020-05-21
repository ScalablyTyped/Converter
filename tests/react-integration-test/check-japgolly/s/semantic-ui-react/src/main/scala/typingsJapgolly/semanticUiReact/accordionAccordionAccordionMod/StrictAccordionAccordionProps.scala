package typingsJapgolly.semanticUiReact.accordionAccordionAccordionMod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.VdomNode
import org.scalajs.dom.raw.HTMLDivElement
import typingsJapgolly.semanticUiReact.accordionPanelMod.AccordionPanelProps
import typingsJapgolly.semanticUiReact.accordionTitleMod.AccordionTitleProps
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandCollection
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StrictAccordionAccordionProps extends js.Object {
  /** Index of the currently active panel. */
  var activeIndex: js.UndefOr[Double | js.Array[Double]] = js.native
  /** An element type to render as (string or function). */
  var as: js.UndefOr[js.Any] = js.native
  /** Primary content. */
  var children: js.UndefOr[Node] = js.native
  /** Additional classes. */
  var className: js.UndefOr[String] = js.native
  /** Initial activeIndex value. */
  var defaultActiveIndex: js.UndefOr[Double | js.Array[Double]] = js.native
  /** Only allow one panel open at a time. */
  var exclusive: js.UndefOr[Boolean] = js.native
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
  /** Shorthand array of props for Accordion. */
  var panels: js.UndefOr[SemanticShorthandCollection[AccordionPanelProps]] = js.native
}

object StrictAccordionAccordionProps {
  @scala.inline
  def apply(): StrictAccordionAccordionProps = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[StrictAccordionAccordionProps]
  }
  @scala.inline
  implicit class StrictAccordionAccordionPropsOps[Self <: StrictAccordionAccordionProps] (val x: Self) extends AnyVal {
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
    def setActiveIndex(value: Double | js.Array[Double]): Self = this.set("activeIndex", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteActiveIndex: Self = this.set("activeIndex", js.undefined)
    @scala.inline
    def setAs(value: js.Any): Self = this.set("as", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteAs: Self = this.set("as", js.undefined)
    @scala.inline
    def setChildrenVdomElement(value: VdomElement): Self = this.set("children", value.rawElement.asInstanceOf[js.Any])
    @scala.inline
    def setChildren(value: VdomNode): Self = this.set("children", value.rawNode.asInstanceOf[js.Any])
    @scala.inline
    def deleteChildren: Self = this.set("children", js.undefined)
    @scala.inline
    def setClassName(value: String): Self = this.set("className", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteClassName: Self = this.set("className", js.undefined)
    @scala.inline
    def setDefaultActiveIndex(value: Double | js.Array[Double]): Self = this.set("defaultActiveIndex", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteDefaultActiveIndex: Self = this.set("defaultActiveIndex", js.undefined)
    @scala.inline
    def setExclusive(value: Boolean): Self = this.set("exclusive", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteExclusive: Self = this.set("exclusive", js.undefined)
    @scala.inline
    def setOnTitleClick(
      value: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback
    ): Self = this.set("onTitleClick", js.Any.fromFunction2((t0: /* event */ ReactMouseEventFrom[HTMLDivElement], t1: /* data */ AccordionTitleProps) => (value(t0, t1)).runNow()))
    @scala.inline
    def deleteOnTitleClick: Self = this.set("onTitleClick", js.undefined)
    @scala.inline
    def setPanels(value: SemanticShorthandCollection[AccordionPanelProps]): Self = this.set("panels", value.asInstanceOf[js.Any])
    @scala.inline
    def deletePanels: Self = this.set("panels", js.undefined)
  }
  
}

