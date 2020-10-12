package typingsJapgolly.semanticUiReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.raw.React.ComponentClassP
import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.VdomNode
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import typingsJapgolly.react.mod.Component
import typingsJapgolly.react.mod.ReactNodeArray
import typingsJapgolly.react.mod.ReactType
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandContent
import typingsJapgolly.semanticUiReact.genericMod.SemanticShorthandItem
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object accordionTitleMod {
  
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/AccordionTitle", JSImport.Default)
  @js.native
  val default: ComponentClassP[AccordionTitleProps with js.Object] = js.native
  
  @js.native
  trait AccordionTitleProps
    extends StrictAccordionTitleProps
       with /* key */ StringDictionary[js.Any]
  object AccordionTitleProps {
    
    @scala.inline
    def apply(): AccordionTitleProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[AccordionTitleProps]
    }
  }
  
  @js.native
  trait StrictAccordionTitleProps extends js.Object {
    
    /** Whether or not the title is in the open state. */
    var active: js.UndefOr[Boolean] = js.native
    
    /** An element type to render as (string or function). */
    var as: js.UndefOr[js.Any] = js.native
    
    /** Primary content. */
    var children: js.UndefOr[Node] = js.native
    
    /** Additional classes. */
    var className: js.UndefOr[String] = js.native
    
    /** Shorthand for primary content. */
    var content: js.UndefOr[SemanticShorthandContent] = js.native
    
    /** Shorthand for Icon. */
    var icon: js.UndefOr[
        SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _
        ]
      ] = js.native
    
    /** AccordionTitle index inside Accordion. */
    var index: js.UndefOr[Double | String] = js.native
    
    /**
      * Called on click.
      *
      * @param {SyntheticEvent} event - React's original SyntheticEvent.
      * @param {object} data - All props.
      */
    var onClick: js.UndefOr[
        js.Function2[
          /* event */ ReactMouseEventFrom[HTMLDivElement], 
          /* data */ AccordionTitleProps, 
          Unit
        ]
      ] = js.native
  }
  object StrictAccordionTitleProps {
    
    @scala.inline
    def apply(): StrictAccordionTitleProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[StrictAccordionTitleProps]
    }
    
    @scala.inline
    implicit class StrictAccordionTitlePropsOps[Self <: StrictAccordionTitleProps] (val x: Self) extends AnyVal {
      
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
      def setContentVdomElement(value: VdomElement): Self = this.set("content", value.rawElement.asInstanceOf[js.Any])
      
      @scala.inline
      def setContent(value: SemanticShorthandContent): Self = this.set("content", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteContent: Self = this.set("content", js.undefined)
      
      @scala.inline
      def setIconVdomElement(value: VdomElement): Self = this.set("icon", value.rawElement.asInstanceOf[js.Any])
      
      @scala.inline
      def setIconFunction3(
        value: (/* component */ ReactType[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _
            ], /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _, /* children */ js.UndefOr[Node | ReactNodeArray]) => Element | Null
      ): Self = this.set("icon", js.Any.fromFunction3(value))
      
      @scala.inline
      def setIcon(
        value: SemanticShorthandItem[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ _
            ]
      ): Self = this.set("icon", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteIcon: Self = this.set("icon", js.undefined)
      
      @scala.inline
      def setIndex(value: Double | String): Self = this.set("index", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteIndex: Self = this.set("index", js.undefined)
      
      @scala.inline
      def setOnClick(
        value: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback
      ): Self = this.set("onClick", js.Any.fromFunction2((t0: /* event */ ReactMouseEventFrom[HTMLDivElement], t1: /* data */ AccordionTitleProps) => (value(t0, t1)).runNow()))
      
      @scala.inline
      def deleteOnClick: Self = this.set("onClick", js.undefined)
    }
  }
  
  /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/AccordionTitle", JSImport.Default)
  @js.native
  class default protected ()
    extends Component[AccordionTitleProps, js.Object, js.Any] {
    def this(props: AccordionTitleProps) = this()
    def this(props: AccordionTitleProps, context: js.Any) = this()
  }
}
