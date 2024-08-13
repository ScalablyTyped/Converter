package typings.antd

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  trait Delay extends StObject {
    
    var delay: js.UndefOr[Double] = js.undefined
  }
  object Delay {
    
    inline def apply(): Delay = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Delay]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Delay] (val x: Self) extends AnyVal {
      
      inline def setDelay(value: Double): Self = StObject.set(x, "delay", value.asInstanceOf[js.Any])
      
      inline def setDelayUndefined: Self = StObject.set(x, "delay", js.undefined)
    }
  }
  
  trait Icon extends StObject {
    
    var icon: String
  }
  object Icon {
    
    inline def apply(icon: String): Icon = {
      val __obj = js.Dynamic.literal(icon = icon.asInstanceOf[js.Any])
      __obj.asInstanceOf[Icon]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Icon] (val x: Self) extends AnyVal {
      
      inline def setIcon(value: String): Self = StObject.set(x, "icon", value.asInstanceOf[js.Any])
    }
  }
  
  trait IconAny extends StObject {
    
    var icon: Any
  }
  object IconAny {
    
    inline def apply(icon: Any): IconAny = {
      val __obj = js.Dynamic.literal(icon = icon.asInstanceOf[js.Any])
      __obj.asInstanceOf[IconAny]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: IconAny] (val x: Self) extends AnyVal {
      
      inline def setIcon(value: Any): Self = StObject.set(x, "icon", value.asInstanceOf[js.Any])
    }
  }
}
