package typings.vue

import org.scalablytyped.runtime.NumberDictionary
import org.scalablytyped.runtime.StringDictionary
import typings.std.Node
import typings.vue.anon.Render
import typings.vue.vueMod.Vue
import typings.vue.vueMod.VueConstructor
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object vnodeMod {
  
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
    def apply(isComment: Boolean, isRootInsert: Boolean): VNode = {
      val __obj = js.Dynamic.literal(isComment = isComment.asInstanceOf[js.Any], isRootInsert = isRootInsert.asInstanceOf[js.Any])
      __obj.asInstanceOf[VNode]
    }
    
    @scala.inline
    implicit class VNodeOps[Self <: VNode] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setIsComment(value: Boolean): Self = this.set("isComment", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setIsRootInsert(value: Boolean): Self = this.set("isRootInsert", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setChildrenVarargs(value: VNode*): Self = this.set("children", js.Array(value :_*))
      
      @scala.inline
      def setChildren(value: js.Array[VNode]): Self = this.set("children", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteChildren: Self = this.set("children", js.undefined)
      
      @scala.inline
      def setComponentInstance(value: Vue): Self = this.set("componentInstance", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteComponentInstance: Self = this.set("componentInstance", js.undefined)
      
      @scala.inline
      def setComponentOptions(value: VNodeComponentOptions): Self = this.set("componentOptions", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteComponentOptions: Self = this.set("componentOptions", js.undefined)
      
      @scala.inline
      def setContext(value: Vue): Self = this.set("context", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteContext: Self = this.set("context", js.undefined)
      
      @scala.inline
      def setData(value: VNodeData): Self = this.set("data", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteData: Self = this.set("data", js.undefined)
      
      @scala.inline
      def setElm(value: Node): Self = this.set("elm", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteElm: Self = this.set("elm", js.undefined)
      
      @scala.inline
      def setIsStatic(value: Boolean): Self = this.set("isStatic", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteIsStatic: Self = this.set("isStatic", js.undefined)
      
      @scala.inline
      def setKey(value: String | Double): Self = this.set("key", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteKey: Self = this.set("key", js.undefined)
      
      @scala.inline
      def setNs(value: String): Self = this.set("ns", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteNs: Self = this.set("ns", js.undefined)
      
      @scala.inline
      def setParent(value: VNode): Self = this.set("parent", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteParent: Self = this.set("parent", js.undefined)
      
      @scala.inline
      def setRaw(value: Boolean): Self = this.set("raw", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteRaw: Self = this.set("raw", js.undefined)
      
      @scala.inline
      def setTag(value: String): Self = this.set("tag", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteTag: Self = this.set("tag", js.undefined)
      
      @scala.inline
      def setText(value: String): Self = this.set("text", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteText: Self = this.set("text", js.undefined)
    }
  }
  
  @js.native
  trait VNodeChildrenArrayContents extends /* x */ NumberDictionary[VNode | String | VNodeChildren]
  object VNodeChildrenArrayContents {
    
    @scala.inline
    def apply(): VNodeChildrenArrayContents = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[VNodeChildrenArrayContents]
    }
  }
  
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
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setCtor(value: VueConstructor[Vue]): Self = this.set("Ctor", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setChildrenVarargs(value: ScopedSlot*): Self = this.set("children", js.Array(value :_*))
      
      @scala.inline
      def setChildren(value: VNodeChildren): Self = this.set("children", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteChildren: Self = this.set("children", js.undefined)
      
      @scala.inline
      def setListeners(value: js.Object): Self = this.set("listeners", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteListeners: Self = this.set("listeners", js.undefined)
      
      @scala.inline
      def setPropsData(value: js.Object): Self = this.set("propsData", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deletePropsData: Self = this.set("propsData", js.undefined)
      
      @scala.inline
      def setTag(value: String): Self = this.set("tag", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteTag: Self = this.set("tag", js.undefined)
    }
  }
  
  @js.native
  trait VNodeData extends js.Object {
    
    var attrs: js.UndefOr[StringDictionary[js.Any]] = js.native
    
    var `class`: js.UndefOr[js.Any] = js.native
    
    var directives: js.UndefOr[js.Array[VNodeDirective]] = js.native
    
    var domProps: js.UndefOr[StringDictionary[js.Any]] = js.native
    
    var hook: js.UndefOr[StringDictionary[js.Function]] = js.native
    
    var inlineTemplate: js.UndefOr[Render] = js.native
    
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
    def apply(): VNodeData = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[VNodeData]
    }
    
    @scala.inline
    implicit class VNodeDataOps[Self <: VNodeData] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setAttrs(value: StringDictionary[js.Any]): Self = this.set("attrs", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteAttrs: Self = this.set("attrs", js.undefined)
      
      @scala.inline
      def setClass(value: js.Any): Self = this.set("class", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteClass: Self = this.set("class", js.undefined)
      
      @scala.inline
      def setDirectivesVarargs(value: VNodeDirective*): Self = this.set("directives", js.Array(value :_*))
      
      @scala.inline
      def setDirectives(value: js.Array[VNodeDirective]): Self = this.set("directives", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteDirectives: Self = this.set("directives", js.undefined)
      
      @scala.inline
      def setDomProps(value: StringDictionary[js.Any]): Self = this.set("domProps", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteDomProps: Self = this.set("domProps", js.undefined)
      
      @scala.inline
      def setHook(value: StringDictionary[js.Function]): Self = this.set("hook", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteHook: Self = this.set("hook", js.undefined)
      
      @scala.inline
      def setInlineTemplate(value: Render): Self = this.set("inlineTemplate", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteInlineTemplate: Self = this.set("inlineTemplate", js.undefined)
      
      @scala.inline
      def setKeepAlive(value: Boolean): Self = this.set("keepAlive", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteKeepAlive: Self = this.set("keepAlive", js.undefined)
      
      @scala.inline
      def setKey(value: String | Double): Self = this.set("key", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteKey: Self = this.set("key", js.undefined)
      
      @scala.inline
      def setNativeOn(value: StringDictionary[js.Function | js.Array[js.Function]]): Self = this.set("nativeOn", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteNativeOn: Self = this.set("nativeOn", js.undefined)
      
      @scala.inline
      def setOn(value: StringDictionary[js.Function | js.Array[js.Function]]): Self = this.set("on", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteOn: Self = this.set("on", js.undefined)
      
      @scala.inline
      def setProps(value: StringDictionary[js.Any]): Self = this.set("props", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteProps: Self = this.set("props", js.undefined)
      
      @scala.inline
      def setRef(value: String): Self = this.set("ref", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteRef: Self = this.set("ref", js.undefined)
      
      @scala.inline
      def setScopedSlots(value: StringDictionary[ScopedSlot]): Self = this.set("scopedSlots", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteScopedSlots: Self = this.set("scopedSlots", js.undefined)
      
      @scala.inline
      def setShow(value: Boolean): Self = this.set("show", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteShow: Self = this.set("show", js.undefined)
      
      @scala.inline
      def setSlot(value: String): Self = this.set("slot", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteSlot: Self = this.set("slot", js.undefined)
      
      @scala.inline
      def setStaticClass(value: String): Self = this.set("staticClass", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteStaticClass: Self = this.set("staticClass", js.undefined)
      
      @scala.inline
      def setStaticStyle(value: StringDictionary[js.Any]): Self = this.set("staticStyle", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteStaticStyle: Self = this.set("staticStyle", js.undefined)
      
      @scala.inline
      def setStyleVarargs(value: js.Object*): Self = this.set("style", js.Array(value :_*))
      
      @scala.inline
      def setStyle(value: js.Array[js.Object] | js.Object): Self = this.set("style", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteStyle: Self = this.set("style", js.undefined)
      
      @scala.inline
      def setTag(value: String): Self = this.set("tag", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteTag: Self = this.set("tag", js.undefined)
      
      @scala.inline
      def setTransition(value: js.Object): Self = this.set("transition", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteTransition: Self = this.set("transition", js.undefined)
    }
  }
  
  @js.native
  trait VNodeDirective extends js.Object {
    
    val arg: String = js.native
    
    val expression: js.Any = js.native
    
    val modifiers: StringDictionary[Boolean] = js.native
    
    val name: String = js.native
    
    val oldValue: js.Any = js.native
    
    val value: js.Any = js.native
  }
  object VNodeDirective {
    
    @scala.inline
    def apply(
      arg: String,
      expression: js.Any,
      modifiers: StringDictionary[Boolean],
      name: String,
      oldValue: js.Any,
      value: js.Any
    ): VNodeDirective = {
      val __obj = js.Dynamic.literal(arg = arg.asInstanceOf[js.Any], expression = expression.asInstanceOf[js.Any], modifiers = modifiers.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any], oldValue = oldValue.asInstanceOf[js.Any], value = value.asInstanceOf[js.Any])
      __obj.asInstanceOf[VNodeDirective]
    }
    
    @scala.inline
    implicit class VNodeDirectiveOps[Self <: VNodeDirective] (val x: Self) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setArg(value: String): Self = this.set("arg", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setExpression(value: js.Any): Self = this.set("expression", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setModifiers(value: StringDictionary[Boolean]): Self = this.set("modifiers", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setName(value: String): Self = this.set("name", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setOldValue(value: js.Any): Self = this.set("oldValue", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setValue(value: js.Any): Self = this.set("value", value.asInstanceOf[js.Any])
    }
  }
  
  type ScopedSlot = js.Function1[/* props */ js.Any, VNodeChildrenArrayContents | String]
  
  type VNodeChildren = VNodeChildrenArrayContents | js.Array[ScopedSlot] | String
}
