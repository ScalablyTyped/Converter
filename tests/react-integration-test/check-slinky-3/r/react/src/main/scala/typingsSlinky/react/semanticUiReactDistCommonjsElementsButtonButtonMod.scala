package typingsSlinky.react

import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.HTMLButtonElement
import slinky.core.ReactComponentClass
import slinky.core.facade.ReactElement
import slinky.web.SyntheticMouseEvent
import typingsSlinky.react.mod.Component
import typingsSlinky.react.reactStrings.`google plus`
import typingsSlinky.react.reactStrings.bottom
import typingsSlinky.react.reactStrings.facebook
import typingsSlinky.react.reactStrings.fade
import typingsSlinky.react.reactStrings.instagram
import typingsSlinky.react.reactStrings.left
import typingsSlinky.react.reactStrings.linkedin
import typingsSlinky.react.reactStrings.right
import typingsSlinky.react.reactStrings.top
import typingsSlinky.react.reactStrings.twitter
import typingsSlinky.react.reactStrings.vertical
import typingsSlinky.react.reactStrings.vk
import typingsSlinky.react.reactStrings.youtube
import typingsSlinky.react.semanticUiReactDistCommonjsElementsButtonButtonContentMod.ButtonContentProps
import typingsSlinky.react.semanticUiReactDistCommonjsElementsButtonButtonGroupMod.ButtonGroupProps
import typingsSlinky.react.semanticUiReactDistCommonjsElementsButtonButtonOrMod.ButtonOrProps
import typingsSlinky.react.semanticUiReactDistCommonjsGenericMod.SemanticCOLORS
import typingsSlinky.react.semanticUiReactDistCommonjsGenericMod.SemanticFLOATS
import typingsSlinky.react.semanticUiReactDistCommonjsGenericMod.SemanticSIZES
import typingsSlinky.react.semanticUiReactDistCommonjsGenericMod.SemanticShorthandContent
import typingsSlinky.react.semanticUiReactDistCommonjsGenericMod.SemanticShorthandItem
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object semanticUiReactDistCommonjsElementsButtonButtonMod {
  
  @JSImport("react/semantic-ui-react/dist/commonjs/elements/Button/Button", JSImport.Default)
  @js.native
  open class default () extends Button
  object default {
    
    /* was `typeof ButtonContent` */
    @JSImport("react/semantic-ui-react/dist/commonjs/elements/Button/Button", "default.Content")
    @js.native
    val Content: ReactComponentClass[ButtonContentProps] = js.native
    
    /* was `typeof ButtonGroup` */
    @JSImport("react/semantic-ui-react/dist/commonjs/elements/Button/Button", "default.Group")
    @js.native
    val Group: ReactComponentClass[ButtonGroupProps] = js.native
    
    /* was `typeof ButtonOr` */
    @JSImport("react/semantic-ui-react/dist/commonjs/elements/Button/Button", "default.Or")
    @js.native
    val Or: ReactComponentClass[ButtonOrProps] = js.native
  }
  
  @js.native
  trait Button
    extends Component[ButtonProps, js.Object, Any] {
    
    def focus(): Unit = js.native
  }
  
  trait ButtonProps
    extends StObject
       with StrictButtonProps
       with /* key */ StringDictionary[Any]
  object ButtonProps {
    
    inline def apply(): ButtonProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ButtonProps]
    }
  }
  
  trait StrictButtonProps extends StObject {
    
    /** A button can show it is currently the active user selection. */
    var active: js.UndefOr[Boolean] = js.undefined
    
    /** A button can animate to show hidden content. */
    var animated: js.UndefOr[Boolean | fade | vertical] = js.undefined
    
    /** An element type to render as (string or function). */
    var as: js.UndefOr[Any] = js.undefined
    
    /** A button can be attached to other content. */
    var attached: js.UndefOr[Boolean | left | right | top | bottom] = js.undefined
    
    /** A basic button is less pronounced. */
    var basic: js.UndefOr[Boolean] = js.undefined
    
    /** Primary content. */
    var children: js.UndefOr[ReactElement] = js.undefined
    
    /** A button can be circular. */
    var circular: js.UndefOr[Boolean] = js.undefined
    
    /** Additional classes. */
    var className: js.UndefOr[String] = js.undefined
    
    /** A button can have different colors. */
    var color: js.UndefOr[
        SemanticCOLORS | facebook | (`google plus`) | vk | twitter | linkedin | instagram | youtube
      ] = js.undefined
    
    /** A button can reduce its padding to fit into tighter spaces. */
    var compact: js.UndefOr[Boolean] = js.undefined
    
    /** Shorthand for primary content. */
    var content: js.UndefOr[SemanticShorthandContent] = js.undefined
    
    /** A button can show it is currently unable to be interacted with. */
    var disabled: js.UndefOr[Boolean] = js.undefined
    
    /** A button can be aligned to the left or right of its container. */
    var floated: js.UndefOr[SemanticFLOATS] = js.undefined
    
    /** A button can take the width of its container. */
    var fluid: js.UndefOr[Boolean] = js.undefined
    
    /** Add an Icon by name, props object, or pass an <Icon />. */
    var icon: js.UndefOr[
        Boolean | (SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ Any
        ])
      ] = js.undefined
    
    /** A button can be formatted to appear on dark backgrounds. */
    var inverted: js.UndefOr[Boolean] = js.undefined
    
    /** Add a Label by text, props object, or pass a <Label />. */
    var label: js.UndefOr[
        SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ Any
        ]
      ] = js.undefined
    
    /** A labeled button can format a Label or Icon to appear on the left or right. */
    var labelPosition: js.UndefOr[right | left] = js.undefined
    
    /** A button can show a loading indicator. */
    var loading: js.UndefOr[Boolean] = js.undefined
    
    /** A button can hint towards a negative consequence. */
    var negative: js.UndefOr[Boolean] = js.undefined
    
    /**
      * Called after user's click.
      * @param {SyntheticEvent} event - React's original SyntheticEvent.
      * @param {object} data - All props.
      */
    var onClick: js.UndefOr[
        js.Function2[/* event */ SyntheticMouseEvent[HTMLButtonElement], /* data */ ButtonProps, Unit]
      ] = js.undefined
    
    /** A button can hint towards a positive consequence. */
    var positive: js.UndefOr[Boolean] = js.undefined
    
    /** A button can be formatted to show different levels of emphasis. */
    var primary: js.UndefOr[Boolean] = js.undefined
    
    /** The role of the HTML element. */
    var role: js.UndefOr[String] = js.undefined
    
    /** A button can be formatted to show different levels of emphasis. */
    var secondary: js.UndefOr[Boolean] = js.undefined
    
    /** A button can have different sizes. */
    var size: js.UndefOr[SemanticSIZES] = js.undefined
    
    /** A button can receive focus. */
    var tabIndex: js.UndefOr[Double | String] = js.undefined
    
    /** A button can be formatted to toggle on and off. */
    var toggle: js.UndefOr[Boolean] = js.undefined
  }
  object StrictButtonProps {
    
    inline def apply(): StrictButtonProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[StrictButtonProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: StrictButtonProps] (val x: Self) extends AnyVal {
      
      inline def setActive(value: Boolean): Self = StObject.set(x, "active", value.asInstanceOf[js.Any])
      
      inline def setActiveUndefined: Self = StObject.set(x, "active", js.undefined)
      
      inline def setAnimated(value: Boolean | fade | vertical): Self = StObject.set(x, "animated", value.asInstanceOf[js.Any])
      
      inline def setAnimatedUndefined: Self = StObject.set(x, "animated", js.undefined)
      
      inline def setAs(value: Any): Self = StObject.set(x, "as", value.asInstanceOf[js.Any])
      
      inline def setAsUndefined: Self = StObject.set(x, "as", js.undefined)
      
      inline def setAttached(value: Boolean | left | right | top | bottom): Self = StObject.set(x, "attached", value.asInstanceOf[js.Any])
      
      inline def setAttachedUndefined: Self = StObject.set(x, "attached", js.undefined)
      
      inline def setBasic(value: Boolean): Self = StObject.set(x, "basic", value.asInstanceOf[js.Any])
      
      inline def setBasicUndefined: Self = StObject.set(x, "basic", js.undefined)
      
      inline def setChildren(value: ReactElement): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
      
      inline def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
      
      inline def setCircular(value: Boolean): Self = StObject.set(x, "circular", value.asInstanceOf[js.Any])
      
      inline def setCircularUndefined: Self = StObject.set(x, "circular", js.undefined)
      
      inline def setClassName(value: String): Self = StObject.set(x, "className", value.asInstanceOf[js.Any])
      
      inline def setClassNameUndefined: Self = StObject.set(x, "className", js.undefined)
      
      inline def setColor(value: SemanticCOLORS | facebook | (`google plus`) | vk | twitter | linkedin | instagram | youtube): Self = StObject.set(x, "color", value.asInstanceOf[js.Any])
      
      inline def setColorUndefined: Self = StObject.set(x, "color", js.undefined)
      
      inline def setCompact(value: Boolean): Self = StObject.set(x, "compact", value.asInstanceOf[js.Any])
      
      inline def setCompactUndefined: Self = StObject.set(x, "compact", js.undefined)
      
      inline def setContent(value: SemanticShorthandContent): Self = StObject.set(x, "content", value.asInstanceOf[js.Any])
      
      inline def setContentUndefined: Self = StObject.set(x, "content", js.undefined)
      
      inline def setDisabled(value: Boolean): Self = StObject.set(x, "disabled", value.asInstanceOf[js.Any])
      
      inline def setDisabledUndefined: Self = StObject.set(x, "disabled", js.undefined)
      
      inline def setFloated(value: SemanticFLOATS): Self = StObject.set(x, "floated", value.asInstanceOf[js.Any])
      
      inline def setFloatedUndefined: Self = StObject.set(x, "floated", js.undefined)
      
      inline def setFluid(value: Boolean): Self = StObject.set(x, "fluid", value.asInstanceOf[js.Any])
      
      inline def setFluidUndefined: Self = StObject.set(x, "fluid", js.undefined)
      
      inline def setIcon(
        value: Boolean | (SemanticShorthandItem[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ Any
            ])
      ): Self = StObject.set(x, "icon", value.asInstanceOf[js.Any])
      
      inline def setIconUndefined: Self = StObject.set(x, "icon", js.undefined)
      
      inline def setInverted(value: Boolean): Self = StObject.set(x, "inverted", value.asInstanceOf[js.Any])
      
      inline def setInvertedUndefined: Self = StObject.set(x, "inverted", js.undefined)
      
      inline def setLabel(
        value: SemanticShorthandItem[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ Any
            ]
      ): Self = StObject.set(x, "label", value.asInstanceOf[js.Any])
      
      inline def setLabelPosition(value: right | left): Self = StObject.set(x, "labelPosition", value.asInstanceOf[js.Any])
      
      inline def setLabelPositionUndefined: Self = StObject.set(x, "labelPosition", js.undefined)
      
      inline def setLabelUndefined: Self = StObject.set(x, "label", js.undefined)
      
      inline def setLoading(value: Boolean): Self = StObject.set(x, "loading", value.asInstanceOf[js.Any])
      
      inline def setLoadingUndefined: Self = StObject.set(x, "loading", js.undefined)
      
      inline def setNegative(value: Boolean): Self = StObject.set(x, "negative", value.asInstanceOf[js.Any])
      
      inline def setNegativeUndefined: Self = StObject.set(x, "negative", js.undefined)
      
      inline def setOnClick(value: (/* event */ SyntheticMouseEvent[HTMLButtonElement], /* data */ ButtonProps) => Unit): Self = StObject.set(x, "onClick", js.Any.fromFunction2(value))
      
      inline def setOnClickUndefined: Self = StObject.set(x, "onClick", js.undefined)
      
      inline def setPositive(value: Boolean): Self = StObject.set(x, "positive", value.asInstanceOf[js.Any])
      
      inline def setPositiveUndefined: Self = StObject.set(x, "positive", js.undefined)
      
      inline def setPrimary(value: Boolean): Self = StObject.set(x, "primary", value.asInstanceOf[js.Any])
      
      inline def setPrimaryUndefined: Self = StObject.set(x, "primary", js.undefined)
      
      inline def setRole(value: String): Self = StObject.set(x, "role", value.asInstanceOf[js.Any])
      
      inline def setRoleUndefined: Self = StObject.set(x, "role", js.undefined)
      
      inline def setSecondary(value: Boolean): Self = StObject.set(x, "secondary", value.asInstanceOf[js.Any])
      
      inline def setSecondaryUndefined: Self = StObject.set(x, "secondary", js.undefined)
      
      inline def setSize(value: SemanticSIZES): Self = StObject.set(x, "size", value.asInstanceOf[js.Any])
      
      inline def setSizeUndefined: Self = StObject.set(x, "size", js.undefined)
      
      inline def setTabIndex(value: Double | String): Self = StObject.set(x, "tabIndex", value.asInstanceOf[js.Any])
      
      inline def setTabIndexUndefined: Self = StObject.set(x, "tabIndex", js.undefined)
      
      inline def setToggle(value: Boolean): Self = StObject.set(x, "toggle", value.asInstanceOf[js.Any])
      
      inline def setToggleUndefined: Self = StObject.set(x, "toggle", js.undefined)
    }
  }
}
