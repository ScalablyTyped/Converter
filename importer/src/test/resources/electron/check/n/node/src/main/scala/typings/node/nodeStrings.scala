package typings.node

import scala.scalajs.js
import scala.scalajs.js.`|`

object nodeStrings {
  @js.native
  sealed trait foo extends js.Object
  
  @inline
  def foo: foo = "foo".asInstanceOf[foo]
}

