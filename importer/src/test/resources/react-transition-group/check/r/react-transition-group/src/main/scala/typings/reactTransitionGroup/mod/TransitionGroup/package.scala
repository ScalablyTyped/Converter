package typings.reactTransitionGroup.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object TransitionGroup {
  import typings.react.mod.Component
  import typings.react.mod.ReactType
  import typings.reactTransitionGroup.Anon_Child
  import typings.reactTransitionGroup.reactTransitionGroupStrings.abbr
  import typings.reactTransitionGroup.reactTransitionGroupStrings.animate

  type TransitionGroup = Component[TransitionGroupProps[abbr, js.Any], js.Object]
  type TransitionGroupProps[T /* <: abbr | animate */, V /* <: ReactType[_] */] = (IntrinsicTransitionGroupProps[T] with (/* import warning: importer.ImportType#apply Failed type conversion: react.react._Global_.JSX.IntrinsicElements[T] */ js.Any)) | (ComponentTransitionGroupProps[V] with Anon_Child)
}
