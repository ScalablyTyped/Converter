package typings.stripeJs

import typings.stripeJs.distStripeJsStripeMod.Stripe
import typings.stripeJs.distStripeJsStripeMod.StripeConstructorOptions
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object distSharedMod {
  
  @JSImport("stripe-js/dist/shared", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  inline def loadStripe(publishableKey: String): js.Promise[Stripe | Null] = ^.asInstanceOf[js.Dynamic].applyDynamic("loadStripe")(publishableKey.asInstanceOf[js.Any]).asInstanceOf[js.Promise[Stripe | Null]]
  inline def loadStripe(publishableKey: String, options: StripeConstructorOptions): js.Promise[Stripe | Null] = (^.asInstanceOf[js.Dynamic].applyDynamic("loadStripe")(publishableKey.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[js.Promise[Stripe | Null]]
}
