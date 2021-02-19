package typings.fpTs

import typings.fpTs.constMod.Const
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object hktMod {
  
  @js.native
  trait HKT[URI, A] extends StObject {
    
    val _A: A = js.native
    
    val _URI: URI = js.native
  }
  object HKT {
    
    @scala.inline
    def apply[URI, A](_A: A, _URI: URI): HKT[URI, A] = {
      val __obj = js.Dynamic.literal(_A = _A.asInstanceOf[js.Any], _URI = _URI.asInstanceOf[js.Any])
      __obj.asInstanceOf[HKT[URI, A]]
    }
    
    @scala.inline
    implicit class HKTMutableBuilder[Self <: HKT[?, ?], URI, A] (val x: Self & (HKT[URI, A])) extends AnyVal {
      
      @scala.inline
      def set_A(value: A): Self = StObject.set(x, "_A", value.asInstanceOf[js.Any])
      
      @scala.inline
      def set_URI(value: URI): Self = StObject.set(x, "_URI", value.asInstanceOf[js.Any])
    }
  }
  
  type Type[URI /* <: URIS */, A] = /* import warning: importer.ImportType#apply Failed type conversion: fp-ts.fp-ts/lib/HKT.URI2HKT<A>[URI] */ js.Any
  
  @js.native
  trait URI2HKT[A] extends StObject
  
  @js.native
  trait URI2HKT2[L, A] extends StObject {
    
    var Const: typings.fpTs.constMod.Const[L, A] = js.native
  }
  object URI2HKT2 {
    
    @scala.inline
    def apply[L, A](Const: Const[L, A]): URI2HKT2[L, A] = {
      val __obj = js.Dynamic.literal(Const = Const.asInstanceOf[js.Any])
      __obj.asInstanceOf[URI2HKT2[L, A]]
    }
    
    @scala.inline
    implicit class URI2HKT2MutableBuilder[Self <: URI2HKT2[?, ?], L, A] (val x: Self & (URI2HKT2[L, A])) extends AnyVal {
      
      @scala.inline
      def setConst(value: Const[L, A]): Self = StObject.set(x, "Const", value.asInstanceOf[js.Any])
    }
  }
  
  type URIS = /* import warning: importer.ImportType#apply Failed type conversion: fp-ts.fp-ts/lib/HKT.HKT<never, never>['_URI'] */ js.Any
}
