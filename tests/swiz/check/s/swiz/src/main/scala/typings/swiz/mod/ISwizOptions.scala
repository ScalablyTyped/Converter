package typings.swiz.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ISwizOptions extends js.Object {
  var `for`: js.UndefOr[String] = js.native
  var stripNulls: js.UndefOr[Boolean] = js.native
  var stripSerializerType: js.UndefOr[Boolean] = js.native
}

object ISwizOptions {
  @scala.inline
  def apply(): ISwizOptions = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[ISwizOptions]
  }
  @scala.inline
  implicit class ISwizOptionsOps[Self <: ISwizOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withFor(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("for")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutFor: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("for")(js.undefined)
        ret
    }
    @scala.inline
    def withStripNulls(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("stripNulls")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutStripNulls: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("stripNulls")(js.undefined)
        ret
    }
    @scala.inline
    def withStripSerializerType(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("stripSerializerType")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutStripSerializerType: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("stripSerializerType")(js.undefined)
        ret
    }
  }
  
}

