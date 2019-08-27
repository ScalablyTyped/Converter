package typings.node.streamMod

import org.scalablytyped.runtime.UndefOr
import typings.node.Error
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ReadableOptions extends js.Object {
  var destroy: UndefOr[js.Function1[UndefOr[Error], _]] = js.undefined
  var encoding: UndefOr[String] = js.undefined
  var highWaterMark: UndefOr[Double] = js.undefined
  var objectMode: UndefOr[Boolean] = js.undefined
  var read: UndefOr[js.ThisFunction1[/* this */ Readable, UndefOr[Double], _]] = js.undefined
}

object ReadableOptions {
  @scala.inline
  def apply(
    destroy: UndefOr[Error] => _ = null,
    encoding: String = null,
    highWaterMark: Int | Double = null,
    objectMode: `<undefined>` | Boolean = js.undefined,
    read: js.ThisFunction1[/* this */ Readable, UndefOr[Double], _] = null
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

