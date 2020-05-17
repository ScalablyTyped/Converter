package typingsSlinky.reactTransitionGroup.transitionGroupMod

import typingsSlinky.react.mod.ReactType
import typingsSlinky.reactTransitionGroup.anon.ChildFactory
import typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.abbr
import typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.animate
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* Rewritten from type alias, can be one of: 
  - typingsSlinky.reactTransitionGroup.transitionGroupMod.IntrinsicTransitionGroupProps[T] with (/ * import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] * / js.Any)
  - typingsSlinky.reactTransitionGroup.transitionGroupMod.ComponentTransitionGroupProps[V] with typingsSlinky.reactTransitionGroup.anon.ChildFactory
*/
trait TransitionGroupProps[T /* <: abbr | animate */, V /* <: ReactType[_] */] extends js.Object

object TransitionGroupProps {
  @scala.inline
  implicit def apply[/* <: typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.abbr | typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.animate */ T, /* <: typingsSlinky.react.mod.ReactType[_] */ V](value: ComponentTransitionGroupProps[V] with ChildFactory): TransitionGroupProps[T, V] = value.asInstanceOf[TransitionGroupProps[T, V]]
  @scala.inline
  implicit def apply[/* <: typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.abbr | typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.animate */ T, /* <: typingsSlinky.react.mod.ReactType[_] */ V](
    value: IntrinsicTransitionGroupProps[T] with (/* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any)
  ): TransitionGroupProps[T, V] = value.asInstanceOf[TransitionGroupProps[T, V]]
}

