package typings
package reactDashTransitionDashGroupLib

import reactDashTransitionDashGroupLib.Anon_Child
import reactDashTransitionDashGroupLib.reactDashTransitionDashGroupLibStrings.abbr
import reactDashTransitionDashGroupLib.reactDashTransitionDashGroupLibStrings.animate
import reactLib.reactMod.Component
import reactLib.reactMod.ReactType
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object transitionGroupMod {
  type TransitionGroup = Component[TransitionGroupProps[abbr, js.Any], js.Object]
  type TransitionGroupProps[T /* <: abbr | animate */, V /* <: ReactType[_] */] = (IntrinsicTransitionGroupProps[T] with (/* import warning: ImportType.apply Failed type conversion: react.react.Global.JSX.IntrinsicElements[T] */ js.Any)) | (ComponentTransitionGroupProps[V] with Anon_Child)
}
