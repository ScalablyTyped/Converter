package typingsJapgolly.stardustUiReactComponentEventListener.anon

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Capture extends js.Object {
  var capture: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Requireable<boolean> */ js.Any = js.native
  var listener: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<(args : ...any): any> */ js.Any = js.native
  var targetRef: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<imported_react.RefObject<Node | Window>> */ js.Any = js.native
  var `type`: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<'waiting' | 'error' | 'abort' | 'cancel' | 'progress' | 'ended' | 'change' | 'input' | 'select' | 'fullscreenchange' | 'fullscreenerror' | 'readystatechange' | 'visibilitychange' | 'animationcancel' | 'animationend' | 'animationiteration' | 'animationstart' | 'auxclick' | 'blur' | 'canplay' | 'canplaythrough' | 'click' | 'close' | 'contextmenu' | 'cuechange' | 'dblclick' | 'drag' | 'dragend' | 'dragenter' | 'dragexit' | 'dragleave' | 'dragover' | 'dragstart' | 'drop' | 'durationchange' | 'emptied' | 'focus' | 'gotpointercapture' | 'invalid' | 'keydown' | 'keypress' | 'keyup' | 'load' | 'loadeddata' | 'loadedmetadata' | 'loadend' | 'loadstart' | 'lostpointercapture' | 'mousedown' | 'mouseenter' | 'mouseleave' | 'mousemove' | 'mouseout' | 'mouseover' | 'mouseup' | 'pause' | 'play' | 'playing' | 'pointercancel' | 'pointerdown' | 'pointerenter' | 'pointerleave' | 'pointermove' | 'pointerout' | 'pointerover' | 'pointerup' | 'ratechange' | 'reset' | 'resize' | 'scroll' | 'securitypolicyviolation' | 'seeked' | 'seeking' | 'stalled' | 'submit' | 'suspend' | 'timeupdate' | 'toggle' | 'touchcancel' | 'touchend' | 'touchmove' | 'touchstart' | 'transitioncancel' | 'transitionend' | 'transitionrun' | 'transitionstart' | 'volumechange' | 'wheel' | 'copy' | 'cut' | 'paste'> */ js.Any = js.native
}

object Capture {
  @scala.inline
  def apply(
    capture: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Requireable<boolean> */ js.Any,
    listener: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<(args : ...any): any> */ js.Any,
    targetRef: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<imported_react.RefObject<Node | Window>> */ js.Any,
    `type`: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<'waiting' | 'error' | 'abort' | 'cancel' | 'progress' | 'ended' | 'change' | 'input' | 'select' | 'fullscreenchange' | 'fullscreenerror' | 'readystatechange' | 'visibilitychange' | 'animationcancel' | 'animationend' | 'animationiteration' | 'animationstart' | 'auxclick' | 'blur' | 'canplay' | 'canplaythrough' | 'click' | 'close' | 'contextmenu' | 'cuechange' | 'dblclick' | 'drag' | 'dragend' | 'dragenter' | 'dragexit' | 'dragleave' | 'dragover' | 'dragstart' | 'drop' | 'durationchange' | 'emptied' | 'focus' | 'gotpointercapture' | 'invalid' | 'keydown' | 'keypress' | 'keyup' | 'load' | 'loadeddata' | 'loadedmetadata' | 'loadend' | 'loadstart' | 'lostpointercapture' | 'mousedown' | 'mouseenter' | 'mouseleave' | 'mousemove' | 'mouseout' | 'mouseover' | 'mouseup' | 'pause' | 'play' | 'playing' | 'pointercancel' | 'pointerdown' | 'pointerenter' | 'pointerleave' | 'pointermove' | 'pointerout' | 'pointerover' | 'pointerup' | 'ratechange' | 'reset' | 'resize' | 'scroll' | 'securitypolicyviolation' | 'seeked' | 'seeking' | 'stalled' | 'submit' | 'suspend' | 'timeupdate' | 'toggle' | 'touchcancel' | 'touchend' | 'touchmove' | 'touchstart' | 'transitioncancel' | 'transitionend' | 'transitionrun' | 'transitionstart' | 'volumechange' | 'wheel' | 'copy' | 'cut' | 'paste'> */ js.Any
  ): Capture = {
    val __obj = js.Dynamic.literal(capture = capture.asInstanceOf[js.Any], listener = listener.asInstanceOf[js.Any], targetRef = targetRef.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[Capture]
  }
  @scala.inline
  implicit class CaptureOps[Self <: Capture] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withCapture(
      value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Requireable<boolean> */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("capture")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withListener(
      value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<(args : ...any): any> */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("listener")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withTargetRef(
      value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<imported_react.RefObject<Node | Window>> */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("targetRef")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withType(
      value: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify PropTypes.Validator<'waiting' | 'error' | 'abort' | 'cancel' | 'progress' | 'ended' | 'change' | 'input' | 'select' | 'fullscreenchange' | 'fullscreenerror' | 'readystatechange' | 'visibilitychange' | 'animationcancel' | 'animationend' | 'animationiteration' | 'animationstart' | 'auxclick' | 'blur' | 'canplay' | 'canplaythrough' | 'click' | 'close' | 'contextmenu' | 'cuechange' | 'dblclick' | 'drag' | 'dragend' | 'dragenter' | 'dragexit' | 'dragleave' | 'dragover' | 'dragstart' | 'drop' | 'durationchange' | 'emptied' | 'focus' | 'gotpointercapture' | 'invalid' | 'keydown' | 'keypress' | 'keyup' | 'load' | 'loadeddata' | 'loadedmetadata' | 'loadend' | 'loadstart' | 'lostpointercapture' | 'mousedown' | 'mouseenter' | 'mouseleave' | 'mousemove' | 'mouseout' | 'mouseover' | 'mouseup' | 'pause' | 'play' | 'playing' | 'pointercancel' | 'pointerdown' | 'pointerenter' | 'pointerleave' | 'pointermove' | 'pointerout' | 'pointerover' | 'pointerup' | 'ratechange' | 'reset' | 'resize' | 'scroll' | 'securitypolicyviolation' | 'seeked' | 'seeking' | 'stalled' | 'submit' | 'suspend' | 'timeupdate' | 'toggle' | 'touchcancel' | 'touchend' | 'touchmove' | 'touchstart' | 'transitioncancel' | 'transitionend' | 'transitionrun' | 'transitionstart' | 'volumechange' | 'wheel' | 'copy' | 'cut' | 'paste'> */ js.Any
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("type")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}
