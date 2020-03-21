package typings.reactTransitionGroup

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object transitionGroupMod {
  type TransitionGroup = typings.react.mod.Component[
    typings.reactTransitionGroup.transitionGroupMod.TransitionGroupProps[typings.reactTransitionGroup.reactTransitionGroupStrings.abbr, js.Any], 
    js.Object
  ]
  type TransitionGroupProps[T /* <: typings.reactTransitionGroup.reactTransitionGroupStrings.abbr | typings.reactTransitionGroup.reactTransitionGroupStrings.animate */, V /* <: typings.react.mod.ReactType[_] */] = (typings.reactTransitionGroup.transitionGroupMod.IntrinsicTransitionGroupProps[T] with (/* import warning: importer.ImportType#apply Failed type conversion: react.react._Global_.JSX.IntrinsicElements[T] */ js.Any)) | (typings.reactTransitionGroup.transitionGroupMod.ComponentTransitionGroupProps[V] with typings.reactTransitionGroup.AnonChildFactory)
}
