package typings
package angularLib

import angularLib.angularMod.autoNs.IInjectorService
import org.scalablytyped.runtime.NumberDictionary
import stdLib.HTMLElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait JQLite
  extends JQuery
     with /* index */ NumberDictionary[HTMLElement]

object JQLite {
  @scala.inline
  def apply(
    addClass: String => JQLite,
    injector: () => IInjectorService,
    NumberDictionary: /* index */ NumberDictionary[HTMLElement] = null
  ): JQLite = {
    val __obj = js.Dynamic.literal(addClass = js.Any.fromFunction1(addClass), injector = js.Any.fromFunction0(injector))
    js.Dynamic.global.Object.assign(__obj, NumberDictionary)
    __obj.asInstanceOf[JQLite]
  }
}

