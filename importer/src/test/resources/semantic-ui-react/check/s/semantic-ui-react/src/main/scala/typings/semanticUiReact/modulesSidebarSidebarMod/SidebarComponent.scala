package typings.semanticUiReact.modulesSidebarSidebarMod

import typings.react.reactMod.ComponentClass
import typings.react.reactMod.ComponentState
import typings.react.reactMod.StatelessComponent
import typings.semanticUiReact.modulesSidebarSidebarPushableMod.SidebarPushableProps
import typings.semanticUiReact.modulesSidebarSidebarPusherMod.SidebarPusherProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SidebarComponent extends ComponentClass[SidebarProps, ComponentState] {
  var Pushable: StatelessComponent[SidebarPushableProps] = js.native
  var Pusher: StatelessComponent[SidebarPusherProps] = js.native
}

