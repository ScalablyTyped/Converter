package typingsJapgolly.reactTransitionGroup.components

import typingsJapgolly.StBuildingComponent.Default
import typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.abbr
import typingsJapgolly.reactTransitionGroup.transitionGroupMod.TransitionGroupProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* The props of this component has an unsupported shape. You can use `set` manually to use it, but with no compiler support :/ . Couldn't find props for typingsJapgolly.reactTransitionGroup.transitionGroupMod.IntrinsicTransitionGroupProps[typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.abbr] with (/ * import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] * / js.Any) because: IArray(Could't extract props from / * import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] * / js.Any because couldn't resolve ClassTree.) */
object TransitionGroup {
  @JSImport("react-transition-group", "TransitionGroup")
  @js.native
  object component extends js.Object
  
  def apply(p: TransitionGroupProps[abbr, js.Any]): Default[typingsJapgolly.reactTransitionGroup.mod.TransitionGroup] = new Default[typingsJapgolly.reactTransitionGroup.mod.TransitionGroup](js.Array(this.component, p.asInstanceOf[js.Any]))
  implicit def make(companion: TransitionGroup.type): Default[typingsJapgolly.reactTransitionGroup.mod.TransitionGroup] = new Default[typingsJapgolly.reactTransitionGroup.mod.TransitionGroup](js.Array(this.component, js.Dictionary.empty))()
}

