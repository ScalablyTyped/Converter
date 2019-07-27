package typings.vueLib.typesVnodeMod

import typings.vueLib.typesVueMod.Vue
import typings.vueLib.typesVueMod.VueConstructor
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
    val __obj = js.Dynamic.literal(Ctor = Ctor)
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (listeners != null) __obj.updateDynamic("listeners")(listeners)
    if (propsData != null) __obj.updateDynamic("propsData")(propsData)
    if (tag != null) __obj.updateDynamic("tag")(tag)
    __obj.asInstanceOf[VNodeComponentOptions]
  }
}

