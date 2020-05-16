package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Inlined type-mappings.Omit<type-mappings.CSSProperties, 'color'> */
@js.native
trait Excluded extends js.Object {
  var fontFamily: String = js.native
  var fontSize: String = js.native
  var fontWeight: String = js.native
  var letterSpacing: String = js.native
  var lineHeight: String = js.native
  var textTransform: String = js.native
}

object Excluded {
  @scala.inline
  def apply(
    fontFamily: String,
    fontSize: String,
    fontWeight: String,
    letterSpacing: String,
    lineHeight: String,
    textTransform: String
  ): Excluded = {
    val __obj = js.Dynamic.literal(fontFamily = fontFamily.asInstanceOf[js.Any], fontSize = fontSize.asInstanceOf[js.Any], fontWeight = fontWeight.asInstanceOf[js.Any], letterSpacing = letterSpacing.asInstanceOf[js.Any], lineHeight = lineHeight.asInstanceOf[js.Any], textTransform = textTransform.asInstanceOf[js.Any])
    __obj.asInstanceOf[Excluded]
  }
  @scala.inline
  implicit class ExcludedOps[Self <: Excluded] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
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
        ret.updateDynamic("letterSpacing")(letterSpacing.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withLineHeight(lineHeight: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("lineHeight")(lineHeight.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withTextTransform(textTransform: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("textTransform")(textTransform.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
  }
  
}

