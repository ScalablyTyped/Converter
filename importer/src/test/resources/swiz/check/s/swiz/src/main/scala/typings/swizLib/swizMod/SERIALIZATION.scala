package typings
package swizLib.swizMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
sealed trait SERIALIZATION extends js.Object

@JSImport("swiz", "SERIALIZATION")
@js.native
object SERIALIZATION extends js.Object {
  @js.native
  sealed trait SERIALIZATION_JSON
    extends swizLib.swizMod.SERIALIZATION
  
  @js.native
  sealed trait SERIALIZATION_XML
    extends swizLib.swizMod.SERIALIZATION
  
  @js.native
  sealed trait `_`
    extends swizLib.swizMod.SERIALIZATION
  
  @js.native
  sealed trait java
    extends swizLib.swizMod.SERIALIZATION
  
  @js.native
  sealed trait js
    extends swizLib.swizMod.SERIALIZATION
  
  @js.native
  sealed trait notify
    extends swizLib.swizMod.SERIALIZATION
  
}

