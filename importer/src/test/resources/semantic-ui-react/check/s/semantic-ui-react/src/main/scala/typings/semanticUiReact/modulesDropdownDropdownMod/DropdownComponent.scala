package typings.semanticUiReact.modulesDropdownDropdownMod

import typings.react.reactMod.ComponentClass
import typings.react.reactMod.ComponentState
import typings.react.reactMod.StatelessComponent
import typings.semanticUiReact.modulesDropdownDropdownDividerMod.DropdownDividerProps
import typings.semanticUiReact.modulesDropdownDropdownHeaderMod.DropdownHeaderProps
import typings.semanticUiReact.modulesDropdownDropdownItemMod.DropdownItemProps
import typings.semanticUiReact.modulesDropdownDropdownMenuMod.DropdownMenuProps
import typings.semanticUiReact.modulesDropdownDropdownSearchInputMod.DropdownSearchInputProps
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

