package typingsSlinky.reactBootstrap

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object toggleButtonGroupMod {
  import typingsSlinky.react.mod.HTMLProps
  import typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroupProps
  import typingsSlinky.reactBootstrap.mod.Omit
  import typingsSlinky.reactBootstrap.reactBootstrapStrings.`type`
  import typingsSlinky.reactBootstrap.reactBootstrapStrings.defaultValue
  import typingsSlinky.reactBootstrap.reactBootstrapStrings.onChange
  import typingsSlinky.reactBootstrap.reactBootstrapStrings.value

  type ToggleButtonGroupProps = BaseProps with (RadioProps | CheckboxProps) with (Omit[ButtonGroupProps, onChange]) with (Omit[HTMLProps[ToggleButtonGroup], defaultValue | `type` | value | onChange])
}
