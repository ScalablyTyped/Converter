package typings.react

import scala.scalajs.js.annotation.ScalaJSDefined
import typings.react.reactMod.ReactNode
import scala.scalajs.js
import scala.scalajs.js.`|`

trait Anon_Children extends js.Object {
  var children: js.UndefOr[ReactNode] = js.undefined
}

object Anon_Children {
  @inline
  def apply(children: ReactNode = null): Anon_Children = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    __obj.asInstanceOf[Anon_Children]
  }
}

