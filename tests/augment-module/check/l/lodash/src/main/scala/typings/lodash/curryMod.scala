package typings.lodash

import typings.lodash.mod.CurriedFunction1
import typings.lodash.mod.CurriedFunction2
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object curryMod {
  
  @JSImport("lodash/fp/curry", JSImport.Namespace)
  @js.native
  val ^ : Curry = js.native
  
  /* Syntax to write `curryMod` instead of `curryMod.^` */
  @scala.inline
  implicit def __is(ignored: curryMod.type): Curry = typings.lodash.curryMod.^
  
  @js.native
  trait Curry extends js.Object {
    
    def apply[T1, R](func: js.Function1[/* t1 */ T1, R]): CurriedFunction1[T1, R] = js.native
    def apply[T1, T2, R](func: js.Function2[/* t1 */ T1, /* t2 */ T2, R]): CurriedFunction2[T1, T2, R] = js.native
  }
}
