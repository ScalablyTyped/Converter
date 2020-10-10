package typings.electron

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("original-fs", JSImport.Namespace)
@js.native
object originalFsMod extends js.Object {
  
  @js.native
  class ReadStream ()
    extends typings.node.fsMod.ReadStream
  
  @js.native
  class WriteStream ()
    extends typings.node.fsMod.WriteStream
}
