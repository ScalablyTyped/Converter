package typings.serveDashStatic.serveDashStaticMod

import org.scalablytyped.runtime.NullOr
import typings.mime.mimeMod.TypeMap
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("serve-static", "mime")
@js.native
object mime extends js.Object {
  val default_type: String = js.native
  def define(mimes: TypeMap): Unit = js.native
  def define(mimes: TypeMap, force: Boolean): Unit = js.native
  def getExtension(mime: String): NullOr[String] = js.native
  def getType(path: String): NullOr[String] = js.native
}

