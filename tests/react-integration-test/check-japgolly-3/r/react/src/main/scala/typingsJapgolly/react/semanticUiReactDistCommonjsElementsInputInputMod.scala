package typingsJapgolly.react

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactEventFrom
import japgolly.scalajs.react.facade.Empty
import japgolly.scalajs.react.facade.JsNumber
import japgolly.scalajs.react.facade.React.Element
import japgolly.scalajs.react.facade.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.VdomNode
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.HTMLInputElement
import typingsJapgolly.react.mod.Component
import typingsJapgolly.react.reactStrings.`left corner`
import typingsJapgolly.react.reactStrings.`right corner`
import typingsJapgolly.react.reactStrings.big
import typingsJapgolly.react.reactStrings.huge
import typingsJapgolly.react.reactStrings.large
import typingsJapgolly.react.reactStrings.left
import typingsJapgolly.react.reactStrings.massive
import typingsJapgolly.react.reactStrings.mini
import typingsJapgolly.react.reactStrings.right
import typingsJapgolly.react.reactStrings.small
import typingsJapgolly.react.semanticUiReactDistCommonjsGenericMod.HtmlInputrops
import typingsJapgolly.react.semanticUiReactDistCommonjsGenericMod.SemanticShorthandItem
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object semanticUiReactDistCommonjsElementsInputInputMod {
  
  @JSImport("react/semantic-ui-react/dist/commonjs/elements/Input/Input", JSImport.Default)
  @js.native
  open class default () extends Input
  
  @js.native
  trait Input
    extends Component[InputProps, js.Object, Any] {
    
    def focus(): Unit = js.native
    
    def select(): Unit = js.native
  }
  
  trait InputOnChangeData
    extends StObject
       with InputProps {
    
    var value: String
  }
  object InputOnChangeData {
    
    inline def apply(value: String): InputOnChangeData = {
      val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
      __obj.asInstanceOf[InputOnChangeData]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: InputOnChangeData] (val x: Self) extends AnyVal {
      
      inline def setValue(value: String): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
    }
  }
  
  trait InputProps
    extends StObject
       with StrictInputProps
       with /* key */ StringDictionary[Any]
  object InputProps {
    
    inline def apply(): InputProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[InputProps]
    }
  }
  
  trait StrictInputProps extends StObject {
    
    /** An Input can be formatted to alert the user to an action they may perform. */
    var action: js.UndefOr[Any | Boolean] = js.undefined
    
    /** An action can appear along side an Input on the left or right. */
    var actionPosition: js.UndefOr[left] = js.undefined
    
    /** An element type to render as (string or function). */
    var as: js.UndefOr[Any] = js.undefined
    
    /** Primary content. */
    var children: js.UndefOr[Node] = js.undefined
    
    /** Additional classes. */
    var className: js.UndefOr[String] = js.undefined
    
    /** An Input field can show that it is disabled. */
    var disabled: js.UndefOr[Boolean] = js.undefined
    
    /** An Input field can show the data contains errors. */
    var error: js.UndefOr[Boolean] = js.undefined
    
    /** Take on the size of its container. */
    var fluid: js.UndefOr[Boolean] = js.undefined
    
    /** An Input field can show a user is currently interacting with it. */
    var focus: js.UndefOr[Boolean] = js.undefined
    
    /** Optional Icon to display inside the Input. */
    var icon: js.UndefOr[Any | SemanticShorthandItem[InputProps]] = js.undefined
    
    /** An Icon can appear inside an Input on the left. */
    var iconPosition: js.UndefOr[left] = js.undefined
    
    /** Shorthand for creating the HTML Input. */
    var input: js.UndefOr[SemanticShorthandItem[HtmlInputrops]] = js.undefined
    
    /** Format to appear on dark backgrounds. */
    var inverted: js.UndefOr[Boolean] = js.undefined
    
    /** Optional Label to display along side the Input. */
    var label: js.UndefOr[
        SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ Any
        ]
      ] = js.undefined
    
    /** A Label can appear outside an Input on the left or right. */
    var labelPosition: js.UndefOr[left | right | (`left corner`) | (`right corner`)] = js.undefined
    
    /** An Icon Input field can show that it is currently loading data. */
    var loading: js.UndefOr[Boolean] = js.undefined
    
    /**
      * Called on change.
      *
      * @param {ChangeEvent} event - React's original SyntheticEvent.
      * @param {object} data - All props and a proposed value.
      */
    var onChange: js.UndefOr[
        js.Function2[/* event */ ReactEventFrom[HTMLInputElement], /* data */ InputOnChangeData, Unit]
      ] = js.undefined
    
    /** An Input can vary in size. */
    var size: js.UndefOr[mini | small | large | big | huge | massive] = js.undefined
    
    /** An Input can receive focus. */
    var tabIndex: js.UndefOr[Double | String] = js.undefined
    
    /** Transparent Input has no background. */
    var transparent: js.UndefOr[Boolean] = js.undefined
    
    /** The HTML input type. */
    var `type`: js.UndefOr[String] = js.undefined
  }
  object StrictInputProps {
    
    inline def apply(): StrictInputProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[StrictInputProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: StrictInputProps] (val x: Self) extends AnyVal {
      
      inline def setAction(value: Any | Boolean): Self = StObject.set(x, "action", value.asInstanceOf[js.Any])
      
      inline def setActionPosition(value: left): Self = StObject.set(x, "actionPosition", value.asInstanceOf[js.Any])
      
      inline def setActionPositionUndefined: Self = StObject.set(x, "actionPosition", js.undefined)
      
      inline def setActionUndefined: Self = StObject.set(x, "action", js.undefined)
      
      inline def setAs(value: Any): Self = StObject.set(x, "as", value.asInstanceOf[js.Any])
      
      inline def setAsUndefined: Self = StObject.set(x, "as", js.undefined)
      
      inline def setChildren(value: VdomNode): Self = StObject.set(x, "children", value.rawNode.asInstanceOf[js.Any])
      
      inline def setChildrenNull: Self = StObject.set(x, "children", null)
      
      inline def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
      
      inline def setChildrenVarargs(value: (Empty | String | JsNumber | Element)*): Self = StObject.set(x, "children", js.Array(value*))
      
      inline def setChildrenVdomElement(value: VdomElement): Self = StObject.set(x, "children", value.rawElement.asInstanceOf[js.Any])
      
      inline def setClassName(value: String): Self = StObject.set(x, "className", value.asInstanceOf[js.Any])
      
      inline def setClassNameUndefined: Self = StObject.set(x, "className", js.undefined)
      
      inline def setDisabled(value: Boolean): Self = StObject.set(x, "disabled", value.asInstanceOf[js.Any])
      
      inline def setDisabledUndefined: Self = StObject.set(x, "disabled", js.undefined)
      
      inline def setError(value: Boolean): Self = StObject.set(x, "error", value.asInstanceOf[js.Any])
      
      inline def setErrorUndefined: Self = StObject.set(x, "error", js.undefined)
      
      inline def setFluid(value: Boolean): Self = StObject.set(x, "fluid", value.asInstanceOf[js.Any])
      
      inline def setFluidUndefined: Self = StObject.set(x, "fluid", js.undefined)
      
      inline def setFocus(value: Boolean): Self = StObject.set(x, "focus", value.asInstanceOf[js.Any])
      
      inline def setFocusUndefined: Self = StObject.set(x, "focus", js.undefined)
      
      inline def setIcon(value: Any | SemanticShorthandItem[InputProps]): Self = StObject.set(x, "icon", value.asInstanceOf[js.Any])
      
      inline def setIconPosition(value: left): Self = StObject.set(x, "iconPosition", value.asInstanceOf[js.Any])
      
      inline def setIconPositionUndefined: Self = StObject.set(x, "iconPosition", js.undefined)
      
      inline def setIconUndefined: Self = StObject.set(x, "icon", js.undefined)
      
      inline def setInput(value: SemanticShorthandItem[HtmlInputrops]): Self = StObject.set(x, "input", value.asInstanceOf[js.Any])
      
      inline def setInputUndefined: Self = StObject.set(x, "input", js.undefined)
      
      inline def setInverted(value: Boolean): Self = StObject.set(x, "inverted", value.asInstanceOf[js.Any])
      
      inline def setInvertedUndefined: Self = StObject.set(x, "inverted", js.undefined)
      
      inline def setLabel(
        value: SemanticShorthandItem[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ Any
            ]
      ): Self = StObject.set(x, "label", value.asInstanceOf[js.Any])
      
      inline def setLabelPosition(value: left | right | (`left corner`) | (`right corner`)): Self = StObject.set(x, "labelPosition", value.asInstanceOf[js.Any])
      
      inline def setLabelPositionUndefined: Self = StObject.set(x, "labelPosition", js.undefined)
      
      inline def setLabelUndefined: Self = StObject.set(x, "label", js.undefined)
      
      inline def setLoading(value: Boolean): Self = StObject.set(x, "loading", value.asInstanceOf[js.Any])
      
      inline def setLoadingUndefined: Self = StObject.set(x, "loading", js.undefined)
      
      inline def setOnChange(value: (/* event */ ReactEventFrom[HTMLInputElement], /* data */ InputOnChangeData) => Callback): Self = StObject.set(x, "onChange", js.Any.fromFunction2((t0: /* event */ ReactEventFrom[HTMLInputElement], t1: /* data */ InputOnChangeData) => (value(t0, t1)).runNow()))
      
      inline def setOnChangeUndefined: Self = StObject.set(x, "onChange", js.undefined)
      
      inline def setSize(value: mini | small | large | big | huge | massive): Self = StObject.set(x, "size", value.asInstanceOf[js.Any])
      
      inline def setSizeUndefined: Self = StObject.set(x, "size", js.undefined)
      
      inline def setTabIndex(value: Double | String): Self = StObject.set(x, "tabIndex", value.asInstanceOf[js.Any])
      
      inline def setTabIndexUndefined: Self = StObject.set(x, "tabIndex", js.undefined)
      
      inline def setTransparent(value: Boolean): Self = StObject.set(x, "transparent", value.asInstanceOf[js.Any])
      
      inline def setTransparentUndefined: Self = StObject.set(x, "transparent", js.undefined)
      
      inline def setType(value: String): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
      
      inline def setTypeUndefined: Self = StObject.set(x, "type", js.undefined)
    }
  }
}
