package typings.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

//
// Props / DOM Attributes
// ----------------------------------------------------------------------
/**
  * @deprecated. This was used to allow clients to pass `ref` and `key`
  * to `createElement`, which is no longer necessary due to intersection
  * types. If you need to declare a props object before passing it to
  * `createElement` or a factory, use `ClassAttributes<T>`:
  *
  * ```ts
  * var b: Button | null;
  * var props: ButtonProps & ClassAttributes<Button> = {
  *     ref: b => button = b, // ok!
  *     label: "I'm a Button"
  * };
  * ```
  */
@js.native
trait Props[T] extends js.Object {
  var children: js.UndefOr[ReactNode] = js.native
  var key: js.UndefOr[Key] = js.native
  var ref: js.UndefOr[LegacyRef[T]] = js.native
}

object Props {
  @scala.inline
  def apply[T](children: ReactNode = null, key: Key = null, ref: LegacyRef[T] = null): Props[T] = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
    __obj.asInstanceOf[Props[T]]
  }
  @scala.inline
  implicit class PropsOps[Self[t] <: Props[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withChildren(children: ReactNode): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (children != null) ret.updateDynamic("children")(children.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutChildren: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "children")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withKey(key: Key): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (key != null) ret.updateDynamic("key")(key.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutKey: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "key")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRefFunction1(ref: /* instance */ T | Null => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("ref")(js.Any.fromFunction1(ref))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withRef(ref: LegacyRef[T]): Self[T] = {
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

