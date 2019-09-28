package typings.constDashEnum

import typings.constDashEnum.constDashEnumMod.Foo
import typings.constDashEnum.constDashEnumMod.Foo2
import scala.scalajs.js
import scala.scalajs.js.`|`

object constDashEnumNumbers {
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
  
  @inline
  def `0`: `0` = 0.asInstanceOf[`0`]
  @inline
  def `1`: `1` = 1.asInstanceOf[`1`]
  @inline
  def `22`: `22` = 22.asInstanceOf[`22`]
}

