package typingsJapgolly.stardustUiReactComponentEventListener

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonListener extends js.Object {
  var capture: js.UndefOr[scala.Nothing] = js.native
  var listener: js.UndefOr[scala.Nothing] = js.native
  var targetRef: js.UndefOr[scala.Nothing] = js.native
  var `type`: js.UndefOr[scala.Nothing] = js.native
}

object AnonListener {
  @scala.inline
  def apply(
    capture: js.UndefOr[scala.Nothing] = js.undefined,
    listener: js.UndefOr[scala.Nothing] = js.undefined,
    targetRef: js.UndefOr[scala.Nothing] = js.undefined,
    `type`: js.UndefOr[scala.Nothing] = js.undefined
  ): AnonListener = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(capture)) __obj.updateDynamic("capture")(capture.asInstanceOf[js.Any])
    if (!js.isUndefined(listener)) __obj.updateDynamic("listener")(listener.asInstanceOf[js.Any])
    if (!js.isUndefined(targetRef)) __obj.updateDynamic("targetRef")(targetRef.asInstanceOf[js.Any])
    if (!js.isUndefined(`type`)) __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnonListener]
  }
  @scala.inline
  implicit class AnonListenerOps[Self <: AnonListener] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withCapture(capture: js.UndefOr[scala.Nothing]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(capture)) ret.updateDynamic("capture")(capture.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutCapture: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "capture")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withListener(listener: js.UndefOr[scala.Nothing]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(listener)) ret.updateDynamic("listener")(listener.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutListener: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "listener")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withTargetRef(targetRef: js.UndefOr[scala.Nothing]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(targetRef)) ret.updateDynamic("targetRef")(targetRef.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutTargetRef: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "targetRef")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withType(`type`: js.UndefOr[scala.Nothing]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(`type`)) ret.updateDynamic("type")(`type`.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutType: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "type")
        ret.asInstanceOf[Self]
    }
  }
  
}

