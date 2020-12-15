package typingsJapgolly.semanticUiReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactEventFrom
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import org.scalajs.dom.raw.HTMLInputElement
import typingsJapgolly.react.mod.Component
import typingsJapgolly.react.mod.InputHTMLAttributes
import typingsJapgolly.react.mod.ReactNodeArray
import typingsJapgolly.react.mod.ReactType
import typingsJapgolly.semanticUiReact.genericMod.HtmlInputrops
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandItem
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.`left corner`
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.`right corner`
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.big
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.huge
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.large
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.left
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.massive
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.mini
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.right
import typingsJapgolly.semanticUiReact.semanticUiReactStrings.small
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object inputInputMod {
  
  @js.native
  trait Input
    extends Component[InputProps, js.Object, js.Any] {
    
    def focus(): Unit = js.native
    
    def select(): Unit = js.native
  }
  
  @js.native
  trait InputOnChangeData extends StrictInputProps {
    
    @JSName("value")
    var value_InputOnChangeData: String = js.native
  }
  object InputOnChangeData {
    
    @scala.inline
    def apply(value: String): InputOnChangeData = {
      val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
      __obj.asInstanceOf[InputOnChangeData]
    }
    
    @scala.inline
    implicit class InputOnChangeDataOps[Self <: InputOnChangeData] (val x: Self) extends AnyVal {
      
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
      def setValue(value: String): Self = this.set("value", value.asInstanceOf[js.Any])
    }
  }
  
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
        js.Function2[/* event */ ReactEventFrom[HTMLInputElement], /* data */ InputOnChangeData, Unit]
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
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setAction(value: js.Any | Boolean): Self = this.set("action", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteAction: Self = this.set("action", js.undefined)
      
      @scala.inline
      def setActionPosition(value: left): Self = this.set("actionPosition", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteActionPosition: Self = this.set("actionPosition", js.undefined)
      
      @scala.inline
      def setAs(value: js.Any): Self = this.set("as", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteAs: Self = this.set("as", js.undefined)
      
      @scala.inline
      def setError(value: Boolean): Self = this.set("error", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteError: Self = this.set("error", js.undefined)
      
      @scala.inline
      def setFluid(value: Boolean): Self = this.set("fluid", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteFluid: Self = this.set("fluid", js.undefined)
      
      @scala.inline
      def setFocus(value: Boolean): Self = this.set("focus", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteFocus: Self = this.set("focus", js.undefined)
      
      @scala.inline
      def setIconVdomElement(value: VdomElement): Self = this.set("icon", value.rawElement.asInstanceOf[js.Any])
      
      @scala.inline
      def setIconFunction3(
        value: (/* component */ ReactType[InputProps], InputProps, /* children */ js.UndefOr[Node | ReactNodeArray]) => Element | Null
      ): Self = this.set("icon", js.Any.fromFunction3(value))
      
      @scala.inline
      def setIcon(value: js.Any | SemanticShorthandItem[InputProps]): Self = this.set("icon", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteIcon: Self = this.set("icon", js.undefined)
      
      @scala.inline
      def setIconPosition(value: left): Self = this.set("iconPosition", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteIconPosition: Self = this.set("iconPosition", js.undefined)
      
      @scala.inline
      def setInputVdomElement(value: VdomElement): Self = this.set("input", value.rawElement.asInstanceOf[js.Any])
      
      @scala.inline
      def setInputFunction3(
        value: (/* component */ ReactType[HtmlInputrops], HtmlInputrops, /* children */ js.UndefOr[Node | ReactNodeArray]) => Element | Null
      ): Self = this.set("input", js.Any.fromFunction3(value))
      
      @scala.inline
      def setInput(value: SemanticShorthandItem[HtmlInputrops]): Self = this.set("input", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteInput: Self = this.set("input", js.undefined)
      
      @scala.inline
      def setInverted(value: Boolean): Self = this.set("inverted", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteInverted: Self = this.set("inverted", js.undefined)
      
      @scala.inline
      def setLabelVdomElement(value: VdomElement): Self = this.set("label", value.rawElement.asInstanceOf[js.Any])
      
      @scala.inline
      def setLabelFunction3(
        value: (/* component */ ReactType[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ _
            ], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify LabelProps */ _, /* children */ js.UndefOr[Node | ReactNodeArray]) => Element | Null
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
      def setLabelPosition(value: left | right | (`left corner`) | (`right corner`)): Self = this.set("labelPosition", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteLabelPosition: Self = this.set("labelPosition", js.undefined)
      
      @scala.inline
      def setLoading(value: Boolean): Self = this.set("loading", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteLoading: Self = this.set("loading", js.undefined)
      
      @scala.inline
      def setOnChange(value: (/* event */ ReactEventFrom[HTMLInputElement], /* data */ InputOnChangeData) => Callback): Self = this.set("onChange", js.Any.fromFunction2((t0: /* event */ ReactEventFrom[HTMLInputElement], t1: /* data */ InputOnChangeData) => (value(t0, t1)).runNow()))
      
      @scala.inline
      def deleteOnChange: Self = this.set("onChange", js.undefined)
      
      @scala.inline
      def setSize(value: mini | small | large | big | huge | massive): Self = this.set("size", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteSize: Self = this.set("size", js.undefined)
      
      @scala.inline
      def setTabIndex(value: Double | String): Self = this.set("tabIndex", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteTabIndex: Self = this.set("tabIndex", js.undefined)
      
      @scala.inline
      def setTransparent(value: Boolean): Self = this.set("transparent", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteTransparent: Self = this.set("transparent", js.undefined)
    }
  }
  
  @JSImport("semantic-ui-react/dist/commonjs/elements/Input/Input", JSImport.Default)
  @js.native
  class default () extends Input
  
  type InputProps = StrictInputProps
}
