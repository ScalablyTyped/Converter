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
    addClass: java.lang.String => JQLite,
    injector: () => angularLib.angularMod.autoNs.IInjectorService,
    NumberDictionary: /* index */ org.scalablytyped.runtime.NumberDictionary[stdLib.HTMLElement] = null
  ): JQLite = {
    val __obj = js.Dynamic.literal(addClass = js.Any.fromFunction1(addClass), injector = js.Any.fromFunction0(injector))
    js.Dynamic.global.Object.assign(__obj, NumberDictionary)
    __obj.asInstanceOf[JQLite]
  }
}

