package typings.constEnum

import typings.constEnum.constEnumMod.Foo
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object constEnumStrings {
  @js.native
  sealed trait C extends Foo
  
  @scala.inline
  def C: C = "C".asInstanceOf[C]
}

