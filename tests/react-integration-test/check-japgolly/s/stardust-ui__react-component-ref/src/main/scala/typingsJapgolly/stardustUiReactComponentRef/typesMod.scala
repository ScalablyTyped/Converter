package typingsJapgolly.stardustUiReactComponentRef

import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Ref
import japgolly.scalajs.react.vdom.VdomElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object typesMod {
  
  @JSImport("@stardust-ui/react-component-ref/dist/es/types", "refPropType")
  @js.native
  val refPropType: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Requireable<React.Ref<any>> */ js.Any = js.native
  
  @js.native
  trait RefProps extends StObject {
    
    var children: Element = js.native
    
    /**
      * Called when a child component will be mounted or updated.
      *
      * @param {HTMLElement} node - Referred node.
      */
    var innerRef: Ref = js.native
  }
  object RefProps {
    
    @scala.inline
    def apply(children: VdomElement): RefProps = {
      val __obj = js.Dynamic.literal(children = children.rawElement.asInstanceOf[js.Any])
      __obj.asInstanceOf[RefProps]
    }
    
    @scala.inline
    implicit class RefPropsMutableBuilder[Self <: RefProps] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setChildren(value: VdomElement): Self = StObject.set(x, "children", value.rawElement.asInstanceOf[js.Any])
      
      @scala.inline
      def setInnerRef(value: Ref): Self = StObject.set(x, "innerRef", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setInnerRefNull: Self = StObject.set(x, "innerRef", null)
    }
  }
}
