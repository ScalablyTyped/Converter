package typingsJapgolly.reactTransitionGroup

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object transitionGroupMod {
  type TransitionGroup = japgolly.scalajs.react.raw.React.Component[
    (typingsJapgolly.reactTransitionGroup.transitionGroupMod.TransitionGroupProps[typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.abbr, js.Any]) with js.Object, 
    js.Object
  ]
  type TransitionGroupProps[T /* <: typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.abbr | typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.animate */, V /* <: typingsJapgolly.react.mod.ReactType[_] */] = (typingsJapgolly.reactTransitionGroup.transitionGroupMod.IntrinsicTransitionGroupProps[T] with (/* import warning: importer.ImportType#apply Failed type conversion: react.react._Global_.JSX.IntrinsicElements[T] */ js.Any)) | (typingsJapgolly.reactTransitionGroup.transitionGroupMod.ComponentTransitionGroupProps[V] with typingsJapgolly.reactTransitionGroup.AnonChildFactory)
}
