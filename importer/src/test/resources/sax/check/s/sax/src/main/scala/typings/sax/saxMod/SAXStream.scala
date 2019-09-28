package typings.sax.saxMod

import scala.scalajs.js.annotation.JSImport
import typings.node.streamMod.Duplex
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSImport("sax", "SAXStream")
@js.native
class SAXStream protected () extends Duplex {
  def this(strict: Boolean, opt: SAXOptions) = this()
  var _parser: SAXParser = js.native
}

