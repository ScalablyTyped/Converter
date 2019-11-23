package typingsJapgolly.reactDashTransitionDashGroup

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object transitionGroupMod {
  import japgolly.scalajs.react.raw.React.Component
  import typingsJapgolly.react.reactMod.ReactType
  import typingsJapgolly.reactDashTransitionDashGroup.Anon_Child
  import typingsJapgolly.reactDashTransitionDashGroup.reactDashTransitionDashGroupStrings.abbr
  import typingsJapgolly.reactDashTransitionDashGroup.reactDashTransitionDashGroupStrings.animate

  type TransitionGroup = Component[(TransitionGroupProps[abbr, js.Any]) with js.Object, js.Object]
  type TransitionGroupProps[T /* <: abbr | animate */, V /* <: ReactType[_] */] = (IntrinsicTransitionGroupProps[T] with (/* import warning: importer.ImportType#apply Failed type conversion: react.react._Global_.JSX.IntrinsicElements[T] */ js.Any)) | (ComponentTransitionGroupProps[V] with Anon_Child)
}
