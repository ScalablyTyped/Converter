package typingsSlinky.reactTransitionGroup

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object transitionGroupMod {
  type TransitionGroup = slinky.core.ReactComponentClass[
    typingsSlinky.reactTransitionGroup.transitionGroupMod.TransitionGroupProps[typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.abbr, js.Any]
  ]
  type TransitionGroupProps[T /* <: typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.abbr | typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.animate */, V /* <: slinky.core.ReactComponentClass[_] */] = (typingsSlinky.reactTransitionGroup.transitionGroupMod.IntrinsicTransitionGroupProps[T] with (/* import warning: importer.ImportType#apply Failed type conversion: react.react._Global_.JSX.IntrinsicElements[T] */ js.Any)) | (typingsSlinky.reactTransitionGroup.transitionGroupMod.ComponentTransitionGroupProps[V] with typingsSlinky.reactTransitionGroup.AnonChildFactory)
}
