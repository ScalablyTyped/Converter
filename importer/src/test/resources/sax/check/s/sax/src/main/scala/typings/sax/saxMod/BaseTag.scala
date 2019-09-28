package typings.sax.saxMod

import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait BaseTag extends js.Object {
  var isSelfClosing: Boolean
  var name: String
}

object BaseTag {
  @inline
  def apply(isSelfClosing: Boolean, name: String): BaseTag = {
    val __obj = js.Dynamic.literal(isSelfClosing = isSelfClosing, name = name)
  
    __obj.asInstanceOf[BaseTag]
  }
}

