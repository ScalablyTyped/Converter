package typingsSlinky.reactTransitionGroup

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

package object transitionGroupMod {
  
  type TransitionGroup = slinky.core.ReactComponentClass[
    typingsSlinky.reactTransitionGroup.transitionGroupMod.TransitionGroupProps[typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.abbr, js.Any]
  ]
  
  type TransitionGroupProps[T /* <: typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.abbr | typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.animate */, V /* <: typingsSlinky.react.mod.ReactType[_] */] = (typingsSlinky.reactTransitionGroup.transitionGroupMod.IntrinsicTransitionGroupProps[T] with (/* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any)) | (typingsSlinky.reactTransitionGroup.transitionGroupMod.ComponentTransitionGroupProps[V] with typingsSlinky.reactTransitionGroup.anon.ChildFactory)
}
