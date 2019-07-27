package typings.node

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait SymbolConstructor extends js.Object {
  val asyncIterator: js.Symbol
  val iterator: js.Symbol
}

object SymbolConstructor {
  @scala.inline
  def apply(asyncIterator: js.Symbol, iterator: js.Symbol): SymbolConstructor = {
    val __obj = js.Dynamic.literal(asyncIterator = asyncIterator, iterator = iterator)
  
    __obj.asInstanceOf[SymbolConstructor]
  }
}

