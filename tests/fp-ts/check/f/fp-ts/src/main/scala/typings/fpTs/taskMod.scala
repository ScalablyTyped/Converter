package typings.fpTs

import typings.fpTs.eitherMod.Either
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("fp-ts/lib/Task", JSImport.Namespace)
@js.native
object taskMod extends js.Object {
  def tryCatch[L, A](f: js.Any, onrejected: js.Function1[/* reason */ js.Object, L]): Either[L, A] = js.native
}

