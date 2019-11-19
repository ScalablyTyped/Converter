package typingsJapgolly.reactBootstrap

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object libToggleButtonGroupMod {
  import typingsJapgolly.react.reactMod.HTMLProps
  import typingsJapgolly.reactBootstrap.libButtonGroupMod.ButtonGroupProps
  import typingsJapgolly.reactBootstrap.reactBootstrapMod.Omit
  import typingsJapgolly.reactBootstrap.reactBootstrapStrings.`type`
  import typingsJapgolly.reactBootstrap.reactBootstrapStrings.defaultValue
  import typingsJapgolly.reactBootstrap.reactBootstrapStrings.onChange
  import typingsJapgolly.reactBootstrap.reactBootstrapStrings.value

  type ToggleButtonGroupProps = BaseProps with (RadioProps | CheckboxProps) with (Omit[ButtonGroupProps, onChange]) with (Omit[HTMLProps[ToggleButtonGroup], defaultValue | `type` | value | onChange])
}
