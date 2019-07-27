package typings.vue.typesVnodeMod

import typings.std.Node
import typings.vue.typesVueMod.Vue
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait VNode extends js.Object {
  var children: js.UndefOr[js.Array[VNode]] = js.undefined
  var componentInstance: js.UndefOr[Vue] = js.undefined
  var componentOptions: js.UndefOr[VNodeComponentOptions] = js.undefined
  var context: js.UndefOr[Vue] = js.undefined
  var data: js.UndefOr[VNodeData] = js.undefined
  var elm: js.UndefOr[Node] = js.undefined
  var isComment: Boolean
  var isRootInsert: Boolean
  var isStatic: js.UndefOr[Boolean] = js.undefined
  var key: js.UndefOr[String | Double] = js.undefined
  var ns: js.UndefOr[String] = js.undefined
  var parent: js.UndefOr[VNode] = js.undefined
  var raw: js.UndefOr[Boolean] = js.undefined
  var tag: js.UndefOr[String] = js.undefined
  var text: js.UndefOr[String] = js.undefined
}

object VNode {
  @scala.inline
  def apply(
    isComment: Boolean,
    isRootInsert: Boolean,
    children: js.Array[VNode] = null,
    componentInstance: Vue = null,
    componentOptions: VNodeComponentOptions = null,
    context: Vue = null,
    data: VNodeData = null,
    elm: Node = null,
    isStatic: js.UndefOr[Boolean] = js.undefined,
    key: String | Double = null,
    ns: String = null,
    parent: VNode = null,
    raw: js.UndefOr[Boolean] = js.undefined,
    tag: String = null,
    text: String = null
  ): VNode = {
    val __obj = js.Dynamic.literal(isComment = isComment, isRootInsert = isRootInsert)
    if (children != null) __obj.updateDynamic("children")(children)
    if (componentInstance != null) __obj.updateDynamic("componentInstance")(componentInstance)
    if (componentOptions != null) __obj.updateDynamic("componentOptions")(componentOptions)
    if (context != null) __obj.updateDynamic("context")(context)
    if (data != null) __obj.updateDynamic("data")(data)
    if (elm != null) __obj.updateDynamic("elm")(elm)
    if (!js.isUndefined(isStatic)) __obj.updateDynamic("isStatic")(isStatic)
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (ns != null) __obj.updateDynamic("ns")(ns)
    if (parent != null) __obj.updateDynamic("parent")(parent)
    if (!js.isUndefined(raw)) __obj.updateDynamic("raw")(raw)
    if (tag != null) __obj.updateDynamic("tag")(tag)
    if (text != null) __obj.updateDynamic("text")(text)
    __obj.asInstanceOf[VNode]
  }
}

