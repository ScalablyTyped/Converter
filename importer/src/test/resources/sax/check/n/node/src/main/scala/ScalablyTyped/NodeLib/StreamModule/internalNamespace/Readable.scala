package ScalablyTyped
package NodeLib.StreamModule.internalNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* RemoveDifficultStuff *//* RemoveMultipleInheritance: Dropped parents ArrayBuffer(TypeRef(QualifiedName(List(Name(NodeLib), Name(NodeJSNamespace), Name(ReadableStream))),List(),NoComments))*/
@js.native
trait Readable extends NodeLib.StreamModule.internal {
  @JSName("on")
  def on_close(event: NodeLib.NodeLibStrings.close, listener: js.Function0[scala.Unit]): this.type = js.native
  def read(): js.Any = js.native
  def read(size: scala.Double): js.Any = js.native
}

