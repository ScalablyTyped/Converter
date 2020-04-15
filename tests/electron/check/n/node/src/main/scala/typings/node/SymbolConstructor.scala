package typings.node

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SymbolConstructor extends js.Object {
  val asyncIterator: js.Symbol = js.native
  val iterator: js.Symbol = js.native
}

object SymbolConstructor {
  @scala.inline
  def apply(asyncIterator: js.Symbol, iterator: js.Symbol): SymbolConstructor = {
    val __obj = js.Dynamic.literal(asyncIterator = asyncIterator.asInstanceOf[js.Any], iterator = iterator.asInstanceOf[js.Any])
    __obj.asInstanceOf[SymbolConstructor]
  }
}

