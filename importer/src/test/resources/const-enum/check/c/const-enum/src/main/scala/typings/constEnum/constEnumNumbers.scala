package typings.constEnum

import typings.constEnum.constEnumMod.Foo
import typings.constEnum.constEnumMod.Foo2
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object constEnumNumbers {
  @js.native
  sealed trait `0` extends Foo2
  
  @js.native
  sealed trait `1`
    extends Foo
       with Foo2
  
  @js.native
  sealed trait `22`
    extends Foo
       with Foo2
  
  @scala.inline
  def `0`: `0` = 0.asInstanceOf[`0`]
  @scala.inline
  def `1`: `1` = 1.asInstanceOf[`1`]
  @scala.inline
  def `22`: `22` = 22.asInstanceOf[`22`]
}

