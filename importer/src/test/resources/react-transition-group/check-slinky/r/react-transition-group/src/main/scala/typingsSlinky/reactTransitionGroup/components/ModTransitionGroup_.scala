package typingsSlinky.reactTransitionGroup.components

import org.scalablytyped.runtime.StringDictionary
import slinky.core.BuildingComponent
import slinky.core.ExternalComponentWithAttributesWithRefType
import slinky.web.html.`*`.tag
import typingsSlinky.reactTransitionGroup.mod.TransitionGroup.TransitionGroupProps
import typingsSlinky.reactTransitionGroup.mod.TransitionGroup_
import typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.abbr
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

/* This component has complicated props, you'll have to assemble `props` yourself using js.Dynamic.literal(...) or similar. QualifiedName(List(Name(typingsSlinky), Name(reactTransitionGroup), Name(mod), Name(TransitionGroup), Name(TransitionGroupProps))) was not a @ScalaJSDefined trait */
object ModTransitionGroup_ {
  object raw
    extends ExternalComponentWithAttributesWithRefType[tag.type, TransitionGroup_] {
    @JSImport("react-transition-group", "TransitionGroup")
    @js.native
    object componentImport extends js.Object
    
    override val component: String | js.Object = this.componentImport
    type Props = TransitionGroupProps[abbr, js.Any]
  }
  
  def apply(
    props: (TransitionGroupProps[abbr, js.Any]) with js.Object,
    _overrides: StringDictionary[js.Any] = null
  ): BuildingComponent[tag.type, TransitionGroup_] = {
    val __obj = js.Dynamic.literal()
    js.Dynamic.global.Object.assign(__obj, props)
    if (_overrides != null) js.Dynamic.global.Object.assign(__obj, _overrides)
    this.raw.apply(__obj.asInstanceOf[this.raw.Props])
  }
}

