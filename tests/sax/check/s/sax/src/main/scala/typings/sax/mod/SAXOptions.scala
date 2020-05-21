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
  def apply(
    lowercase: js.UndefOr[Boolean] = js.undefined,
    normalize: js.UndefOr[Boolean] = js.undefined,
    noscript: js.UndefOr[Boolean] = js.undefined,
    position: js.UndefOr[Boolean] = js.undefined,
    trim: js.UndefOr[Boolean] = js.undefined,
    xmlns: js.UndefOr[Boolean] = js.undefined
  ): SAXOptions = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(lowercase)) __obj.updateDynamic("lowercase")(lowercase.asInstanceOf[js.Any])
    if (!js.isUndefined(normalize)) __obj.updateDynamic("normalize")(normalize.asInstanceOf[js.Any])
    if (!js.isUndefined(noscript)) __obj.updateDynamic("noscript")(noscript.asInstanceOf[js.Any])
    if (!js.isUndefined(position)) __obj.updateDynamic("position")(position.asInstanceOf[js.Any])
    if (!js.isUndefined(trim)) __obj.updateDynamic("trim")(trim.asInstanceOf[js.Any])
    if (!js.isUndefined(xmlns)) __obj.updateDynamic("xmlns")(xmlns.asInstanceOf[js.Any])
    __obj.asInstanceOf[SAXOptions]
  }
  @scala.inline
  implicit class SAXOptionsOps[Self <: SAXOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withLowercase(lowercase: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(lowercase)) ret.updateDynamic("lowercase")(lowercase.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutLowercase: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "lowercase")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withNormalize(normalize: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(normalize)) ret.updateDynamic("normalize")(normalize.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutNormalize: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "normalize")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withNoscript(noscript: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(noscript)) ret.updateDynamic("noscript")(noscript.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutNoscript: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "noscript")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withPosition(position: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(position)) ret.updateDynamic("position")(position.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutPosition: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "position")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withTrim(trim: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(trim)) ret.updateDynamic("trim")(trim.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutTrim: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "trim")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withXmlns(xmlns: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(xmlns)) ret.updateDynamic("xmlns")(xmlns.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutXmlns: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "xmlns")
        ret.asInstanceOf[Self]
    }
  }
  
}

