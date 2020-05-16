package typings.stylis.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Options extends js.Object {
  var cascade: js.UndefOr[Boolean] = js.native
  var compress: js.UndefOr[Boolean] = js.native
  var global: js.UndefOr[Boolean] = js.native
  var keyframe: js.UndefOr[Boolean] = js.native
  var prefix: js.UndefOr[
    Boolean | (js.Function3[/* key */ String, /* value */ String, /* context */ Double, Boolean])
  ] = js.native
  var preserve: js.UndefOr[Boolean] = js.native
  var semicolon: js.UndefOr[Boolean] = js.native
}

object Options {
  @scala.inline
  def apply(
    cascade: js.UndefOr[Boolean] = js.undefined,
    compress: js.UndefOr[Boolean] = js.undefined,
    global: js.UndefOr[Boolean] = js.undefined,
    keyframe: js.UndefOr[Boolean] = js.undefined,
    prefix: Boolean | (js.Function3[/* key */ String, /* value */ String, /* context */ Double, Boolean]) = null,
    preserve: js.UndefOr[Boolean] = js.undefined,
    semicolon: js.UndefOr[Boolean] = js.undefined
  ): Options = {
    val __obj = js.Dynamic.literal()
    if (!js.isUndefined(cascade)) __obj.updateDynamic("cascade")(cascade.asInstanceOf[js.Any])
    if (!js.isUndefined(compress)) __obj.updateDynamic("compress")(compress.asInstanceOf[js.Any])
    if (!js.isUndefined(global)) __obj.updateDynamic("global")(global.asInstanceOf[js.Any])
    if (!js.isUndefined(keyframe)) __obj.updateDynamic("keyframe")(keyframe.asInstanceOf[js.Any])
    if (prefix != null) __obj.updateDynamic("prefix")(prefix.asInstanceOf[js.Any])
    if (!js.isUndefined(preserve)) __obj.updateDynamic("preserve")(preserve.asInstanceOf[js.Any])
    if (!js.isUndefined(semicolon)) __obj.updateDynamic("semicolon")(semicolon.asInstanceOf[js.Any])
    __obj.asInstanceOf[Options]
  }
  @scala.inline
  implicit class OptionsOps[Self <: Options] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withCascade(cascade: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(cascade)) ret.updateDynamic("cascade")(cascade.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutCascade: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "cascade")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withCompress(compress: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(compress)) ret.updateDynamic("compress")(compress.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutCompress: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "compress")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withGlobal(global: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(global)) ret.updateDynamic("global")(global.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutGlobal: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "global")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withKeyframe(keyframe: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(keyframe)) ret.updateDynamic("keyframe")(keyframe.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutKeyframe: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "keyframe")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withPrefixFunction3(prefix: (/* key */ String, /* value */ String, /* context */ Double) => Boolean): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("prefix")(js.Any.fromFunction3(prefix))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withPrefix(
      prefix: Boolean | (js.Function3[/* key */ String, /* value */ String, /* context */ Double, Boolean])
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (prefix != null) ret.updateDynamic("prefix")(prefix.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutPrefix: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "prefix")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withPreserve(preserve: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(preserve)) ret.updateDynamic("preserve")(preserve.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutPreserve: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "preserve")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withSemicolon(semicolon: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(semicolon)) ret.updateDynamic("semicolon")(semicolon.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutSemicolon: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "semicolon")
        ret.asInstanceOf[Self]
    }
  }
  
}

