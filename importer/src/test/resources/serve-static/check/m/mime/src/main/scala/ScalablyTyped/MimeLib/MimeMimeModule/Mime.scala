package ScalablyTyped
package MimeLib.MimeMimeModule

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Mime extends js.Object {
  def define(mimes: MimeLib.MimeModule.TypeMap): scala.Unit = js.native
  def define(mimes: MimeLib.MimeModule.TypeMap, force: scala.Boolean): scala.Unit = js.native
  def getExtension(mime: java.lang.String): java.lang.String | scala.Null = js.native
  def getType(path: java.lang.String): java.lang.String | scala.Null = js.native
}

