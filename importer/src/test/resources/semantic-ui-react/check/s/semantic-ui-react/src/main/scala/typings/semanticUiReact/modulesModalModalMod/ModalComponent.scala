package typings.semanticUiReact.modulesModalModalMod

import typings.react.reactMod.ComponentClass
import typings.react.reactMod.ComponentState
import typings.react.reactMod.StatelessComponent
import typings.semanticUiReact.modulesModalModalActionsMod.ModalActionsProps
import typings.semanticUiReact.modulesModalModalContentMod.ModalContentProps
import typings.semanticUiReact.modulesModalModalDescriptionMod.ModalDescriptionProps
import typings.semanticUiReact.modulesModalModalHeaderMod.ModalHeaderProps
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

