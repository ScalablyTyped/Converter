package typings.node.streamMod

import typings.node.Error
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait WritableOptions extends js.Object {
  var `final`: js.UndefOr[
    js.Function1[/* callback */ js.Function1[/* error */ js.UndefOr[Error], Unit], Unit]
  ] = js.undefined
}

object WritableOptions {
  @scala.inline
  def apply(`final`: /* callback */ js.Function1[/* error */ js.UndefOr[Error], Unit] => Unit = null): WritableOptions = {
    val __obj = js.Dynamic.literal()
    if (`final` != null) __obj.updateDynamic("final")(js.Any.fromFunction1(`final`))
    __obj.asInstanceOf[WritableOptions]
  }
}

