package ScalablyTyped
package SaxLib
package SaxModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("sax", "SAXStream")
@js.native
class SAXStream protected () extends NodeLib.StreamModule.Duplex {
  def this(strict: scala.Boolean, opt: SaxLib.SaxModule.SAXOptions) = this()
  var _parser: SaxLib.SaxModule.SAXParser = js.native
}

