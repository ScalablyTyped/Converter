package typings.node.streamMod

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.node.Error
import scala.scalajs.js
import scala.scalajs.js.`|`

trait DuplexOptions
  extends ReadableOptions
     with WritableOptions {
  var allowHalfOpen: js.UndefOr[Boolean] = js.undefined
}

object DuplexOptions {
  @inline
  def apply(
    allowHalfOpen: js.UndefOr[Boolean] = js.undefined,
    destroy: /* error */ js.UndefOr[Error] => _ = null,
    encoding: String = null,
    `final`: /* callback */ js.Function1[/* error */ js.UndefOr[Error], Unit] => Unit = null,
    highWaterMark: Int | Double = null,
    objectMode: js.UndefOr[Boolean] = js.undefined,
    read: js.ThisFunction1[/* this */ Readable, /* size */ js.UndefOr[Double], _] = null
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

