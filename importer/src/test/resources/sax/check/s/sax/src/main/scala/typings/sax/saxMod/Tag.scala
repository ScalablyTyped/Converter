package typings.sax.saxMod

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js
import scala.scalajs.js.`|`

trait Tag extends BaseTag {
  var attributes: StringDictionary[String]
}

object Tag {
  @inline
  def apply(attributes: StringDictionary[String], isSelfClosing: Boolean, name: String): Tag = {
    val __obj = js.Dynamic.literal(attributes = attributes, isSelfClosing = isSelfClosing, name = name)
  
    __obj.asInstanceOf[Tag]
  }
}

