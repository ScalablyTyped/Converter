package typings.react.reactMod

import japgolly.scalajs.react.raw.React.Node
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// Context via RenderProps
trait ProviderProps[T] extends js.Object {
  var children: js.UndefOr[Node] = js.undefined
  var value: T
}

object ProviderProps {
  @scala.inline
  def apply[T](value: T, children: Node = null): ProviderProps[T] = {
    val __obj = js.Dynamic.literal(value = value.asInstanceOf[js.Any])
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    __obj.asInstanceOf[ProviderProps[T]]
  }
}

