package typings
package fpDashTsLib.libEitherTMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait EitherT[F]
  extends Foo[F, fpDashTsLib.libEitherMod.URI] {
  def chain[L, A, B](
    f: js.Function1[/* a */ A, fpDashTsLib.libHKTMod.HKT[F, fpDashTsLib.libEitherMod.Either[L, B]]],
    fa: fpDashTsLib.libHKTMod.HKT[F, fpDashTsLib.libEitherMod.Either[L, A]]
  ): fpDashTsLib.libHKTMod.HKT[F, fpDashTsLib.libEitherMod.Either[L, B]]
}

