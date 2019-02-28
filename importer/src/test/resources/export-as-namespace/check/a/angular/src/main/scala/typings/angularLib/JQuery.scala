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
  def injector(): angularLib.angularMod.angularNs.autoNs.IInjectorService
}

object JQuery {
  @scala.inline
  def apply(
    addClass: js.Function1[java.lang.String, JQuery],
    injector: js.Function0[angularLib.angularMod.angularNs.autoNs.IInjectorService]
  ): JQuery = {
    val __obj = js.Dynamic.literal(addClass = addClass, injector = injector)
  
    __obj.asInstanceOf[JQuery]
  }
}

