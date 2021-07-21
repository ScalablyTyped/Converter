package typingsSlinky.reactTransitionGroup

import slinky.core.ReactComponentClass
import typingsSlinky.react.mod.Component
import typingsSlinky.react.mod.ReactType
import typingsSlinky.reactTransitionGroup.anon.ChildFactory
import typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.abbr
import typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.animate
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object transitionGroupMod {
  
  @JSImport("react-transition-group/TransitionGroup", JSImport.Namespace)
  @js.native
  class ^ ()
    extends StObject
       with Component[TransitionGroupProps[abbr, js.Any], js.Object]
  
  trait ComponentTransitionGroupProps[T /* <: ReactType[js.Any] */] extends StObject {
    
    var component: T
  }
  object ComponentTransitionGroupProps {
    
    inline def apply[T /* <: ReactType[js.Any] */](component: T): ComponentTransitionGroupProps[T] = {
      val __obj = js.Dynamic.literal(component = component.asInstanceOf[js.Any])
      __obj.asInstanceOf[ComponentTransitionGroupProps[T]]
    }
    
    extension [Self <: ComponentTransitionGroupProps[?], T /* <: ReactType[js.Any] */](x: Self & ComponentTransitionGroupProps[T]) {
      
      inline def setComponent(value: T): Self = StObject.set(x, "component", value.asInstanceOf[js.Any])
    }
  }
  
  trait IntrinsicTransitionGroupProps[T /* <: abbr | animate */] extends StObject {
    
    var component: js.UndefOr[T] = js.undefined
  }
  object IntrinsicTransitionGroupProps {
    
    inline def apply[T /* <: abbr | animate */](): IntrinsicTransitionGroupProps[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[IntrinsicTransitionGroupProps[T]]
    }
    
    extension [Self <: IntrinsicTransitionGroupProps[?], T /* <: abbr | animate */](x: Self & IntrinsicTransitionGroupProps[T]) {
      
      inline def setComponent(value: T): Self = StObject.set(x, "component", value.asInstanceOf[js.Any])
      
      inline def setComponentUndefined: Self = StObject.set(x, "component", js.undefined)
    }
  }
  
  type TransitionGroup = ReactComponentClass[TransitionGroupProps[abbr, js.Any]]
  
  type TransitionGroupProps[T /* <: abbr | animate */, V /* <: ReactType[js.Any] */] = (IntrinsicTransitionGroupProps[T] & (/* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any)) | (ComponentTransitionGroupProps[V] & ChildFactory)
}
