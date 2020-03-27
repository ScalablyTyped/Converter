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
}

