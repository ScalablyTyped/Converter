package typings.reactDashTransitionDashGroup

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object transitionGroupMod {
  import slinky.core.ReactComponentClass
  import typings.react.reactMod.Component
  import typings.reactDashTransitionDashGroup.Anon_Child
  import typings.reactDashTransitionDashGroup.reactDashTransitionDashGroupStrings.abbr
  import typings.reactDashTransitionDashGroup.reactDashTransitionDashGroupStrings.animate

  type TransitionGroup = Component[TransitionGroupProps[abbr, js.Any], js.Object]
  type TransitionGroupProps[T /* <: abbr | animate */, V /* <: ReactComponentClass[_] */] = (IntrinsicTransitionGroupProps[T] with (/* import warning: ImportType.apply Failed type conversion: react.react._Global_.JSX.IntrinsicElements[T] */ js.Any)) | (ComponentTransitionGroupProps[V] with Anon_Child)
}
