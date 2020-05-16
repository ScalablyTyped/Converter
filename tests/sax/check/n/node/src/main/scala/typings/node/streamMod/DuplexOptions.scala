package typings.node.streamMod

import typings.node.Error
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait DuplexOptions
  extends ReadableOptions
     with WritableOptions {
  var allowHalfOpen: js.UndefOr[Boolean] = js.native
}

object DuplexOptions {
  @scala.inline
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
    if (!js.isUndefined(allowHalfOpen)) __obj.updateDynamic("allowHalfOpen")(allowHalfOpen.asInstanceOf[js.Any])
    if (destroy != null) __obj.updateDynamic("destroy")(js.Any.fromFunction1(destroy))
    if (encoding != null) __obj.updateDynamic("encoding")(encoding.asInstanceOf[js.Any])
    if (`final` != null) __obj.updateDynamic("final")(js.Any.fromFunction1(`final`))
    if (highWaterMark != null) __obj.updateDynamic("highWaterMark")(highWaterMark.asInstanceOf[js.Any])
    if (!js.isUndefined(objectMode)) __obj.updateDynamic("objectMode")(objectMode.asInstanceOf[js.Any])
    if (read != null) __obj.updateDynamic("read")(read.asInstanceOf[js.Any])
    __obj.asInstanceOf[DuplexOptions]
  }
  @scala.inline
  implicit class DuplexOptionsOps[Self <: DuplexOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withAllowHalfOpen(allowHalfOpen: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(allowHalfOpen)) ret.updateDynamic("allowHalfOpen")(allowHalfOpen.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutAllowHalfOpen: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "allowHalfOpen")
        ret.asInstanceOf[Self]
    }
  }
  
}

