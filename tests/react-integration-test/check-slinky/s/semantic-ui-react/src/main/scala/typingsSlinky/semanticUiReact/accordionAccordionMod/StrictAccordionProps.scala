package typingsSlinky.semanticUiReact.accordionAccordionMod

import org.scalajs.dom.raw.HTMLDivElement
import slinky.core.TagMod
import slinky.web.SyntheticMouseEvent
import typingsSlinky.semanticUiReact.accordionAccordionAccordionMod.StrictAccordionAccordionProps
import typingsSlinky.semanticUiReact.accordionPanelMod.AccordionPanelProps
import typingsSlinky.semanticUiReact.accordionTitleMod.AccordionTitleProps
import typingsSlinky.semanticUiReact.genericMod.SemanticShorthandCollection
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StrictAccordionProps extends StrictAccordionAccordionProps {
  /** Format to take up the width of its container. */
  var fluid: js.UndefOr[Boolean] = js.native
  /** Format for dark backgrounds. */
  var inverted: js.UndefOr[Boolean] = js.native
  /** Adds some basic styling to accordion panels. */
  var styled: js.UndefOr[Boolean] = js.native
}

object StrictAccordionProps {
  @scala.inline
  def apply(
    activeIndex: Double | js.Array[Double] = null,
    as: js.Any = null,
    children: TagMod[Any] = null,
    className: String = null,
    defaultActiveIndex: Double | js.Array[Double] = null,
    exclusive: js.UndefOr[Boolean] = js.undefined,
    fluid: js.UndefOr[Boolean] = js.undefined,
    inverted: js.UndefOr[Boolean] = js.undefined,
    onTitleClick: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit = null,
    panels: SemanticShorthandCollection[AccordionPanelProps] = null,
    styled: js.UndefOr[Boolean] = js.undefined
  ): StrictAccordionProps = {
    val __obj = js.Dynamic.literal()
    if (activeIndex != null) __obj.updateDynamic("activeIndex")(activeIndex.asInstanceOf[js.Any])
    if (as != null) __obj.updateDynamic("as")(as.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (className != null) __obj.updateDynamic("className")(className.asInstanceOf[js.Any])
    if (defaultActiveIndex != null) __obj.updateDynamic("defaultActiveIndex")(defaultActiveIndex.asInstanceOf[js.Any])
    if (!js.isUndefined(exclusive)) __obj.updateDynamic("exclusive")(exclusive.asInstanceOf[js.Any])
    if (!js.isUndefined(fluid)) __obj.updateDynamic("fluid")(fluid.asInstanceOf[js.Any])
    if (!js.isUndefined(inverted)) __obj.updateDynamic("inverted")(inverted.asInstanceOf[js.Any])
    if (onTitleClick != null) __obj.updateDynamic("onTitleClick")(js.Any.fromFunction2(onTitleClick))
    if (panels != null) __obj.updateDynamic("panels")(panels.asInstanceOf[js.Any])
    if (!js.isUndefined(styled)) __obj.updateDynamic("styled")(styled.asInstanceOf[js.Any])
    __obj.asInstanceOf[StrictAccordionProps]
  }
  @scala.inline
  implicit class StrictAccordionPropsOps[Self <: StrictAccordionProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withFluid(fluid: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(fluid)) ret.updateDynamic("fluid")(fluid.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutFluid: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "fluid")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withInverted(inverted: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(inverted)) ret.updateDynamic("inverted")(inverted.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutInverted: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "inverted")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withStyled(styled: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(styled)) ret.updateDynamic("styled")(styled.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutStyled: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "styled")
        ret.asInstanceOf[Self]
    }
  }
  
}

