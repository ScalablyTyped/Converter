package typings
package angularLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait JQuery extends js.Object {
  /**
    * Adds the specified class(es) to each of the set of matched elements.
    *
    * @param className One or more space-separated classes to be added to the class attribute of each matched element.
    * @see {@link https://api.jquery.com/addClass/#addClass-className}
    */
  def addClass(className: java.lang.String): this.type
  def injector(): angularLib.angularMod.autoNs.IInjectorService
}

object JQuery {
  @scala.inline
  def apply(
    addClass: java.lang.String => JQuery,
    injector: () => angularLib.angularMod.autoNs.IInjectorService
  ): JQuery = {
    val __obj = js.Dynamic.literal(addClass = js.Any.fromFunction1(addClass), injector = js.Any.fromFunction0(injector))
  
    __obj.asInstanceOf[JQuery]
  }
}

