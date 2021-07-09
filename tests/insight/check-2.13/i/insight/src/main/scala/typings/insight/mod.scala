package typings.insight

import typings.insight.mod.insight.IConfigstore
import typings.insight.mod.insight.IOptions
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("insight", JSImport.Namespace)
  @js.native
  class ^ protected ()
    extends StObject
       with Insight_ {
    def this(options: IOptions) = this()
  }
  
  @js.native
  trait Insight_ extends StObject {
    
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
    implicit class Insight_MutableBuilder[Self <: Insight_] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setClientId(value: String): Self = StObject.set(x, "clientId", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setConfig(value: IConfigstore): Self = StObject.set(x, "config", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setOptOut(value: Boolean): Self = StObject.set(x, "optOut", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setTrack(value: /* repeated */ String => Unit): Self = StObject.set(x, "track", js.Any.fromFunction1(value))
    }
  }
  
  object insight {
    
    @js.native
    trait IConfigstore extends StObject {
      
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
      implicit class IConfigstoreMutableBuilder[Self <: IConfigstore] (val x: Self) extends AnyVal {
        
        @scala.inline
        def setAll(value: js.Any): Self = StObject.set(x, "all", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setDel(value: String => Unit): Self = StObject.set(x, "del", js.Any.fromFunction1(value))
        
        @scala.inline
        def setGet(value: String => js.Any): Self = StObject.set(x, "get", js.Any.fromFunction1(value))
        
        @scala.inline
        def setPath(value: String): Self = StObject.set(x, "path", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setSet(value: (String, js.Any) => Unit): Self = StObject.set(x, "set", js.Any.fromFunction2(value))
      }
    }
    
    @js.native
    trait IOptions extends StObject {
      
      var trackingCode: String = js.native
    }
    object IOptions {
      
      @scala.inline
      def apply(trackingCode: String): IOptions = {
        val __obj = js.Dynamic.literal(trackingCode = trackingCode.asInstanceOf[js.Any])
        __obj.asInstanceOf[IOptions]
      }
      
      @scala.inline
      implicit class IOptionsMutableBuilder[Self <: IOptions] (val x: Self) extends AnyVal {
        
        @scala.inline
        def setTrackingCode(value: String): Self = StObject.set(x, "trackingCode", value.asInstanceOf[js.Any])
      }
    }
  }
}
