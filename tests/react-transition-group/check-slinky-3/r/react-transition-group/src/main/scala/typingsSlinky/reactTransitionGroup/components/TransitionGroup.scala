package typingsSlinky.reactTransitionGroup.components

import _root_.typingsSlinky.StBuildingComponent
import _root_.typingsSlinky.reactTransitionGroup.anon.ChildFactory
import _root_.typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.abbr
import _root_.typingsSlinky.reactTransitionGroup.transitionGroupMod.ComponentTransitionGroupProps
import _root_.typingsSlinky.reactTransitionGroup.transitionGroupMod.IntrinsicTransitionGroupProps
import slinky.core.facade.ReactElement
import slinky.web.html.`*`.tag
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object TransitionGroup {
  
  object ComponentTransitionGroupPropsChildFactory {
    
    inline def apply(component: Any): Builder = {
      val __props = js.Dynamic.literal(component = component.asInstanceOf[js.Any])
      new Builder(js.Array(this.component, __props.asInstanceOf[ComponentTransitionGroupProps[Any] & ChildFactory]))
    }
    
    @JSImport("react-transition-group", "TransitionGroup")
    @js.native
    val component: js.Object = js.native
    
    @scala.inline
    open class Builder (val args: js.Array[Any])
      extends AnyVal
         with StBuildingComponent[tag.type, _root_.typingsSlinky.reactTransitionGroup.mod.TransitionGroup] {
      
      inline def childFactory(value: /* child */ ReactElement => ReactElement): this.type = set("childFactory", js.Any.fromFunction1(value))
    }
    
    type Props = ComponentTransitionGroupProps[Any] & ChildFactory
    
    def withProps(p: ComponentTransitionGroupProps[Any] & ChildFactory): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  object IntrinsicTransitionGroupPropsAny {
    
    @JSImport("react-transition-group", "TransitionGroup")
    @js.native
    val component: js.Object = js.native
    
    @scala.inline
    open class Builder (val args: js.Array[Any])
      extends AnyVal
         with StBuildingComponent[tag.type, _root_.typingsSlinky.reactTransitionGroup.mod.TransitionGroup] {
      
      inline def component(value: abbr): this.type = set("component", value.asInstanceOf[js.Any])
    }
    
    type Props = IntrinsicTransitionGroupProps[abbr] & (/* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any)
    
    implicit def make(companion: IntrinsicTransitionGroupPropsAny.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(
      p: IntrinsicTransitionGroupProps[abbr] & (/* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any)
    ): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
  }
}
