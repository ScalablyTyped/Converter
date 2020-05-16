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
  def apply(
    activeIndex: Double | js.Array[Double] = null,
    as: js.Any = null,
    children: VdomNode = null,
    className: String = null,
    defaultActiveIndex: Double | js.Array[Double] = null,
    exclusive: js.UndefOr[Boolean] = js.undefined,
    onTitleClick: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback = null,
    panels: SemanticShorthandCollection[AccordionPanelProps] = null
  ): StrictAccordionAccordionProps = {
    val __obj = js.Dynamic.literal()
    if (activeIndex != null) __obj.updateDynamic("activeIndex")(activeIndex.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (defaultActiveIndex != null) __obj.updateDynamic("defaultActiveIndex")(defaultActiveIndex.asInstanceOf[js.Any])
    if (!js.isUndefined(exclusive)) __obj.updateDynamic("exclusive")(exclusive.asInstanceOf[js.Any])
    if (onTitleClick != null) __obj.updateDynamic("onTitleClick")(js.Any.fromFunction2((t0: /* event */ ReactMouseEventFrom[HTMLDivElement], t1: /* data */ AccordionTitleProps) => onTitleClick(t0, t1).runNow()))
    if (panels != null) __obj.updateDynamic("panels")(panels.asInstanceOf[js.Any])
    __obj.asInstanceOf[StrictAccordionAccordionProps]
  }
  @scala.inline
  implicit class StrictAccordionAccordionPropsOps[Self <: StrictAccordionAccordionProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withActiveIndex(activeIndex: Double | js.Array[Double]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (activeIndex != null) ret.updateDynamic("activeIndex")(activeIndex.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutActiveIndex: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "activeIndex")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withAs(as: js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (as != null) ret.updateDynamic("as")(as.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutAs: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "as")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withChildrenVdomElement(children: VdomElement): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (children != null) ret.updateDynamic("children")(children.rawElement.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withChildren(children: VdomNode): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (children != null) ret.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutChildren: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "children")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withClassName(className: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (className != null) ret.updateDynamic("className")(className.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutClassName: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "className")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withDefaultActiveIndex(defaultActiveIndex: Double | js.Array[Double]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (defaultActiveIndex != null) ret.updateDynamic("defaultActiveIndex")(defaultActiveIndex.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutDefaultActiveIndex: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "defaultActiveIndex")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withExclusive(exclusive: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(exclusive)) ret.updateDynamic("exclusive")(exclusive.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutExclusive: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "exclusive")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnTitleClick(
      onTitleClick: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onTitleClick != null) ret.updateDynamic("onTitleClick")(js.Any.fromFunction2((t0: /* event */ ReactMouseEventFrom[HTMLDivElement], t1: /* data */ AccordionTitleProps) => onTitleClick(t0, t1).runNow()))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOnTitleClick: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "onTitleClick")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withPanels(panels: SemanticShorthandCollection[AccordionPanelProps]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (panels != null) ret.updateDynamic("panels")(panels.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutPanels: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "panels")
        ret.asInstanceOf[Self]
    }
  }
  
}

