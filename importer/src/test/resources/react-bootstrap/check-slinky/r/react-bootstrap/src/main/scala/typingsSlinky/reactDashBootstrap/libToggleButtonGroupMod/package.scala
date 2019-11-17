package typingsSlinky.reactDashBootstrap

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object libToggleButtonGroupMod {
  import typingsSlinky.react.reactMod.HTMLProps
  import typingsSlinky.reactDashBootstrap.libButtonGroupMod.ButtonGroupProps
  import typingsSlinky.reactDashBootstrap.reactDashBootstrapMod.Omit
  import typingsSlinky.reactDashBootstrap.reactDashBootstrapStrings.`type`
  import typingsSlinky.reactDashBootstrap.reactDashBootstrapStrings.defaultValue
  import typingsSlinky.reactDashBootstrap.reactDashBootstrapStrings.onChange
  import typingsSlinky.reactDashBootstrap.reactDashBootstrapStrings.value

  type ToggleButtonGroupProps = BaseProps with (RadioProps | CheckboxProps) with (Omit[ButtonGroupProps, onChange]) with (Omit[HTMLProps[ToggleButtonGroup], defaultValue | `type` | value | onChange])
}
