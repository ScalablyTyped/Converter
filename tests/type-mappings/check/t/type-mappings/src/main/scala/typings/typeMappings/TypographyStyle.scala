package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined std.Required<std.Pick<type-mappings.CSSProperties, 'fontFamily' | 'fontSize' | 'fontWeight' | 'color'>> & std.Partial<std.Pick<type-mappings.CSSProperties, 'letterSpacing' | 'lineHeight' | 'textTransform'>> */
@js.native
trait TypographyStyle extends js.Object {
  var color: String = js.native
  var fontFamily: String = js.native
  var fontSize: String = js.native
  var fontWeight: String = js.native
  var letterSpacing: js.UndefOr[String] = js.native
  var lineHeight: js.UndefOr[String] = js.native
  var textTransform: js.UndefOr[String] = js.native
}

object TypographyStyle {
  @scala.inline
  def apply(
    color: String,
    fontFamily: String,
    fontSize: String,
    fontWeight: String,
    letterSpacing: String = null,
    lineHeight: String = null,
    textTransform: String = null
  ): TypographyStyle = {
    val __obj = js.Dynamic.literal(color = color.asInstanceOf[js.Any], fontFamily = fontFamily.asInstanceOf[js.Any], fontSize = fontSize.asInstanceOf[js.Any], fontWeight = fontWeight.asInstanceOf[js.Any])
    if (letterSpacing != null) __obj.updateDynamic("letterSpacing")(letterSpacing.asInstanceOf[js.Any])
    if (lineHeight != null) __obj.updateDynamic("lineHeight")(lineHeight.asInstanceOf[js.Any])
    if (textTransform != null) __obj.updateDynamic("textTransform")(textTransform.asInstanceOf[js.Any])
    __obj.asInstanceOf[TypographyStyle]
  }
  @scala.inline
  implicit class TypographyStyleOps[Self <: TypographyStyle] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withColor(color: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("color")(color.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withFontFamily(fontFamily: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("fontFamily")(fontFamily.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withFontSize(fontSize: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("fontSize")(fontSize.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withFontWeight(fontWeight: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("fontWeight")(fontWeight.asInstanceOf[js.Any])
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

