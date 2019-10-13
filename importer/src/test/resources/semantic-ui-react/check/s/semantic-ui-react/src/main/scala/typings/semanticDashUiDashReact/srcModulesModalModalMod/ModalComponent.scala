package typings.semanticDashUiDashReact.srcModulesModalModalMod

import typings.react.reactMod.ComponentClass
import typings.react.reactMod.ComponentState
import typings.react.reactMod.StatelessComponent
import typings.semanticDashUiDashReact.srcModulesModalModalActionsMod.ModalActionsProps
import typings.semanticDashUiDashReact.srcModulesModalModalContentMod.ModalContentProps
import typings.semanticDashUiDashReact.srcModulesModalModalDescriptionMod.ModalDescriptionProps
import typings.semanticDashUiDashReact.srcModulesModalModalHeaderMod.ModalHeaderProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ModalComponent extends ComponentClass[ModalProps, ComponentState] {
  var Actions: ComponentClass[ModalActionsProps, ComponentState] = js.native
  var Content: StatelessComponent[ModalContentProps] = js.native
  var Description: StatelessComponent[ModalDescriptionProps] = js.native
  var Header: StatelessComponent[ModalHeaderProps] = js.native
}

