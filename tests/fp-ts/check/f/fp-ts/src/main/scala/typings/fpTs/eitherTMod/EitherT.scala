package typings.fpTs.eitherTMod

import typings.fpTs.eitherMod.Either
import typings.fpTs.eitherMod.URI
import typings.fpTs.hktMod.HKT
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait EitherT[F] extends Foo[F, URI] {
  def chain[L, A, B](f: js.Function1[/* a */ A, HKT[F, Either[L, B]]], fa: HKT[F, Either[L, A]]): HKT[F, Either[L, B]] = js.native
}

object EitherT {
  @scala.inline
  def apply[F](
    chain: (js.Function1[js.Any, HKT[F, Either[js.Any, js.Any]]], HKT[F, Either[js.Any, js.Any]]) => HKT[F, Either[js.Any, js.Any]]
  ): EitherT[F] = {
    val __obj = js.Dynamic.literal(chain = js.Any.fromFunction2(chain))
    __obj.asInstanceOf[EitherT[F]]
  }
  @scala.inline
  implicit class EitherTOps[Self <: EitherT[_], F] (val x: Self with EitherT[F]) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setChain(
      value: (js.Function1[js.Any, HKT[F, Either[js.Any, js.Any]]], HKT[F, Either[js.Any, js.Any]]) => HKT[F, Either[js.Any, js.Any]]
    ): Self = this.set("chain", js.Any.fromFunction2(value))
  }
  
}

