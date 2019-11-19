package typingsJapgolly.reactTransitionGroup

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object transitionGroupMod {
  import typingsJapgolly.react.reactMod.Component
  import typingsJapgolly.react.reactMod.ReactType
  import typingsJapgolly.reactTransitionGroup.Anon_Child
  import typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.abbr
  import typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.animate

  type TransitionGroup = Component[TransitionGroupProps[abbr, js.Any], js.Object]
  type TransitionGroupProps[T /* <: abbr | animate */, V /* <: ReactType[_] */] = (IntrinsicTransitionGroupProps[T] with (/* import warning: importer.ImportType#apply Failed type conversion: react.react._Global_.JSX.IntrinsicElements[T] */ js.Any)) | (ComponentTransitionGroupProps[V] with Anon_Child)
}
