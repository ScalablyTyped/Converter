package typingsSlinky.reactTransitionGroup

import slinky.core.ReactComponentClass
import typingsSlinky.react.mod.Component
import typingsSlinky.react.mod.ReactType
import typingsSlinky.reactTransitionGroup.anon.ChildFactory
import typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.abbr
import typingsSlinky.reactTransitionGroup.reactTransitionGroupStrings.animate
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object transitionGroupMod {
  
  @JSImport("react-transition-group/TransitionGroup", JSImport.Namespace)
  @js.native
  class ^ ()
    extends Component[TransitionGroupProps[abbr, js.Any], js.Object]
  
  @js.native
  trait ComponentTransitionGroupProps[T /* <: ReactType[_] */] extends js.Object {
    
    var component: T = js.native
  }
  object ComponentTransitionGroupProps {
    
    @scala.inline
    def apply[T /* <: ReactType[_] */](component: T): ComponentTransitionGroupProps[T] = {
      val __obj = js.Dynamic.literal(component = component.asInstanceOf[js.Any])
      __obj.asInstanceOf[ComponentTransitionGroupProps[T]]
    }
    
    @scala.inline
    implicit class ComponentTransitionGroupPropsOps[Self <: ComponentTransitionGroupProps[_], T /* <: ReactType[_] */] (val x: Self with ComponentTransitionGroupProps[T]) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setComponent(value: T): Self = this.set("component", value.asInstanceOf[js.Any])
    }
  }
  
  @js.native
  trait IntrinsicTransitionGroupProps[T /* <: abbr | animate */] extends js.Object {
    
    var component: js.UndefOr[T] = js.native
  }
  object IntrinsicTransitionGroupProps {
    
    @scala.inline
    def apply[T /* <: abbr | animate */](): IntrinsicTransitionGroupProps[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[IntrinsicTransitionGroupProps[T]]
    }
    
    @scala.inline
    implicit class IntrinsicTransitionGroupPropsOps[Self <: IntrinsicTransitionGroupProps[_], T /* <: abbr | animate */] (val x: Self with IntrinsicTransitionGroupProps[T]) extends AnyVal {
      
      @scala.inline
      def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
      
      @scala.inline
      def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
      
      @scala.inline
      def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
      }
      
      @scala.inline
      def setComponent(value: T): Self = this.set("component", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteComponent: Self = this.set("component", js.undefined)
    }
  }
  
  type TransitionGroup = ReactComponentClass[TransitionGroupProps[abbr, js.Any]]
  
  type TransitionGroupProps[T /* <: abbr | animate */, V /* <: ReactType[_] */] = (IntrinsicTransitionGroupProps[T] with (/* import warning: importer.ImportType#apply Failed type conversion: react.react.<global>.JSX.IntrinsicElements[T] */ js.Any)) | (ComponentTransitionGroupProps[V] with ChildFactory)
}
