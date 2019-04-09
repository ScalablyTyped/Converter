package typings
package nodeLib.streamMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait DuplexOptions
  extends ReadableOptions
     with WritableOptions {
  var allowHalfOpen: js.UndefOr[scala.Boolean] = js.undefined
}

object DuplexOptions {
  @scala.inline
  def apply(
    allowHalfOpen: js.UndefOr[scala.Boolean] = js.undefined,
    destroy: /* error */ js.UndefOr[nodeLib.Error] => _ = null,
    encoding: java.lang.String = null,
    `final`: /* callback */ js.Function1[/* error */ js.UndefOr[nodeLib.Error], scala.Unit] => scala.Unit = null,
    highWaterMark: scala.Int | scala.Double = null,
    objectMode: js.UndefOr[scala.Boolean] = js.undefined,
    read: js.ThisFunction1[/* this */ Readable, /* size */ js.UndefOr[scala.Double], _] = null
  ): DuplexOptions = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(allowHalfOpen)) __obj.updateDynamic("allowHalfOpen")(allowHalfOpen)
    if (destroy != null) __obj.updateDynamic("destroy")(js.Any.fromFunction1(destroy))
    if (encoding != null) __obj.updateDynamic("encoding")(encoding)
    if (`final` != null) __obj.updateDynamic("final")(js.Any.fromFunction1(`final`))
    if (highWaterMark != null) __obj.updateDynamic("highWaterMark")(highWaterMark.asInstanceOf[js.Any])
    if (!js.isUndefined(objectMode)) __obj.updateDynamic("objectMode")(objectMode)
    if (read != null) __obj.updateDynamic("read")(read)
    __obj.asInstanceOf[DuplexOptions]
  }
}

