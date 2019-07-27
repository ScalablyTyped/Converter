package typings.saxLib.saxMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("sax", JSImport.Namespace)
@js.native
object ^ extends js.Object {
  var EVENTS: js.Array[String] = js.native
  def createStream(strict: Boolean, opt: SAXOptions): SAXStream = js.native
  def parser(strict: Boolean, opt: SAXOptions): SAXParser = js.native
}

