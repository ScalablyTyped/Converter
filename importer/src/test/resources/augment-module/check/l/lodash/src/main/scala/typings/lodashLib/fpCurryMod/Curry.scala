package typings
package lodashLib.fpCurryMod

import lodashLib.lodashMod.CurriedFunction1
import lodashLib.lodashMod.CurriedFunction2
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Curry extends js.Object {
  def apply[T1, R](func: js.Function1[/* t1 */ T1, R]): CurriedFunction1[T1, R] = js.native
  def apply[T1, T2, R](func: js.Function2[/* t1 */ T1, /* t2 */ T2, R]): CurriedFunction2[T1, T2, R] = js.native
}

