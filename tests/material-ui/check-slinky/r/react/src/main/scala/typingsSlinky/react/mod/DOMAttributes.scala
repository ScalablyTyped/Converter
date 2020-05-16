package typingsSlinky.react.mod

import slinky.core.TagMod
import typingsSlinky.react.AnonHtml
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait DOMAttributes[T] extends js.Object {
  var children: js.UndefOr[TagMod[Any]] = js.native
  var dangerouslySetInnerHTML: js.UndefOr[AnonHtml] = js.native
  var onClick: js.UndefOr[Double | (js.Function1[/* x */ String, Unit])] = js.native
}

object DOMAttributes {
  @scala.inline
  def apply[T](
    children: TagMod[Any] = null,
    dangerouslySetInnerHTML: AnonHtml = null,
    onClick: Double | (js.Function1[/* x */ String, Unit]) = null
  ): DOMAttributes[T] = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (dangerouslySetInnerHTML != null) __obj.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
    if (onClick != null) __obj.updateDynamic("onClick")(onClick.asInstanceOf[js.Any])
    __obj.asInstanceOf[DOMAttributes[T]]
  }
  @scala.inline
  implicit class DOMAttributesOps[Self[t] <: DOMAttributes[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withChildren(children: TagMod[Any]): Self[T] = {
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
    def withDangerouslySetInnerHTML(dangerouslySetInnerHTML: AnonHtml): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (dangerouslySetInnerHTML != null) ret.updateDynamic("dangerouslySetInnerHTML")(dangerouslySetInnerHTML.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutDangerouslySetInnerHTML: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "dangerouslySetInnerHTML")
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnClickFunction1(onClick: /* x */ String => Unit): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("onClick")(js.Any.fromFunction1(onClick))
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withOnClick(onClick: Double | (js.Function1[/* x */ String, Unit])): Self[T] = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onClick != null) ret.updateDynamic("onClick")(onClick.asInstanceOf[js.Any])
        ret.asInstanceOf[Self[T]]
    }
    @scala.inline
    def withoutOnClick: Self[T] = {
        val ret = this.duplicate
        js.special.delete(ret, "onClick")
        ret.asInstanceOf[Self[T]]
    }
  }
  
}

