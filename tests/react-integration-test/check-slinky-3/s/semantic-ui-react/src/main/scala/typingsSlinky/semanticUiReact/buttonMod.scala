package typingsSlinky.semanticUiReact

import org.scalajs.dom.HTMLButtonElement
import slinky.core.ReactComponentClass
import slinky.core.facade.ReactElement
import slinky.web.SyntheticMouseEvent
import typingsSlinky.react.mod.ButtonHTMLAttributes
import typingsSlinky.react.mod.Component
import typingsSlinky.react.mod.ReactNodeArray
import typingsSlinky.react.mod.ReactType
import typingsSlinky.semanticUiReact.buttonContentMod.ButtonContentProps
import typingsSlinky.semanticUiReact.buttonGroupMod.ButtonGroupProps
import typingsSlinky.semanticUiReact.buttonOrMod.ButtonOrProps
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
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object buttonMod {
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/Button/Button", JSImport.Default)
  @js.native
  open class default () extends Button
  object default {
    
    /* was `typeof ButtonContent` */
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button/Button", "default.Content")
    @js.native
    val Content: ReactComponentClass[ButtonContentProps] = js.native
    
    /* was `typeof ButtonGroup` */
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button/Button", "default.Group")
    @js.native
    val Group: ReactComponentClass[ButtonGroupProps] = js.native
    
    /* was `typeof ButtonOr` */
    @JSImport("semantic-ui-react/dist/commonjs/elements/Button/Button", "default.Or")
    @js.native
    val Or: ReactComponentClass[ButtonOrProps] = js.native
  }
  
  @js.native
  trait Button
    extends Component[ButtonProps, js.Object, js.Any] {
    
    def focus(): Unit = js.native
  }
  
  type ButtonProps = StrictButtonProps
  
  trait StrictButtonProps
    extends StObject
       with ButtonHTMLAttributes[HTMLButtonElement] {
    
    /** A button can show it is currently the active user selection. */
    var active: js.UndefOr[Boolean] = js.undefined
    
    /** A button can animate to show hidden content. */
    var animated: js.UndefOr[Boolean | fade | vertical] = js.undefined
    
    /** An element type to render as (string or function). */
    var as: js.UndefOr[js.Any] = js.undefined
    
    /** A button can be attached to other content. */
    var attached: js.UndefOr[Boolean | left | right | top | bottom] = js.undefined
    
    /** A basic button is less pronounced. */
    var basic: js.UndefOr[Boolean] = js.undefined
    
    /** A button can be circular. */
    var circular: js.UndefOr[Boolean] = js.undefined
    
    /** A button can have different colors. */
    @JSName("color")
    var color_StrictButtonProps: js.UndefOr[
        SemanticCOLORS | facebook | (`google plus`) | vk | twitter | linkedin | instagram | youtube
      ] = js.undefined
    
    /** A button can reduce its padding to fit into tighter spaces. */
    var compact: js.UndefOr[Boolean] = js.undefined
    
    /** Shorthand for primary content. */
    var content: js.UndefOr[SemanticShorthandContent] = js.undefined
    
    /** A button can be aligned to the left or right of its container. */
    var floated: js.UndefOr[SemanticFLOATS] = js.undefined
    
    /** A button can take the width of its container. */
    var fluid: js.UndefOr[Boolean] = js.undefined
    
    /** Add an Icon by name, props object, or pass an <Icon />. */
    var icon: js.UndefOr[
        Boolean | (SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ js.Any
        ])
      ] = js.undefined
    
    /** A button can be formatted to appear on dark backgrounds. */
    var inverted: js.UndefOr[Boolean] = js.undefined
    
    /** Add a Label by text, props object, or pass a <Label />. */
    var label: js.UndefOr[
        SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ js.Any
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
    @JSName("onClick")
    var onClick_StrictButtonProps: js.UndefOr[
        js.Function2[/* event */ SyntheticMouseEvent[HTMLButtonElement], /* data */ ButtonProps, Unit]
      ] = js.undefined
    
    /** A button can hint towards a positive consequence. */
    var positive: js.UndefOr[Boolean] = js.undefined
    
    /** A button can be formatted to show different levels of emphasis. */
    var primary: js.UndefOr[Boolean] = js.undefined
    
    /** A button can be formatted to show different levels of emphasis. */
    var secondary: js.UndefOr[Boolean] = js.undefined
    
    /** A button can have different sizes. */
    var size: js.UndefOr[SemanticSIZES] = js.undefined
    
    /** A button can receive focus. */
    @JSName("tabIndex")
    var tabIndex_StrictButtonProps: js.UndefOr[Double | String] = js.undefined
    
    /** A button can be formatted to toggle on and off. */
    var toggle: js.UndefOr[Boolean] = js.undefined
  }
  object StrictButtonProps {
    
    inline def apply(): StrictButtonProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[StrictButtonProps]
    }
    
    extension [Self <: StrictButtonProps](x: Self) {
      
      inline def setActive(value: Boolean): Self = StObject.set(x, "active", value.asInstanceOf[js.Any])
      
      inline def setActiveUndefined: Self = StObject.set(x, "active", js.undefined)
      
      inline def setAnimated(value: Boolean | fade | vertical): Self = StObject.set(x, "animated", value.asInstanceOf[js.Any])
      
      inline def setAnimatedUndefined: Self = StObject.set(x, "animated", js.undefined)
      
      inline def setAs(value: js.Any): Self = StObject.set(x, "as", value.asInstanceOf[js.Any])
      
      inline def setAsUndefined: Self = StObject.set(x, "as", js.undefined)
      
      inline def setAttached(value: Boolean | left | right | top | bottom): Self = StObject.set(x, "attached", value.asInstanceOf[js.Any])
      
      inline def setAttachedUndefined: Self = StObject.set(x, "attached", js.undefined)
      
      inline def setBasic(value: Boolean): Self = StObject.set(x, "basic", value.asInstanceOf[js.Any])
      
      inline def setBasicUndefined: Self = StObject.set(x, "basic", js.undefined)
      
      inline def setCircular(value: Boolean): Self = StObject.set(x, "circular", value.asInstanceOf[js.Any])
      
      inline def setCircularUndefined: Self = StObject.set(x, "circular", js.undefined)
      
      inline def setColor(value: SemanticCOLORS | facebook | (`google plus`) | vk | twitter | linkedin | instagram | youtube): Self = StObject.set(x, "color", value.asInstanceOf[js.Any])
      
      inline def setColorUndefined: Self = StObject.set(x, "color", js.undefined)
      
      inline def setCompact(value: Boolean): Self = StObject.set(x, "compact", value.asInstanceOf[js.Any])
      
      inline def setCompactUndefined: Self = StObject.set(x, "compact", js.undefined)
      
      inline def setContent(value: SemanticShorthandContent): Self = StObject.set(x, "content", value.asInstanceOf[js.Any])
      
      inline def setContentUndefined: Self = StObject.set(x, "content", js.undefined)
      
      inline def setFloated(value: SemanticFLOATS): Self = StObject.set(x, "floated", value.asInstanceOf[js.Any])
      
      inline def setFloatedUndefined: Self = StObject.set(x, "floated", js.undefined)
      
      inline def setFluid(value: Boolean): Self = StObject.set(x, "fluid", value.asInstanceOf[js.Any])
      
      inline def setFluidUndefined: Self = StObject.set(x, "fluid", js.undefined)
      
      inline def setIcon(
        value: Boolean | (SemanticShorthandItem[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ js.Any
            ])
      ): Self = StObject.set(x, "icon", value.asInstanceOf[js.Any])
      
      inline def setIconFunction3(
        value: (/* component */ ReactType[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ js.Any
            ], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ js.Any, /* children */ js.UndefOr[ReactElement | ReactNodeArray]) => ReactElement | Null
      ): Self = StObject.set(x, "icon", js.Any.fromFunction3(value))
      
      inline def setIconReactElement(value: ReactElement): Self = StObject.set(x, "icon", value.asInstanceOf[js.Any])
      
      inline def setIconUndefined: Self = StObject.set(x, "icon", js.undefined)
      
      inline def setInverted(value: Boolean): Self = StObject.set(x, "inverted", value.asInstanceOf[js.Any])
      
      inline def setInvertedUndefined: Self = StObject.set(x, "inverted", js.undefined)
      
      inline def setLabel(
        value: SemanticShorthandItem[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ js.Any
            ]
      ): Self = StObject.set(x, "label", value.asInstanceOf[js.Any])
      
      inline def setLabelFunction3(
        value: (/* component */ ReactType[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ js.Any
            ], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ js.Any, /* children */ js.UndefOr[ReactElement | ReactNodeArray]) => ReactElement | Null
      ): Self = StObject.set(x, "label", js.Any.fromFunction3(value))
      
      inline def setLabelPosition(value: right | left): Self = StObject.set(x, "labelPosition", value.asInstanceOf[js.Any])
      
      inline def setLabelPositionUndefined: Self = StObject.set(x, "labelPosition", js.undefined)
      
      inline def setLabelReactElement(value: ReactElement): Self = StObject.set(x, "label", value.asInstanceOf[js.Any])
      
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
