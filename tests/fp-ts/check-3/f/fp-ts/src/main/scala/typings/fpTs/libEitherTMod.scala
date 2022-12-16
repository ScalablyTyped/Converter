package typings.fpTs

import typings.fpTs.libEitherMod.Either
import typings.fpTs.libEitherMod.URI
import typings.fpTs.libHktMod.HKT
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object libEitherTMod {
  
  trait EitherT[F]
    extends StObject
       with Foo[F, URI] {
    
    def chain[L, A, B](f: js.Function1[/* a */ A, HKT[F, Either[L, B]]], fa: HKT[F, Either[L, A]]): HKT[F, Either[L, B]]
  }
  object EitherT {
    
    inline def apply[F](
      chain: (js.Function1[Any, HKT[F, Either[Any, Any]]], HKT[F, Either[Any, Any]]) => HKT[F, Either[Any, Any]]
    ): EitherT[F] = {
      val __obj = js.Dynamic.literal(chain = js.Any.fromFunction2(chain))
      __obj.asInstanceOf[EitherT[F]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: EitherT[?], F] (val x: Self & EitherT[F]) extends AnyVal {
      
      inline def setChain(
        value: (js.Function1[Any, HKT[F, Either[Any, Any]]], HKT[F, Either[Any, Any]]) => HKT[F, Either[Any, Any]]
      ): Self = StObject.set(x, "chain", js.Any.fromFunction2(value))
    }
  }
  
  trait Foo[T, U] extends StObject
}
