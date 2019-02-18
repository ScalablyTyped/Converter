package typings
package angularLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait JQLite
  extends JQuery
     with /* index */ org.scalablytyped.runtime.NumberDictionary[stdLib.HTMLElement]

object JQLite {
  @scala.inline
  def apply(
    addClass: js.Function1[java.lang.String, JQLite],
    injector: js.Function0[angularLib.angularMod.angularNs.autoNs.IInjectorService],
    NumberDictionary: /* index */ org.scalablytyped.runtime.NumberDictionary[stdLib.HTMLElement] = null
  ): JQLite = {
    val __obj = js.Dynamic.literal(addClass = addClass, injector = injector)
    js.Dynamic.global.Object.assign(__obj, NumberDictionary)
    __obj.asInstanceOf[JQLite]
  }
}

