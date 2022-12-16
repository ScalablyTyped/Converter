package typingsSlinky.componentstest

import slinky.core.facade.ReactElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  /* Inlined react.react.PropsWithChildren<{  ne :(other : object): boolean | undefined,   equals :boolean | undefined, finalize (other : object): boolean}> */
  trait PropsWithChildren extends StObject {
    
    var children: js.UndefOr[ReactElement] = js.undefined
    
    @JSName("equals")
    var equals_FPropsWithChildren: js.UndefOr[Boolean] = js.undefined
    
    def finalize(other: js.Object): Boolean
    
    @JSName("ne")
    var ne_FPropsWithChildren: js.UndefOr[js.Function1[/* other */ js.Object, Boolean]] = js.undefined
  }
  object PropsWithChildren {
    
    inline def apply(finalize_ : js.Object => Boolean): PropsWithChildren = {
      val __obj = js.Dynamic.literal()
      __obj.updateDynamic("finalize")(js.Any.fromFunction1(finalize_))
      __obj.asInstanceOf[PropsWithChildren]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: PropsWithChildren] (val x: Self) extends AnyVal {
      
      inline def setChildren(value: ReactElement): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
      
      inline def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
      
      inline def setEquals_(value: Boolean): Self = StObject.set(x, "equals", value.asInstanceOf[js.Any])
      
      inline def setEquals_Undefined: Self = StObject.set(x, "equals", js.undefined)
      
      inline def setFinalize_(value: js.Object => Boolean): Self = StObject.set(x, "finalize", js.Any.fromFunction1(value))
      
      inline def setNe_(value: /* other */ js.Object => Boolean): Self = StObject.set(x, "ne", js.Any.fromFunction1(value))
      
      inline def setNe_Undefined: Self = StObject.set(x, "ne", js.undefined)
    }
  }
}
