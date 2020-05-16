package typingsJapgolly.react.mod

import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomElement
import japgolly.scalajs.react.vdom.VdomNode
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// Context via RenderProps
@js.native
trait ProviderProps[T] extends js.Object {
  var children: js.UndefOr[Node] = js.native
  var value: T = js.native
}

object ProviderProps {
  @scala.inline
  def apply[T](value: T, children: VdomNode = null): ProviderProps[T] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
    __obj.asInstanceOf[ProviderProps[T]]
  }
  @scala.inline
  implicit class ProviderPropsOps[Self[t] <: ProviderProps[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withValue(value: T): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("value")(value.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withChildrenVdomElement(children: VdomElement): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (children != null) ret.updateDynamic("children")(children.rawElement.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withChildren(children: VdomNode): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (children != null) ret.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutChildren: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "children")
        ret.asInstanceOf[Self[T]]
    }
  }
  
}

