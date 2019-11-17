package typings.atStardustDashUiReactDashComponentDashEventDashListener.distEsTypesMod

import slinky.core.facade.ReactRef
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait EventListenerOptions[T /* <: EventTypes */] extends js.Object {
  /** Indicating that events of this type will be dispatched to the registered listener before being dispatched to any EventTarget beneath it in the DOM tree. */
  var capture: js.UndefOr[Boolean] = js.undefined
  /** A function which receives a notification when an event of the specified type occurs. */
  var listener: EventHandler[T]
  /** A ref object with a target node. */
  var targetRef: ReactRef[
    /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Node */ js.Any
  ]
  /** A case-sensitive string representing the event type to listen for. */
  var `type`: T
}

object EventListenerOptions {
  @scala.inline
  def apply[T /* <: EventTypes */](
    listener: /* import warning: ImportType.apply Failed type conversion: / * import warning: QualifyReferences.resolveTypeRef many Couldn't qualify DocumentEventMap * / any[T] */ /* e */ js.Any => Unit,
    targetRef: ReactRef[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Node */ js.Any
    ],
    `type`: T,
    capture: js.UndefOr[Boolean] = js.undefined
  ): EventListenerOptions[T] = {
    val __obj = js.Dynamic.literal(listener = js.Any.fromFunction1(listener), targetRef = targetRef.asInstanceOf[js.Any])
    __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
    if (!js.isUndefined(capture)) __obj.updateDynamic("capture")(capture.asInstanceOf[js.Any])
    __obj.asInstanceOf[EventListenerOptions[T]]
  }
}

