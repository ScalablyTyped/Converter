package typings.fpTs

import typings.fpTs.eitherMod.Either
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  object either {
    
    @JSImport("fp-ts", "either.URI")
    @js.native
    val URI: /* "Either" */ String = js.native
  }
  
  object task {
    
    @JSImport("fp-ts", "task")
    @js.native
    val ^ : js.Any = js.native
    
    @scala.inline
    def tryCatch[L, A](f: js.Any, onrejected: js.Function1[/* reason */ js.Object, L]): Either[L, A] = (^.asInstanceOf[js.Dynamic].applyDynamic("tryCatch")(f.asInstanceOf[js.Any], onrejected.asInstanceOf[js.Any])).asInstanceOf[Either[L, A]]
  }
}
