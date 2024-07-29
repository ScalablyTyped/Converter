package typings.stripeJs

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object distStripeJsStripeMod {
  
  trait Stripe extends StObject {
    
    def foo(): Unit
  }
  object Stripe {
    
    inline def apply(foo: () => Unit): Stripe = {
      val __obj = js.Dynamic.literal(foo = js.Any.fromFunction0(foo))
      __obj.asInstanceOf[Stripe]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Stripe] (val x: Self) extends AnyVal {
      
      inline def setFoo(value: () => Unit): Self = StObject.set(x, "foo", js.Any.fromFunction0(value))
    }
  }
  
  type StripeConstructor = js.Function2[
    /* publishableKey */ String, 
    /* options */ js.UndefOr[StripeConstructorOptions], 
    Stripe
  ]
  
  trait StripeConstructorOptions extends StObject {
    
    /**
      * Override your account's [API version](https://stripe.com/docs/api/versioning).
      */
    var apiVersion: js.UndefOr[String] = js.undefined
    
    /**
      * Opt-in to prerelease Stripe.js features by passing `betas` when instantiating a `Stripe` object.
      *
      * Supported values for the `betas` option can be found in integration guides for prerelease features.
      * Most users of Stripe.js do not pass this option.
      */
    var betas: js.UndefOr[js.Array[String]] = js.undefined
    
    /**
      * The [IETF language tag](https://en.wikipedia.org/wiki/IETF_language_tag) used to globally configure localization in Stripe.js.
      * Setting the locale here will localize error strings for all Stripe.js methods.
      * It will also configure the locale for [Elements](#element_mount) and [Checkout](https://stripe.com/docs/js/checkout/redirect_to_checkout). Default is `auto` (Stripe detects the locale of the browser).
      *
      * Supported values depend on which features you are using.
      * Checkout supports a slightly different set of locales than the rest of Stripe.js.
      * If you are planning on using Checkout, make sure to use a [value](#checkout_redirect_to_checkout-options-locale) that it supports.
      */
    var locale: js.UndefOr[String] = js.undefined
    
    /**
      * For usage with [Connect](https://stripe.com/docs/connect) only.
      * Specifying a connected account ID (e.g., `acct_24BFMpJ1svR5A89k`) allows you to perform actions on behalf of that account.
      */
    var stripeAccount: js.UndefOr[String] = js.undefined
  }
  object StripeConstructorOptions {
    
    inline def apply(): StripeConstructorOptions = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[StripeConstructorOptions]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: StripeConstructorOptions] (val x: Self) extends AnyVal {
      
      inline def setApiVersion(value: String): Self = StObject.set(x, "apiVersion", value.asInstanceOf[js.Any])
      
      inline def setApiVersionUndefined: Self = StObject.set(x, "apiVersion", js.undefined)
      
      inline def setBetas(value: js.Array[String]): Self = StObject.set(x, "betas", value.asInstanceOf[js.Any])
      
      inline def setBetasUndefined: Self = StObject.set(x, "betas", js.undefined)
      
      inline def setBetasVarargs(value: String*): Self = StObject.set(x, "betas", js.Array(value*))
      
      inline def setLocale(value: String): Self = StObject.set(x, "locale", value.asInstanceOf[js.Any])
      
      inline def setLocaleUndefined: Self = StObject.set(x, "locale", js.undefined)
      
      inline def setStripeAccount(value: String): Self = StObject.set(x, "stripeAccount", value.asInstanceOf[js.Any])
      
      inline def setStripeAccountUndefined: Self = StObject.set(x, "stripeAccount", js.undefined)
    }
  }
}
