package typings.vue.vnodeMod

import org.scalablytyped.runtime.StringDictionary
import typings.vue.AnonRender
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait VNodeData extends js.Object {
  var attrs: js.UndefOr[StringDictionary[js.Any]] = js.native
  var `class`: js.UndefOr[js.Any] = js.native
  var directives: js.UndefOr[js.Array[VNodeDirective]] = js.native
  var domProps: js.UndefOr[StringDictionary[js.Any]] = js.native
  var hook: js.UndefOr[StringDictionary[js.Function]] = js.native
  var inlineTemplate: js.UndefOr[AnonRender] = js.native
  var keepAlive: js.UndefOr[Boolean] = js.native
  var key: js.UndefOr[String | Double] = js.native
  var nativeOn: js.UndefOr[StringDictionary[js.Function | js.Array[js.Function]]] = js.native
  var on: js.UndefOr[StringDictionary[js.Function | js.Array[js.Function]]] = js.native
  var props: js.UndefOr[StringDictionary[js.Any]] = js.native
  var ref: js.UndefOr[String] = js.native
  var scopedSlots: js.UndefOr[StringDictionary[ScopedSlot]] = js.native
  var show: js.UndefOr[Boolean] = js.native
  var slot: js.UndefOr[String] = js.native
  var staticClass: js.UndefOr[String] = js.native
  var staticStyle: js.UndefOr[StringDictionary[js.Any]] = js.native
  var style: js.UndefOr[js.Array[js.Object] | js.Object] = js.native
  var tag: js.UndefOr[String] = js.native
  var transition: js.UndefOr[js.Object] = js.native
}

object VNodeData {
  @scala.inline
  def apply(
    attrs: StringDictionary[js.Any] = null,
    `class`: js.Any = null,
    directives: js.Array[VNodeDirective] = null,
    domProps: StringDictionary[js.Any] = null,
    hook: StringDictionary[js.Function] = null,
    inlineTemplate: AnonRender = null,
    keepAlive: js.UndefOr[Boolean] = js.undefined,
    key: String | Double = null,
    nativeOn: StringDictionary[js.Function | js.Array[js.Function]] = null,
    on: StringDictionary[js.Function | js.Array[js.Function]] = null,
    props: StringDictionary[js.Any] = null,
    ref: String = null,
    scopedSlots: StringDictionary[ScopedSlot] = null,
    show: js.UndefOr[Boolean] = js.undefined,
    slot: String = null,
    staticClass: String = null,
    staticStyle: StringDictionary[js.Any] = null,
    style: js.Array[js.Object] | js.Object = null,
    tag: String = null,
    transition: js.Object = null
  ): VNodeData = {
    val __obj = js.Dynamic.literal()
    if (attrs != null) __obj.updateDynamic("attrs")(attrs.asInstanceOf[js.Any])
    if (`class` != null) __obj.updateDynamic("class")(`class`.asInstanceOf[js.Any])
    if (directives != null) __obj.updateDynamic("directives")(directives.asInstanceOf[js.Any])
    if (domProps != null) __obj.updateDynamic("domProps")(domProps.asInstanceOf[js.Any])
    if (hook != null) __obj.updateDynamic("hook")(hook.asInstanceOf[js.Any])
    if (inlineTemplate != null) __obj.updateDynamic("inlineTemplate")(inlineTemplate.asInstanceOf[js.Any])
    if (!js.isUndefined(keepAlive)) __obj.updateDynamic("keepAlive")(keepAlive.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (nativeOn != null) __obj.updateDynamic("nativeOn")(nativeOn.asInstanceOf[js.Any])
    if (on != null) __obj.updateDynamic("on")(on.asInstanceOf[js.Any])
    if (props != null) __obj.updateDynamic("props")(props.asInstanceOf[js.Any])
    if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
    if (scopedSlots != null) __obj.updateDynamic("scopedSlots")(scopedSlots.asInstanceOf[js.Any])
    if (!js.isUndefined(show)) __obj.updateDynamic("show")(show.asInstanceOf[js.Any])
    if (slot != null) __obj.updateDynamic("slot")(slot.asInstanceOf[js.Any])
    if (staticClass != null) __obj.updateDynamic("staticClass")(staticClass.asInstanceOf[js.Any])
    if (staticStyle != null) __obj.updateDynamic("staticStyle")(staticStyle.asInstanceOf[js.Any])
    if (style != null) __obj.updateDynamic("style")(style.asInstanceOf[js.Any])
    if (tag != null) __obj.updateDynamic("tag")(tag.asInstanceOf[js.Any])
    if (transition != null) __obj.updateDynamic("transition")(transition.asInstanceOf[js.Any])
    __obj.asInstanceOf[VNodeData]
  }
  @scala.inline
  implicit class VNodeDataOps[Self <: VNodeData] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withAttrs(attrs: StringDictionary[js.Any]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (attrs != null) ret.updateDynamic("attrs")(attrs.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutAttrs: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "attrs")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withClass(`class`: js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (`class` != null) ret.updateDynamic("class")(`class`.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutClass: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "class")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withDirectives(directives: js.Array[VNodeDirective]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (directives != null) ret.updateDynamic("directives")(directives.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutDirectives: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "directives")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withDomProps(domProps: StringDictionary[js.Any]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (domProps != null) ret.updateDynamic("domProps")(domProps.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutDomProps: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "domProps")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withHook(hook: StringDictionary[js.Function]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (hook != null) ret.updateDynamic("hook")(hook.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutHook: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "hook")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withInlineTemplate(inlineTemplate: AnonRender): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (inlineTemplate != null) ret.updateDynamic("inlineTemplate")(inlineTemplate.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutInlineTemplate: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "inlineTemplate")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withKeepAlive(keepAlive: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(keepAlive)) ret.updateDynamic("keepAlive")(keepAlive.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutKeepAlive: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "keepAlive")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withKey(key: String | Double): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (key != null) ret.updateDynamic("key")(key.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutKey: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "key")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withNativeOn(nativeOn: StringDictionary[js.Function | js.Array[js.Function]]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (nativeOn != null) ret.updateDynamic("nativeOn")(nativeOn.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutNativeOn: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "nativeOn")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withOn(on: StringDictionary[js.Function | js.Array[js.Function]]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (on != null) ret.updateDynamic("on")(on.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutOn: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "on")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withProps(props: StringDictionary[js.Any]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (props != null) ret.updateDynamic("props")(props.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutProps: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "props")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withRef(ref: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (ref != null) ret.updateDynamic("ref")(ref.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutRef: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "ref")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withScopedSlots(scopedSlots: StringDictionary[ScopedSlot]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (scopedSlots != null) ret.updateDynamic("scopedSlots")(scopedSlots.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutScopedSlots: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "scopedSlots")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withShow(show: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(show)) ret.updateDynamic("show")(show.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutShow: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "show")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withSlot(slot: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (slot != null) ret.updateDynamic("slot")(slot.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutSlot: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "slot")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withStaticClass(staticClass: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (staticClass != null) ret.updateDynamic("staticClass")(staticClass.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutStaticClass: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "staticClass")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withStaticStyle(staticStyle: StringDictionary[js.Any]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (staticStyle != null) ret.updateDynamic("staticStyle")(staticStyle.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutStaticStyle: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "staticStyle")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withStyle(style: js.Array[js.Object] | js.Object): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (style != null) ret.updateDynamic("style")(style.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutStyle: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "style")
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
    @scala.inline
    def withTransition(transition: js.Object): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (transition != null) ret.updateDynamic("transition")(transition.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutTransition: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "transition")
        ret.asInstanceOf[Self]
    }
  }
  
}

