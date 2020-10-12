package typings.insight

import typings.insight.mod.insight.IConfigstore
import typings.insight.mod.insight.IOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("insight", JSImport.Namespace)
  @js.native
  class ^ protected () extends Insight_ {
    def this(options: IOptions) = this()
  }
  
  @js.native
  trait Insight_ extends js.Object {
    
    var clientId: String = js.native
    
    var config: IConfigstore = js.native
    
    var optOut: Boolean = js.native
    
    def track(args: String*): Unit = js.native
  }
  object Insight_ {
    
    @scala.inline
    def apply(clientId: String, config: IConfigstore, optOut: Boolean, track: /* repeated */ String => Unit): Insight_ = {
      val __obj = js.Dynamic.literal(clientId = clientId.asInstanceOf[js.Any], config = config.asInstanceOf[js.Any], optOut = optOut.asInstanceOf[js.Any], track = js.Any.fromFunction1(track))
      __obj.asInstanceOf[Insight_]
    }
    
    @scala.inline
    implicit class Insight_Ops[Self <: Insight_] (val x: Self) extends AnyVal {
      
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
      def setClientId(value: String): Self = this.set("clientId", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setConfig(value: IConfigstore): Self = this.set("config", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setOptOut(value: Boolean): Self = this.set("optOut", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setTrack(value: /* repeated */ String => Unit): Self = this.set("track", js.Any.fromFunction1(value))
    }
  }
  
  object insight {
    
    @js.native
    trait IConfigstore extends js.Object {
      
      var all: js.Any = js.native
      
      def del(key: String): Unit = js.native
      
      def get(key: String): js.Any = js.native
      
      var path: String = js.native
      
      def set(key: String, `val`: js.Any): Unit = js.native
    }
    object IConfigstore {
      
      @scala.inline
      def apply(
        all: js.Any,
        del: String => Unit,
        get: String => js.Any,
        path: String,
        set: (String, js.Any) => Unit
      ): IConfigstore = {
        val __obj = js.Dynamic.literal(all = all.asInstanceOf[js.Any], del = js.Any.fromFunction1(del), get = js.Any.fromFunction1(get), path = path.asInstanceOf[js.Any], set = js.Any.fromFunction2(set))
        __obj.asInstanceOf[IConfigstore]
      }
      
      @scala.inline
      implicit class IConfigstoreOps[Self <: IConfigstore] (val x: Self) extends AnyVal {
        
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
        def setAll(value: js.Any): Self = this.set("all", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setDel(value: String => Unit): Self = this.set("del", js.Any.fromFunction1(value))
        
        @scala.inline
        def setGet(value: String => js.Any): Self = this.set("get", js.Any.fromFunction1(value))
        
        @scala.inline
        def setPath(value: String): Self = this.set("path", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setSet(value: (String, js.Any) => Unit): Self = this.set("set", js.Any.fromFunction2(value))
      }
    }
    
    @js.native
    trait IOptions extends js.Object {
      
      var trackingCode: String = js.native
    }
    object IOptions {
      
      @scala.inline
      def apply(trackingCode: String): IOptions = {
        val __obj = js.Dynamic.literal(trackingCode = trackingCode.asInstanceOf[js.Any])
        __obj.asInstanceOf[IOptions]
      }
      
      @scala.inline
      implicit class IOptionsOps[Self <: IOptions] (val x: Self) extends AnyVal {
        
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
        def setTrackingCode(value: String): Self = this.set("trackingCode", value.asInstanceOf[js.Any])
      }
    }
  }
}
