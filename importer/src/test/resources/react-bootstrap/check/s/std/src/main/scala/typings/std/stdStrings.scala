package typings.std

import scala.scalajs.js
import scala.scalajs.js.`|`

object stdStrings {
  @js.native
  sealed trait Partial extends js.Object
  
  @js.native
  sealed trait Pick extends js.Object
  
  @inline
  def Partial: Partial = "Partial".asInstanceOf[Partial]
  @inline
  def Pick: Pick = "Pick".asInstanceOf[Pick]
}

