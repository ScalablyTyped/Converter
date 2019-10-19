package typingsJapgolly.reactBootstrap.mod.lib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object ToggleButtonGroup {
  import typingsJapgolly.react.mod.HTMLProps
  import typingsJapgolly.reactBootstrap.mod.Omit
  import typingsJapgolly.reactBootstrap.mod.lib.ButtonGroup.ButtonGroupProps
  import typingsJapgolly.reactBootstrap.reactBootstrapStrings.`type`
  import typingsJapgolly.reactBootstrap.reactBootstrapStrings.defaultValue
  import typingsJapgolly.reactBootstrap.reactBootstrapStrings.onChange
  import typingsJapgolly.reactBootstrap.reactBootstrapStrings.value

  type ToggleButtonGroupProps = BaseProps with (RadioProps | CheckboxProps) with (Omit[ButtonGroupProps, onChange]) with (Omit[
    HTMLProps[typingsJapgolly.reactBootstrap.mod.lib.ToggleButtonGroup.ToggleButtonGroup], 
    defaultValue | `type` | value | onChange
  ])
}
