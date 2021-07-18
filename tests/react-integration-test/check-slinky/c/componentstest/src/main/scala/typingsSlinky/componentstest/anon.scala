package typingsSlinky.componentstest

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  trait Equals extends StObject {
    
    @JSName("equals")
    var equals_FEquals: js.UndefOr[Boolean] = js.undefined
    
    def finalize(other: js.Object): Boolean
    
    @JSName("ne")
    var ne_FEquals: js.UndefOr[js.Function1[/* other */ js.Object, Boolean]] = js.undefined
  }
  object Equals {
    
    inline def apply(finalize_ : js.Object => Boolean): Equals = {
      val __obj = js.Dynamic.literal()
      __obj.updateDynamic("finalize")(js.Any.fromFunction1(finalize_))
      __obj.asInstanceOf[Equals]
    }
    
    extension [Self <: Equals](x: Self) {
      
      inline def setEquals_(value: Boolean): Self = StObject.set(x, "equals", value.asInstanceOf[js.Any])
      
      inline def setEquals_Undefined: Self = StObject.set(x, "equals", js.undefined)
      
      inline def setFinalize_(value: js.Object => Boolean): Self = StObject.set(x, "finalize", js.Any.fromFunction1(value))
      
      inline def setNe_(value: /* other */ js.Object => Boolean): Self = StObject.set(x, "ne", js.Any.fromFunction1(value))
      
      inline def setNe_Undefined: Self = StObject.set(x, "ne", js.undefined)
    }
  }
}
