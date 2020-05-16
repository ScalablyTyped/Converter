package typings.react.mod

import typings.std.Element
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// string fallback for custom web-components
@js.native
trait DOMElement[P /* <: HTMLAttributes[T] | SVGAttributes[T] */, T /* <: Element */] extends ReactElement {
  var ref: Ref[T] = js.native
  @JSName("type")
  var type_DOMElement: String = js.native
}

object DOMElement {
  @scala.inline
  def apply[P /* <: HTMLAttributes[T] | SVGAttributes[T] */, T /* <: Element */](props: js.Any, ref: Ref[T], `type`: String, key: Key = null): DOMElement[P, T] = {
    val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any], ref = ref.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    __obj.asInstanceOf[DOMElement[P, T]]
  }
  @scala.inline
  implicit class DOMElementOps[Self[p /* <: typings.react.mod.HTMLAttributes[T] | typings.react.mod.SVGAttributes[T] */, t /* <: typings.std.Element */] <: DOMElement[p, t], P <: HTMLAttributes[T] | SVGAttributes[T], T <: Element] (val x: Self[P, T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[P, T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[P, T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[P, T]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[P, T]) with Other]
    @scala.inline
    def withRefFunction1(ref: /* instance */ T | Null => js.Any): Self[P, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("ref")(js.Any.fromFunction1(ref))
        ret.asInstanceOf[Self[P, T]]
    }
    @scala.inline
    def withRef(ref: Ref[T]): Self[P, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("ref")(ref.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[P, T]]
    }
    @scala.inline
    def withType(`type`: String): Self[P, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("type")(`type`.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[P, T]]
    }
  }
  
}

