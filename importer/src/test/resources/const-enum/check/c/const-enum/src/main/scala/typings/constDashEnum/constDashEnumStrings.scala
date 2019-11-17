package typings.constDashEnum

import typings.constDashEnum.constDashEnumMod.Foo
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object constDashEnumStrings {
  @js.native
  sealed trait C extends Foo
  
  @scala.inline
  def C: C = "C".asInstanceOf[C]
}

