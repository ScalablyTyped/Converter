package typingsJapgolly.componentstest

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait Equals extends StObject {
    
    @JSName("equals")
    var equals_FEquals: js.UndefOr[Boolean] = js.native
    
    def finalize(other: js.Object): Boolean = js.native
    
    @JSName("ne")
    var ne_FEquals: js.UndefOr[js.Function1[/* other */ js.Object, Boolean]] = js.native
  }
  object Equals {
    
    @scala.inline
    def apply(finalize_ : js.Object => Boolean): Equals = {
      val __obj = js.Dynamic.literal()
      __obj.updateDynamic("finalize")(js.Any.fromFunction1(finalize_))
      __obj.asInstanceOf[Equals]
    }
    
    @scala.inline
    implicit class EqualsMutableBuilder[Self <: Equals] (val x: Self) extends AnyVal {
      
      @scala.inline
      def setEquals_(value: Boolean): Self = StObject.set(x, "equals", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setEquals_Undefined: Self = StObject.set(x, "equals", js.undefined)
      
      @scala.inline
      def setFinalize_(value: js.Object => Boolean): Self = StObject.set(x, "finalize", js.Any.fromFunction1(value))
      
      @scala.inline
      def setNe_(value: /* other */ js.Object => Boolean): Self = StObject.set(x, "ne", js.Any.fromFunction1(value))
      
      @scala.inline
      def setNe_Undefined: Self = StObject.set(x, "ne", js.undefined)
    }
  }
}
