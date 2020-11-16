package typings.swiz.mod

import typings.swiz.mod.struct.IField
import typings.swiz.mod.struct.IObj
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@JSImport("swiz", "Swiz")
@js.native
class Swiz protected () extends js.Object {
  def this(defs: js.Array[IObj]) = this()
  def this(defs: js.Array[IObj], options: ISwizOptions) = this()
  
  def deserialize(
    mode: SERIALIZATION,
    version: Double,
    raw: String,
    callback: js.Function2[/* err */ js.Any, /* result */ js.Any, Unit]
  ): Unit = js.native
  
  def getFieldDefinition(stype: String, name: String): IField = js.native
  
  def serialize(
    mode: SERIALIZATION,
    version: Double,
    obj: ISerializable,
    callback: js.Function2[/* err */ js.Any, /* result */ String, Unit]
  ): Unit = js.native
  
  def serializeForPagination(
    mode: SERIALIZATION,
    array: js.Array[_],
    metadata: js.Any,
    callback: js.Function2[/* err */ js.Any, /* result */ String, Unit]
  ): Unit = js.native
}
