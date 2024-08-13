package typingsJapgolly.react

import japgolly.scalajs.react.Callback
import typingsJapgolly.react.mod.Component
import typingsJapgolly.react.mod.HTMLProps
import typingsJapgolly.react.reactStrings.`type`
import typingsJapgolly.react.reactStrings.checkbox
import typingsJapgolly.react.reactStrings.defaultValue
import typingsJapgolly.react.reactStrings.onChange
import typingsJapgolly.react.reactStrings.radio
import typingsJapgolly.react.reactStrings.value
import typingsJapgolly.reactBootstrap.libButtonGroupMod.ButtonGroupProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object reactBootstrapLibToggleButtonGroupMod {
  
  @JSImport("react/react-bootstrap/lib/ToggleButtonGroup", JSImport.Namespace)
  @js.native
  open class ^ ()
    extends Component[ToggleButtonGroupProps, js.Object, Any]
  
  trait BaseProps extends StObject {
    
    /**
      * You'll usually want to use string|number|string[]|number[] here,
      * but you can technically use any|any[].
      */
    var defaultValue: js.UndefOr[Any] = js.undefined
    
    /**
      * You'll usually want to use string|number|string[]|number[] here,
      * but you can technically use any|any[].
      */
    var value: js.UndefOr[Any] = js.undefined
  }
  object BaseProps {
    
    inline def apply(): BaseProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[BaseProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: BaseProps] (val x: Self) extends AnyVal {
      
      inline def setDefaultValue(value: Any): Self = StObject.set(x, "defaultValue", value.asInstanceOf[js.Any])
      
      inline def setDefaultValueUndefined: Self = StObject.set(x, "defaultValue", js.undefined)
      
      inline def setValue(value: Any): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
      
      inline def setValueUndefined: Self = StObject.set(x, "value", js.undefined)
    }
  }
  
  trait CheckboxProps extends StObject {
    
    var name: js.UndefOr[String] = js.undefined
    
    var onChange: js.UndefOr[js.Function1[/* values */ js.Array[Any], Unit]] = js.undefined
    
    var `type`: checkbox
  }
  object CheckboxProps {
    
    inline def apply(): CheckboxProps = {
      val __obj = js.Dynamic.literal()
      __obj.updateDynamic("type")("checkbox")
      __obj.asInstanceOf[CheckboxProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: CheckboxProps] (val x: Self) extends AnyVal {
      
      inline def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
      
      inline def setNameUndefined: Self = StObject.set(x, "name", js.undefined)
      
      inline def setOnChange(value: /* values */ js.Array[Any] => Callback): Self = StObject.set(x, "onChange", js.Any.fromFunction1((t0: /* values */ js.Array[Any]) => value(t0).runNow()))
      
      inline def setOnChangeUndefined: Self = StObject.set(x, "onChange", js.undefined)
      
      inline def setType(value: checkbox): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
    }
  }
  
  trait RadioProps extends StObject {
    
    /** Required if `type` is set to "radio" */
    var name: String
    
    var onChange: js.UndefOr[js.Function1[/* value */ Any, Unit]] = js.undefined
    
    var `type`: radio
  }
  object RadioProps {
    
    inline def apply(name: String): RadioProps = {
      val __obj = js.Dynamic.literal(name = name.asInstanceOf[js.Any])
      __obj.updateDynamic("type")("radio")
      __obj.asInstanceOf[RadioProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: RadioProps] (val x: Self) extends AnyVal {
      
      inline def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
      
      inline def setOnChange(value: /* value */ Any => Callback): Self = StObject.set(x, "onChange", js.Any.fromFunction1((t0: /* value */ Any) => value(t0).runNow()))
      
      inline def setOnChangeUndefined: Self = StObject.set(x, "onChange", js.undefined)
      
      inline def setType(value: radio): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
    }
  }
  
  type ToggleButtonGroup = japgolly.scalajs.react.facade.React.Component[ToggleButtonGroupProps & js.Object, js.Object]
  
  /** 
  NOTE: Rewritten from type alias:
  {{{
  type ToggleButtonGroupProps = react.react/react-bootstrap/lib/ToggleButtonGroup.RadioProps & react.react/react-bootstrap/lib/ToggleButtonGroup.BaseProps & react.react/react-bootstrap.Omit<react-bootstrap.react-bootstrap/lib/ButtonGroup.ButtonGroupProps, 'onChange'> & react.react/react-bootstrap.Omit<react.react.HTMLProps<react.react/react-bootstrap/lib/ToggleButtonGroup.ToggleButtonGroup>, 'defaultValue' | 'type' | 'value' | 'onChange'> | react.react/react-bootstrap/lib/ToggleButtonGroup.CheckboxProps & react.react/react-bootstrap/lib/ToggleButtonGroup.BaseProps & react.react/react-bootstrap.Omit<react-bootstrap.react-bootstrap/lib/ButtonGroup.ButtonGroupProps, 'onChange'> & react.react/react-bootstrap.Omit<react.react.HTMLProps<react.react/react-bootstrap/lib/ToggleButtonGroup.ToggleButtonGroup>, 'defaultValue' | 'type' | 'value' | 'onChange'>
  }}}
  to avoid circular code involving: 
  - react.react/react-bootstrap/lib/ToggleButtonGroup.ToggleButtonGroup
  - react.react/react-bootstrap/lib/ToggleButtonGroup.ToggleButtonGroupProps
  */
  type ToggleButtonGroupProps = (RadioProps & BaseProps & (typingsJapgolly.react.reactBootstrapMod.Omit[ButtonGroupProps, onChange]) & (typingsJapgolly.react.reactBootstrapMod.Omit[HTMLProps[Any], defaultValue | `type` | value | onChange])) | (CheckboxProps & BaseProps & (typingsJapgolly.react.reactBootstrapMod.Omit[ButtonGroupProps, onChange]) & (typingsJapgolly.react.reactBootstrapMod.Omit[HTMLProps[Any], defaultValue | `type` | value | onChange]))
}
