package typings.lodash

import org.scalablytyped.runtime.Shortcut
import typings.lodash.mod.CurriedFunction1
import typings.lodash.mod.CurriedFunction2
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object curryMod extends Shortcut {
  
  @JSImport("lodash/fp/curry", JSImport.Namespace)
  @js.native
  val ^ : Curry = js.native
  
  @js.native
  trait Curry extends StObject {
    
    def apply[T1, R](func: js.Function1[/* t1 */ T1, R]): CurriedFunction1[T1, R] = js.native
    def apply[T1, T2, R](func: js.Function2[/* t1 */ T1, /* t2 */ T2, R]): CurriedFunction2[T1, T2, R] = js.native
  }
  
  type _To = Curry
  
  /* This means you don't have to write `^`, but can instead just say `curryMod.foo` */
  override def _to: Curry = ^
}
