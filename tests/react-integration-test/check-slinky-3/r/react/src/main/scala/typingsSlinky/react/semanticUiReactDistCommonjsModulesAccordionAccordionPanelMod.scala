package typingsSlinky.react

import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.HTMLDivElement
import slinky.core.ReactComponentClass
import slinky.web.SyntheticMouseEvent
import typingsSlinky.react.mod.Component
import typingsSlinky.react.semanticUiReactDistCommonjsGenericMod.SemanticShorthandItem
import typingsSlinky.react.semanticUiReactDistCommonjsModulesAccordionAccordionContentMod.AccordionContentProps
import typingsSlinky.react.semanticUiReactDistCommonjsModulesAccordionAccordionTitleMod.AccordionTitleProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object semanticUiReactDistCommonjsModulesAccordionAccordionPanelMod {
  
  @JSImport("react/semantic-ui-react/dist/commonjs/modules/Accordion/AccordionPanel", JSImport.Default)
  @js.native
  open class default ()
    extends Component[AccordionPanelProps, js.Object, Any]
  
  type AccordionPanel = ReactComponentClass[AccordionPanelProps]
  
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
          /* event */ SyntheticMouseEvent[HTMLDivElement], 
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
    
    @scala.inline
    implicit open class MutableBuilder[Self <: StrictAccordionPanelProps] (val x: Self) extends AnyVal {
      
      inline def setActive(value: Boolean): Self = StObject.set(x, "active", value.asInstanceOf[js.Any])
      
      inline def setActiveUndefined: Self = StObject.set(x, "active", js.undefined)
      
      inline def setContent(value: SemanticShorthandItem[AccordionContentProps]): Self = StObject.set(x, "content", value.asInstanceOf[js.Any])
      
      inline def setContentUndefined: Self = StObject.set(x, "content", js.undefined)
      
      inline def setIndex(value: Double | String): Self = StObject.set(x, "index", value.asInstanceOf[js.Any])
      
      inline def setIndexUndefined: Self = StObject.set(x, "index", js.undefined)
      
      inline def setOnTitleClick(value: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit): Self = StObject.set(x, "onTitleClick", js.Any.fromFunction2(value))
      
      inline def setOnTitleClickUndefined: Self = StObject.set(x, "onTitleClick", js.undefined)
      
      inline def setTitle(value: SemanticShorthandItem[AccordionTitleProps]): Self = StObject.set(x, "title", value.asInstanceOf[js.Any])
      
      inline def setTitleUndefined: Self = StObject.set(x, "title", js.undefined)
    }
  }
}
