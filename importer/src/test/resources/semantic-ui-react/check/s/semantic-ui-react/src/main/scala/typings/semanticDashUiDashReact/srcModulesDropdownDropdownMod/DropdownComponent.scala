package typings.semanticDashUiDashReact.srcModulesDropdownDropdownMod

import typings.react.reactMod.ComponentClass
import typings.react.reactMod.ComponentState
import typings.react.reactMod.StatelessComponent
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownDividerMod.DropdownDividerProps
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownHeaderMod.DropdownHeaderProps
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownItemMod.DropdownItemProps
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownMenuMod.DropdownMenuProps
import typings.semanticDashUiDashReact.srcModulesDropdownDropdownSearchInputMod.DropdownSearchInputProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait DropdownComponent extends ComponentClass[DropdownProps, ComponentState] {
  var Divider: ComponentClass[DropdownDividerProps, ComponentState] = js.native
  var Header: ComponentClass[DropdownHeaderProps, ComponentState] = js.native
  var Item: ComponentClass[DropdownItemProps, ComponentState] = js.native
  var Menu: StatelessComponent[DropdownMenuProps] = js.native
  var SearchInput: ComponentClass[DropdownSearchInputProps, ComponentState] = js.native
}

