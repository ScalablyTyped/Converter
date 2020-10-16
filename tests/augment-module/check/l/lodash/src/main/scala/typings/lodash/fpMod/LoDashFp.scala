package typings.lodash.fpMod

import typings.lodash.curryMod.Curry
import typings.lodash.mod.CurriedFunction1
import typings.lodash.mod.CurriedFunction2
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait LoDashFp extends js.Object {
  def curry[T1, R](func: js.Function1[/* t1 */ T1, R]): CurriedFunction1[T1, R] = js.native
  def curry[T1, T2, R](func: js.Function2[/* t1 */ T1, /* t2 */ T2, R]): CurriedFunction2[T1, T2, R] = js.native
  @JSName("curry")
  var curry_Original: Curry = js.native
}

