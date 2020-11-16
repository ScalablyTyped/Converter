package typings.node.NodeJS

import typings.node.Buffer
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait ReadableStream extends EventEmitter {
  
  def read(): String | Buffer = js.native
  def read(size: Double): String | Buffer = js.native
}
