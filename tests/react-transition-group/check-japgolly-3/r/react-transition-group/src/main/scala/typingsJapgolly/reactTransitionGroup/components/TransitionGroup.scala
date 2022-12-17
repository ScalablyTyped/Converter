package typingsJapgolly.reactTransitionGroup.components

import japgolly.scalajs.react.facade.React.Element
import typingsJapgolly.StBuildingComponent.Default
import typingsJapgolly.reactTransitionGroup.anon.ChildFactory
import typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.abbr
import typingsJapgolly.reactTransitionGroup.transitionGroupMod.ComponentTransitionGroupProps
import typingsJapgolly.reactTransitionGroup.transitionGroupMod.IntrinsicTransitionGroupProps
import typingsJapgolly.reactTransitionGroup.transitionGroupMod.^
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object TransitionGroup {
  
  object ComponentTransitionGroupPropsChildFactory {
    
    inline def apply(component: Any, childFactory: /* child */ Element => Element = null): Default[^] = {
      val __props = js.Dynamic.literal(component = component.asInstanceOf[js.Any])
      if (childFactory != null) __props.updateDynamic("childFactory")(js.Any.fromFunction1(childFactory))
      new Default[^](js.Array(this.component, __props.asInstanceOf[ComponentTransitionGroupProps[Any] & ChildFactory]))
    }
    
    @JSImport("react-transition-group/TransitionGroup", JSImport.Namespace)
    @js.native
    val component: js.Object = js.native
    
    type Props = ComponentTransitionGroupProps[Any] & ChildFactory
    
    def withProps(p: ComponentTransitionGroupProps[Any] & ChildFactory): Default[^] = new Default[^](js.Array(this.component, p.asInstanceOf[js.Any]))
  }
  
  object IntrinsicTransitionGroupPropsAny {
    
    inline def apply(component: abbr = null): Default[^] = {
      val __props = js.Dynamic.literal()
      if (component != null) __props.updateDynamic("component")(component.asInstanceOf[js.Any])
      new Default[^](js.Array(this.component, __props.asInstanceOf[IntrinsicTransitionGroupProps[abbr] & (/* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any)]))
    }
    
    @JSImport("react-transition-group/TransitionGroup", JSImport.Namespace)
    @js.native
    val component: js.Object = js.native
    
    type Props = IntrinsicTransitionGroupProps[abbr] & (/* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any)
    
    implicit def make(companion: IntrinsicTransitionGroupPropsAny.type): Default[^] = new Default[^](js.Array(this.component, js.Dictionary.empty))()
    
    def withProps(
      p: IntrinsicTransitionGroupProps[abbr] & (/* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any)
    ): Default[^] = new Default[^](js.Array(this.component, p.asInstanceOf[js.Any]))
  }
}
