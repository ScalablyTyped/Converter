package typings.vueResource.vuejs

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait HttpHeaders
  extends /* key */ StringDictionary[js.Any] {
  var common: js.UndefOr[StringDictionary[String]] = js.native
  var custom: js.UndefOr[StringDictionary[String]] = js.native
  var delete: js.UndefOr[StringDictionary[String]] = js.native
  var patch: js.UndefOr[StringDictionary[String]] = js.native
  var post: js.UndefOr[StringDictionary[String]] = js.native
  var put: js.UndefOr[StringDictionary[String]] = js.native
}

object HttpHeaders {
  @scala.inline
  def apply(
    StringDictionary: /* key */ StringDictionary[js.Any] = null,
    common: StringDictionary[String] = null,
    custom: StringDictionary[String] = null,
    delete: StringDictionary[String] = null,
    patch: StringDictionary[String] = null,
    post: StringDictionary[String] = null,
    put: StringDictionary[String] = null
  ): HttpHeaders = {
    val __obj = js.Dynamic.literal()
    if (StringDictionary != null) js.Dynamic.global.Object.assign(__obj, StringDictionary)
    if (common != null) __obj.updateDynamic("common")(common.asInstanceOf[js.Any])
    if (custom != null) __obj.updateDynamic("custom")(custom.asInstanceOf[js.Any])
    if (delete != null) __obj.updateDynamic("delete")(delete.asInstanceOf[js.Any])
    if (patch != null) __obj.updateDynamic("patch")(patch.asInstanceOf[js.Any])
    if (post != null) __obj.updateDynamic("post")(post.asInstanceOf[js.Any])
    if (put != null) __obj.updateDynamic("put")(put.asInstanceOf[js.Any])
    __obj.asInstanceOf[HttpHeaders]
  }
  @scala.inline
  implicit class HttpHeadersOps[Self <: HttpHeaders] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withCommon(common: StringDictionary[String]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (common != null) ret.updateDynamic("common")(common.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutCommon: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "common")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withCustom(custom: StringDictionary[String]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (custom != null) ret.updateDynamic("custom")(custom.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutCustom: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "custom")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withDelete(delete: StringDictionary[String]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (delete != null) ret.updateDynamic("delete")(delete.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutDelete: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "delete")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withPatch(patch: StringDictionary[String]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (patch != null) ret.updateDynamic("patch")(patch.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutPatch: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "patch")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withPost(post: StringDictionary[String]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (post != null) ret.updateDynamic("post")(post.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutPost: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "post")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withPut(put: StringDictionary[String]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (put != null) ret.updateDynamic("put")(put.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutPut: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "put")
        ret.asInstanceOf[Self]
    }
  }
  
}

