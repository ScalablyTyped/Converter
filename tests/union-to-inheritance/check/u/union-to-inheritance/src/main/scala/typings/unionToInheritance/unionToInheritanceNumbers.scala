package typings.unionToInheritance

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object unionToInheritanceNumbers {
  @js.native
  sealed trait `1` extends C
  
  @js.native
  sealed trait `2` extends C
  
  @scala.inline
  def `1`: `1` = 1.asInstanceOf[`1`]
  @scala.inline
  def `2`: `2` = 2.asInstanceOf[`2`]
}

