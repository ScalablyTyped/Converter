package typingsSlinky.semanticUiReact

import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.raw.HTMLDivElement
import slinky.core.ReactComponentClass
import slinky.core.facade.ReactElement
import slinky.web.SyntheticMouseEvent
import typingsSlinky.react.mod.Component
import typingsSlinky.semanticUiReact.accordionPanelMod.AccordionPanelProps
import typingsSlinky.semanticUiReact.accordionTitleMod.AccordionTitleProps
import typingsSlinky.semanticUiReact.genericMod.SemanticShorthandCollection
import typingsSlinky.semanticUiReact.genericMod.SemanticShorthandItem
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object accordionAccordionAccordionMod {
  
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/AccordionAccordion", JSImport.Default)
  @js.native
  val default: ReactComponentClass[AccordionAccordionProps] = js.native
  
  @js.native
  trait AccordionAccordionProps
    extends StrictAccordionAccordionProps
       with /* key */ StringDictionary[js.Any]
  object AccordionAccordionProps {
    
    @scala.inline
    def apply(): AccordionAccordionProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[AccordionAccordionProps]
    }
  }
  
  @js.native
  trait StrictAccordionAccordionProps extends StObject {
    
    /** Index of the currently active panel. */
    var activeIndex: js.UndefOr[Double | js.Array[Double]] = js.native
    
    /** An element type to render as (string or function). */
    var as: js.UndefOr[js.Any] = js.native
    
    /** Primary content. */
    var children: js.UndefOr[ReactElement] = js.native
    
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
          /* event */ SyntheticMouseEvent[HTMLDivElement], 
          /* data */ AccordionTitleProps, 
          Unit
        ]
      ] = js.native
    
    /** Shorthand array of props for Accordion. */
    var panels: js.UndefOr[SemanticShorthandCollection[AccordionPanelProps]] = js.native
  }
  object StrictAccordionAccordionProps {
    
    @scala.inline
    def apply(): StrictAccordionAccordionProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[StrictAccordionAccordionProps]
    }
    
    @scala.inline
    implicit class StrictAccordionAccordionPropsMutableBuilder[Self <: StrictAccordionAccordionProps] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setActiveIndex(value: Double | js.Array[Double]): Self = StObject.set(x, "activeIndex", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setActiveIndexUndefined: Self = StObject.set(x, "activeIndex", js.undefined)
      
      @scala.inline
      def setActiveIndexVarargs(value: Double*): Self = StObject.set(x, "activeIndex", js.Array(value :_*))
      
      @scala.inline
      def setAs(value: js.Any): Self = StObject.set(x, "as", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setAsUndefined: Self = StObject.set(x, "as", js.undefined)
      
      @scala.inline
      def setChildren(value: ReactElement): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setChildrenReactElement(value: ReactElement): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
      
      @scala.inline
      def setClassName(value: String): Self = StObject.set(x, "className", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setClassNameUndefined: Self = StObject.set(x, "className", js.undefined)
      
      @scala.inline
      def setDefaultActiveIndex(value: Double | js.Array[Double]): Self = StObject.set(x, "defaultActiveIndex", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setDefaultActiveIndexUndefined: Self = StObject.set(x, "defaultActiveIndex", js.undefined)
      
      @scala.inline
      def setDefaultActiveIndexVarargs(value: Double*): Self = StObject.set(x, "defaultActiveIndex", js.Array(value :_*))
      
      @scala.inline
      def setExclusive(value: Boolean): Self = StObject.set(x, "exclusive", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setExclusiveUndefined: Self = StObject.set(x, "exclusive", js.undefined)
      
      @scala.inline
      def setOnTitleClick(value: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit): Self = StObject.set(x, "onTitleClick", js.Any.fromFunction2(value))
      
      @scala.inline
      def setOnTitleClickUndefined: Self = StObject.set(x, "onTitleClick", js.undefined)
      
      @scala.inline
      def setPanels(value: SemanticShorthandCollection[AccordionPanelProps]): Self = StObject.set(x, "panels", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPanelsUndefined: Self = StObject.set(x, "panels", js.undefined)
      
      @scala.inline
      def setPanelsVarargs(value: SemanticShorthandItem[AccordionPanelProps]*): Self = StObject.set(x, "panels", js.Array(value :_*))
    }
  }
  
  /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/AccordionAccordion", JSImport.Default)
  @js.native
  class default protected ()
    extends Component[AccordionAccordionProps, js.Object, js.Any] {
    def this(props: AccordionAccordionProps) = this()
    def this(props: AccordionAccordionProps, context: js.Any) = this()
  }
}
