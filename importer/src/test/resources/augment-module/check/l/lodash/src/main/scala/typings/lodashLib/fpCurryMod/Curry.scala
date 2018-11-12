package typings
package lodashLib.fpCurryMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Curry extends js.Object {
  def apply[T1, R](func: js.Function1[/* t1 */ T1, R]): lodashLib.lodashMod.underscoreNs.CurriedFunction1[T1, R] = js.native
  def apply[T1, T2, R](func: js.Function2[/* t1 */ T1, /* t2 */ T2, R]): lodashLib.lodashMod.underscoreNs.CurriedFunction2[T1, T2, R] = js.native
}

