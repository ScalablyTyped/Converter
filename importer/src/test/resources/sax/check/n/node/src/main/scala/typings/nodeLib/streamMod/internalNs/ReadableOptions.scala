package typings
package nodeLib.streamMod.internalNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ReadableOptions extends js.Object {
  var destroy: js.UndefOr[js.Function1[/* error */ js.UndefOr[nodeLib.Error], _]] = js.undefined
  var encoding: js.UndefOr[java.lang.String] = js.undefined
  var highWaterMark: js.UndefOr[scala.Double] = js.undefined
  var objectMode: js.UndefOr[scala.Boolean] = js.undefined
  var read: js.UndefOr[js.ThisFunction1[/* this */ Readable, /* size */ js.UndefOr[scala.Double], _]] = js.undefined
}

object ReadableOptions {
  @scala.inline
  def apply(
    destroy: /* error */ js.UndefOr[nodeLib.Error] => _ = null,
    encoding: java.lang.String = null,
    highWaterMark: scala.Int | scala.Double = null,
    objectMode: js.UndefOr[scala.Boolean] = js.undefined,
    read: js.ThisFunction1[/* this */ Readable, /* size */ js.UndefOr[scala.Double], _] = null
  ): ReadableOptions = {
    val __obj = js.Dynamic.literal()
    if (destroy != null) __obj.updateDynamic("destroy")(js.Any.fromFunction1(destroy))
    if (encoding != null) __obj.updateDynamic("encoding")(encoding)
    if (highWaterMark != null) __obj.updateDynamic("highWaterMark")(highWaterMark.asInstanceOf[js.Any])
    if (!js.isUndefined(objectMode)) __obj.updateDynamic("objectMode")(objectMode)
    if (read != null) __obj.updateDynamic("read")(read)
    __obj.asInstanceOf[ReadableOptions]
  }
}

