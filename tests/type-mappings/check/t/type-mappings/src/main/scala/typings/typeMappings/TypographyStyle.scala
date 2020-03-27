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
}

