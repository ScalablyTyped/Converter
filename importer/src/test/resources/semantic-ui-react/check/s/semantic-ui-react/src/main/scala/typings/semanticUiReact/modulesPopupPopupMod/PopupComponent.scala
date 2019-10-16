package typings.semanticUiReact.modulesPopupPopupMod

import typings.react.reactMod.ComponentClass
import typings.react.reactMod.ComponentState
import typings.react.reactMod.StatelessComponent
import typings.semanticUiReact.modulesPopupPopupContentMod.PopupContentProps
import typings.semanticUiReact.modulesPopupPopupHeaderMod.PopupHeaderProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait PopupComponent extends ComponentClass[PopupProps, ComponentState] {
  var Content: StatelessComponent[PopupContentProps] = js.native
  var Header: StatelessComponent[PopupHeaderProps] = js.native
}

