package typings.swiz.swizMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
sealed trait SERIALIZATION extends js.Object

@JSImport("swiz", "SERIALIZATION")
@js.native
object SERIALIZATION extends js.Object {
  @js.native
  sealed trait SERIALIZATION_JSON extends SERIALIZATION
  
  @js.native
  sealed trait SERIALIZATION_XML extends SERIALIZATION
  
  @js.native
  sealed trait _underscore extends SERIALIZATION
  
  @js.native
  sealed trait java extends SERIALIZATION
  
  @js.native
  sealed trait js extends SERIALIZATION
  
  @js.native
  sealed trait notify extends SERIALIZATION
  
}

