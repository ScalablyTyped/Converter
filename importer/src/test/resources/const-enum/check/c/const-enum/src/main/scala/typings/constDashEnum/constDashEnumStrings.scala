package typings.constDashEnum

import typings.constDashEnum.constDashEnumMod.Foo
import scala.scalajs.js
import scala.scalajs.js.`|`

object constDashEnumStrings {
  @js.native
  sealed trait C extends Foo
  
  @inline
  def C: C = "C".asInstanceOf[C]
}

