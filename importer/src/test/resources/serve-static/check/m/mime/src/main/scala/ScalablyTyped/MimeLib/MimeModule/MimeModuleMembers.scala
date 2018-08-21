package ScalablyTyped
package MimeLib
package MimeModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("mime", JSImport.Namespace)
@js.native
object MimeModuleMembers extends js.Object {
  val default_type: java.lang.String = js.native
  def define(mimes: MimeLib.MimeModule.TypeMap): scala.Unit = js.native
  def define(mimes: MimeLib.MimeModule.TypeMap, force: scala.Boolean): scala.Unit = js.native
  def getExtension(mime: java.lang.String): java.lang.String | scala.Null = js.native
  def getType(path: java.lang.String): java.lang.String | scala.Null = js.native
}

