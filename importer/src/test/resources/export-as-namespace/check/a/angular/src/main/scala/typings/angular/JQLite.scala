package typings.angular

import org.scalablytyped.runtime.NumberDictionary
import scala.scalajs.js.annotation.ScalaJSDefined
import typings.angular.angularMod.auto.IInjectorService
import typings.std.HTMLElement
import scala.scalajs.js
import scala.scalajs.js.`|`

trait JQLite
  extends JQuery
     with /* index */ NumberDictionary[HTMLElement]

object JQLite {
  @inline
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

