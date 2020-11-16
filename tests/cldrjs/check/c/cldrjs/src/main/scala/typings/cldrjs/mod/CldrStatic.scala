package typings.cldrjs.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

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
  
  def get(path: String): js.Any = js.native
  
  def off(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit = js.native
  
  def on(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit = js.native
  
  def once(event: String, listener: js.Function2[/* path */ String, /* value */ js.Any, Unit]): Unit = js.native
  
  def supplemental(path: String): js.Any = js.native
  def supplemental(paths: js.Array[String]): js.Any = js.native
  @JSName("supplemental")
  var supplemental_Original: SupplementalStatic = js.native
}
