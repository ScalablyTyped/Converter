package typingsJapgolly.reactTransitionGroup

import typingsJapgolly.react.mod.Component
import typingsJapgolly.react.mod.ReactType
import typingsJapgolly.reactTransitionGroup.anon.ChildFactory
import typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.abbr
import typingsJapgolly.reactTransitionGroup.reactTransitionGroupStrings.animate
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object transitionGroupMod {
  
  @JSImport("react-transition-group/TransitionGroup", JSImport.Namespace)
  @js.native
  class ^ ()
    extends StObject
       with Component[TransitionGroupProps[abbr, js.Any], js.Object]
  
  @js.native
  trait ComponentTransitionGroupProps[T /* <: ReactType[js.Any] */] extends StObject {
    
    var component: T = js.native
  }
  object ComponentTransitionGroupProps {
    
    @scala.inline
    def apply[T /* <: ReactType[js.Any] */](component: T): ComponentTransitionGroupProps[T] = {
      val __obj = js.Dynamic.literal(component = component.asInstanceOf[js.Any])
      __obj.asInstanceOf[ComponentTransitionGroupProps[T]]
    }
  }
  
  @js.native
  trait IntrinsicTransitionGroupProps[T /* <: abbr | animate */] extends StObject {
    
    var component: js.UndefOr[T] = js.native
  }
  object IntrinsicTransitionGroupProps {
    
    @scala.inline
    def apply[T /* <: abbr | animate */](component: T = null): IntrinsicTransitionGroupProps[T] = {
      val __obj = js.Dynamic.literal()
      if (component != null) __obj.updateDynamic("component")(component.asInstanceOf[js.Any])
      __obj.asInstanceOf[IntrinsicTransitionGroupProps[T]]
    }
  }
  
  type TransitionGroup = japgolly.scalajs.react.raw.React.Component[(TransitionGroupProps[abbr, js.Any]) with js.Object, js.Object]
  
  type TransitionGroupProps[T /* <: abbr | animate */, V /* <: ReactType[js.Any] */] = (IntrinsicTransitionGroupProps[T] with (/* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any)) | (ComponentTransitionGroupProps[V] with ChildFactory)
}
