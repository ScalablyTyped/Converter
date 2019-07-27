package typings.fpDashTs

import typings.fpDashTs.fpDashTsStrings.Either
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("fp-ts", JSImport.Namespace)
@js.native
object fpDashTsMod extends js.Object {
  @JSName("either")
  @js.native
  object eitherNs extends js.Object {
    val URI: Either = js.native
  }
  
  @JSName("task")
  @js.native
  object taskNs extends js.Object {
    def tryCatch[L, A](f: js.Any, onrejected: js.Function1[/* reason */ js.Object, L]): typings.fpDashTs.libEitherMod.Either[L, A] = js.native
  }
  
}

