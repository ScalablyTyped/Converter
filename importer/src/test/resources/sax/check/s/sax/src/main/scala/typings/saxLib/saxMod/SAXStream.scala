package typings.saxLib.saxMod

import typings.nodeLib.streamMod.Duplex
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("sax", "SAXStream")
@js.native
class SAXStream protected () extends Duplex {
  def this(strict: Boolean, opt: SAXOptions) = this()
  var _parser: SAXParser = js.native
}

