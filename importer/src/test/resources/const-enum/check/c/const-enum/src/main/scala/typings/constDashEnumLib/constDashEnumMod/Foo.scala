package typings.constDashEnumLib.constDashEnumMod

import typings.constDashEnumLib.constDashEnumLibNumbers.`1`
import typings.constDashEnumLib.constDashEnumLibNumbers.`22`
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.constDashEnumLib.constDashEnumLibNumbers.`1`
  - typings.constDashEnumLib.constDashEnumLibNumbers.`22`
  - typings.constDashEnumLib.constDashEnumLibStrings.C
*/
trait Foo extends js.Object

object Foo {
  @scala.inline
  def A: `1` = this.cast(1)
  @scala.inline
  def B: `22` = this.cast(22)
  @scala.inline
  def C: typings.constDashEnumLib.constDashEnumLibStrings.C = this.cast("C")
  @scala.inline
  /* private */ def cast[T](in: js.Any): T = in.asInstanceOf[T]
}

