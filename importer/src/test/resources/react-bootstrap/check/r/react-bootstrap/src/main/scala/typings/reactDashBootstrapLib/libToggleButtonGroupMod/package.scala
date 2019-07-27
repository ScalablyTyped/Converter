package typings
package reactDashBootstrapLib

import reactDashBootstrapLib.libButtonGroupMod.ButtonGroupProps
import reactDashBootstrapLib.reactDashBootstrapLibStrings.`type`
import reactDashBootstrapLib.reactDashBootstrapLibStrings.defaultValue
import reactDashBootstrapLib.reactDashBootstrapLibStrings.onChange
import reactDashBootstrapLib.reactDashBootstrapLibStrings.value
import reactDashBootstrapLib.reactDashBootstrapMod.Omit
import reactLib.reactMod.HTMLProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object libToggleButtonGroupMod {
  type ToggleButtonGroupProps = BaseProps with (RadioProps | CheckboxProps) with (Omit[ButtonGroupProps, onChange]) with (Omit[HTMLProps[ToggleButtonGroup], defaultValue | `type` | value | onChange])
}
