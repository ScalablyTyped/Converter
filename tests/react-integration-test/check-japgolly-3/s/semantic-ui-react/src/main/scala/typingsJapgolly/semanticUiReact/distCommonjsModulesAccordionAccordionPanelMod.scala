package typingsJapgolly.semanticUiReact

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.ReactMouseEventFrom
import japgolly.scalajs.react.facade.Empty
import japgolly.scalajs.react.facade.JsNumber
import japgolly.scalajs.react.facade.React.Element
import japgolly.scalajs.react.facade.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.HTMLDivElement
import typingsJapgolly.react.mod.Component
import typingsJapgolly.react.mod.ReactNodeArray
import typingsJapgolly.react.mod.ReactType
import typingsJapgolly.semanticUiReact.distCommonjsGenericMod.SemanticShorthandItem
import typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionContentMod.AccordionContentProps
import typingsJapgolly.semanticUiReact.distCommonjsModulesAccordionAccordionTitleMod.AccordionTitleProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object distCommonjsModulesAccordionAccordionPanelMod {
  
  @JSImport("semantic-ui-react/dist/commonjs/modules/Accordion/AccordionPanel", JSImport.Default)
  @js.native
  open class default ()
    extends Component[AccordionPanelProps, js.Object, Any]
  
  type AccordionPanel = japgolly.scalajs.react.facade.React.Component[AccordionPanelProps & js.Object, js.Object]
  
  trait AccordionPanelProps
    extends StObject
       with StrictAccordionPanelProps
       with /* key */ StringDictionary[Any]
  object AccordionPanelProps {
    
    inline def apply(): AccordionPanelProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[AccordionPanelProps]
    }
  }
  
  trait StrictAccordionPanelProps extends StObject {
    
    /** Whether or not the title is in the open state. */
    var active: js.UndefOr[Boolean] = js.undefined
    
    /** A shorthand for Accordion.Content. */
    var content: js.UndefOr[SemanticShorthandItem[AccordionContentProps]] = js.undefined
    
    /** A panel index. */
    var index: js.UndefOr[Double | String] = js.undefined
    
    /**
      * Called when a panel title is clicked.
      *
      * @param {SyntheticEvent} event - React's original SyntheticEvent.
      * @param {AccordionTitleProps} data - All item props.
      */
    var onTitleClick: js.UndefOr[
        js.Function2[
          /* event */ ReactMouseEventFrom[HTMLDivElement], 
          /* data */ AccordionTitleProps, 
          Unit
        ]
      ] = js.undefined
    
    /** A shorthand for Accordion.Title. */
    var title: js.UndefOr[SemanticShorthandItem[AccordionTitleProps]] = js.undefined
  }
  object StrictAccordionPanelProps {
    
    inline def apply(): StrictAccordionPanelProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[StrictAccordionPanelProps]
    }
    
    extension [Self <: StrictAccordionPanelProps](x: Self) {
      
      inline def setActive(value: Boolean): Self = StObject.set(x, "active", value.asInstanceOf[js.Any])
      
      inline def setActiveUndefined: Self = StObject.set(x, "active", js.undefined)
      
      inline def setContent(value: SemanticShorthandItem[AccordionContentProps]): Self = StObject.set(x, "content", value.asInstanceOf[js.Any])
      
      inline def setContentFunction3(
        value: (/* component */ ReactType[AccordionContentProps], AccordionContentProps, /* children */ js.UndefOr[Node | ReactNodeArray]) => Element | Null
      ): Self = StObject.set(x, "content", js.Any.fromFunction3(value))
      
      inline def setContentNull: Self = StObject.set(x, "content", null)
      
      inline def setContentUndefined: Self = StObject.set(x, "content", js.undefined)
      
      inline def setContentVarargs(value: (Empty | String | JsNumber | Element)*): Self = StObject.set(x, "content", js.Array(value*))
      
      inline def setContentVdomElement(value: VdomElement): Self = StObject.set(x, "content", value.rawElement.asInstanceOf[js.Any])
      
      inline def setIndex(value: Double | String): Self = StObject.set(x, "index", value.asInstanceOf[js.Any])
      
      inline def setIndexUndefined: Self = StObject.set(x, "index", js.undefined)
      
      inline def setOnTitleClick(
        value: (/* event */ ReactMouseEventFrom[HTMLDivElement], /* data */ AccordionTitleProps) => Callback
      ): Self = StObject.set(x, "onTitleClick", js.Any.fromFunction2((t0: /* event */ ReactMouseEventFrom[HTMLDivElement], t1: /* data */ AccordionTitleProps) => (value(t0, t1)).runNow()))
      
      inline def setOnTitleClickUndefined: Self = StObject.set(x, "onTitleClick", js.undefined)
      
      inline def setTitle(value: SemanticShorthandItem[AccordionTitleProps]): Self = StObject.set(x, "title", value.asInstanceOf[js.Any])
      
      inline def setTitleFunction3(
        value: (/* component */ ReactType[AccordionTitleProps], AccordionTitleProps, /* children */ js.UndefOr[Node | ReactNodeArray]) => Element | Null
      ): Self = StObject.set(x, "title", js.Any.fromFunction3(value))
      
      inline def setTitleNull: Self = StObject.set(x, "title", null)
      
      inline def setTitleUndefined: Self = StObject.set(x, "title", js.undefined)
      
      inline def setTitleVarargs(value: (Empty | String | JsNumber | Element)*): Self = StObject.set(x, "title", js.Array(value*))
      
      inline def setTitleVdomElement(value: VdomElement): Self = StObject.set(x, "title", value.rawElement.asInstanceOf[js.Any])
    }
  }
}
