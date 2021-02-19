package typingsJapgolly.reactTransitionGroup.components

import typingsJapgolly.StBuildingComponent.Default
import typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.abbr
import typingsJapgolly.reactTransitionGroup.transitionGroupMod.TransitionGroupProps
import typingsJapgolly.reactTransitionGroup.transitionGroupMod.^
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

/* The props of this component has an unsupported shape. You can use `set` manually to use it, but with no compiler support :/ . Couldn't find props for typingsJapgolly.reactTransitionGroup.transitionGroupMod.IntrinsicTransitionGroupProps[typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.abbr] & (/ * import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] * / js.Any) because: IArray(Could't extract props from / * import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] * / js.Any because couldn't resolve ClassTree.) */
object TransitionGroup {
  
  def apply(p: TransitionGroupProps[abbr, js.Any]): Default[^] = new Default[^](js.Array(this.component, p.asInstanceOf[js.Any]))
  
  @JSImport("react-transition-group/TransitionGroup", JSImport.Namespace)
  @js.native
  val component: js.Object = js.native
  
  implicit def make(companion: TransitionGroup.type): Default[^] = new Default[^](js.Array(this.component, js.Dictionary.empty))()
}
