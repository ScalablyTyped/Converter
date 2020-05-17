package typings.reactTransitionGroup.transitionGroupMod

import typings.react.mod.ReactType
import typings.reactTransitionGroup.anon.ChildFactory
import typings.reactTransitionGroup.reactTransitionGroupStrings.abbr
import typings.reactTransitionGroup.reactTransitionGroupStrings.animate
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typings.reactTransitionGroup.transitionGroupMod.IntrinsicTransitionGroupProps[T] with (/ * import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] * / js.Any)
  - typings.reactTransitionGroup.transitionGroupMod.ComponentTransitionGroupProps[V] with typings.reactTransitionGroup.anon.ChildFactory
*/
trait TransitionGroupProps[T /* <: abbr | animate */, V /* <: ReactType[_] */] extends js.Object

object TransitionGroupProps {
  @scala.inline
  implicit def apply[T, V](
    value: IntrinsicTransitionGroupProps[T] with (/* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any)
  ): TransitionGroupProps[T, V] = value.asInstanceOf[TransitionGroupProps[T, V]]
  @scala.inline
  implicit def apply[T, V](value: ComponentTransitionGroupProps[V] with ChildFactory): TransitionGroupProps[T, V] = value.asInstanceOf[TransitionGroupProps[T, V]]
}

