package typings.fpTs

import typings.fpTs.eitherMod.Either
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("fp-ts", JSImport.Namespace)
@js.native
object mod extends js.Object {
  @js.native
  object either extends js.Object {
    val URI: /* "Either" */ String = js.native
  }
  
  @js.native
  object task extends js.Object {
    def tryCatch[L, A](f: js.Any, onrejected: js.Function1[/* reason */ js.Object, L]): Either[L, A] = js.native
  }
  
}

