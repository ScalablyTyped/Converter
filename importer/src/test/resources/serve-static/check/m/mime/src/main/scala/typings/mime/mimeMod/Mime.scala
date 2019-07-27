package typings.mime.mimeMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Mime extends js.Object {
  def define(mimes: TypeMap): Unit = js.native
  def define(mimes: TypeMap, force: Boolean): Unit = js.native
  def getExtension(mime: String): String | Null = js.native
  def getType(path: String): String | Null = js.native
}

