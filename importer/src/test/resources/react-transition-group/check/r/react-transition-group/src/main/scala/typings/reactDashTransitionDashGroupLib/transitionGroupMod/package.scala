package typings
package reactDashTransitionDashGroupLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object transitionGroupMod {
  type TransitionGroup = reactLib.reactMod.Component[
    TransitionGroupProps[
      reactDashTransitionDashGroupLib.reactDashTransitionDashGroupLibStrings.abbr, 
      js.Any
    ], 
    js.Object
  ]
  type TransitionGroupProps[T /* <: reactDashTransitionDashGroupLib.reactDashTransitionDashGroupLibStrings.abbr | reactDashTransitionDashGroupLib.reactDashTransitionDashGroupLibStrings.animate */, V /* <: reactLib.reactMod.ReactType[_] */] = (IntrinsicTransitionGroupProps[T] with (/* import warning: ImportType.apply Failed type conversion: react.react.Global.JSX.IntrinsicElements[T] */ js.Any)) | (ComponentTransitionGroupProps[V] with reactDashTransitionDashGroupLib.Anon_Child)
}
