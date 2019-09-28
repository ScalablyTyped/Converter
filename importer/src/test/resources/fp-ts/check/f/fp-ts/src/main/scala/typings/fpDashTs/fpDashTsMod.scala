package typings.fpDashTs

import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.annotation.JSImport.Namespace
import typings.fpDashTs.fpDashTsStrings.Either
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSImport("fp-ts", Namespace)
@js.native
object fpDashTsMod extends js.Object {
  @js.native
  object either extends js.Object {
    val URI: Either = js.native
  }
  
  @js.native
  object task extends js.Object {
    def tryCatch[L, A](f: js.Any, onrejected: js.Function1[/* reason */ js.Object, L]): typings.fpDashTs.libEitherMod.Either[L, A] = js.native
  }
  
}

