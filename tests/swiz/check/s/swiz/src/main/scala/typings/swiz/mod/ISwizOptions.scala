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
  def apply(
    `for`: String = null,
    stripNulls: js.UndefOr[Boolean] = js.undefined,
    stripSerializerType: js.UndefOr[Boolean] = js.undefined
  ): ISwizOptions = {
    val __obj = js.Dynamic.literal()
    if (`for` != null) __obj.updateDynamic("for")(`for`.asInstanceOf[js.Any])
    if (!js.isUndefined(stripNulls)) __obj.updateDynamic("stripNulls")(stripNulls.asInstanceOf[js.Any])
    if (!js.isUndefined(stripSerializerType)) __obj.updateDynamic("stripSerializerType")(stripSerializerType.asInstanceOf[js.Any])
    __obj.asInstanceOf[ISwizOptions]
  }
  @scala.inline
  implicit class ISwizOptionsOps[Self <: ISwizOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withFor(`for`: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (`for` != null) ret.updateDynamic("for")(`for`.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutFor: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "for")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withStripNulls(stripNulls: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(stripNulls)) ret.updateDynamic("stripNulls")(stripNulls.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutStripNulls: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "stripNulls")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withStripSerializerType(stripSerializerType: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(stripSerializerType)) ret.updateDynamic("stripSerializerType")(stripSerializerType.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutStripSerializerType: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "stripSerializerType")
        ret.asInstanceOf[Self]
    }
  }
  
}

