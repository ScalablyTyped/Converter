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
}

