package typings.lodash

import typings.lodash.curryMod.Curry
import typings.lodash.mod.CurriedFunction1
import typings.lodash.mod.CurriedFunction2
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object fpMod {
  
  @JSImport("lodash/fp", JSImport.Namespace)
  @js.native
  val ^ : LoDashFp = js.native
  
  /* Syntax to write `fpMod` instead of `fpMod.^` */
  @scala.inline
  implicit def __is(ignored: fpMod.type): LoDashFp = typings.lodash.fpMod.^
  
  @js.native
  trait LoDashFp extends StObject {
    
    def curry[T1, R](func: js.Function1[/* t1 */ T1, R]): CurriedFunction1[T1, R] = js.native
    def curry[T1, T2, R](func: js.Function2[/* t1 */ T1, /* t2 */ T2, R]): CurriedFunction2[T1, T2, R] = js.native
    @JSName("curry")
    var curry_Original: Curry = js.native
  }
  
  // Backward compatibility with --target es5
  object global {
    
    // tslint:disable-next-line:no-empty-interface
    @js.native
    trait Map[K, V] extends StObject
    
    // tslint:disable-next-line:no-empty-interface
    @js.native
    trait Set[T] extends StObject
    
    // tslint:disable-next-line:no-empty-interface
    @js.native
    trait WeakMap[K /* <: js.Object */, V] extends StObject
    
    // tslint:disable-next-line:no-empty-interface
    @js.native
    trait WeakSet[T] extends StObject
  }
}
