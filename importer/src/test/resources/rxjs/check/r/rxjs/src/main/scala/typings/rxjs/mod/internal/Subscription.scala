package typings.rxjs.mod.internal

import typings.rxjs.mod.internal.types.SubscriptionLike
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("rxjs/internal/Subscription", JSImport.Namespace)
@js.native
object Subscription extends js.Object {
  @js.native
  /**
    * @param {function(): void} [unsubscribe] A function describing how to
    * perform the disposal of resources when the `unsubscribe` method is called.
    */
  class Subscription () extends SubscriptionLike {
    def this(unsubscribe: js.Function0[Unit]) = this()
    /** @internal */
    var _subscriptions: js.Any = js.native
    /* CompleteClass */
    override val closed: Boolean = js.native
    /* CompleteClass */
    override def unsubscribe(): Unit = js.native
  }
  
  /* static members */
  @js.native
  object Subscription extends js.Object {
    /** @nocollapse */
    var EMPTY: typings.rxjs.mod.internal.Subscription.Subscription = js.native
  }
  
}

