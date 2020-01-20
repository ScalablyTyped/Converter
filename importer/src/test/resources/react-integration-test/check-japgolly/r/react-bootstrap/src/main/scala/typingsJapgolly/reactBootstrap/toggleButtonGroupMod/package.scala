package typingsJapgolly.reactBootstrap

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object toggleButtonGroupMod {
  type ToggleButtonGroupProps = typingsJapgolly.reactBootstrap.toggleButtonGroupMod.BaseProps with (typingsJapgolly.reactBootstrap.toggleButtonGroupMod.RadioProps | typingsJapgolly.reactBootstrap.toggleButtonGroupMod.CheckboxProps) with (typingsJapgolly.reactBootstrap.mod.Omit[
    typingsJapgolly.reactBootstrap.buttonGroupMod.ButtonGroupProps, 
    typingsJapgolly.reactBootstrap.reactBootstrapStrings.onChange
  ]) with (typingsJapgolly.reactBootstrap.mod.Omit[
    typingsJapgolly.react.mod.HTMLProps[typingsJapgolly.reactBootstrap.toggleButtonGroupMod.ToggleButtonGroup], 
    typingsJapgolly.reactBootstrap.reactBootstrapStrings.defaultValue | typingsJapgolly.reactBootstrap.reactBootstrapStrings.`type` | typingsJapgolly.reactBootstrap.reactBootstrapStrings.value | typingsJapgolly.reactBootstrap.reactBootstrapStrings.onChange
  ])
}
