package typings
package nodeLib.streamMod.internalNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait WritableOptions extends js.Object {
  var `final`: js.UndefOr[
    js.Function1[
      /* callback */ js.Function1[/* error */ js.UndefOr[nodeLib.Error], scala.Unit], 
      scala.Unit
    ]
  ] = js.undefined
}

object WritableOptions {
  @scala.inline
  def apply(
    `final`: /* callback */ js.Function1[/* error */ js.UndefOr[nodeLib.Error], scala.Unit] => scala.Unit = null
  ): WritableOptions = {
    val __obj = js.Dynamic.literal()
    if (`final` != null) __obj.updateDynamic("final")(js.Any.fromFunction1(`final`))
    __obj.asInstanceOf[WritableOptions]
  }
}

