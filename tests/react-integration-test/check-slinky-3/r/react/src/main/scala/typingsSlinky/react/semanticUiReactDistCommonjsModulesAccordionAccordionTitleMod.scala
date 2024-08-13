package typingsSlinky.react

import org.scalablytyped.runtime.Shortcut
import org.scalablytyped.runtime.StringDictionary
import org.scalajs.dom.HTMLDivElement
import slinky.core.ReactComponentClass
import slinky.core.facade.ReactElement
import slinky.web.SyntheticMouseEvent
import typingsSlinky.react.mod.Component
import typingsSlinky.react.semanticUiReactDistCommonjsGenericMod.SemanticShorthandContent
import typingsSlinky.react.semanticUiReactDistCommonjsGenericMod.SemanticShorthandItem
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object semanticUiReactDistCommonjsModulesAccordionAccordionTitleMod extends Shortcut {
  
  /* This class was inferred from a value with a constructor. In rare cases (like HTMLElement in the DOM) it might not work as you expect. */
  @JSImport("react/semantic-ui-react/dist/commonjs/modules/Accordion/AccordionTitle", JSImport.Default)
  @js.native
  open class default protected ()
    extends Component[AccordionTitleProps, js.Object, Any] {
    def this(props: AccordionTitleProps) = this()
    def this(props: AccordionTitleProps, context: Any) = this()
  }
  @JSImport("react/semantic-ui-react/dist/commonjs/modules/Accordion/AccordionTitle", JSImport.Default)
  @js.native
  val default: ReactComponentClass[AccordionTitleProps] = js.native
  
  trait AccordionTitleProps
    extends StObject
       with StrictAccordionTitleProps
       with /* key */ StringDictionary[Any]
  object AccordionTitleProps {
    
    inline def apply(): AccordionTitleProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[AccordionTitleProps]
    }
  }
  
  trait StrictAccordionTitleProps extends StObject {
    
    /** Whether or not the title is in the open state. */
    var active: js.UndefOr[Boolean] = js.undefined
    
    /** An element type to render as (string or function). */
    var as: js.UndefOr[Any] = js.undefined
    
    /** Primary content. */
    var children: js.UndefOr[ReactElement] = js.undefined
    
    /** Additional classes. */
    var className: js.UndefOr[String] = js.undefined
    
    /** Shorthand for primary content. */
    var content: js.UndefOr[SemanticShorthandContent] = js.undefined
    
    /** Shorthand for Icon. */
    var icon: js.UndefOr[
        SemanticShorthandItem[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ Any
        ]
      ] = js.undefined
    
    /** AccordionTitle index inside Accordion. */
    var index: js.UndefOr[Double | String] = js.undefined
    
    /**
      * Called on click.
      *
      * @param {SyntheticEvent} event - React's original SyntheticEvent.
      * @param {object} data - All props.
      */
    var onClick: js.UndefOr[
        js.Function2[
          /* event */ SyntheticMouseEvent[HTMLDivElement], 
          /* data */ AccordionTitleProps, 
          Unit
        ]
      ] = js.undefined
  }
  object StrictAccordionTitleProps {
    
    inline def apply(): StrictAccordionTitleProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[StrictAccordionTitleProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: StrictAccordionTitleProps] (val x: Self) extends AnyVal {
      
      inline def setActive(value: Boolean): Self = StObject.set(x, "active", value.asInstanceOf[js.Any])
      
      inline def setActiveUndefined: Self = StObject.set(x, "active", js.undefined)
      
      inline def setAs(value: Any): Self = StObject.set(x, "as", value.asInstanceOf[js.Any])
      
      inline def setAsUndefined: Self = StObject.set(x, "as", js.undefined)
      
      inline def setChildren(value: ReactElement): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
      
      inline def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
      
      inline def setClassName(value: String): Self = StObject.set(x, "className", value.asInstanceOf[js.Any])
      
      inline def setClassNameUndefined: Self = StObject.set(x, "className", js.undefined)
      
      inline def setContent(value: SemanticShorthandContent): Self = StObject.set(x, "content", value.asInstanceOf[js.Any])
      
      inline def setContentUndefined: Self = StObject.set(x, "content", js.undefined)
      
      inline def setIcon(
        value: SemanticShorthandItem[
              /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify IconProps */ Any
            ]
      ): Self = StObject.set(x, "icon", value.asInstanceOf[js.Any])
      
      inline def setIconUndefined: Self = StObject.set(x, "icon", js.undefined)
      
      inline def setIndex(value: Double | String): Self = StObject.set(x, "index", value.asInstanceOf[js.Any])
      
      inline def setIndexUndefined: Self = StObject.set(x, "index", js.undefined)
      
      inline def setOnClick(value: (/* event */ SyntheticMouseEvent[HTMLDivElement], /* data */ AccordionTitleProps) => Unit): Self = StObject.set(x, "onClick", js.Any.fromFunction2(value))
      
      inline def setOnClickUndefined: Self = StObject.set(x, "onClick", js.undefined)
    }
  }
  
  type _To = ReactComponentClass[AccordionTitleProps]
  
  /* This means you don't have to write `default`, but can instead just say `semanticUiReactDistCommonjsModulesAccordionAccordionTitleMod.foo` */
  override def _to: ReactComponentClass[AccordionTitleProps] = default
}
