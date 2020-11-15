package typings.sax.mod

import typings.node.streamMod.Duplex
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("sax", "SAXStream")
@js.native
class SAXStream protected () extends Duplex {
  def this(strict: Boolean, opt: SAXOptions) = this()
  
  var _parser: SAXParser = js.native
}
