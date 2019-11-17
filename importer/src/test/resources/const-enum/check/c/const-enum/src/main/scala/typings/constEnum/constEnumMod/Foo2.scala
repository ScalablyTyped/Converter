package typings.constEnum.constEnumMod

import typings.constEnum.constEnumNumbers.`0`
import typings.constEnum.constEnumNumbers.`1`
import typings.constEnum.constEnumNumbers.`22`
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.constEnum.constEnumNumbers.`0`
  - typings.constEnum.constEnumNumbers.`22`
  - typings.constEnum.constEnumNumbers.`1`
*/
trait Foo2 extends js.Object

object Foo2 {
  @scala.inline
  def A: `0` = this.cast(0)
  @scala.inline
  def B: `22` = this.cast(22)
  @scala.inline
  def C: `1` = this.cast(0 + 1)
  @scala.inline
  /* private */ def cast[T](in: js.Any): T = in.asInstanceOf[T]
}

@JSImport("const-enum", "foo2")
@js.native
object foo2 extends js.Object {
  def apply(x: Foo2): Double = js.native
}

