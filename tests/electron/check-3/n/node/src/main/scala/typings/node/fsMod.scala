package typings.node

import _root_.typings.node.streamMod.Readable
import _root_.typings.node.streamMod.Writable
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object fsMod {
  
  @JSImport("fs", "ReadStream")
  @js.native
  open class ReadStream () extends Readable
  
  @JSImport("fs", "WriteStream")
  @js.native
  open class WriteStream () extends Writable
}
