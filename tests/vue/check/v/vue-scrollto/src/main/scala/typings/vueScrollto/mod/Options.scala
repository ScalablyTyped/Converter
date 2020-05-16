package typings.vueScrollto.mod

import typings.std.Element
import typings.vueScrollto.vueScrolltoBooleans.`false`
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Options extends js.Object {
  // Indicates if user can cancel the scroll or not. Default: true
  var cancelable: js.UndefOr[Boolean] = js.native
  // The container that has to be scrolled. Default: body
  var container: js.UndefOr[String | Element] = js.native
  // The duration (in milliseconds) of the scrolling animation. Default: 500
  var duration: js.UndefOr[Double] = js.native
  // The easing to be used when animating. Default: ease
  var easing: js.UndefOr[String] = js.native
  // The element you want to scroll to.
  var el: js.UndefOr[String | Element] = js.native
  var element: js.UndefOr[String | Element] = js.native
  // The offset that should be applied when scrolling. Default: 0
  var offset: js.UndefOr[Double] = js.native
  // A callback function that should be called when scrolling has been aborted by the user (user scrolled, clicked
  // etc.). Default: noop
  var onCancel: js.UndefOr[js.Function0[Unit] | `false`] = js.native
  // A callback function that should be called when scrolling has ended. Default: noop
  var onDone: js.UndefOr[js.Function0[Unit] | `false`] = js.native
  // Whether or not we want scrolling on the x axis. Default: true
  var x: js.UndefOr[Boolean] = js.native
  // Whether or not we want scrolling on the y axis. Default: true
  var y: js.UndefOr[Boolean] = js.native
}

object Options {
  @scala.inline
  def apply(
    cancelable: js.UndefOr[Boolean] = js.undefined,
    container: String | Element = null,
    duration: Int | Double = null,
    easing: String = null,
    el: String | Element = null,
    element: String | Element = null,
    offset: Int | Double = null,
    onCancel: js.Function0[Unit] | `false` = null,
    onDone: js.Function0[Unit] | `false` = null,
    x: js.UndefOr[Boolean] = js.undefined,
    y: js.UndefOr[Boolean] = js.undefined
  ): Options = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(cancelable)) __obj.updateDynamic("cancelable")(cancelable.asInstanceOf[js.Any])
    if (container != null) __obj.updateDynamic("container")(container.asInstanceOf[js.Any])
    if (duration != null) __obj.updateDynamic("duration")(duration.asInstanceOf[js.Any])
    if (easing != null) __obj.updateDynamic("easing")(easing.asInstanceOf[js.Any])
    if (el != null) __obj.updateDynamic("el")(el.asInstanceOf[js.Any])
    if (element != null) __obj.updateDynamic("element")(element.asInstanceOf[js.Any])
    if (offset != null) __obj.updateDynamic("offset")(offset.asInstanceOf[js.Any])
    if (onCancel != null) __obj.updateDynamic("onCancel")(onCancel.asInstanceOf[js.Any])
    if (onDone != null) __obj.updateDynamic("onDone")(onDone.asInstanceOf[js.Any])
    if (!js.isUndefined(x)) __obj.updateDynamic("x")(x.asInstanceOf[js.Any])
    if (!js.isUndefined(y)) __obj.updateDynamic("y")(y.asInstanceOf[js.Any])
    __obj.asInstanceOf[Options]
  }
  @scala.inline
  implicit class OptionsOps[Self <: Options] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withCancelable(cancelable: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(cancelable)) ret.updateDynamic("cancelable")(cancelable.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutCancelable: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "cancelable")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withContainer(container: String | Element): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (container != null) ret.updateDynamic("container")(container.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutContainer: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "container")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withDuration(duration: Int | Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (duration != null) ret.updateDynamic("duration")(duration.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutDuration: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "duration")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withEasing(easing: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (easing != null) ret.updateDynamic("easing")(easing.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutEasing: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "easing")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withEl(el: String | Element): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (el != null) ret.updateDynamic("el")(el.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutEl: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "el")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withElement(element: String | Element): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (element != null) ret.updateDynamic("element")(element.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutElement: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "element")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOffset(offset: Int | Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (offset != null) ret.updateDynamic("offset")(offset.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOffset: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "offset")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnCancelFunction0(onCancel: () => Unit): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("onCancel")(js.Any.fromFunction0(onCancel))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnCancel(onCancel: js.Function0[Unit] | `false`): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onCancel != null) ret.updateDynamic("onCancel")(onCancel.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOnCancel: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "onCancel")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnDoneFunction0(onDone: () => Unit): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("onDone")(js.Any.fromFunction0(onDone))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOnDone(onDone: js.Function0[Unit] | `false`): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (onDone != null) ret.updateDynamic("onDone")(onDone.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOnDone: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "onDone")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withX(x: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(x)) ret.updateDynamic("x")(x.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutX: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "x")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withY(y: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(y)) ret.updateDynamic("y")(y.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutY: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "y")
        ret.asInstanceOf[Self]
    }
  }
  
}

