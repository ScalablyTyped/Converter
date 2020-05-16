package typingsSlinky.stardustUiReactComponentRef

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonChildren extends js.Object {
  var children: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<PropTypes.ReactElementLike> */ js.Any = js.native
  var innerRef: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<React.Ref<any>> */ js.Any = js.native
}

object AnonChildren {
  @scala.inline
  def apply(
    children: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<PropTypes.ReactElementLike> */ js.Any,
    innerRef: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<React.Ref<any>> */ js.Any
  ): AnonChildren = {
    val __obj = js.Dynamic.literal(children = children.asInstanceOf[js.Any], innerRef = innerRef.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnonChildren]
  }
  @scala.inline
  implicit class AnonChildrenOps[Self <: AnonChildren] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withChildren(
      value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<PropTypes.ReactElementLike> */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("children")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withInnerRef(
      value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<React.Ref<any>> */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("innerRef")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}

