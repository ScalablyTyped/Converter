package typings.cldrjsLib.cldrjsMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/**
  * @name CldrStatic
  * @memberof cldr
  * @kind interface
  *
  * @description
  * The cldr class definition.
  */
@js.native
trait CldrStatic extends js.Object {
  @JSName("supplemental")
  var supplemental_Original: SupplementalStatic = js.native
  def get(path: String): js.Any = js.native
  def off(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit = js.native
  def on(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit = js.native
  def once(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit = js.native
  def supplemental(path: String): js.Any = js.native
  def supplemental(paths: js.Array[String]): js.Any = js.native
}

