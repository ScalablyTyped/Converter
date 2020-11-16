package typings.constEnum.mod

import typings.constEnum.constEnumNumbers._4294901760
import typings.constEnum.constEnumNumbers.`16`
import typings.constEnum.constEnumNumbers.`65535`
import typings.constEnum.constEnumNumbers.`65536`
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* Rewritten from type alias, can be one of: 
  - typings.constEnum.constEnumNumbers.`65535`
  - typings.constEnum.constEnumNumbers.`65536`
  - typings.constEnum.constEnumNumbers.`16`
  - typings.constEnum.constEnumNumbers._4294901760
*/
trait PreOrderHookFlags extends js.Object
object PreOrderHookFlags {
  
  /** The index of the next pre-order hook to be called in the hooks array, on the first 16
    bits */
  @scala.inline
  def IndexOfTheNextPreOrderHookMaskMask: `65535` = 65535.asInstanceOf[`65535`]
  
  /**
    * The number of init hooks that have already been called, on the last 16 bits
    */
  @scala.inline
  def NumberOfInitHooksCalledIncrementer: `65536` = 65536.asInstanceOf[`65536`]
  
  @scala.inline
  def NumberOfInitHooksCalledMask: _4294901760 = 4294901760.0.asInstanceOf[_4294901760]
  
  @scala.inline
  def NumberOfInitHooksCalledShift: `16` = 16.asInstanceOf[`16`]
}
