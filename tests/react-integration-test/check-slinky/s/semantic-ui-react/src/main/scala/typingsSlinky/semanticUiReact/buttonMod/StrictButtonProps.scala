package typingsSlinky.semanticUiReact.buttonMod

import org.scalajs.dom.raw.HTMLButtonElement
import slinky.core.ReactComponentClass
import slinky.core.TagMod
import slinky.core.facade.ReactElement
import slinky.web.SyntheticMouseEvent
import typingsSlinky.react.mod.ButtonHTMLAttributes
import typingsSlinky.react.mod.ReactNodeArray
import typingsSlinky.semanticUiReact.genericMod.SemanticCOLORS
import typingsSlinky.semanticUiReact.genericMod.SemanticFLOATS
import typingsSlinky.semanticUiReact.genericMod.SemanticSIZES
import typingsSlinky.semanticUiReact.genericMod.SemanticShorthandContent
import typingsSlinky.semanticUiReact.genericMod.SemanticShorthandItem
import typingsSlinky.semanticUiReact.semanticUiReactStrings.`google plus`
import typingsSlinky.semanticUiReact.semanticUiReactStrings.bottom
import typingsSlinky.semanticUiReact.semanticUiReactStrings.facebook
import typingsSlinky.semanticUiReact.semanticUiReactStrings.fade
import typingsSlinky.semanticUiReact.semanticUiReactStrings.instagram
import typingsSlinky.semanticUiReact.semanticUiReactStrings.left
import typingsSlinky.semanticUiReact.semanticUiReactStrings.linkedin
import typingsSlinky.semanticUiReact.semanticUiReactStrings.right
import typingsSlinky.semanticUiReact.semanticUiReactStrings.top
import typingsSlinky.semanticUiReact.semanticUiReactStrings.twitter
import typingsSlinky.semanticUiReact.semanticUiReactStrings.vertical
import typingsSlinky.semanticUiReact.semanticUiReactStrings.vk
import typingsSlinky.semanticUiReact.semanticUiReactStrings.youtube
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait StrictButtonProps extends ButtonHTMLAttributes[HTMLButtonElement] {
  /** A button can show it is currently the active user selection. */
  var active: js.UndefOr[Boolean] = js.native
  /** A button can animate to show hidden content. */
  var animated: js.UndefOr[Boolean | fade | vertical] = js.native
  /** An element type to render as (string or function). */
  var as: js.UndefOr[js.Any] = js.native
  /** A button can be attached to other content. */
  var attached: js.UndefOr[Boolean | left | right | top | bottom] = js.native
  /** A basic button is less pronounced. */
  var basic: js.UndefOr[Boolean] = js.native
  /** A button can be circular. */
  var circular: js.UndefOr[Boolean] = js.native
  /** A button can have different colors. */
  @JSName("color")
  var color_StrictButtonProps: js.UndefOr[
    SemanticCOLORS | facebook | (`google plus`) | vk | twitter | linkedin | instagram | youtube
  ] = js.native
  /** A button can reduce its padding to fit into tighter spaces. */
  var compact: js.UndefOr[Boolean] = js.native
  /** Shorthand for primary content. */
  var content: js.UndefOr[SemanticShorthandContent] = js.native
  /** A button can be aligned to the left or right of its container. */
  var floated: js.UndefOr[SemanticFLOATS] = js.native
  /** A button can take the width of its container. */
  var fluid: js.UndefOr[Boolean] = js.native
  /** Add an Icon by name, props object, or pass an <Icon />. */
  var icon: js.UndefOr[
    Boolean | (SemanticShorthandItem[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _
    ])
  ] = js.native
  /** A button can be formatted to appear on dark backgrounds. */
  var inverted: js.UndefOr[Boolean] = js.native
  /** Add a Label by text, props object, or pass a <Label />. */
  var label: js.UndefOr[
    SemanticShorthandItem[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ _
    ]
  ] = js.native
  /** A labeled button can format a Label or Icon to appear on the left or right. */
  var labelPosition: js.UndefOr[right | left] = js.native
  /** A button can show a loading indicator. */
  var loading: js.UndefOr[Boolean] = js.native
  /** A button can hint towards a negative consequence. */
  var negative: js.UndefOr[Boolean] = js.native
  /**
    * Called after user's click.
    * @param {SyntheticEvent} event - React's original SyntheticEvent.
    * @param {object} data - All props.
    */
  @JSName("onClick")
  var onClick_StrictButtonProps: js.UndefOr[
    js.Function2[/* event */ SyntheticMouseEvent[HTMLButtonElement], /* data */ ButtonProps, Unit]
  ] = js.native
  /** A button can hint towards a positive consequence. */
  var positive: js.UndefOr[Boolean] = js.native
  /** A button can be formatted to show different levels of emphasis. */
  var primary: js.UndefOr[Boolean] = js.native
  /** A button can be formatted to show different levels of emphasis. */
  var secondary: js.UndefOr[Boolean] = js.native
  /** A button can have different sizes. */
  var size: js.UndefOr[SemanticSIZES] = js.native
  /** A button can receive focus. */
  @JSName("tabIndex")
  var tabIndex_StrictButtonProps: js.UndefOr[Double | String] = js.native
  /** A button can be formatted to toggle on and off. */
  var toggle: js.UndefOr[Boolean] = js.native
}

object StrictButtonProps {
  @scala.inline
  def apply(): StrictButtonProps = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[StrictButtonProps]
  }
  @scala.inline
  implicit class StrictButtonPropsOps[Self <: StrictButtonProps] (val x: Self) extends AnyVal {
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
    def setAnimated(value: Boolean | fade | vertical): Self = this.set("animated", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteAnimated: Self = this.set("animated", js.undefined)
    @scala.inline
    def setAs(value: js.Any): Self = this.set("as", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteAs: Self = this.set("as", js.undefined)
    @scala.inline
    def setAttached(value: Boolean | left | right | top | bottom): Self = this.set("attached", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteAttached: Self = this.set("attached", js.undefined)
    @scala.inline
    def setBasic(value: Boolean): Self = this.set("basic", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteBasic: Self = this.set("basic", js.undefined)
    @scala.inline
    def setCircular(value: Boolean): Self = this.set("circular", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteCircular: Self = this.set("circular", js.undefined)
    @scala.inline
    def setColor(value: SemanticCOLORS | facebook | (`google plus`) | vk | twitter | linkedin | instagram | youtube): Self = this.set("color", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteColor: Self = this.set("color", js.undefined)
    @scala.inline
    def setCompact(value: Boolean): Self = this.set("compact", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteCompact: Self = this.set("compact", js.undefined)
    @scala.inline
    def setContentReactElement(value: ReactElement): Self = this.set("content", value.asInstanceOf[js.Any])
    @scala.inline
    def setContent(value: SemanticShorthandContent): Self = this.set("content", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteContent: Self = this.set("content", js.undefined)
    @scala.inline
    def setFloated(value: SemanticFLOATS): Self = this.set("floated", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteFloated: Self = this.set("floated", js.undefined)
    @scala.inline
    def setFluid(value: Boolean): Self = this.set("fluid", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteFluid: Self = this.set("fluid", js.undefined)
    @scala.inline
    def setIconReactElement(value: ReactElement): Self = this.set("icon", value.asInstanceOf[js.Any])
    @scala.inline
    def setIconFunction3(
      value: (/* component */ ReactComponentClass[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _
        ], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _, /* children */ js.UndefOr[TagMod[Any] | ReactNodeArray]) => ReactElement | Null
    ): Self = this.set("icon", js.Any.fromFunction3(value))
    @scala.inline
    def setIcon(
      value: Boolean | (SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _
        ])
    ): Self = this.set("icon", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteIcon: Self = this.set("icon", js.undefined)
    @scala.inline
    def setInverted(value: Boolean): Self = this.set("inverted", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteInverted: Self = this.set("inverted", js.undefined)
    @scala.inline
    def setLabelReactElement(value: ReactElement): Self = this.set("label", value.asInstanceOf[js.Any])
    @scala.inline
    def setLabelFunction3(
      value: (/* component */ ReactComponentClass[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ _
        ], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ _, /* children */ js.UndefOr[TagMod[Any] | ReactNodeArray]) => ReactElement | Null
    ): Self = this.set("label", js.Any.fromFunction3(value))
    @scala.inline
    def setLabel(
      value: SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ _
        ]
    ): Self = this.set("label", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteLabel: Self = this.set("label", js.undefined)
    @scala.inline
    def setLabelPosition(value: right | left): Self = this.set("labelPosition", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteLabelPosition: Self = this.set("labelPosition", js.undefined)
    @scala.inline
    def setLoading(value: Boolean): Self = this.set("loading", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteLoading: Self = this.set("loading", js.undefined)
    @scala.inline
    def setNegative(value: Boolean): Self = this.set("negative", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteNegative: Self = this.set("negative", js.undefined)
    @scala.inline
    def setOnClick(value: (/* event */ SyntheticMouseEvent[HTMLButtonElement], /* data */ ButtonProps) => Unit): Self = this.set("onClick", js.Any.fromFunction2(value))
    @scala.inline
    def deleteOnClick: Self = this.set("onClick", js.undefined)
    @scala.inline
    def setPositive(value: Boolean): Self = this.set("positive", value.asInstanceOf[js.Any])
    @scala.inline
    def deletePositive: Self = this.set("positive", js.undefined)
    @scala.inline
    def setPrimary(value: Boolean): Self = this.set("primary", value.asInstanceOf[js.Any])
    @scala.inline
    def deletePrimary: Self = this.set("primary", js.undefined)
    @scala.inline
    def setSecondary(value: Boolean): Self = this.set("secondary", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteSecondary: Self = this.set("secondary", js.undefined)
    @scala.inline
    def setSize(value: SemanticSIZES): Self = this.set("size", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteSize: Self = this.set("size", js.undefined)
    @scala.inline
    def setTabIndex(value: Double | String): Self = this.set("tabIndex", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteTabIndex: Self = this.set("tabIndex", js.undefined)
    @scala.inline
    def setToggle(value: Boolean): Self = this.set("toggle", value.asInstanceOf[js.Any])
    @scala.inline
    def deleteToggle: Self = this.set("toggle", js.undefined)
  }
  
}

