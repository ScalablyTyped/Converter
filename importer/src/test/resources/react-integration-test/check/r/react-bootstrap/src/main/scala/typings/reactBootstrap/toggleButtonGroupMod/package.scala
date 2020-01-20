package typings.reactBootstrap

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object toggleButtonGroupMod {
  import typings.react.mod.HTMLProps
  import typings.reactBootstrap.buttonGroupMod.ButtonGroupProps
  import typings.reactBootstrap.mod.Omit
  import typings.reactBootstrap.reactBootstrapStrings.`type`
  import typings.reactBootstrap.reactBootstrapStrings.defaultValue
  import typings.reactBootstrap.reactBootstrapStrings.onChange
  import typings.reactBootstrap.reactBootstrapStrings.value

  type ToggleButtonGroupProps = BaseProps with (RadioProps | CheckboxProps) with (Omit[ButtonGroupProps, onChange]) with (Omit[HTMLProps[ToggleButtonGroup], defaultValue | `type` | value | onChange])
}
