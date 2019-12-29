package typingsSlinky.componentstest.componentstestMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait A extends Props {
  var aMember: Double = js.native
  def aCallback(): Double = js.native
}

object A {
  @scala.inline
  def apply(aCallback: () => Double, aMember: Double): A = {
    val __obj = js.Dynamic.literal(aCallback = js.Any.fromFunction0(aCallback), aMember = aMember.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[A]
  }
}

