package typings.reactBootstrap

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object libToggleButtonGroupMod {
  import typings.react.reactMod.HTMLProps
  import typings.reactBootstrap.libButtonGroupMod.ButtonGroupProps
  import typings.reactBootstrap.reactBootstrapMod.Omit
  import typings.reactBootstrap.reactBootstrapStrings.`type`
  import typings.reactBootstrap.reactBootstrapStrings.defaultValue
  import typings.reactBootstrap.reactBootstrapStrings.onChange
  import typings.reactBootstrap.reactBootstrapStrings.value

  type ToggleButtonGroupProps = BaseProps with (RadioProps | CheckboxProps) with (Omit[ButtonGroupProps, onChange]) with (Omit[HTMLProps[ToggleButtonGroup], defaultValue | `type` | value | onChange])
}
