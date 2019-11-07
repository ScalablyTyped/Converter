package typings.constEnum.constEnumMod

import typings.constEnum.constEnumNumbers.`1`
import typings.constEnum.constEnumNumbers.`22`
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.constEnum.constEnumNumbers.`1`
  - typings.constEnum.constEnumNumbers.`22`
  - typings.constEnum.constEnumStrings.C
*/
trait Foo extends js.Object

object Foo {
  @scala.inline
  def A: `1` = this.cast(1)
  @scala.inline
  def B: `22` = this.cast(22)
  @scala.inline
  def C: typings.constEnum.constEnumStrings.C = this.cast("C")
  @scala.inline
  /* private */ def cast[T](in: js.Any): T = in.asInstanceOf[T]
}

