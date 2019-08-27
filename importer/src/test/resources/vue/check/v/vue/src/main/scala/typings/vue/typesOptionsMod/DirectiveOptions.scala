package typings.vue.typesOptionsMod

import org.scalablytyped.runtime.UndefOr
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait DirectiveOptions extends js.Object {
  var bind: UndefOr[DirectiveFunction] = js.undefined
  var componentUpdated: UndefOr[DirectiveFunction] = js.undefined
  var inserted: UndefOr[DirectiveFunction] = js.undefined
  var unbind: UndefOr[DirectiveFunction] = js.undefined
  var update: UndefOr[DirectiveFunction] = js.undefined
}

object DirectiveOptions {
  @scala.inline
  def apply(
    bind: DirectiveFunction = null,
    componentUpdated: DirectiveFunction = null,
    inserted: DirectiveFunction = null,
    unbind: DirectiveFunction = null,
    update: DirectiveFunction = null
  ): DirectiveOptions = {
    val __obj = js.Dynamic.literal()
    if (bind != null) __obj.updateDynamic("bind")(bind)
    if (componentUpdated != null) __obj.updateDynamic("componentUpdated")(componentUpdated)
    if (inserted != null) __obj.updateDynamic("inserted")(inserted)
    if (unbind != null) __obj.updateDynamic("unbind")(unbind)
    if (update != null) __obj.updateDynamic("update")(update)
    __obj.asInstanceOf[DirectiveOptions]
  }
}

