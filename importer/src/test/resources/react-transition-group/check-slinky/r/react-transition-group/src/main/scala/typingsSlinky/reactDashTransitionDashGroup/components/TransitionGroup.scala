package typingsSlinky.reactDashTransitionDashGroup.components

import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typingsSlinky.reactDashTransitionDashGroup.reactDashTransitionDashGroupStrings.abbr
import typingsSlinky.reactDashTransitionDashGroup.transitionGroupMod.TransitionGroupProps
import typingsSlinky.reactDashTransitionDashGroup.transitionGroupMod.^
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* This component has complicated props, you'll have to assemble `props` yourself using js.Dynamic.literal(...) or similar. QualifiedName(List(Name(typingsSlinky), Name(reactDashTransitionDashGroup), Name(transitionGroupMod), Name(TransitionGroupProps))) was not a @ScalaJSDefined trait */
object TransitionGroup
  extends ExternalComponentWithAttributesWithRefType[tag.type, ^] {
  @JSImport("react-transition-group/TransitionGroup", JSImport.Namespace)
  @js.native
  object componentImport extends js.Object
  
  override val component: String | js.Object = this.componentImport
  type Props = TransitionGroupProps[abbr, js.Any]
}

