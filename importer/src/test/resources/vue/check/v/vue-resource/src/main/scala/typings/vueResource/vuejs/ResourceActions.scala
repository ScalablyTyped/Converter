package typings.vueResource.vuejs

import typings.vueResource.Anon_Method
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait ResourceActions extends js.Object {
  var delete: Anon_Method
  var get: Anon_Method
  var query: Anon_Method
  var remove: Anon_Method
  var save: Anon_Method
  var update: Anon_Method
}

object ResourceActions {
  @scala.inline
  def apply(
    delete: Anon_Method,
    get: Anon_Method,
    query: Anon_Method,
    remove: Anon_Method,
    save: Anon_Method,
    update: Anon_Method
  ): ResourceActions = {
    val __obj = js.Dynamic.literal(delete = delete.asInstanceOf[js.Any], get = get.asInstanceOf[js.Any], query = query.asInstanceOf[js.Any], remove = remove.asInstanceOf[js.Any], save = save.asInstanceOf[js.Any], update = update.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[ResourceActions]
  }
}

