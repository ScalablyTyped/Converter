package ScalablyTyped
package SaxLib.SaxModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("sax", "SAXStream")
@js.native
class SAXStream protected () extends NodeLib.StreamModule.Duplex {
  def this(strict: scala.Boolean, opt: SAXOptions) = this()
  val _parser: SAXParser = js.native
}

