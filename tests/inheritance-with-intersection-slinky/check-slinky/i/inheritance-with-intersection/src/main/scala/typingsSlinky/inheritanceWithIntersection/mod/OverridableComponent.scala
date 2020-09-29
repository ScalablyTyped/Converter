package typingsSlinky.inheritanceWithIntersection.mod

import slinky.core.facade.ReactElement
import typingsSlinky.inheritanceWithIntersection.anon.Component
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait OverridableComponent extends js.Object {
  def apply(props: AProps): ReactElement = js.native
  def apply[C /* <: ReactElement */](props: Component[C]): ReactElement = js.native
}

