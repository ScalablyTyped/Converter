package typings.reactDashBootstrapLib

import typings.reactDashBootstrapLib.libButtonGroupMod.ButtonGroupProps
import typings.reactDashBootstrapLib.reactDashBootstrapLibStrings.`type`
import typings.reactDashBootstrapLib.reactDashBootstrapLibStrings.defaultValue
import typings.reactDashBootstrapLib.reactDashBootstrapLibStrings.onChange
import typings.reactDashBootstrapLib.reactDashBootstrapLibStrings.value
import typings.reactDashBootstrapLib.reactDashBootstrapMod.Omit
import typings.reactLib.reactMod.HTMLProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object libToggleButtonGroupMod {
  type ToggleButtonGroupProps = BaseProps with (RadioProps | CheckboxProps) with (Omit[ButtonGroupProps, onChange]) with (Omit[HTMLProps[ToggleButtonGroup], defaultValue | `type` | value | onChange])
}
