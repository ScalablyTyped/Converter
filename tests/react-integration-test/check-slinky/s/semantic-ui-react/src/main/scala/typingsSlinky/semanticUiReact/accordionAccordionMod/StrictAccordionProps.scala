package typingsSlinky.semanticUiReact.accordionAccordionMod

import typingsSlinky.semanticUiReact.accordionAccordionAccordionMod.StrictAccordionAccordionProps
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
  def apply(): StrictAccordionProps = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[StrictAccordionProps]
  }
  @scala.inline
  implicit class StrictAccordionPropsOps[Self <: StrictAccordionProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withFluid(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("fluid")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutFluid: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("fluid")(js.undefined)
        ret
    }
    @scala.inline
    def withInverted(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("inverted")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutInverted: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("inverted")(js.undefined)
        ret
    }
    @scala.inline
    def withStyled(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("styled")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutStyled: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("styled")(js.undefined)
        ret
    }
  }
  
}

