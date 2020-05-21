package typingsJapgolly.reactTransitionGroup.components

import japgolly.scalajs.react.Children.Varargs
import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.JsForwardRefComponent.force
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.abbr
import typingsJapgolly.reactTransitionGroup.transitionGroupMod.TransitionGroupProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* This component has complicated props, you'll have to assemble `props` yourself using js.Dynamic.literal(...) or similar: Couldn't find props for typingsJapgolly.reactTransitionGroup.transitionGroupMod.IntrinsicTransitionGroupProps[typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.abbr] with (/ * import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] * / js.Any) because: IArray(Could't extract props from / * import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] * / js.Any because couldn't resolve ClassTree.). */
object TransitionGroup {
  def apply(props: (TransitionGroupProps[abbr, js.Any]) with js.Object)(children: ChildArg*): UnmountedWithRoot[
    (TransitionGroupProps[abbr, js.Any]) with js.Object, 
    typingsJapgolly.reactTransitionGroup.mod.TransitionGroup, 
    Unit, 
    (TransitionGroupProps[abbr, js.Any]) with js.Object
  ] = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, props)
    val f = force[(TransitionGroupProps[abbr, js.Any]) with js.Object, Varargs, typingsJapgolly.reactTransitionGroup.mod.TransitionGroup](this.componentImport)
    f(__obj.asInstanceOf[(TransitionGroupProps[abbr, js.Any]) with js.Object])(children :_*)
  }
  @JSImport("react-transition-group", "TransitionGroup")
  @js.native
  object componentImport extends js.Object
  
}

