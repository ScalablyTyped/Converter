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
  def apply(Ctor: VueConstructor[Vue]): VNodeComponentOptions = {
    val __obj = js.Dynamic.literal(Ctor = Ctor.asInstanceOf[js.Any])
    __obj.asInstanceOf[VNodeComponentOptions]
  }
  @scala.inline
  implicit class VNodeComponentOptionsOps[Self <: VNodeComponentOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withCtor(value: VueConstructor[Vue]): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("Ctor")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withChildren(value: VNodeChildren): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("children")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutChildren: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("children")(js.undefined)
        ret
    }
    @scala.inline
    def withListeners(value: js.Object): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("listeners")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutListeners: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("listeners")(js.undefined)
        ret
    }
    @scala.inline
    def withPropsData(value: js.Object): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("propsData")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutPropsData: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("propsData")(js.undefined)
        ret
    }
    @scala.inline
    def withTag(value: String): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("tag")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withoutTag: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("tag")(js.undefined)
        ret
    }
  }
  
}

