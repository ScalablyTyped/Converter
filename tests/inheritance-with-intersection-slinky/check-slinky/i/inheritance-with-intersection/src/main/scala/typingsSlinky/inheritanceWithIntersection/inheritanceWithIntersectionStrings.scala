package typingsSlinky.inheritanceWithIntersection

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object inheritanceWithIntersectionStrings {
  @js.native
  sealed trait a extends js.Object
  
  @js.native
  sealed trait button extends js.Object
  
  @scala.inline
  def a: a = "a".asInstanceOf[a]
  @scala.inline
  def button: button = "button".asInstanceOf[button]
}

