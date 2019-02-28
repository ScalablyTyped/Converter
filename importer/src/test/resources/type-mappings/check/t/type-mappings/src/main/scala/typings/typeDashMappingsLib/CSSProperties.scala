package typings
package typeDashMappingsLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait CSSProperties extends js.Object {
  var color: java.lang.String
  var fontFamily: java.lang.String
  var fontSize: java.lang.String
  var fontWeight: java.lang.String
  var letterSpacing: java.lang.String
  var lineHeight: java.lang.String
  var textTransform: java.lang.String
}

object CSSProperties {
  @scala.inline
  def apply(
    color: java.lang.String,
    fontFamily: java.lang.String,
    fontSize: java.lang.String,
    fontWeight: java.lang.String,
    letterSpacing: java.lang.String,
    lineHeight: java.lang.String,
    textTransform: java.lang.String
  ): CSSProperties = {
    val __obj = js.Dynamic.literal(color = color, fontFamily = fontFamily, fontSize = fontSize, fontWeight = fontWeight, letterSpacing = letterSpacing, lineHeight = lineHeight, textTransform = textTransform)
  
    __obj.asInstanceOf[CSSProperties]
  }
}

