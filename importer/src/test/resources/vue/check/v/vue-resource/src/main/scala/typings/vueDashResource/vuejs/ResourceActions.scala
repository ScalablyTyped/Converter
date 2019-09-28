package typings.vueDashResource.vuejs

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.vueDashResource.Anon_Method
import scala.scalajs.js
import scala.scalajs.js.`|`

trait ResourceActions extends js.Object {
  var delete: Anon_Method
  var get: Anon_Method
  var query: Anon_Method
  var remove: Anon_Method
  var save: Anon_Method
  var update: Anon_Method
}

object ResourceActions {
  @inline
  def apply(
    delete: Anon_Method,
    get: Anon_Method,
    query: Anon_Method,
    remove: Anon_Method,
    save: Anon_Method,
    update: Anon_Method
  ): ResourceActions = {
    val __obj = js.Dynamic.literal(delete = delete, get = get, query = query, remove = remove, save = save, update = update)
  
    __obj.asInstanceOf[ResourceActions]
  }
}

