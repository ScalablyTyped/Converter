package typings.node.streamMod

import typings.node.Error
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ReadableOptions extends js.Object {
  var destroy: js.UndefOr[js.Function1[/* error */ js.UndefOr[Error], _]] = js.native
  var encoding: js.UndefOr[String] = js.native
  var highWaterMark: js.UndefOr[Double] = js.native
  var objectMode: js.UndefOr[Boolean] = js.native
  var read: js.UndefOr[js.ThisFunction1[/* this */ Readable, /* size */ js.UndefOr[Double], _]] = js.native
}

object ReadableOptions {
  @scala.inline
  def apply(
    destroy: /* error */ js.UndefOr[Error] => _ = null,
    encoding: String = null,
    highWaterMark: Int | Double = null,
    objectMode: js.UndefOr[Boolean] = js.undefined,
    read: js.ThisFunction1[/* this */ Readable, /* size */ js.UndefOr[Double], _] = null
  ): ReadableOptions = {
    val __obj = js.Dynamic.literal()
    if (destroy != null) __obj.updateDynamic("destroy")(js.Any.fromFunction1(destroy))
    if (encoding != null) __obj.updateDynamic("encoding")(encoding.asInstanceOf[js.Any])
    if (highWaterMark != null) __obj.updateDynamic("highWaterMark")(highWaterMark.asInstanceOf[js.Any])
    if (!js.isUndefined(objectMode)) __obj.updateDynamic("objectMode")(objectMode.asInstanceOf[js.Any])
    if (read != null) __obj.updateDynamic("read")(read.asInstanceOf[js.Any])
    __obj.asInstanceOf[ReadableOptions]
  }
  @scala.inline
  implicit class ReadableOptionsOps[Self <: ReadableOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withDestroy(destroy: /* error */ js.UndefOr[Error] => _): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (destroy != null) ret.updateDynamic("destroy")(js.Any.fromFunction1(destroy))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutDestroy: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "destroy")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withEncoding(encoding: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (encoding != null) ret.updateDynamic("encoding")(encoding.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutEncoding: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "encoding")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withHighWaterMark(highWaterMark: Int | Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (highWaterMark != null) ret.updateDynamic("highWaterMark")(highWaterMark.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutHighWaterMark: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "highWaterMark")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withObjectMode(objectMode: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(objectMode)) ret.updateDynamic("objectMode")(objectMode.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutObjectMode: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "objectMode")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withRead(read: js.ThisFunction1[/* this */ Readable, /* size */ js.UndefOr[Double], _]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (read != null) ret.updateDynamic("read")(read.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutRead: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "read")
        ret.asInstanceOf[Self]
    }
  }
  
}

