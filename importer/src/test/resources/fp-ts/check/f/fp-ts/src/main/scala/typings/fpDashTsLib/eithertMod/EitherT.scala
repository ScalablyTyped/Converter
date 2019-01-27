package typings
package fpDashTsLib.eithertMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait EitherT[F]
  extends Foo[F, fpDashTsLib.eitherMod.URI] {
  def chain[L, A, B](
    f: js.Function1[/* a */ A, fpDashTsLib.hktMod.HKT[F, fpDashTsLib.eitherMod.Either[L, B]]],
    fa: fpDashTsLib.hktMod.HKT[F, fpDashTsLib.eitherMod.Either[L, A]]
  ): fpDashTsLib.hktMod.HKT[F, fpDashTsLib.eitherMod.Either[L, B]]
}

