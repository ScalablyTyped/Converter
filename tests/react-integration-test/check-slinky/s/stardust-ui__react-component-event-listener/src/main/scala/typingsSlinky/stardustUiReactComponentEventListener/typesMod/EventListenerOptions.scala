package typingsSlinky.stardustUiReactComponentEventListener.typesMod

import slinky.core.facade.ReactRef
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait EventListenerOptions[T /* <: EventTypes */] extends js.Object {
  /** Indicating that events of this type will be dispatched to the registered listener before being dispatched to any EventTarget beneath it in the DOM tree. */
  var capture: js.UndefOr[Boolean] = js.native
  /** A function which receives a notification when an event of the specified type occurs. */
  var listener: EventHandler[T] = js.native
  /** A ref object with a target node. */
  var targetRef: ReactRef[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
  ] = js.native
  /** A case-sensitive string representing the event type to listen for. */
  var `type`: T = js.native
}

object EventListenerOptions {
  @scala.inline
  def apply[T](
    listener: /* import warning: importer.ImportType#apply Failed type conversion: / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify DocumentEventMap * / any[T] */ /* e */ js.Any => Unit,
    targetRef: ReactRef[
      /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
    ],
    `type`: T
  ): EventListenerOptions[T] = {
    val __obj = js.Dynamic.literal(listener = js.Any.fromFunction1(listener), targetRef = targetRef.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    __obj.asInstanceOf[EventListenerOptions[T]]
  }
  @scala.inline
  implicit class EventListenerOptionsOps[Self <: EventListenerOptions[_], T] (val x: Self with EventListenerOptions[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withListener(
      value: /* import warning: importer.ImportType#apply Failed type conversion: / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify DocumentEventMap * / any[T] */ /* e */ js.Any => Unit
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("listener")(js.Any.fromFunction1(value))
        ret
    }
    @scala.inline
    def withTargetRef(
      value: ReactRef[
          /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
        ]
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("targetRef")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withType(value: T): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("type")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withCapture(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("capture")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutCapture: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("capture")(js.undefined)
        ret
    }
  }
  
}

