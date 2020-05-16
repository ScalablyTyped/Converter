package typings.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait VideoHTMLAttributes[T] extends MediaHTMLAttributes[T] {
  var disablePictureInPicture: js.UndefOr[Boolean] = js.native
  var height: js.UndefOr[Double | String] = js.native
  var playsInline: js.UndefOr[Boolean] = js.native
  var poster: js.UndefOr[String] = js.native
  var width: js.UndefOr[Double | String] = js.native
}

object VideoHTMLAttributes {
  @scala.inline
  def apply[T](): VideoHTMLAttributes[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[VideoHTMLAttributes[T]]
  }
  @scala.inline
  implicit class VideoHTMLAttributesOps[Self[t] <: VideoHTMLAttributes[t], T] (val x: Self[T]) extends AnyVal {
    @scala.inline
    def duplicate: Self[T] = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self[T]]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self[T] with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self[T] with Other]
    @scala.inline
    def withDisablePictureInPicture(value: Boolean): Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("disablePictureInPicture")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutDisablePictureInPicture: Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("disablePictureInPicture")(js.undefined)
        ret
    }
    @scala.inline
    def withHeight(value: Double | String): Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("height")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutHeight: Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("height")(js.undefined)
        ret
    }
    @scala.inline
    def withPlaysInline(value: Boolean): Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("playsInline")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutPlaysInline: Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("playsInline")(js.undefined)
        ret
    }
    @scala.inline
    def withPoster(value: String): Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("poster")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutPoster: Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("poster")(js.undefined)
        ret
    }
    @scala.inline
    def withWidth(value: Double | String): Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("width")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutWidth: Self[T] = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("width")(js.undefined)
        ret
    }
  }
  
}

