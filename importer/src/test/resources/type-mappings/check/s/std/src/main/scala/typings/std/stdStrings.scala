package typings.std

import scala.scalajs.js
import scala.scalajs.js.`|`

object stdStrings {
  @js.native
  sealed trait Partial extends js.Object
  
  @js.native
  sealed trait Pick extends js.Object
  
  @js.native
  sealed trait Proxify extends js.Object
  
  @js.native
  sealed trait Readonly extends js.Object
  
  @js.native
  sealed trait Required extends js.Object
  
  @inline
  def Partial: Partial = "Partial".asInstanceOf[Partial]
  @inline
  def Pick: Pick = "Pick".asInstanceOf[Pick]
  @inline
  def Proxify: Proxify = "Proxify".asInstanceOf[Proxify]
  @inline
  def Readonly: Readonly = "Readonly".asInstanceOf[Readonly]
  @inline
  def Required: Required = "Required".asInstanceOf[Required]
}

