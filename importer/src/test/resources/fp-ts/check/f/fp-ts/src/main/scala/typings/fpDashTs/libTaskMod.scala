package typings.fpDashTs

import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.annotation.JSImport.Namespace
import typings.fpDashTs.libEitherMod.Either
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSImport("fp-ts/lib/Task", Namespace)
@js.native
object libTaskMod extends js.Object {
  def tryCatch[L, A](f: js.Any, onrejected: js.Function1[/* reason */ js.Object, L]): Either[L, A] = js.native
}

