package typings.vueResource.vuejs

import typings.vueResource.AnonMethod
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ResourceActions extends js.Object {
  var delete: AnonMethod = js.native
  var get: AnonMethod = js.native
  var query: AnonMethod = js.native
  var remove: AnonMethod = js.native
  var save: AnonMethod = js.native
  var update: AnonMethod = js.native
}

object ResourceActions {
  @scala.inline
  def apply(
    delete: AnonMethod,
    get: AnonMethod,
    query: AnonMethod,
    remove: AnonMethod,
    save: AnonMethod,
    update: AnonMethod
  ): ResourceActions = {
    val __obj = js.Dynamic.literal(delete = delete.asInstanceOf[js.Any], get = get.asInstanceOf[js.Any], query = query.asInstanceOf[js.Any], remove = remove.asInstanceOf[js.Any], save = save.asInstanceOf[js.Any], update = update.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[ResourceActions]
  }
}

