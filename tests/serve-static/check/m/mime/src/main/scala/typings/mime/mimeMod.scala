package typings.mime

import typings.mime.mod.TypeMap
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mimeMod {
  
  @js.native
  trait Mime extends js.Object {
    
    def define(mimes: TypeMap): Unit = js.native
    def define(mimes: TypeMap, force: Boolean): Unit = js.native
    
    def getExtension(mime: String): String | Null = js.native
    
    def getType(path: String): String | Null = js.native
  }
  
  @JSImport("mime/Mime", JSImport.Default)
  @js.native
  class default protected () extends Mime {
    def this(mimes: TypeMap) = this()
  }
}
