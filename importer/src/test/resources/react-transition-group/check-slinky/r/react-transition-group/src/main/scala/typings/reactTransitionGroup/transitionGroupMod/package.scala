package typings.reactTransitionGroup

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object transitionGroupMod {
  import slinky.core.ReactComponentClass
  import typings.react.reactMod.Component
  import typings.reactTransitionGroup.Anon_Child
  import typings.reactTransitionGroup.reactTransitionGroupStrings.abbr
  import typings.reactTransitionGroup.reactTransitionGroupStrings.animate

  type TransitionGroup = Component[TransitionGroupProps[abbr, js.Any], js.Object]
  type TransitionGroupProps[T /* <: abbr | animate */, V /* <: ReactComponentClass[_] */] = (IntrinsicTransitionGroupProps[T] with (/* import warning: ImportType.apply Failed type conversion: react.react._Global_.JSX.IntrinsicElements[T] */ js.Any)) | (ComponentTransitionGroupProps[V] with Anon_Child)
}
