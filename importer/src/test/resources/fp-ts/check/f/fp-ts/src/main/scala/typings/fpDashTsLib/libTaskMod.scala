package typings
package fpDashTsLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("fp-ts/lib/Task", JSImport.Namespace)
@js.native
object libTaskMod extends js.Object {
  val tryCatch: js.Function2[
    /* f */ js.Any, 
    /* onrejected */ js.Function1[/* reason */ js.Object, js.Any], 
    fpDashTsLib.libEitherMod.Either[js.Any, js.Any]
  ] = js.native
}

