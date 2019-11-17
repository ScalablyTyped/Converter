package typings.constDashEnum.constDashEnumMod

import typings.constDashEnum.constDashEnumNumbers.`1`
import typings.constDashEnum.constDashEnumNumbers.`22`
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.constDashEnum.constDashEnumNumbers.`1`
  - typings.constDashEnum.constDashEnumNumbers.`22`
  - typings.constDashEnum.constDashEnumStrings.C
*/
trait Foo extends js.Object

object Foo {
  @scala.inline
  def A: `1` = this.cast(1)
  @scala.inline
  def B: `22` = this.cast(22)
  @scala.inline
  def C: typings.constDashEnum.constDashEnumStrings.C = this.cast("C")
  @scala.inline
  /* private */ def cast[T](in: js.Any): T = in.asInstanceOf[T]
}

