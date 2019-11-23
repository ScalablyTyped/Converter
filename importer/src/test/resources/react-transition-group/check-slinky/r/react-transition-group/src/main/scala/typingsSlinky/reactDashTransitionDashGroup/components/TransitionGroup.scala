package typingsSlinky.reactDashTransitionDashGroup.components

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typingsSlinky.reactDashTransitionDashGroup.reactDashTransitionDashGroupStrings.abbr
import typingsSlinky.reactDashTransitionDashGroup.transitionGroupMod.TransitionGroupProps
import typingsSlinky.reactDashTransitionDashGroup.transitionGroupMod.^
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* This component has complicated props, you'll have to assemble it yourself using js.Dynamic.literal(...) or similar */
object TransitionGroup
  extends ExternalComponentWithAttributesWithRefType[tag.type, ^] {
  override val component: String | js.Object = js.constructorOf[typingsSlinky.reactDashTransitionDashGroup.transitionGroupMod.^].asInstanceOf[String | js.Object]
  def apply(
    props: (TransitionGroupProps[abbr, js.Any]) with js.Object,
    overrides: StringDictionary[js.Any] = null
  ): BuildingComponent[tag.type, ^] = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, props)
    if (overrides != null) js.Dynamic.global.Object.assign(__obj, overrides)
    super.apply(__obj.asInstanceOf[Props])
  }
  type Props = js.Object
}

