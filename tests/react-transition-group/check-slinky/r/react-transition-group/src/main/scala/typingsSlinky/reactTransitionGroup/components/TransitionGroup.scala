package typingsSlinky.reactTransitionGroup.components

import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.abbr
import typingsSlinky.reactTransitionGroup.transitionGroupMod.TransitionGroupProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* This component has complicated props, you'll have to assemble `props` yourself using js.Dynamic.literal(...) or similar. Couldn't find props for TypeRef(QualifiedName(IArray(Name(<intersection>))),IArray(TypeRef(QualifiedName(IArray(Name(typingsSlinky), Name(reactTransitionGroup), Name(transitionGroupMod), Name(IntrinsicTransitionGroupProps))),IArray(TypeRef(QualifiedName(IArray(Name(typingsSlinky), Name(reactTransitionGroup), Name(reactTransitionGroupStrings), Name(abbr))),IArray(),Comments(0))),NoComments), TypeRef(QualifiedName(IArray(Name(scala), Name(scalajs), Name(js), Name(Any))),IArray(),Comments(1))),NoComments) because: Could't extract props from TypeRef(QualifiedName(IArray(Name(scala), Name(scalajs), Name(js), Name(Any))),IArray(),Comments(1)) because couldn't resolve ClassTree. */
object TransitionGroup
  extends ExternalComponentWithAttributesWithRefType[tag.type, typingsSlinky.reactTransitionGroup.mod.TransitionGroup] {
  @JSImport("react-transition-group", "TransitionGroup")
  @js.native
  object componentImport extends js.Object
  
  override val component: String | js.Object = this.componentImport
  type Props = TransitionGroupProps[abbr, js.Any]
}

