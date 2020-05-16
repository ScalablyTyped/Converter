package typings.sax.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SAXOptions extends js.Object {
  var lowercase: js.UndefOr[Boolean] = js.native
  var normalize: js.UndefOr[Boolean] = js.native
  var noscript: js.UndefOr[Boolean] = js.native
  var position: js.UndefOr[Boolean] = js.native
  var trim: js.UndefOr[Boolean] = js.native
  var xmlns: js.UndefOr[Boolean] = js.native
}

object SAXOptions {
  @scala.inline
  def apply(): SAXOptions = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[SAXOptions]
  }
  @scala.inline
  implicit class SAXOptionsOps[Self <: SAXOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withLowercase(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("lowercase")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutLowercase: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("lowercase")(js.undefined)
        ret
    }
    @scala.inline
    def withNormalize(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("normalize")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutNormalize: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("normalize")(js.undefined)
        ret
    }
    @scala.inline
    def withNoscript(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("noscript")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutNoscript: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("noscript")(js.undefined)
        ret
    }
    @scala.inline
    def withPosition(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("position")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutPosition: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("position")(js.undefined)
        ret
    }
    @scala.inline
    def withTrim(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("trim")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutTrim: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("trim")(js.undefined)
        ret
    }
    @scala.inline
    def withXmlns(value: Boolean): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("xmlns")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutXmlns: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("xmlns")(js.undefined)
        ret
    }
  }
  
}

