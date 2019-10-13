package typings.semanticDashUiDashReact.srcModulesSidebarSidebarMod

import typings.react.reactMod.ComponentClass
import typings.react.reactMod.ComponentState
import typings.react.reactMod.StatelessComponent
import typings.semanticDashUiDashReact.srcModulesSidebarSidebarPushableMod.SidebarPushableProps
import typings.semanticDashUiDashReact.srcModulesSidebarSidebarPusherMod.SidebarPusherProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SidebarComponent extends ComponentClass[SidebarProps, ComponentState] {
  var Pushable: StatelessComponent[SidebarPushableProps] = js.native
  var Pusher: StatelessComponent[SidebarPusherProps] = js.native
}

