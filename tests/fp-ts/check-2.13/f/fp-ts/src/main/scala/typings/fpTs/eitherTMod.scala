package typings.fpTs

import typings.fpTs.eitherMod.Either
import typings.fpTs.eitherMod.URI
import typings.fpTs.hktMod.HKT
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object eitherTMod {
  
  @js.native
  trait EitherT[F]
    extends StObject
       with Foo[F, URI] {
    
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
    implicit class EitherTMutableBuilder[Self <: EitherT[_], F] (val x: Self with EitherT[F]) extends AnyVal {
      
      @scala.inline
      def setChain(
        value: (js.Function1[js.Any, HKT[F, Either[js.Any, js.Any]]], HKT[F, Either[js.Any, js.Any]]) => HKT[F, Either[js.Any, js.Any]]
      ): Self = StObject.set(x, "chain", js.Any.fromFunction2(value))
    }
  }
  
  @js.native
  trait Foo[T, U] extends StObject
}
