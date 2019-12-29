package typings.vueDashResource.vuejs

import typings.vueDashResource.Anon_Method
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ResourceActions extends js.Object {
  var delete: Anon_Method = js.native
  var get: Anon_Method = js.native
  var query: Anon_Method = js.native
  var remove: Anon_Method = js.native
  var save: Anon_Method = js.native
  var update: Anon_Method = js.native
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

