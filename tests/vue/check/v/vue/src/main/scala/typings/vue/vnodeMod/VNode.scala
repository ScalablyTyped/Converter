package typings.vue.vnodeMod

import typings.std.Node
import typings.vue.vueMod.Vue
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
  @scala.inline
  implicit class VNodeOps[Self <: VNode] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withIsComment(isComment: Boolean): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("isComment")(isComment.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withIsRootInsert(isRootInsert: Boolean): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("isRootInsert")(isRootInsert.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withChildren(children: js.Array[VNode]): Self = {
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
    def withComponentInstance(componentInstance: Vue): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (componentInstance != null) ret.updateDynamic("componentInstance")(componentInstance.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutComponentInstance: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "componentInstance")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withComponentOptions(componentOptions: VNodeComponentOptions): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (componentOptions != null) ret.updateDynamic("componentOptions")(componentOptions.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutComponentOptions: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "componentOptions")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withContext(context: Vue): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (context != null) ret.updateDynamic("context")(context.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutContext: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "context")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withData(data: VNodeData): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (data != null) ret.updateDynamic("data")(data.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutData: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "data")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withElm(elm: Node): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (elm != null) ret.updateDynamic("elm")(elm.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutElm: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "elm")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withIsStatic(isStatic: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(isStatic)) ret.updateDynamic("isStatic")(isStatic.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutIsStatic: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "isStatic")
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
    def withNs(ns: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (ns != null) ret.updateDynamic("ns")(ns.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutNs: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "ns")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withParent(parent: VNode): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (parent != null) ret.updateDynamic("parent")(parent.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutParent: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "parent")
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withRaw(raw: js.UndefOr[Boolean]): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (!js.isUndefined(raw)) ret.updateDynamic("raw")(raw.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutRaw: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "raw")
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
    def withText(text: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (text != null) ret.updateDynamic("text")(text.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutText: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "text")
        ret.asInstanceOf[Self]
    }
  }
  
}

