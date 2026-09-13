package typingsJapgolly.componentstest

import typingsJapgolly.componentstest.anon.`0`
import typingsJapgolly.componentstest.componentstestStrings.filled
import typingsJapgolly.componentstest.componentstestStrings.outlined
import typingsJapgolly.componentstest.componentstestStrings.standard
import typingsJapgolly.componentstest.componentstestStrings.variant
import typingsJapgolly.componentstest.mod.FooProps
import typingsJapgolly.react.mod.global.JSX.Element
import typingsJapgolly.std.Omit
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object textFieldMod {
  
  @JSImport("componentstest/TextField", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  inline def default_variant[Variant /* <: TextFieldVariants */](props: `0`[Variant] & (Omit[TextFieldProps[TextFieldVariants], variant])): Element = ^.asInstanceOf[js.Dynamic].applyDynamic("default")(props.asInstanceOf[js.Any]).asInstanceOf[Element]
  
  trait FilledTextFieldProps
    extends StObject
       with FooProps {
    
    var variant: filled
  }
  object FilledTextFieldProps {
    
    inline def apply(): FilledTextFieldProps = {
      val __obj = js.Dynamic.literal(variant = "filled")
      __obj.asInstanceOf[FilledTextFieldProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: FilledTextFieldProps] (val x: Self) extends AnyVal {
      
      inline def setVariant(value: filled): Self = StObject.set(x, "variant", value.asInstanceOf[js.Any])
    }
  }
  
  trait OutlinedTextFieldProps
    extends StObject
       with FooProps {
    
    var variant: outlined
  }
  object OutlinedTextFieldProps {
    
    inline def apply(): OutlinedTextFieldProps = {
      val __obj = js.Dynamic.literal(variant = "outlined")
      __obj.asInstanceOf[OutlinedTextFieldProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: OutlinedTextFieldProps] (val x: Self) extends AnyVal {
      
      inline def setVariant(value: outlined): Self = StObject.set(x, "variant", value.asInstanceOf[js.Any])
    }
  }
  
  trait StandardTextFieldProps
    extends StObject
       with FooProps {
    
    var variant: js.UndefOr[standard] = js.undefined
  }
  object StandardTextFieldProps {
    
    inline def apply(): StandardTextFieldProps = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[StandardTextFieldProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: StandardTextFieldProps] (val x: Self) extends AnyVal {
      
      inline def setVariant(value: standard): Self = StObject.set(x, "variant", value.asInstanceOf[js.Any])
      
      inline def setVariantUndefined: Self = StObject.set(x, "variant", js.undefined)
    }
  }
  
  /** NOTE: Conditional type definitions are impossible to translate to Scala.
    * See https://www.typescriptlang.org/docs/handbook/2/conditional-types.html for an intro.
    * This RHS of the type alias is guess work. You should cast if it's not correct in your case.
    * TS definition: {{{
    Variant extends 'filled' ? componentstest.componentstest/TextField.FilledTextFieldProps : Variant extends 'standard' ? componentstest.componentstest/TextField.StandardTextFieldProps : componentstest.componentstest/TextField.OutlinedTextFieldProps
    }}}
    */
  type TextFieldProps[Variant /* <: TextFieldVariants */] = FilledTextFieldProps
  
  /* Rewritten from type alias, can be one of: 
    - typingsJapgolly.componentstest.componentstestStrings.outlined
    - typingsJapgolly.componentstest.componentstestStrings.filled
    - typingsJapgolly.componentstest.componentstestStrings.standard
  */
  trait TextFieldVariants extends StObject
  object TextFieldVariants {
    
    inline def filled: typingsJapgolly.componentstest.componentstestStrings.filled = "filled".asInstanceOf[typingsJapgolly.componentstest.componentstestStrings.filled]
    
    inline def outlined: typingsJapgolly.componentstest.componentstestStrings.outlined = "outlined".asInstanceOf[typingsJapgolly.componentstest.componentstestStrings.outlined]
    
    inline def standard: typingsJapgolly.componentstest.componentstestStrings.standard = "standard".asInstanceOf[typingsJapgolly.componentstest.componentstestStrings.standard]
  }
}
