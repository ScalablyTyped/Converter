package typings.reactDashTransitionDashGroupLib

import typings.reactDashTransitionDashGroupLib.Anon_Child
import typings.reactDashTransitionDashGroupLib.reactDashTransitionDashGroupLibStrings.abbr
import typings.reactDashTransitionDashGroupLib.reactDashTransitionDashGroupLibStrings.animate
import typings.reactLib.reactMod.Component
import typings.reactLib.reactMod.ReactType
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object transitionGroupMod {
  type TransitionGroup = Component[TransitionGroupProps[abbr, js.Any], js.Object]
  type TransitionGroupProps[T /* <: abbr | animate */, V /* <: ReactType[_] */] = (IntrinsicTransitionGroupProps[T] with (/* import warning: ImportType.apply Failed type conversion: react.react.Global.JSX.IntrinsicElements[T] */ js.Any)) | (ComponentTransitionGroupProps[V] with Anon_Child)
}
