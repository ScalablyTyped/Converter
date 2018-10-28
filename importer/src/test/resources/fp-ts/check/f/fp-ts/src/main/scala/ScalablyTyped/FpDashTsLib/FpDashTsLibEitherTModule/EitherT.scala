package ScalablyTyped
package FpDashTsLib.FpDashTsLibEitherTModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait EitherT[F]
  extends Foo[F, FpDashTsLib.FpDashTsLibEitherModule.URI] {
  def chain[L, A, B](
    f: js.Function1[
      /* a */ A, 
      FpDashTsLib.FpDashTsLibHKTModule.HKT[F, FpDashTsLib.FpDashTsLibEitherModule.Either[L, B]]
    ],
    fa: FpDashTsLib.FpDashTsLibHKTModule.HKT[F, FpDashTsLib.FpDashTsLibEitherModule.Either[L, A]]
  ): FpDashTsLib.FpDashTsLibHKTModule.HKT[F, FpDashTsLib.FpDashTsLibEitherModule.Either[L, B]]
}

