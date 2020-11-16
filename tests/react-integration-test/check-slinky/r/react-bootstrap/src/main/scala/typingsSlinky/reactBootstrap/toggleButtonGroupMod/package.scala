package typingsSlinky.reactBootstrap

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

package object toggleButtonGroupMod {
  
  type ToggleButtonGroupProps = typingsSlinky.reactBootstrap.toggleButtonGroupMod.BaseProps with (typingsSlinky.reactBootstrap.toggleButtonGroupMod.RadioProps | typingsSlinky.reactBootstrap.toggleButtonGroupMod.CheckboxProps) with (typingsSlinky.reactBootstrap.mod.Omit[
    typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroupProps, 
    typingsSlinky.reactBootstrap.reactBootstrapStrings.onChange
  ]) with (typingsSlinky.reactBootstrap.mod.Omit[
    typingsSlinky.react.mod.HTMLProps[typingsSlinky.reactBootstrap.toggleButtonGroupMod.ToggleButtonGroup], 
    typingsSlinky.reactBootstrap.reactBootstrapStrings.defaultValue | typingsSlinky.reactBootstrap.reactBootstrapStrings.`type` | typingsSlinky.reactBootstrap.reactBootstrapStrings.value | typingsSlinky.reactBootstrap.reactBootstrapStrings.onChange
  ])
}
