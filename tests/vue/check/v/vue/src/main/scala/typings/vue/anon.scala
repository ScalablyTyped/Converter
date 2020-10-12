package typings.vue

import org.scalablytyped.runtime.Instantiable1
import typings.vue.optionsMod.InjectKey
import typings.vue.vnodeMod.VNode
import typings.vue.vueMod.CreateElement
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait Default extends js.Object {
    
    var default: js.UndefOr[js.Any] = js.native
    
    var from: js.UndefOr[InjectKey] = js.native
  }
  object Default {
    
    @scala.inline
    def apply(): Default = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Default]
    }
    
    @scala.inline
    implicit class DefaultOps[Self <: Default] (val x: Self) extends AnyVal {
      
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
      def setDefault(value: js.Any): Self = this.set("default", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteDefault: Self = this.set("default", js.undefined)
      
      @scala.inline
      def setFrom(value: InjectKey): Self = this.set("from", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteFrom: Self = this.set("from", js.undefined)
    }
  }
  
  @js.native
  trait Event extends js.Object {
    
    var event: js.UndefOr[String] = js.native
    
    var prop: js.UndefOr[String] = js.native
  }
  object Event {
    
    @scala.inline
    def apply(): Event = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Event]
    }
    
    @scala.inline
    implicit class EventOps[Self <: Event] (val x: Self) extends AnyVal {
      
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
      def setEvent(value: String): Self = this.set("event", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteEvent: Self = this.set("event", js.undefined)
      
      @scala.inline
      def setProp(value: String): Self = this.set("prop", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteProp: Self = this.set("prop", js.undefined)
    }
  }
  
  @js.native
  trait FnCall extends js.Object {
    
    def apply[T](array: js.Array[T], key: Double, value: T): T = js.native
    def apply[T](`object`: js.Object, key: String, value: T): T = js.native
  }
  
  @js.native
  trait FnCallObjectKey extends js.Object {
    
    def apply(`object`: js.Object, key: String): Unit = js.native
    def apply[T](array: js.Array[T], key: Double): Unit = js.native
  }
  
  @js.native
  trait Instantiable[T]
    extends Instantiable1[/* args (repeated) */ js.Any, T with js.Object]
  
  @js.native
  trait Render extends js.Object {
    
    var render: js.Function = js.native
    
    var staticRenderFns: js.Array[js.Function] = js.native
  }
  object Render {
    
    @scala.inline
    def apply(render: js.Function, staticRenderFns: js.Array[js.Function]): Render = {
      val __obj = js.Dynamic.literal(render = render.asInstanceOf[js.Any], staticRenderFns = staticRenderFns.asInstanceOf[js.Any])
      __obj.asInstanceOf[Render]
    }
    
    @scala.inline
    implicit class RenderOps[Self <: Render] (val x: Self) extends AnyVal {
      
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
      def setRender(value: js.Function): Self = this.set("render", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setStaticRenderFnsVarargs(value: js.Function*): Self = this.set("staticRenderFns", js.Array(value :_*))
      
      @scala.inline
      def setStaticRenderFns(value: js.Array[js.Function]): Self = this.set("staticRenderFns", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait StaticRenderFns extends js.Object {
    
    def render(createElement: CreateElement): VNode = js.native
    
    var staticRenderFns: js.Array[js.Function0[VNode]] = js.native
  }
  object StaticRenderFns {
    
    @scala.inline
    def apply(render: CreateElement => VNode, staticRenderFns: js.Array[js.Function0[VNode]]): StaticRenderFns = {
      val __obj = js.Dynamic.literal(render = js.Any.fromFunction1(render), staticRenderFns = staticRenderFns.asInstanceOf[js.Any])
      __obj.asInstanceOf[StaticRenderFns]
    }
    
    @scala.inline
    implicit class StaticRenderFnsOps[Self <: StaticRenderFns] (val x: Self) extends AnyVal {
      
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
      def setRender(value: CreateElement => VNode): Self = this.set("render", js.Any.fromFunction1(value))
      
      @scala.inline
      def setStaticRenderFnsVarargs(value: js.Function0[VNode]*): Self = this.set("staticRenderFns", js.Array(value :_*))
      
      @scala.inline
      def setStaticRenderFns(value: js.Array[js.Function0[VNode]]): Self = this.set("staticRenderFns", value.asInstanceOf[js.Any])
    }
  }
}
