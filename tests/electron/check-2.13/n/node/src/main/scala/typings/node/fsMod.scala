package typings.node

import typings.node.streamMod.Readable
import typings.node.streamMod.Writable
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object fsMod {
  
  @JSImport("fs", "ReadStream")
  @js.native
  class ReadStream () extends Readable
  
  @JSImport("fs", "WriteStream")
  @js.native
  class WriteStream () extends Writable
}
