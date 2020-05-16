package typingsJapgolly.react.mod

import japgolly.scalajs.react.Callback
import japgolly.scalajs.react.CallbackTo
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ComponentElement[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */] extends ReactElement {
  var ref: js.UndefOr[LegacyRef[T]] = js.native
}

object ComponentElement {
  @scala.inline
  def apply[P, T /* <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object] */](props: js.Any, `type`: js.Any, key: Key = null, ref: LegacyRef[T] = null): ComponentElement[P, T] = {
    val __obj = js.Dynamic.literal(props = props.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
    __obj.asInstanceOf[ComponentElement[P, T]]
  }
  @scala.inline
  implicit class ComponentElementOps[Self[p, t /* <: typingsJapgolly.react.mod.Component[P, typingsJapgolly.react.mod.ComponentState, _] */] <: ComponentElement[p, t], P, T <: japgolly.scalajs.react.raw.React.Component[P with js.Object, js.Object]] (val x: Self[P, T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[P, T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[P, T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): (Self[P, T]) with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[(Self[P, T]) with Other]
    @scala.inline
    def withRefFunction1(ref: /* instance */ T | Null => CallbackTo[Callback]): Self[P, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("ref")(js.Any.fromFunction1((t0: /* instance */ T | Null) => ref(t0).runNow()))
        ret.asInstanceOf[Self[P, T]]
    }
    @scala.inline
    def withRef(ref: LegacyRef[T]): Self[P, T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (ref != null) ret.updateDynamic("ref")(ref.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[P, T]]
    }
    @scala.inline
    def withoutRef: Self[P, T] = {
        val ret = this.duplicate
        js.special.delete(ret, "ref")
        ret.asInstanceOf[Self[P, T]]
    }
  }
  
}

