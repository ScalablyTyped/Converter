package typingsSlinky.stardustUiReactComponentRef

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait Children extends StObject {
    
    var children: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<PropTypes.ReactElementLike> */ js.Any = js.native
    
    var innerRef: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<React.Ref<any>> */ js.Any = js.native
  }
  object Children {
    
    @scala.inline
    def apply(
      children: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<PropTypes.ReactElementLike> */ js.Any,
      innerRef: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<React.Ref<any>> */ js.Any
    ): Children = {
      val __obj = js.Dynamic.literal(children = children.asInstanceOf[js.Any], innerRef = innerRef.asInstanceOf[js.Any])
      __obj.asInstanceOf[Children]
    }
    
    @scala.inline
    implicit class ChildrenMutableBuilder[Self <: Children] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setChildren(
        value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<PropTypes.ReactElementLike> */ js.Any
      ): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setInnerRef(
        value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<React.Ref<any>> */ js.Any
      ): Self = StObject.set(x, "innerRef", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait InnerRef extends StObject {
    
    var children: Unit = js.native
    
    var innerRef: Unit = js.native
  }
  object InnerRef {
    
    @scala.inline
    def apply(children: Unit, innerRef: Unit): InnerRef = {
      val __obj = js.Dynamic.literal(children = children.asInstanceOf[js.Any], innerRef = innerRef.asInstanceOf[js.Any])
      __obj.asInstanceOf[InnerRef]
    }
    
    @scala.inline
    implicit class InnerRefMutableBuilder[Self <: InnerRef] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setChildren(value: Unit): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setInnerRef(value: Unit): Self = StObject.set(x, "innerRef", value.asInstanceOf[js.Any])
    }
  }
}
