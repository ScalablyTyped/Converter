package typings.fpTs

import typings.fpTs.libEitherMod.Either
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object libTaskMod {
  
  @JSImport("fp-ts/lib/Task", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  inline def tryCatch[L, A](f: Any, onrejected: js.Function1[/* reason */ js.Object, L]): Either[L, A] = (^.asInstanceOf[js.Dynamic].applyDynamic("tryCatch")(f.asInstanceOf[js.Any], onrejected.asInstanceOf[js.Any])).asInstanceOf[Either[L, A]]
}
