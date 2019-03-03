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

object EitherT {
  @scala.inline
  def apply[F](
    chain: (js.Function1[
      js.Any, 
      fpDashTsLib.libHKTMod.HKT[F, fpDashTsLib.libEitherMod.Either[js.Any, js.Any]]
    ], fpDashTsLib.libHKTMod.HKT[F, fpDashTsLib.libEitherMod.Either[js.Any, js.Any]]) => fpDashTsLib.libHKTMod.HKT[F, fpDashTsLib.libEitherMod.Either[js.Any, js.Any]]
  ): EitherT[F] = {
    val __obj = js.Dynamic.literal(chain = js.Any.fromFunction2(chain))
  
    __obj.asInstanceOf[EitherT[F]]
  }
}

