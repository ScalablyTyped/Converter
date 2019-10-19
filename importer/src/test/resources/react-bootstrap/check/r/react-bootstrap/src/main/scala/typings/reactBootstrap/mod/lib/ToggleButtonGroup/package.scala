package typings.reactBootstrap.mod.lib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object ToggleButtonGroup {
  import typings.react.mod.HTMLProps
  import typings.reactBootstrap.mod.Omit
  import typings.reactBootstrap.mod.lib.ButtonGroup.ButtonGroupProps
  import typings.reactBootstrap.reactBootstrapStrings.`type`
  import typings.reactBootstrap.reactBootstrapStrings.defaultValue
  import typings.reactBootstrap.reactBootstrapStrings.onChange
  import typings.reactBootstrap.reactBootstrapStrings.value

  type ToggleButtonGroupProps = BaseProps with (RadioProps | CheckboxProps) with (Omit[ButtonGroupProps, onChange]) with (Omit[
    HTMLProps[typings.reactBootstrap.mod.lib.ToggleButtonGroup.ToggleButtonGroup], 
    defaultValue | `type` | value | onChange
  ])
}
