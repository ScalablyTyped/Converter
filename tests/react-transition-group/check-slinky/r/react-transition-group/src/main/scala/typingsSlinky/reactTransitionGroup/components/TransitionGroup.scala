package typingsSlinky.reactTransitionGroup.components

import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent.Default
import typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.abbr
import typingsSlinky.reactTransitionGroup.transitionGroupMod.TransitionGroupProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* The props of this component has an unsupported shape. You can use `set` manually to use it, but with no compiler support :/ . Couldn't find props for typingsSlinky.reactTransitionGroup.transitionGroupMod.IntrinsicTransitionGroupProps[typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.abbr] with (/ * import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] * / js.Any) because: IArray(Could't extract props from / * import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] * / js.Any because couldn't resolve ClassTree.) */
object TransitionGroup {
  
  @JSImport("react-transition-group", "TransitionGroup")
  @js.native
  object component extends js.Object
  
  def apply(p: TransitionGroupProps[abbr, js.Any]): Default[tag.type, typingsSlinky.reactTransitionGroup.mod.TransitionGroup] = new Default[tag.type, typingsSlinky.reactTransitionGroup.mod.TransitionGroup](js.Array(this.component, p.asInstanceOf[js.Any]))
  
  implicit def make(companion: TransitionGroup.type): Default[tag.type, typingsSlinky.reactTransitionGroup.mod.TransitionGroup] = new Default[tag.type, typingsSlinky.reactTransitionGroup.mod.TransitionGroup](js.Array(this.component, js.Dictionary.empty))()
}
