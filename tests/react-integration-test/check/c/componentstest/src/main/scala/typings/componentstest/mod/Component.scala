package typings.componentstest.mod

import org.scalablytyped.runtime.TopLevel
import typings.react.mod.ComponentState
import typings.react.mod.ComponentType
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("componentstest", "Component")
@js.native
class Component protected ()
  extends typings.react.mod.Component[Props, ComponentState, js.Any] {
  def this(props: Props) = this()
  def this(props: Props, context: js.Any) = this()
}

@JSImport("componentstest", "Component")
@js.native
object Component extends TopLevel[ComponentType[Props]]

