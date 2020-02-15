package org.scalablytyped.converter.internal.ts.parser

import scala.language.implicitConversions
import scala.util.parsing.combinator.{ImplicitConversions, Parsers}

trait ImplicitConversions1 extends ImplicitConversions { self: Parsers =>

  @inline implicit final def flatten6[A, B, C, D, E, F, G](
      g: (A, B, C, D, E, F) => G,
  ): (((((A ~ B) ~ C) ~ D) ~ E) ~ F) => G = {
    case a ~ b ~ c ~ d ~ e ~ f => g(a, b, c, d, e, f)
  }

  @inline implicit final def flatten7[A, B, C, D, E, F, G, H](
      h: (A, B, C, D, E, F, G) => H,
  ): (((((A ~ B) ~ C) ~ D) ~ E) ~ F ~ G) => H = {
    case a ~ b ~ c ~ d ~ e ~ f ~ g => h(a, b, c, d, e, f, g)
  }

  @inline implicit final def flatten8[A, B, C, D, E, F, G, H, I](
      i: (A, B, C, D, E, F, G, H) => I,
  ): A ~ B ~ C ~ D ~ E ~ F ~ G ~ H => I = {
    case a ~ b ~ c ~ d ~ e ~ f ~ g ~ h => i(a, b, c, d, e, f, g, h)
  }

  @inline implicit final def flatten9[A, B, C, D, E, F, G, H, I, J](
      j: (A, B, C, D, E, F, G, H, I) => J,
  ): A ~ B ~ C ~ D ~ E ~ F ~ G ~ H ~ I => J = {
    case a ~ b ~ c ~ d ~ e ~ f ~ g ~ h ~ i => j(a, b, c, d, e, f, g, h, i)
  }
}
