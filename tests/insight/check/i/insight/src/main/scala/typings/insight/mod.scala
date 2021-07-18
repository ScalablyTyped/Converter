package typings.insight

import typings.insight.mod.insight.IConfigstore
import typings.insight.mod.insight.IOptions
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("insight", JSImport.Namespace)
  @js.native
  class ^ protected ()
    extends StObject
       with Insight_ {
    def this(options: IOptions) = this()
    
    /* CompleteClass */
    var clientId: String = js.native
    
    /* CompleteClass */
    var config: IConfigstore = js.native
    
    /* CompleteClass */
    var optOut: Boolean = js.native
    
    /* CompleteClass */
    override def track(args: String*): Unit = js.native
  }
  
  trait Insight_ extends StObject {
    
    var clientId: String
    
    var config: IConfigstore
    
    var optOut: Boolean
    
    def track(args: String*): Unit
  }
  object Insight_ {
    
    inline def apply(clientId: String, config: IConfigstore, optOut: Boolean, track: /* repeated */ String => Unit): Insight_ = {
      val __obj = js.Dynamic.literal(clientId = clientId.asInstanceOf[js.Any], config = config.asInstanceOf[js.Any], optOut = optOut.asInstanceOf[js.Any], track = js.Any.fromFunction1(track))
      __obj.asInstanceOf[Insight_]
    }
    
    extension [Self <: Insight_](x: Self) {
      
      inline def setClientId(value: String): Self = StObject.set(x, "clientId", value.asInstanceOf[js.Any])
      
      inline def setConfig(value: IConfigstore): Self = StObject.set(x, "config", value.asInstanceOf[js.Any])
      
      inline def setOptOut(value: Boolean): Self = StObject.set(x, "optOut", value.asInstanceOf[js.Any])
      
      inline def setTrack(value: /* repeated */ String => Unit): Self = StObject.set(x, "track", js.Any.fromFunction1(value))
    }
  }
  
  object insight {
    
    trait IConfigstore extends StObject {
      
      var all: js.Any
      
      def del(key: String): Unit
      
      def get(key: String): js.Any
      
      var path: String
      
      def set(key: String, `val`: js.Any): Unit
    }
    object IConfigstore {
      
      inline def apply(
        all: js.Any,
        del: String => Unit,
        get: String => js.Any,
        path: String,
        set: (String, js.Any) => Unit
      ): IConfigstore = {
        val __obj = js.Dynamic.literal(all = all.asInstanceOf[js.Any], del = js.Any.fromFunction1(del), get = js.Any.fromFunction1(get), path = path.asInstanceOf[js.Any], set = js.Any.fromFunction2(set))
        __obj.asInstanceOf[IConfigstore]
      }
      
      extension [Self <: IConfigstore](x: Self) {
        
        inline def setAll(value: js.Any): Self = StObject.set(x, "all", value.asInstanceOf[js.Any])
        
        inline def setDel(value: String => Unit): Self = StObject.set(x, "del", js.Any.fromFunction1(value))
        
        inline def setGet(value: String => js.Any): Self = StObject.set(x, "get", js.Any.fromFunction1(value))
        
        inline def setPath(value: String): Self = StObject.set(x, "path", value.asInstanceOf[js.Any])
        
        inline def setSet(value: (String, js.Any) => Unit): Self = StObject.set(x, "set", js.Any.fromFunction2(value))
      }
    }
    
    trait IOptions extends StObject {
      
      var trackingCode: String
    }
    object IOptions {
      
      inline def apply(trackingCode: String): IOptions = {
        val __obj = js.Dynamic.literal(trackingCode = trackingCode.asInstanceOf[js.Any])
        __obj.asInstanceOf[IOptions]
      }
      
      extension [Self <: IOptions](x: Self) {
        
        inline def setTrackingCode(value: String): Self = StObject.set(x, "trackingCode", value.asInstanceOf[js.Any])
      }
    }
  }
}
