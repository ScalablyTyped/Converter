package typingsSlinky.reactBootstrap

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object libToggleButtonGroupMod {
  import typingsSlinky.react.reactMod.HTMLProps
  import typingsSlinky.reactBootstrap.libButtonGroupMod.ButtonGroupProps
  import typingsSlinky.reactBootstrap.reactBootstrapMod.Omit
  import typingsSlinky.reactBootstrap.reactBootstrapStrings.`type`
  import typingsSlinky.reactBootstrap.reactBootstrapStrings.defaultValue
  import typingsSlinky.reactBootstrap.reactBootstrapStrings.onChange
  import typingsSlinky.reactBootstrap.reactBootstrapStrings.value

  type ToggleButtonGroupProps = BaseProps with (RadioProps | CheckboxProps) with (Omit[ButtonGroupProps, onChange]) with (Omit[HTMLProps[ToggleButtonGroup], defaultValue | `type` | value | onChange])
}
