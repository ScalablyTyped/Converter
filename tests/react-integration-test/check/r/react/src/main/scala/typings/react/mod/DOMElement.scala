package typings.react.mod

import typings.std.Element
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// string fallback for custom web-components
@js.native
trait DOMElement[P /* <: HTMLAttributes[T] | SVGAttributes[T] */, T /* <: Element */] extends ReactElement {
  var ref: LegacyRef[T] = js.native
}

object DOMElement {
  @scala.inline
  def apply[P /* <: HTMLAttributes[T] | SVGAttributes[T] */, T /* <: Element */](props: js.Any, `type`: js.Any): DOMElement[P, T] = {
    val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[DOMElement[P, T]]
  }
  @scala.inline
  implicit class DOMElementOps[Self[p /* <: typings.react.mod.HTMLAttributes[T] | typings.react.mod.SVGAttributes[T] */, t /* <: typings.std.Element */] <: DOMElement[p, t], P, T] (val x: Self[P, T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[P, T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[P, T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[P, T]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[P, T]) with Other]
    @scala.inline
    def withRefFunction1(value: /* instance */ T | Null => Unit): Self[P, T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("ref")(js.Any.fromFunction1(value))
        ret
    }
    @scala.inline
    def withRef(value: LegacyRef[T]): Self[P, T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("ref")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withRefNull: Self[P, T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("ref")(null)
        ret
    }
  }
  
}

