package typings.fpTs

import typings.fpTs.eitherMod.Either
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object taskMod {
  
  @JSImport("fp-ts/lib/Task", "tryCatch")
  @js.native
  def tryCatch[L, A](f: js.Any, onrejected: js.Function1[/* reason */ js.Object, L]): Either[L, A] = js.native
}
