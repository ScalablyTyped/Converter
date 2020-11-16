package typings.rxjs

import typings.rxjs.typesMod.SubscriptionLike
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("rxjs/internal/Subscription", JSImport.Namespace)
@js.native
object subscriptionMod extends js.Object {
  
  @js.native
  /**
    * @param {function(): void} [unsubscribe] A function describing how to
    * perform the disposal of resources when the `unsubscribe` method is called.
    */
  class Subscription () extends SubscriptionLike {
    def this(unsubscribe: js.Function0[Unit]) = this()
    
    /** @internal */
    var _subscriptions: js.Any = js.native
  }
  /* static members */
  @js.native
  object Subscription extends js.Object {
    
    /** @nocollapse */
    var EMPTY: Subscription = js.native
  }
}
