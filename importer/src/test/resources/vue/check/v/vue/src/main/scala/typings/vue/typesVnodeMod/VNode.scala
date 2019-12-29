package typings.vue.typesVnodeMod

import typings.std.Node
import typings.vue.typesVueMod.Vue
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait VNode extends js.Object {
  var children: js.UndefOr[js.Array[VNode]] = js.native
  var componentInstance: js.UndefOr[Vue] = js.native
  var componentOptions: js.UndefOr[VNodeComponentOptions] = js.native
  var context: js.UndefOr[Vue] = js.native
  var data: js.UndefOr[VNodeData] = js.native
  var elm: js.UndefOr[Node] = js.native
  var isComment: Boolean = js.native
  var isRootInsert: Boolean = js.native
  var isStatic: js.UndefOr[Boolean] = js.native
  var key: js.UndefOr[String | Double] = js.native
  var ns: js.UndefOr[String] = js.native
  var parent: js.UndefOr[VNode] = js.native
  var raw: js.UndefOr[Boolean] = js.native
  var tag: js.UndefOr[String] = js.native
  var text: js.UndefOr[String] = js.native
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
    val __obj = js.Dynamic.literal(isComment = isComment.asInstanceOf[js.Any], isRootInsert = isRootInsert.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (componentInstance != null) __obj.updateDynamic("componentInstance")(componentInstance.asInstanceOf[js.Any])
    if (componentOptions != null) __obj.updateDynamic("componentOptions")(componentOptions.asInstanceOf[js.Any])
    if (context != null) __obj.updateDynamic("context")(context.asInstanceOf[js.Any])
    if (data != null) __obj.updateDynamic("data")(data.asInstanceOf[js.Any])
    if (elm != null) __obj.updateDynamic("elm")(elm.asInstanceOf[js.Any])
    if (!js.isUndefined(isStatic)) __obj.updateDynamic("isStatic")(isStatic.asInstanceOf[js.Any])
    if (key != null) __obj.updateDynamic("key")(key.asInstanceOf[js.Any])
    if (ns != null) __obj.updateDynamic("ns")(ns.asInstanceOf[js.Any])
    if (parent != null) __obj.updateDynamic("parent")(parent.asInstanceOf[js.Any])
    if (!js.isUndefined(raw)) __obj.updateDynamic("raw")(raw.asInstanceOf[js.Any])
    if (tag != null) __obj.updateDynamic("tag")(tag.asInstanceOf[js.Any])
    if (text != null) __obj.updateDynamic("text")(text.asInstanceOf[js.Any])
    __obj.asInstanceOf[VNode]
  }
}

