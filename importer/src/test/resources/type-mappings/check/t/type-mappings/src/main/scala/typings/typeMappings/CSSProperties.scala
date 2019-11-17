package typings.typeMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait CSSProperties extends js.Object {
  var color: String
  var fontFamily: String
  var fontSize: String
  var fontWeight: String
  var letterSpacing: String
  var lineHeight: String
  var textTransform: String
}

object CSSProperties {
  @scala.inline
  def apply(
    color: String,
    fontFamily: String,
    fontSize: String,
    fontWeight: String,
    letterSpacing: String,
    lineHeight: String,
    textTransform: String
  ): CSSProperties = {
    val __obj = js.Dynamic.literal(color = color.asInstanceOf[js.Any], fontFamily = fontFamily.asInstanceOf[js.Any], fontSize = fontSize.asInstanceOf[js.Any], fontWeight = fontWeight.asInstanceOf[js.Any], letterSpacing = letterSpacing.asInstanceOf[js.Any], lineHeight = lineHeight.asInstanceOf[js.Any], textTransform = textTransform.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[CSSProperties]
  }
}

