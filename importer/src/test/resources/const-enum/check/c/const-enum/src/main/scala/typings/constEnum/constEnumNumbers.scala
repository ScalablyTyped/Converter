package typings.constEnum

import typings.constEnum.mod.Foo2_
import typings.constEnum.mod.Foo_
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object constEnumNumbers {
  @js.native
  sealed trait `0` extends Foo2_
  
  @js.native
  sealed trait `1`
    extends Foo2_
       with Foo_
  
  @js.native
  sealed trait `22`
    extends Foo2_
       with Foo_
  
  @scala.inline
  def `0`: `0` = 0.asInstanceOf[`0`]
  @scala.inline
  def `1`: `1` = 1.asInstanceOf[`1`]
  @scala.inline
  def `22`: `22` = 22.asInstanceOf[`22`]
}

