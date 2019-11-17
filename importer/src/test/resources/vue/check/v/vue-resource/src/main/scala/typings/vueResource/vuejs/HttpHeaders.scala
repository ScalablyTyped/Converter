package typings.vueResource.vuejs

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait HttpHeaders
  extends /* key */ StringDictionary[js.Any] {
  var common: js.UndefOr[StringDictionary[String]] = js.undefined
  var custom: js.UndefOr[StringDictionary[String]] = js.undefined
  var delete: js.UndefOr[StringDictionary[String]] = js.undefined
  var patch: js.UndefOr[StringDictionary[String]] = js.undefined
  var post: js.UndefOr[StringDictionary[String]] = js.undefined
  var put: js.UndefOr[StringDictionary[String]] = js.undefined
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
}

