package typings.fpTs.mod.lib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("fp-ts/lib/Task", JSImport.Namespace)
@js.native
object Task extends js.Object {
  def tryCatch[L, A](f: js.Any, onrejected: js.Function1[/* reason */ js.Object, L]): typings.fpTs.mod.lib.Either.Either[L, A] = js.native
}

