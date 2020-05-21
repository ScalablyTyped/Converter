package typings.vueResource.vuejs

import typings.vueResource.anon.Method
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ResourceActions extends js.Object {
  var delete: Method = js.native
  var get: Method = js.native
  var query: Method = js.native
  var remove: Method = js.native
  var save: Method = js.native
  var update: Method = js.native
}

object ResourceActions {
  @scala.inline
  def apply(delete: Method, get: Method, query: Method, remove: Method, save: Method, update: Method): ResourceActions = {
    val __obj = js.Dynamic.literal(delete = delete.asInstanceOf[js.Any], get = get.asInstanceOf[js.Any], query = query.asInstanceOf[js.Any], remove = remove.asInstanceOf[js.Any], save = save.asInstanceOf[js.Any], update = update.asInstanceOf[js.Any])
    __obj.asInstanceOf[ResourceActions]
  }
  @scala.inline
  implicit class ResourceActionsOps[Self <: ResourceActions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setDelete(value: Method): Self = this.set("delete", value.asInstanceOf[js.Any])
    @scala.inline
    def setGet(value: Method): Self = this.set("get", value.asInstanceOf[js.Any])
    @scala.inline
    def setQuery(value: Method): Self = this.set("query", value.asInstanceOf[js.Any])
    @scala.inline
    def setRemove(value: Method): Self = this.set("remove", value.asInstanceOf[js.Any])
    @scala.inline
    def setSave(value: Method): Self = this.set("save", value.asInstanceOf[js.Any])
    @scala.inline
    def setUpdate(value: Method): Self = this.set("update", value.asInstanceOf[js.Any])
  }
  
}

