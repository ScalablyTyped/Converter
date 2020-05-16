package typings.electron.Electron

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Event
  extends typings.std.Event {
  var altKey: js.UndefOr[Boolean] = js.native
  var ctrlKey: js.UndefOr[Boolean] = js.native
  var metaKey: js.UndefOr[Boolean] = js.native
  var returnValue: js.Any = js.native
  var shiftKey: js.UndefOr[Boolean] = js.native
  def preventDefault(): Unit = js.native
}

object Event {
  @scala.inline
  def apply(
    preventDefault: () => Unit,
    returnValue: js.Any,
    altKey: js.UndefOr[Boolean] = js.undefined,
    ctrlKey: js.UndefOr[Boolean] = js.undefined,
    metaKey: js.UndefOr[Boolean] = js.undefined,
    shiftKey: js.UndefOr[Boolean] = js.undefined
  ): Event = {
    val __obj = js.Dynamic.literal(preventDefault = js.Any.fromFunction0(preventDefault), returnValue = returnValue.asInstanceOf[js.Any])
    if (!js.isUndefined(altKey)) __obj.updateDynamic("altKey")(altKey.asInstanceOf[js.Any])
    if (!js.isUndefined(ctrlKey)) __obj.updateDynamic("ctrlKey")(ctrlKey.asInstanceOf[js.Any])
    if (!js.isUndefined(metaKey)) __obj.updateDynamic("metaKey")(metaKey.asInstanceOf[js.Any])
    if (!js.isUndefined(shiftKey)) __obj.updateDynamic("shiftKey")(shiftKey.asInstanceOf[js.Any])
    __obj.asInstanceOf[Event]
  }
  @scala.inline
  implicit class EventOps[Self <: Event] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withPreventDefault(preventDefault: () => Unit): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("preventDefault")(js.Any.fromFunction0(preventDefault))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withReturnValue(returnValue: js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("returnValue")(returnValue.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withAltKey(altKey: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(altKey)) ret.updateDynamic("altKey")(altKey.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutAltKey: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "altKey")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withCtrlKey(ctrlKey: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(ctrlKey)) ret.updateDynamic("ctrlKey")(ctrlKey.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutCtrlKey: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "ctrlKey")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withMetaKey(metaKey: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(metaKey)) ret.updateDynamic("metaKey")(metaKey.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutMetaKey: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "metaKey")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withShiftKey(shiftKey: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(shiftKey)) ret.updateDynamic("shiftKey")(shiftKey.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutShiftKey: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "shiftKey")
        ret.asInstanceOf[Self]
    }
  }
  
}

