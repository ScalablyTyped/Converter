package typingsJapgolly.stardustUiReactComponentRef

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  trait Children extends StObject {
    
    var children: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<PropTypes.ReactElementLike> */ Any
    
    var innerRef: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<React.Ref<any>> */ Any
  }
  object Children {
    
    inline def apply(
      children: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<PropTypes.ReactElementLike> */ Any,
      innerRef: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<React.Ref<any>> */ Any
    ): Children = {
      val __obj = js.Dynamic.literal(children = children.asInstanceOf[js.Any], innerRef = innerRef.asInstanceOf[js.Any])
      __obj.asInstanceOf[Children]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Children] (val x: Self) extends AnyVal {
      
      inline def setChildren(
        value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<PropTypes.ReactElementLike> */ Any
      ): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
      
      inline def setInnerRef(
        value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<React.Ref<any>> */ Any
      ): Self = StObject.set(x, "innerRef", value.asInstanceOf[js.Any])
    }
  }
  
  trait InnerRef extends StObject {
    
    var children: Unit
    
    var innerRef: Unit
  }
  object InnerRef {
    
    inline def apply(children: Unit, innerRef: Unit): InnerRef = {
      val __obj = js.Dynamic.literal(children = children.asInstanceOf[js.Any], innerRef = innerRef.asInstanceOf[js.Any])
      __obj.asInstanceOf[InnerRef]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: InnerRef] (val x: Self) extends AnyVal {
      
      inline def setChildren(value: Unit): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
      
      inline def setInnerRef(value: Unit): Self = StObject.set(x, "innerRef", value.asInstanceOf[js.Any])
    }
  }
}
