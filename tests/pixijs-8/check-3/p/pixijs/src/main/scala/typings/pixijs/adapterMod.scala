package typings.pixijs

import typings.pixijs.anon.TypeofWebGLRenderingConte
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object adapterMod {
  
  trait Adapter extends StObject {
    
    /** Returns a WebGL rendering context. */
    def getWebGLRenderingContext(): TypeofWebGLRenderingConte
  }
  object Adapter {
    
    inline def apply(getWebGLRenderingContext: () => TypeofWebGLRenderingConte): Adapter = {
      val __obj = js.Dynamic.literal(getWebGLRenderingContext = js.Any.fromFunction0(getWebGLRenderingContext))
      __obj.asInstanceOf[Adapter]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Adapter] (val x: Self) extends AnyVal {
      
      inline def setGetWebGLRenderingContext(value: () => TypeofWebGLRenderingConte): Self = StObject.set(x, "getWebGLRenderingContext", js.Any.fromFunction0(value))
    }
  }
}
