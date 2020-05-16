package typings.vue.optionsMod

import typings.std.HTMLElement
import typings.vue.vnodeMod.VNode
import typings.vue.vnodeMod.VNodeDirective
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait DirectiveOptions extends js.Object {
  var bind: js.UndefOr[DirectiveFunction] = js.native
  var componentUpdated: js.UndefOr[DirectiveFunction] = js.native
  var inserted: js.UndefOr[DirectiveFunction] = js.native
  var unbind: js.UndefOr[DirectiveFunction] = js.native
  var update: js.UndefOr[DirectiveFunction] = js.native
}

object DirectiveOptions {
  @scala.inline
  def apply(): DirectiveOptions = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[DirectiveOptions]
  }
  @scala.inline
  implicit class DirectiveOptionsOps[Self <: DirectiveOptions] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withBind(
      value: (/* el */ HTMLElement, /* binding */ VNodeDirective, /* vnode */ VNode, /* oldVnode */ VNode) => Unit
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("bind")(js.Any.fromFunction4(value))
        ret
    }
    @scala.inline
    def withoutBind: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("bind")(js.undefined)
        ret
    }
    @scala.inline
    def withComponentUpdated(
      value: (/* el */ HTMLElement, /* binding */ VNodeDirective, /* vnode */ VNode, /* oldVnode */ VNode) => Unit
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("componentUpdated")(js.Any.fromFunction4(value))
        ret
    }
    @scala.inline
    def withoutComponentUpdated: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("componentUpdated")(js.undefined)
        ret
    }
    @scala.inline
    def withInserted(
      value: (/* el */ HTMLElement, /* binding */ VNodeDirective, /* vnode */ VNode, /* oldVnode */ VNode) => Unit
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("inserted")(js.Any.fromFunction4(value))
        ret
    }
    @scala.inline
    def withoutInserted: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("inserted")(js.undefined)
        ret
    }
    @scala.inline
    def withUnbind(
      value: (/* el */ HTMLElement, /* binding */ VNodeDirective, /* vnode */ VNode, /* oldVnode */ VNode) => Unit
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("unbind")(js.Any.fromFunction4(value))
        ret
    }
    @scala.inline
    def withoutUnbind: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("unbind")(js.undefined)
        ret
    }
    @scala.inline
    def withUpdate(
      value: (/* el */ HTMLElement, /* binding */ VNodeDirective, /* vnode */ VNode, /* oldVnode */ VNode) => Unit
    ): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("update")(js.Any.fromFunction4(value))
        ret
    }
    @scala.inline
    def withoutUpdate: Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("update")(js.undefined)
        ret
    }
  }
  
}

