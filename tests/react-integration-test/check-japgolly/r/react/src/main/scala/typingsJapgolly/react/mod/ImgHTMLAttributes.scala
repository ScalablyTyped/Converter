package typingsJapgolly.react.mod

import typingsJapgolly.react.reactStrings._empty
import typingsJapgolly.react.reactStrings.`use-credentials`
import typingsJapgolly.react.reactStrings.anonymous
import typingsJapgolly.react.reactStrings.async
import typingsJapgolly.react.reactStrings.auto
import typingsJapgolly.react.reactStrings.sync
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ImgHTMLAttributes[T] extends HTMLAttributes[T] {
  var alt: js.UndefOr[String] = js.native
  var crossOrigin: js.UndefOr[anonymous | `use-credentials` | _empty] = js.native
  var decoding: js.UndefOr[async | auto | sync] = js.native
  var height: js.UndefOr[Double | String] = js.native
  var sizes: js.UndefOr[String] = js.native
  var src: js.UndefOr[String] = js.native
  var srcSet: js.UndefOr[String] = js.native
  var useMap: js.UndefOr[String] = js.native
  var width: js.UndefOr[Double | String] = js.native
}

object ImgHTMLAttributes {
  @scala.inline
  def apply[T](): ImgHTMLAttributes[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[ImgHTMLAttributes[T]]
  }
  @scala.inline
  implicit class ImgHTMLAttributesOps[Self <: ImgHTMLAttributes[_], T] (val x: Self with ImgHTMLAttributes[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withAlt(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("alt")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutAlt: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("alt")(js.undefined)
        ret
    }
    @scala.inline
    def withCrossOrigin(value: anonymous | `use-credentials` | _empty): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("crossOrigin")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutCrossOrigin: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("crossOrigin")(js.undefined)
        ret
    }
    @scala.inline
    def withDecoding(value: async | auto | sync): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("decoding")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutDecoding: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("decoding")(js.undefined)
        ret
    }
    @scala.inline
    def withHeight(value: Double | String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("height")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutHeight: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("height")(js.undefined)
        ret
    }
    @scala.inline
    def withSizes(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("sizes")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutSizes: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("sizes")(js.undefined)
        ret
    }
    @scala.inline
    def withSrc(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("src")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutSrc: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("src")(js.undefined)
        ret
    }
    @scala.inline
    def withSrcSet(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("srcSet")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutSrcSet: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("srcSet")(js.undefined)
        ret
    }
    @scala.inline
    def withUseMap(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("useMap")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutUseMap: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("useMap")(js.undefined)
        ret
    }
    @scala.inline
    def withWidth(value: Double | String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("width")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutWidth: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("width")(js.undefined)
        ret
    }
  }
  
}

