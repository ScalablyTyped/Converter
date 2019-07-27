package typings
package typeDashMappingsLib

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
    val __obj = js.Dynamic.literal(color = color, fontFamily = fontFamily, fontSize = fontSize, fontWeight = fontWeight, letterSpacing = letterSpacing, lineHeight = lineHeight, textTransform = textTransform)
  
    __obj.asInstanceOf[CSSProperties]
  }
}

