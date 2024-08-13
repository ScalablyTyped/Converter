package typings.stripeJs

import typings.stripeJs.anon.SetLoadParameters
import typings.stripeJs.distStripeJsStripeMod.Stripe
import typings.stripeJs.distStripeJsStripeMod.StripeConstructorOptions
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object distPureMod {
  
  @JSImport("stripe-js/dist/pure", "loadStripe")
  @js.native
  val loadStripe: (js.Function2[
    /* publishableKey */ String, 
    /* options */ js.UndefOr[StripeConstructorOptions], 
    js.Promise[Stripe | Null]
  ]) & SetLoadParameters = js.native
}
