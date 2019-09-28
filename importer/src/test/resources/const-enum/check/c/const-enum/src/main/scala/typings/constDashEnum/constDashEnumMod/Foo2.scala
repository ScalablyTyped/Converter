package typings.constDashEnum.constDashEnumMod

import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.annotation.ScalaJSDefined
import typings.constDashEnum.constDashEnumNumbers.`0`
import typings.constDashEnum.constDashEnumNumbers.`1`
import typings.constDashEnum.constDashEnumNumbers.`22`
import scala.scalajs.js
import scala.scalajs.js.`|`

/* Rewritten from type alias, can be one of: 
  - typings.constDashEnum.constDashEnumNumbers.`0`
  - typings.constDashEnum.constDashEnumNumbers.`22`
  - typings.constDashEnum.constDashEnumNumbers.`1`
*/
trait Foo2 extends js.Object

object Foo2 {
  @inline
  def A: `0` = this.cast(0)
  @inline
  def B: `22` = this.cast(22)
  @inline
  def C: `1` = this.cast(0 + 1)
  @inline
  /* private */ def cast[T](in: js.Any): T = in.asInstanceOf[T]
}

@JSImport("const-enum", "foo2")
@js.native
object foo2 extends js.Object {
  def apply(x: Foo2): Double = js.native
}

