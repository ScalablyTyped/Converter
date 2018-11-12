package typings
package swizLib.swizMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("swiz", "Swiz")
@js.native
class Swiz protected () extends js.Object {
  def this(defs: js.Array[swizLib.swizMod.structNs.IObj]) = this()
  def this(defs: js.Array[swizLib.swizMod.structNs.IObj], options: ISwizOptions) = this()
  def deserialize(
    mode: SERIALIZATION,
    version: scala.Double,
    raw: java.lang.String,
    callback: js.Function2[/* err */ js.Any, /* result */ js.Any, scala.Unit]
  ): scala.Unit = js.native
  def getFieldDefinition(stype: java.lang.String, name: java.lang.String): swizLib.swizMod.structNs.IField = js.native
  def serialize(
    mode: SERIALIZATION,
    version: scala.Double,
    obj: ISerializable,
    callback: js.Function2[/* err */ js.Any, /* result */ java.lang.String, scala.Unit]
  ): scala.Unit = js.native
  def serializeForPagination(
    mode: SERIALIZATION,
    array: js.Array[_],
    metadata: js.Any,
    callback: js.Function2[/* err */ js.Any, /* result */ java.lang.String, scala.Unit]
  ): scala.Unit = js.native
}

