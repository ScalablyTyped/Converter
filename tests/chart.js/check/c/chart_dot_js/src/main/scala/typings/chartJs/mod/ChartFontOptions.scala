package typings.chartJs.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ChartFontOptions extends js.Object {
  var foo: Boolean = js.native
}

object ChartFontOptions {
  @scala.inline
  def apply(foo: Boolean): ChartFontOptions = {
    val __obj = js.Dynamic.literal(foo = foo.asInstanceOf[js.Any])
    __obj.asInstanceOf[ChartFontOptions]
  }
  @scala.inline
  implicit class ChartFontOptionsOps[Self <: ChartFontOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withFoo(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("foo")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}

