package typings.reactDashTransitionDashGroup

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object transitionGroupMod {
  import typings.react.reactMod.Component
  import typings.react.reactMod.ReactType
  import typings.reactDashTransitionDashGroup.Anon_Child
  import typings.reactDashTransitionDashGroup.reactDashTransitionDashGroupStrings.abbr
  import typings.reactDashTransitionDashGroup.reactDashTransitionDashGroupStrings.animate

  type TransitionGroup = Component[TransitionGroupProps[abbr, js.Any], js.Object]
  type TransitionGroupProps[T /* <: abbr | animate */, V /* <: ReactType[_] */] = (IntrinsicTransitionGroupProps[T] with (/* import warning: ImportType.apply Failed type conversion: react.react.Global.JSX.IntrinsicElements[T] */ js.Any)) | (ComponentTransitionGroupProps[V] with Anon_Child)
}
