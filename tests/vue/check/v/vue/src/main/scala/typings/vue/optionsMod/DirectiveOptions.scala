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
  def apply(
    bind: (/* el */ HTMLElement, /* binding */ VNodeDirective, /* vnode */ VNode, /* oldVnode */ VNode) => Unit = null,
    componentUpdated: (/* el */ HTMLElement, /* binding */ VNodeDirective, /* vnode */ VNode, /* oldVnode */ VNode) => Unit = null,
    inserted: (/* el */ HTMLElement, /* binding */ VNodeDirective, /* vnode */ VNode, /* oldVnode */ VNode) => Unit = null,
    unbind: (/* el */ HTMLElement, /* binding */ VNodeDirective, /* vnode */ VNode, /* oldVnode */ VNode) => Unit = null,
    update: (/* el */ HTMLElement, /* binding */ VNodeDirective, /* vnode */ VNode, /* oldVnode */ VNode) => Unit = null
  ): DirectiveOptions = {
    val __obj = js.Dynamic.literal()
    if (bind != null) __obj.updateDynamic("bind")(js.Any.fromFunction4(bind))
    if (componentUpdated != null) __obj.updateDynamic("componentUpdated")(js.Any.fromFunction4(componentUpdated))
    if (inserted != null) __obj.updateDynamic("inserted")(js.Any.fromFunction4(inserted))
    if (unbind != null) __obj.updateDynamic("unbind")(js.Any.fromFunction4(unbind))
    if (update != null) __obj.updateDynamic("update")(js.Any.fromFunction4(update))
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
      bind: (/* el */ HTMLElement, /* binding */ VNodeDirective, /* vnode */ VNode, /* oldVnode */ VNode) => Unit
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (bind != null) ret.updateDynamic("bind")(js.Any.fromFunction4(bind))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutBind: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "bind")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withComponentUpdated(
      componentUpdated: (/* el */ HTMLElement, /* binding */ VNodeDirective, /* vnode */ VNode, /* oldVnode */ VNode) => Unit
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (componentUpdated != null) ret.updateDynamic("componentUpdated")(js.Any.fromFunction4(componentUpdated))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutComponentUpdated: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "componentUpdated")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withInserted(
      inserted: (/* el */ HTMLElement, /* binding */ VNodeDirective, /* vnode */ VNode, /* oldVnode */ VNode) => Unit
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (inserted != null) ret.updateDynamic("inserted")(js.Any.fromFunction4(inserted))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutInserted: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "inserted")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withUnbind(
      unbind: (/* el */ HTMLElement, /* binding */ VNodeDirective, /* vnode */ VNode, /* oldVnode */ VNode) => Unit
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (unbind != null) ret.updateDynamic("unbind")(js.Any.fromFunction4(unbind))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutUnbind: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "unbind")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withUpdate(
      update: (/* el */ HTMLElement, /* binding */ VNodeDirective, /* vnode */ VNode, /* oldVnode */ VNode) => Unit
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (update != null) ret.updateDynamic("update")(js.Any.fromFunction4(update))
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutUpdate: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "update")
        ret.asInstanceOf[Self]
    }
  }
  
}

