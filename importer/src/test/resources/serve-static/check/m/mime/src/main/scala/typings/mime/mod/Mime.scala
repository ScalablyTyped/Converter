package typings.mime.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("mime/Mime", JSImport.Namespace)
@js.native
object Mime extends js.Object {
  @js.native
  trait Mime extends js.Object {
    def define(mimes: TypeMap): Unit = js.native
    def define(mimes: TypeMap, force: Boolean): Unit = js.native
    def getExtension(mime: String): String | Null = js.native
    def getType(path: String): String | Null = js.native
  }
  
  @js.native
  class default protected ()
    extends typings.mime.mod.Mime.Mime {
    def this(mimes: TypeMap) = this()
  }
  
}

