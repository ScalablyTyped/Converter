package typingsJapgolly.stardustUiReactComponentRef

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait Children extends js.Object {
    
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
    implicit class ChildrenOps[Self <: Children] (val x: Self) extends AnyVal {
      
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
      def setChildren(
        value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<PropTypes.ReactElementLike> */ js.Any
      ): Self = this.set("children", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setInnerRef(
        value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<React.Ref<any>> */ js.Any
      ): Self = this.set("innerRef", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait InnerRef extends js.Object {
    
    var children: js.UndefOr[scala.Nothing] = js.native
    
    var innerRef: js.UndefOr[scala.Nothing] = js.native
  }
}
