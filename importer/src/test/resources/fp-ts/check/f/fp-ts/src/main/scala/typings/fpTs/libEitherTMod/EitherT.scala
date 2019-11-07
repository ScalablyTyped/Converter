package typings.fpTs.libEitherTMod

import typings.fpTs.libEitherMod.Either
import typings.fpTs.libEitherMod.URI
import typings.fpTs.libHKTMod.HKT
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait EitherT[F] extends Foo[F, URI] {
  def chain[L, A, B](f: js.Function1[/* a */ A, HKT[F, Either[L, B]]], fa: HKT[F, Either[L, A]]): HKT[F, Either[L, B]]
}

object EitherT {
  @scala.inline
  def apply[F](
    chain: (js.Function1[js.Any, HKT[F, Either[js.Any, js.Any]]], HKT[F, Either[js.Any, js.Any]]) => HKT[F, Either[js.Any, js.Any]]
  ): EitherT[F] = {
    val __obj = js.Dynamic.literal(chain = js.Any.fromFunction2(chain))
  
    __obj.asInstanceOf[EitherT[F]]
  }
}

