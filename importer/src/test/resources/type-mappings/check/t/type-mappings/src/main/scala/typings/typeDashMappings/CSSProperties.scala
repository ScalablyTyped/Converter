package typings.typeDashMappings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait CSSProperties extends js.Object {
  var color: String = js.native
  var fontFamily: String = js.native
  var fontSize: String = js.native
  var fontWeight: String = js.native
  var letterSpacing: String = js.native
  var lineHeight: String = js.native
  var textTransform: String = js.native
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

