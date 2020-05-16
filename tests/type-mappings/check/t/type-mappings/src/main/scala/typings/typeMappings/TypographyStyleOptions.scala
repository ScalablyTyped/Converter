package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined std.Partial<type-mappings.TypographyStyle> */
@js.native
trait TypographyStyleOptions extends js.Object {
  var color: js.UndefOr[String] = js.native
  var fontFamily: js.UndefOr[String] = js.native
  var fontSize: js.UndefOr[String] = js.native
  var fontWeight: js.UndefOr[String] = js.native
  var letterSpacing: js.UndefOr[String] = js.native
  var lineHeight: js.UndefOr[String] = js.native
  var textTransform: js.UndefOr[String] = js.native
}

object TypographyStyleOptions {
  @scala.inline
  def apply(
    color: String = null,
    fontFamily: String = null,
    fontSize: String = null,
    fontWeight: String = null,
    letterSpacing: String = null,
    lineHeight: String = null,
    textTransform: String = null
  ): TypographyStyleOptions = {
    val __obj = js.Dynamic.literal()
    if (color != null) __obj.updateDynamic("color")(color.asInstanceOf[js.Any])
    if (fontFamily != null) __obj.updateDynamic("fontFamily")(fontFamily.asInstanceOf[js.Any])
    if (fontSize != null) __obj.updateDynamic("fontSize")(fontSize.asInstanceOf[js.Any])
    if (fontWeight != null) __obj.updateDynamic("fontWeight")(fontWeight.asInstanceOf[js.Any])
    if (letterSpacing != null) __obj.updateDynamic("letterSpacing")(letterSpacing.asInstanceOf[js.Any])
    if (lineHeight != null) __obj.updateDynamic("lineHeight")(lineHeight.asInstanceOf[js.Any])
    if (textTransform != null) __obj.updateDynamic("textTransform")(textTransform.asInstanceOf[js.Any])
    __obj.asInstanceOf[TypographyStyleOptions]
  }
  @scala.inline
  implicit class TypographyStyleOptionsOps[Self <: TypographyStyleOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withColor(color: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (color != null) ret.updateDynamic("color")(color.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutColor: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "color")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withFontFamily(fontFamily: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (fontFamily != null) ret.updateDynamic("fontFamily")(fontFamily.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutFontFamily: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "fontFamily")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withFontSize(fontSize: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (fontSize != null) ret.updateDynamic("fontSize")(fontSize.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutFontSize: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "fontSize")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withFontWeight(fontWeight: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (fontWeight != null) ret.updateDynamic("fontWeight")(fontWeight.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutFontWeight: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "fontWeight")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withLetterSpacing(letterSpacing: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (letterSpacing != null) ret.updateDynamic("letterSpacing")(letterSpacing.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutLetterSpacing: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "letterSpacing")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withLineHeight(lineHeight: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (lineHeight != null) ret.updateDynamic("lineHeight")(lineHeight.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutLineHeight: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "lineHeight")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withTextTransform(textTransform: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (textTransform != null) ret.updateDynamic("textTransform")(textTransform.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutTextTransform: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "textTransform")
        ret.asInstanceOf[Self]
    }
  }
  
}

