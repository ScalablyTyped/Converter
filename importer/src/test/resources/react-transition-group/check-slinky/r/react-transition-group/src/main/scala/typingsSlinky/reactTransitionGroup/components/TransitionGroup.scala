package typingsSlinky.reactTransitionGroup.components

import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.abbr
import typingsSlinky.reactTransitionGroup.transitionGroupMod.TransitionGroupProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* This component has complicated props, you'll have to assemble `props` yourself using js.Dynamic.literal(...) or similar. QualifiedName(IArray(Name(typingsSlinky), Name(reactTransitionGroup), Name(transitionGroupMod), Name(TransitionGroupProps))) was not a @ScalaJSDefined trait */
object TransitionGroup
  extends ExternalComponentWithAttributesWithRefType[tag.type, typingsSlinky.reactTransitionGroup.mod.TransitionGroup] {
  @JSImport("react-transition-group", "TransitionGroup")
  @js.native
  object componentImport extends js.Object
  
  override val component: String | js.Object = this.componentImport
  type Props = TransitionGroupProps[abbr, js.Any]
}

