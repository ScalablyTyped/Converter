package typings.vue.vnodeMod

import typings.vue.vueMod.Vue
import typings.vue.vueMod.VueConstructor
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait VNodeComponentOptions extends js.Object {
  var Ctor: VueConstructor[Vue] = js.native
  var children: js.UndefOr[VNodeChildren] = js.native
  var listeners: js.UndefOr[js.Object] = js.native
  var propsData: js.UndefOr[js.Object] = js.native
  var tag: js.UndefOr[String] = js.native
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
  @scala.inline
  implicit class VNodeComponentOptionsOps[Self <: VNodeComponentOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withCtor(Ctor: VueConstructor[Vue]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("Ctor")(Ctor.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withChildren(children: VNodeChildren): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (children != null) ret.updateDynamic("children")(children.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutChildren: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "children")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withListeners(listeners: js.Object): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (listeners != null) ret.updateDynamic("listeners")(listeners.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutListeners: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "listeners")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withPropsData(propsData: js.Object): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (propsData != null) ret.updateDynamic("propsData")(propsData.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutPropsData: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "propsData")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withTag(tag: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (tag != null) ret.updateDynamic("tag")(tag.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutTag: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "tag")
        ret.asInstanceOf[Self]
    }
  }
  
}

