package typings.fpTs

import typings.fpTs.libConstMod.Const
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object libHktMod {
  
  trait HKT[URI, A] extends StObject {
    
    val _A: A
    
    val _URI: URI
  }
  object HKT {
    
    inline def apply[URI, A](_A: A, _URI: URI): HKT[URI, A] = {
      val __obj = js.Dynamic.literal(_A = _A.asInstanceOf[js.Any], _URI = _URI.asInstanceOf[js.Any])
      __obj.asInstanceOf[HKT[URI, A]]
    }
    
    extension [Self <: HKT[?, ?], URI, A](x: Self & (HKT[URI, A])) {
      
      inline def set_A(value: A): Self = StObject.set(x, "_A", value.asInstanceOf[js.Any])
      
      inline def set_URI(value: URI): Self = StObject.set(x, "_URI", value.asInstanceOf[js.Any])
    }
  }
  
  type Type[URI /* <: URIS */, A] = /* import warning: importer.ImportType#apply Failed type conversion: fp-ts.fp-ts/lib/HKT.URI2HKT<A>[URI] */ js.Any
  
  trait URI2HKT[A] extends StObject
  
  trait URI2HKT2[L, A] extends StObject {
    
    var Const: typings.fpTs.libConstMod.Const[L, A]
  }
  object URI2HKT2 {
    
    inline def apply[L, A](Const: Const[L, A]): URI2HKT2[L, A] = {
      val __obj = js.Dynamic.literal(Const = Const.asInstanceOf[js.Any])
      __obj.asInstanceOf[URI2HKT2[L, A]]
    }
    
    extension [Self <: URI2HKT2[?, ?], L, A](x: Self & (URI2HKT2[L, A])) {
      
      inline def setConst(value: Const[L, A]): Self = StObject.set(x, "Const", value.asInstanceOf[js.Any])
    }
  }
  
  type URIS = /* import warning: importer.ImportType#apply Failed type conversion: fp-ts.fp-ts/lib/HKT.HKT<never, never>['_URI'] */ js.Any
}
