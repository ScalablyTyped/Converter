package ScalablyTyped
package CldrjsLib.CldrjsModule.selfNamespace

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
  val supplemental_Original: CldrjsLib.CldrjsCldrDotJsDashSupplementalModule.CldrjsModule.SupplementalStatic = js.native
  def get(path: java.lang.String): js.Any = js.native
  def off(event: java.lang.String, listener: js.Function2[/* path */ java.lang.String, /* value */ js.Any, scala.Unit]): scala.Unit = js.native
  def on(event: java.lang.String, listener: js.Function2[/* path */ java.lang.String, /* value */ js.Any, scala.Unit]): scala.Unit = js.native
  def once(event: java.lang.String, listener: js.Function2[/* path */ java.lang.String, /* value */ js.Any, scala.Unit]): scala.Unit = js.native
  def supplemental(path: java.lang.String): js.Any = js.native
  def supplemental(paths: StdLib.Array[java.lang.String]): js.Any = js.native
}

