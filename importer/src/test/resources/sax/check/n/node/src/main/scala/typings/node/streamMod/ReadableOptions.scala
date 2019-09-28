package typings.node.streamMod

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.node.Error
import scala.scalajs.js
import scala.scalajs.js.`|`

trait ReadableOptions extends js.Object {
  var destroy: js.UndefOr[js.Function1[/* error */ js.UndefOr[Error], _]] = js.undefined
  var encoding: js.UndefOr[String] = js.undefined
  var highWaterMark: js.UndefOr[Double] = js.undefined
  var objectMode: js.UndefOr[Boolean] = js.undefined
  var read: js.UndefOr[js.ThisFunction1[/* this */ Readable, /* size */ js.UndefOr[Double], _]] = js.undefined
}

object ReadableOptions {
  @inline
  def apply(
    destroy: /* error */ js.UndefOr[Error] => _ = null,
    encoding: String = null,
    highWaterMark: Int | Double = null,
    objectMode: js.UndefOr[Boolean] = js.undefined,
    read: js.ThisFunction1[/* this */ Readable, /* size */ js.UndefOr[Double], _] = null
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

