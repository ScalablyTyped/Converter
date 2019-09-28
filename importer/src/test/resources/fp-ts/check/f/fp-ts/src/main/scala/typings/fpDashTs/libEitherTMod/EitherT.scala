package typings.fpDashTs.libEitherTMod

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.fpDashTs.libEitherMod.Either
import typings.fpDashTs.libEitherMod.URI
import typings.fpDashTs.libHKTMod.HKT
import scala.scalajs.js
import scala.scalajs.js.`|`

trait EitherT[F] extends Foo[F, URI] {
  def chain[L, A, B](f: js.Function1[/* a */ A, HKT[F, Either[L, B]]], fa: HKT[F, Either[L, A]]): HKT[F, Either[L, B]]
}

object EitherT {
  @inline
  def apply[F](
    chain: (js.Function1[js.Any, HKT[F, Either[js.Any, js.Any]]], HKT[F, Either[js.Any, js.Any]]) => HKT[F, Either[js.Any, js.Any]]
  ): EitherT[F] = {
    val __obj = js.Dynamic.literal(chain = js.Any.fromFunction2(chain))
  
    __obj.asInstanceOf[EitherT[F]]
  }
}

