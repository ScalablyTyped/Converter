package typingsSlinky.reactBootstrap.mod.lib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object ToggleButtonGroup {
  import typingsSlinky.react.mod.HTMLProps
  import typingsSlinky.reactBootstrap.mod.Omit
  import typingsSlinky.reactBootstrap.mod.lib.ButtonGroup.ButtonGroupProps
  import typingsSlinky.reactBootstrap.reactBootstrapStrings.`type`
  import typingsSlinky.reactBootstrap.reactBootstrapStrings.defaultValue
  import typingsSlinky.reactBootstrap.reactBootstrapStrings.onChange
  import typingsSlinky.reactBootstrap.reactBootstrapStrings.value

  type ToggleButtonGroupProps = BaseProps with (RadioProps | CheckboxProps) with (Omit[ButtonGroupProps, onChange]) with (Omit[
    HTMLProps[typingsSlinky.reactBootstrap.mod.lib.ToggleButtonGroup.ToggleButtonGroup], 
    defaultValue | `type` | value | onChange
  ])
}
