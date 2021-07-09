package typings.vue

import org.scalablytyped.runtime.Instantiable1
import typings.vue.optionsMod.InjectKey
import typings.vue.vnodeMod.VNode
import typings.vue.vueMod.CreateElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait Default extends StObject {
    
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
    implicit class DefaultMutableBuilder[Self <: Default] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setDefault(value: js.Any): Self = StObject.set(x, "default", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setDefaultUndefined: Self = StObject.set(x, "default", js.undefined)
      
      @scala.inline
      def setFrom(value: InjectKey): Self = StObject.set(x, "from", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setFromUndefined: Self = StObject.set(x, "from", js.undefined)
    }
  }
  
  @js.native
  trait Event extends StObject {
    
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
    implicit class EventMutableBuilder[Self <: Event] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setEvent(value: String): Self = StObject.set(x, "event", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setEventUndefined: Self = StObject.set(x, "event", js.undefined)
      
      @scala.inline
      def setProp(value: String): Self = StObject.set(x, "prop", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setPropUndefined: Self = StObject.set(x, "prop", js.undefined)
    }
  }
  
  @js.native
  trait FnCall extends StObject {
    
    def apply[T](array: js.Array[T], key: Double, value: T): T = js.native
    def apply[T](`object`: js.Object, key: String, value: T): T = js.native
  }
  
  @js.native
  trait FnCallObjectKey extends StObject {
    
    def apply(`object`: js.Object, key: String): Unit = js.native
    def apply[T](array: js.Array[T], key: Double): Unit = js.native
  }
  
  @js.native
  trait Instantiable[T]
    extends StObject
       with Instantiable1[/* args (repeated) */ js.Any, T with js.Object]
  
  @js.native
  trait Render extends StObject {
    
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
    implicit class RenderMutableBuilder[Self <: Render] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setRender(value: js.Function): Self = StObject.set(x, "render", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setStaticRenderFns(value: js.Array[js.Function]): Self = StObject.set(x, "staticRenderFns", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setStaticRenderFnsVarargs(value: js.Function*): Self = StObject.set(x, "staticRenderFns", js.Array(value :_*))
    }
  }
  
  @js.native
  trait StaticRenderFns extends StObject {
    
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
    implicit class StaticRenderFnsMutableBuilder[Self <: StaticRenderFns] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setRender(value: CreateElement => VNode): Self = StObject.set(x, "render", js.Any.fromFunction1(value))
      
      @scala.inline
      def setStaticRenderFns(value: js.Array[js.Function0[VNode]]): Self = StObject.set(x, "staticRenderFns", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setStaticRenderFnsVarargs(value: js.Function0[VNode]*): Self = StObject.set(x, "staticRenderFns", js.Array(value :_*))
    }
  }
}
