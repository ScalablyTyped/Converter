package typingsSlinky.reactBootstrap

import typingsSlinky.react.mod.Component
import typingsSlinky.react.mod.HTMLProps
import typingsSlinky.reactBootstrap.buttonGroupMod.ButtonGroupProps
import typingsSlinky.reactBootstrap.mod.Omit
import typingsSlinky.reactBootstrap.reactBootstrapStrings.`type`
import typingsSlinky.reactBootstrap.reactBootstrapStrings.checkbox
import typingsSlinky.reactBootstrap.reactBootstrapStrings.defaultValue
import typingsSlinky.reactBootstrap.reactBootstrapStrings.onChange
import typingsSlinky.reactBootstrap.reactBootstrapStrings.radio
import typingsSlinky.reactBootstrap.reactBootstrapStrings.value
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object toggleButtonGroupMod {
  
  @JSImport("react-bootstrap/lib/ToggleButtonGroup", JSImport.Namespace)
  @js.native
  class ^ ()
    extends Component[ToggleButtonGroupProps, js.Object, js.Any]
  
  @js.native
  trait BaseProps extends js.Object {
    
    /**
      * You'll usually want to use string|number|string[]|number[] here,
      * but you can technically use any|any[].
      */
    var defaultValue: js.UndefOr[js.Any] = js.native
    
    /**
      * You'll usually want to use string|number|string[]|number[] here,
      * but you can technically use any|any[].
      */
    var value: js.UndefOr[js.Any] = js.native
  }
  object BaseProps {
    
    @scala.inline
    def apply(): BaseProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[BaseProps]
    }
    
    @scala.inline
    implicit class BasePropsOps[Self <: BaseProps] (val x: Self) extends AnyVal {
      
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
      def setDefaultValue(value: js.Any): Self = this.set("defaultValue", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteDefaultValue: Self = this.set("defaultValue", js.undefined)
      
      @scala.inline
      def setValue(value: js.Any): Self = this.set("value", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteValue: Self = this.set("value", js.undefined)
    }
  }
  
  @js.native
  trait CheckboxProps extends js.Object {
    
    var name: js.UndefOr[String] = js.native
    
    var onChange: js.UndefOr[js.Function1[/* values */ js.Array[_], Unit]] = js.native
    
    var `type`: checkbox = js.native
  }
  object CheckboxProps {
    
    @scala.inline
    def apply(`type`: checkbox): CheckboxProps = {
      val __obj = js.Dynamic.literal()
      __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
      __obj.asInstanceOf[CheckboxProps]
    }
    
    @scala.inline
    implicit class CheckboxPropsOps[Self <: CheckboxProps] (val x: Self) extends AnyVal {
      
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
      def setType(value: checkbox): Self = this.set("type", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setName(value: String): Self = this.set("name", value.asInstanceOf[js.Any])
      
      @scala.inline
      def deleteName: Self = this.set("name", js.undefined)
      
      @scala.inline
      def setOnChange(value: /* values */ js.Array[_] => Unit): Self = this.set("onChange", js.Any.fromFunction1(value))
      
      @scala.inline
      def deleteOnChange: Self = this.set("onChange", js.undefined)
    }
  }
  
  @js.native
  trait RadioProps extends js.Object {
    
    /** Required if `type` is set to "radio" */
    var name: String = js.native
    
    var onChange: js.UndefOr[js.Function1[/* value */ js.Any, Unit]] = js.native
    
    var `type`: radio = js.native
  }
  object RadioProps {
    
    @scala.inline
    def apply(name: String, `type`: radio): RadioProps = {
      val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any])
      __obj.updateDynamic("type")(`type`.asInstanceOf[js.Any])
      __obj.asInstanceOf[RadioProps]
    }
    
    @scala.inline
    implicit class RadioPropsOps[Self <: RadioProps] (val x: Self) extends AnyVal {
      
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
      def setName(value: String): Self = this.set("name", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setType(value: radio): Self = this.set("type", value.asInstanceOf[js.Any])
      
      @scala.inline
      def setOnChange(value: /* value */ js.Any => Unit): Self = this.set("onChange", js.Any.fromFunction1(value))
      
      @scala.inline
      def deleteOnChange: Self = this.set("onChange", js.undefined)
    }
  }
  
  @js.native
  trait ToggleButtonGroup
    extends Component[ToggleButtonGroupProps, js.Object, js.Any]
  
  type ToggleButtonGroupProps = BaseProps with (RadioProps | CheckboxProps) with (Omit[ButtonGroupProps, onChange]) with (Omit[HTMLProps[ToggleButtonGroup], defaultValue | `type` | value | onChange])
}
