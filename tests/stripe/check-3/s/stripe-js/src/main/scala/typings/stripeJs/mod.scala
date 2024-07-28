package typings.stripeJs

import typings.stripeJs.distStripeJsStripeMod.Stripe
import typings.stripeJs.distStripeJsStripeMod.StripeConstructor
import typings.stripeJs.distStripeJsStripeMod.StripeConstructorOptions
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("stripe-js", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  inline def loadStripe(publishableKey: String): js.Promise[Stripe | Null] = ^.asInstanceOf[js.Dynamic].applyDynamic("loadStripe")(publishableKey.asInstanceOf[js.Any]).asInstanceOf[js.Promise[Stripe | Null]]
  inline def loadStripe(publishableKey: String, options: StripeConstructorOptions): js.Promise[Stripe | Null] = (^.asInstanceOf[js.Dynamic].applyDynamic("loadStripe")(publishableKey.asInstanceOf[js.Any], options.asInstanceOf[js.Any])).asInstanceOf[js.Promise[Stripe | Null]]
  
  object global {
    
    trait Window extends StObject {
      
      // Stripe.js must be loaded directly from https://js.stripe.com/v3, which
      // places a `Stripe` object on the window
      var Stripe: js.UndefOr[StripeConstructor] = js.undefined
    }
    object Window {
      
      inline def apply(): Window = {
        val __obj = js.Dynamic.literal()
        __obj.asInstanceOf[Window]
      }
      
      @scala.inline
      implicit open class MutableBuilder[Self <: Window] (val x: Self) extends AnyVal {
        
        inline def setStripe(value: (/* publishableKey */ String, /* options */ js.UndefOr[StripeConstructorOptions]) => Stripe): Self = StObject.set(x, "Stripe", js.Any.fromFunction2(value))
        
        inline def setStripeUndefined: Self = StObject.set(x, "Stripe", js.undefined)
      }
    }
  }
}
