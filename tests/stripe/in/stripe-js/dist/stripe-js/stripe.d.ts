export interface Stripe {
  foo(): void
}

export interface StripeConstructor {
  (
    /**
     * Your publishable key.
     */
    publishableKey: string,

    /**
     * Initialization options.
     */
    options?: StripeConstructorOptions
  ): Stripe;
}

export interface StripeConstructorOptions {
  /**
   * For usage with [Connect](https://stripe.com/docs/connect) only.
   * Specifying a connected account ID (e.g., `acct_24BFMpJ1svR5A89k`) allows you to perform actions on behalf of that account.
   */
  stripeAccount?: string;

  /**
   * Override your account's [API version](https://stripe.com/docs/api/versioning).
   */
  apiVersion?: string;

  /**
   * The [IETF language tag](https://en.wikipedia.org/wiki/IETF_language_tag) used to globally configure localization in Stripe.js.
   * Setting the locale here will localize error strings for all Stripe.js methods.
   * It will also configure the locale for [Elements](#element_mount) and [Checkout](https://stripe.com/docs/js/checkout/redirect_to_checkout). Default is `auto` (Stripe detects the locale of the browser).
   *
   * Supported values depend on which features you are using.
   * Checkout supports a slightly different set of locales than the rest of Stripe.js.
   * If you are planning on using Checkout, make sure to use a [value](#checkout_redirect_to_checkout-options-locale) that it supports.
   */
  locale?: string;

  /**
   * Opt-in to prerelease Stripe.js features by passing `betas` when instantiating a `Stripe` object.
   *
   * Supported values for the `betas` option can be found in integration guides for prerelease features.
   * Most users of Stripe.js do not pass this option.
   */
  betas?: string[];
}
