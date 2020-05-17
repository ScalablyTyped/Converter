package typingsJapgolly.reactTransitionGroup.transitionGroupMod

import typingsJapgolly.react.mod.ReactType
import typingsJapgolly.reactTransitionGroup.anon.ChildFactory
import typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.abbr
import typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.animate
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typingsJapgolly.reactTransitionGroup.transitionGroupMod.IntrinsicTransitionGroupProps[T] with (/ * import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] * / js.Any)
  - typingsJapgolly.reactTransitionGroup.transitionGroupMod.ComponentTransitionGroupProps[V] with typingsJapgolly.reactTransitionGroup.anon.ChildFactory
*/
trait TransitionGroupProps[T /* <: abbr | animate */, V /* <: ReactType[_] */] extends js.Object

object TransitionGroupProps {
  @scala.inline
  implicit def apply[/* <: typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.abbr | typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.animate */ T, /* <: typingsJapgolly.react.mod.ReactType[_] */ V](value: ComponentTransitionGroupProps[V] with ChildFactory): TransitionGroupProps[T, V] = value.asInstanceOf[TransitionGroupProps[T, V]]
  @scala.inline
  implicit def apply[/* <: typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.abbr | typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.animate */ T, /* <: typingsJapgolly.react.mod.ReactType[_] */ V](
    value: IntrinsicTransitionGroupProps[T] with (/* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any)
  ): TransitionGroupProps[T, V] = value.asInstanceOf[TransitionGroupProps[T, V]]
}

