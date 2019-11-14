package typings.vue.typesVnodeMod

import typings.vue.typesVueMod.Vue
import typings.vue.typesVueMod.VueConstructor
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait VNodeComponentOptions extends js.Object {
  var Ctor: VueConstructor[Vue]
  var children: js.UndefOr[VNodeChildren] = js.undefined
  var listeners: js.UndefOr[js.Object] = js.undefined
  var propsData: js.UndefOr[js.Object] = js.undefined
  var tag: js.UndefOr[String] = js.undefined
}

object VNodeComponentOptions {
  @scala.inline
  def apply(
    Ctor: VueConstructor[Vue],
    children: VNodeChildren = null,
    listeners: js.Object = null,
    propsData: js.Object = null,
    tag: String = null
  ): VNodeComponentOptions = {
    val __obj = js.Dynamic.literal(Ctor = Ctor.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (listeners != null) __obj.updateDynamic("listeners")(listeners.asInstanceOf[js.Any])
    if (propsData != null) __obj.updateDynamic("propsData")(propsData.asInstanceOf[js.Any])
    if (tag != null) __obj.updateDynamic("tag")(tag.asInstanceOf[js.Any])
    __obj.asInstanceOf[VNodeComponentOptions]
  }
}

