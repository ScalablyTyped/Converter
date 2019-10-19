package typings.angular

import org.scalablytyped.runtime.NumberDictionary
import typings.angular.mod.auto.IInjectorService
import typings.std.HTMLElement
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
    if (NumberDictionary != null) js.Dynamic.global.Object.assign(__obj, NumberDictionary)
    __obj.asInstanceOf[JQLite]
  }
}

