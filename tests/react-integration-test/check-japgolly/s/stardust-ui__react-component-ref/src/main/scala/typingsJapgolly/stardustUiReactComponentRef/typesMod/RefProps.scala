package typingsJapgolly.stardustUiReactComponentRef.typesMod

import japgolly.scalajs.react.raw.React.Element
import japgolly.scalajs.react.raw.React.Ref
import japgolly.scalajs.react.vdom.VdomElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait RefProps extends js.Object {
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
  implicit class RefPropsOps[Self <: RefProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withChildren(value: VdomElement): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("children")(value.rawElement.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withInnerRef(value: Ref): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("innerRef")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withInnerRefNull: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("innerRef")(null)
        ret
    }
  }
  
}

