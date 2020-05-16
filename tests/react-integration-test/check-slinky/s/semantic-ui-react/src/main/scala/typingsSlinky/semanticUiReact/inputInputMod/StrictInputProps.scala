package typingsSlinky.semanticUiReact.inputInputMod

import org.scalajs.dom.raw.HTMLInputElement
import slinky.core.ReactComponentClass
import slinky.core.TagMod
import slinky.core.facade.ReactElement
import typingsSlinky.react.mod.ChangeEvent
import typingsSlinky.react.mod.InputHTMLAttributes
import typingsSlinky.react.mod.ReactNodeArray
import typingsSlinky.semanticUiReact.genericMod.HtmlInputrops
import typingsSlinky.semanticUiReact.genericMod.SemanticShorthandItem
import typingsSlinky.semanticUiReact.semanticUiReactStrings.`left corner`
import typingsSlinky.semanticUiReact.semanticUiReactStrings.`right corner`
import typingsSlinky.semanticUiReact.semanticUiReactStrings.big
import typingsSlinky.semanticUiReact.semanticUiReactStrings.huge
import typingsSlinky.semanticUiReact.semanticUiReactStrings.large
import typingsSlinky.semanticUiReact.semanticUiReactStrings.left
import typingsSlinky.semanticUiReact.semanticUiReactStrings.massive
import typingsSlinky.semanticUiReact.semanticUiReactStrings.mini
import typingsSlinky.semanticUiReact.semanticUiReactStrings.right
import typingsSlinky.semanticUiReact.semanticUiReactStrings.small
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StrictInputProps extends InputHTMLAttributes[HTMLInputElement] {
  /** An Input can be formatted to alert the user to an action they may perform. */
  var action: js.UndefOr[js.Any | Boolean] = js.native
  /** An action can appear along side an Input on the left or right. */
  var actionPosition: js.UndefOr[left] = js.native
  /** An element type to render as (string or function). */
  var as: js.UndefOr[js.Any] = js.native
  /** An Input field can show the data contains errors. */
  var error: js.UndefOr[Boolean] = js.native
  /** Take on the size of its container. */
  var fluid: js.UndefOr[Boolean] = js.native
  /** An Input field can show a user is currently interacting with it. */
  var focus: js.UndefOr[Boolean] = js.native
  /** Optional Icon to display inside the Input. */
  var icon: js.UndefOr[js.Any | SemanticShorthandItem[InputProps]] = js.native
  /** An Icon can appear inside an Input on the left. */
  var iconPosition: js.UndefOr[left] = js.native
  /** Shorthand for creating the HTML Input. */
  var input: js.UndefOr[SemanticShorthandItem[HtmlInputrops]] = js.native
  /** Format to appear on dark backgrounds. */
  var inverted: js.UndefOr[Boolean] = js.native
  /** Optional Label to display along side the Input. */
  var label: js.UndefOr[
    SemanticShorthandItem[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ _
    ]
  ] = js.native
  /** A Label can appear outside an Input on the left or right. */
  var labelPosition: js.UndefOr[left | right | (`left corner`) | (`right corner`)] = js.native
  /** An Icon Input field can show that it is currently loading data. */
  var loading: js.UndefOr[Boolean] = js.native
  /**
    * Called on change.
    *
    * @param {ChangeEvent} event - React's original SyntheticEvent.
    * @param {object} data - All props and a proposed value.
    */
  @JSName("onChange")
  var onChange_StrictInputProps: js.UndefOr[
    js.Function2[/* event */ ChangeEvent[HTMLInputElement], /* data */ InputOnChangeData, Unit]
  ] = js.native
  /** An Input can vary in size. */
  @JSName("size")
  var size_StrictInputProps: js.UndefOr[mini | small | large | big | huge | massive] = js.native
  /** An Input can receive focus. */
  @JSName("tabIndex")
  var tabIndex_StrictInputProps: js.UndefOr[Double | String] = js.native
  /** Transparent Input has no background. */
  var transparent: js.UndefOr[Boolean] = js.native
}

object StrictInputProps {
  @scala.inline
  def apply(): StrictInputProps = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[StrictInputProps]
  }
  @scala.inline
  implicit class StrictInputPropsOps[Self <: StrictInputProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withAction(value: js.Any | Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("action")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutAction: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("action")(js.undefined)
        ret
    }
    @scala.inline
    def withActionPosition(value: left): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("actionPosition")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutActionPosition: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("actionPosition")(js.undefined)
        ret
    }
    @scala.inline
    def withAs(value: js.Any): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("as")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutAs: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("as")(js.undefined)
        ret
    }
    @scala.inline
    def withError(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("error")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutError: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("error")(js.undefined)
        ret
    }
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
    def withFocus(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("focus")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutFocus: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("focus")(js.undefined)
        ret
    }
    @scala.inline
    def withIconFunction3(
      value: (/* component */ ReactComponentClass[InputProps], InputProps, /* children */ js.UndefOr[TagMod[Any] | ReactNodeArray]) => ReactElement | Null
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("icon")(js.Any.fromFunction3(value))
        ret
    }
    @scala.inline
    def withIcon(value: js.Any | SemanticShorthandItem[InputProps]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("icon")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutIcon: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("icon")(js.undefined)
        ret
    }
    @scala.inline
    def withIconPosition(value: left): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("iconPosition")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutIconPosition: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("iconPosition")(js.undefined)
        ret
    }
    @scala.inline
    def withInputFunction3(
      value: (/* component */ ReactComponentClass[HtmlInputrops], HtmlInputrops, /* children */ js.UndefOr[TagMod[Any] | ReactNodeArray]) => ReactElement | Null
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("input")(js.Any.fromFunction3(value))
        ret
    }
    @scala.inline
    def withInput(value: SemanticShorthandItem[HtmlInputrops]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("input")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutInput: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("input")(js.undefined)
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
    def withLabelFunction3(
      value: (/* component */ ReactComponentClass[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ _
        ], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ _, /* children */ js.UndefOr[TagMod[Any] | ReactNodeArray]) => ReactElement | Null
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("label")(js.Any.fromFunction3(value))
        ret
    }
    @scala.inline
    def withLabel(
      value: SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ _
        ]
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("label")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutLabel: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("label")(js.undefined)
        ret
    }
    @scala.inline
    def withLabelPosition(value: left | right | (`left corner`) | (`right corner`)): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("labelPosition")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutLabelPosition: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("labelPosition")(js.undefined)
        ret
    }
    @scala.inline
    def withLoading(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("loading")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutLoading: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("loading")(js.undefined)
        ret
    }
    @scala.inline
    def withOnChange(value: (/* event */ ChangeEvent[HTMLInputElement], /* data */ InputOnChangeData) => Unit): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("onChange")(js.Any.fromFunction2(value))
        ret
    }
    @scala.inline
    def withoutOnChange: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("onChange")(js.undefined)
        ret
    }
    @scala.inline
    def withSize(value: mini | small | large | big | huge | massive): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("size")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutSize: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("size")(js.undefined)
        ret
    }
    @scala.inline
    def withTabIndex(value: Double | String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("tabIndex")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutTabIndex: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("tabIndex")(js.undefined)
        ret
    }
    @scala.inline
    def withTransparent(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("transparent")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutTransparent: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("transparent")(js.undefined)
        ret
    }
  }
  
}

