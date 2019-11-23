package typingsJapgolly.reactDashBootstrap

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object libToggleButtonGroupMod {
  import typingsJapgolly.react.reactMod.HTMLProps
  import typingsJapgolly.reactDashBootstrap.libButtonGroupMod.ButtonGroupProps
  import typingsJapgolly.reactDashBootstrap.reactDashBootstrapMod.Omit
  import typingsJapgolly.reactDashBootstrap.reactDashBootstrapStrings.`type`
  import typingsJapgolly.reactDashBootstrap.reactDashBootstrapStrings.defaultValue
  import typingsJapgolly.reactDashBootstrap.reactDashBootstrapStrings.onChange
  import typingsJapgolly.reactDashBootstrap.reactDashBootstrapStrings.value

  type ToggleButtonGroupProps = BaseProps with (RadioProps | CheckboxProps) with (Omit[ButtonGroupProps, onChange]) with (Omit[HTMLProps[ToggleButtonGroup], defaultValue | `type` | value | onChange])
}
