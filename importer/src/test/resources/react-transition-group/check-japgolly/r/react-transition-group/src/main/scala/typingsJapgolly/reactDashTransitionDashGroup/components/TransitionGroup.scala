package typingsJapgolly.reactDashTransitionDashGroup.components

import japgolly.scalajs.react.CtorType.ChildArg
import japgolly.scalajs.react.Key
import japgolly.scalajs.react.component.JsForwardRef.UnmountedWithRoot
import org.scalablytyped.runtime.StringDictionary
import typingsJapgolly.reactDashTransitionDashGroup.reactDashTransitionDashGroupStrings.abbr
import typingsJapgolly.reactDashTransitionDashGroup.transitionGroupMod.TransitionGroupProps
import typingsJapgolly.reactDashTransitionDashGroup.transitionGroupMod.^
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* This component has complicated props, you'll have to assemble `props` yourself using js.Dynamic.literal(...) or similar. */
object TransitionGroup {
  def apply(
    props: (TransitionGroupProps[abbr, js.Any]) with js.Object,
    key: js.UndefOr[Key] = js.undefined,
    overrides: StringDictionary[js.Any] = null
  )(
    children: ChildArg*
  ): UnmountedWithRoot[
    (TransitionGroupProps[abbr, js.Any]) with js.Object, 
    ^, 
    Unit, 
    (TransitionGroupProps[abbr, js.Any]) with js.Object
  ] = {
    val __obj = js.Dynamic.literal()
  
      js.Dynamic.global.Object.assign(__obj, props)
    key.foreach(k => __obj.updateDynamic("key")(k.asInstanceOf[js.Any]))
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
  
    val f = japgolly.scalajs.react.JsForwardRefComponent.force[
  (typingsJapgolly.reactDashTransitionDashGroup.transitionGroupMod.TransitionGroupProps[
    typingsJapgolly.reactDashTransitionDashGroup.reactDashTransitionDashGroupStrings.abbr, 
    js.Any
  ]) with js.Object, 
  japgolly.scalajs.react.Children.Varargs, 
  typingsJapgolly.reactDashTransitionDashGroup.transitionGroupMod.^](js.constructorOf[typingsJapgolly.reactDashTransitionDashGroup.transitionGroupMod.^].asInstanceOf[js.Any])
    f(__obj.asInstanceOf[(typingsJapgolly.reactDashTransitionDashGroup.transitionGroupMod.TransitionGroupProps[
  typingsJapgolly.reactDashTransitionDashGroup.reactDashTransitionDashGroupStrings.abbr, 
  js.Any]) with js.Object])(children: _*)
  }
}

