package typings
package rxjsLib.internalSubscriptionMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("rxjs/internal/Subscription", "Subscription")
@js.native
class Subscription ()
  extends rxjsLib.internalTypesMod.SubscriptionLike {
  /**
       * @param {function(): void} [unsubscribe] A function describing how to
       * perform the disposal of resources when the `unsubscribe` method is called.
       */
  def this(unsubscribe: js.Function0[scala.Unit]) = this()
  /** @internal */
  var _subscriptions: js.Any = js.native
  /* CompleteClass */
  override val closed: scala.Boolean = js.native
  /* CompleteClass */
  override def unsubscribe(): scala.Unit = js.native
}

@JSImport("rxjs/internal/Subscription", "Subscription")
@js.native
object Subscription extends js.Object {
  /** @nocollapse */
  var EMPTY: rxjsLib.internalSubscriptionMod.Subscription = js.native
}

