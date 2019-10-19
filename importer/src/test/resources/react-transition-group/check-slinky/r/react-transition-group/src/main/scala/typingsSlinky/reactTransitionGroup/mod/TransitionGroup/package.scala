package typingsSlinky.reactTransitionGroup.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object TransitionGroup {
  import slinky.core.ReactComponentClass
  import typingsSlinky.reactTransitionGroup.Anon_Child
  import typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.abbr
  import typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.animate

  type TransitionGroup = ReactComponentClass[TransitionGroupProps[abbr, js.Any]]
  type TransitionGroupProps[T /* <: abbr | animate */, V /* <: ReactComponentClass[_] */] = (IntrinsicTransitionGroupProps[T] with (/* import warning: importer.ImportType#apply Failed type conversion: react.react._Global_.JSX.IntrinsicElements[T] */ js.Any)) | (ComponentTransitionGroupProps[V] with Anon_Child)
}
