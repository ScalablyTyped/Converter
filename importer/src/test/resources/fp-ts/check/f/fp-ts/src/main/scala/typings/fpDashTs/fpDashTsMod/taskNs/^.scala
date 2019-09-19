package typings.fpDashTs.fpDashTsMod.taskNs

import typings.fpDashTs.libEitherMod.Either
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("fp-ts", "task")
@js.native
object ^ extends js.Object {
  def tryCatch[L, A](f: js.Any, onrejected: js.Function1[/* reason */ js.Object, L]): Either[L, A] = js.native
}

