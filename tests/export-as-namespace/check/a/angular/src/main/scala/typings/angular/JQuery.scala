package typings.angular

import typings.angular.mod.auto.IInjectorService
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait JQuery extends js.Object {
  /**
    * Adds the specified class(es) to each of the set of matched elements.
    *
    * @param className One or more space-separated classes to be added to the class attribute of each matched element.
    * @see {@link https://api.jquery.com/addClass/#addClass-className}
    */
  def addClass(className: String): this.type = js.native
  def injector(): IInjectorService = js.native
}

object JQuery {
  @scala.inline
  def apply(addClass: String => JQuery, injector: () => IInjectorService): JQuery = {
    val __obj = js.Dynamic.literal(addClass = js.Any.fromFunction1(addClass), injector = js.Any.fromFunction0(injector))
    __obj.asInstanceOf[JQuery]
  }
  @scala.inline
  implicit class JQueryOps[Self <: JQuery] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withAddClass(value: String => JQuery): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("addClass")(js.Any.fromFunction1(value))
        ret
    }
    @scala.inline
    def withInjector(value: () => IInjectorService): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("injector")(js.Any.fromFunction0(value))
        ret
    }
  }
  
}

