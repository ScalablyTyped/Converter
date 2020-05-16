package typingsJapgolly.react.mod

import japgolly.scalajs.react.CallbackTo
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ClassAttributes[T] extends Attributes {
  var ref: js.UndefOr[japgolly.scalajs.react.raw.React.Ref] = js.native
}

object ClassAttributes {
  @scala.inline
  def apply[T](key: Key = null, ref: japgolly.scalajs.react.raw.React.Ref = null): ClassAttributes[T] = {
    val __obj = js.Dynamic.literal()
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
    __obj.asInstanceOf[ClassAttributes[T]]
  }
  @scala.inline
  implicit class ClassAttributesOps[Self[t] <: ClassAttributes[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withRefFunction1(ref: /* instance */ T | Null => CallbackTo[CallbackTo[js.Any]]): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("ref")(js.Any.fromFunction1((t0: /* instance */ T | Null) => ref(t0).runNow()))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRef(ref: japgolly.scalajs.react.raw.React.Ref): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (ref != null) ret.updateDynamic("ref")(ref.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutRef: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "ref")
        ret.asInstanceOf[Self[T]]
    }
  }
  
}

