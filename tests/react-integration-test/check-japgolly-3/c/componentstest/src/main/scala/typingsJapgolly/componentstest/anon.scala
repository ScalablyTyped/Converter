package typingsJapgolly.componentstest

import japgolly.scalajs.react.facade.React.ElementType
import typingsJapgolly.componentstest.textFieldMod.TextFieldVariants
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  trait `0`[Variant /* <: TextFieldVariants */] extends StObject {
    
    var variant: js.UndefOr[Variant] = js.undefined
  }
  object `0` {
    
    inline def apply[Variant /* <: TextFieldVariants */](): `0`[Variant] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[`0`[Variant]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: `0`[?], Variant /* <: TextFieldVariants */] (val x: Self & `0`[Variant]) extends AnyVal {
      
      inline def setVariant(value: Variant): Self = StObject.set(x, "variant", value.asInstanceOf[js.Any])
      
      inline def setVariantUndefined: Self = StObject.set(x, "variant", js.undefined)
    }
  }
  
  trait Component[C /* <: ElementType */] extends StObject {
    
    var component: C
  }
  object Component {
    
    inline def apply[C /* <: ElementType */](component: C): Component[C] = {
      val __obj = js.Dynamic.literal(component = component.asInstanceOf[js.Any])
      __obj.asInstanceOf[Component[C]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Component[?], C /* <: ElementType */] (val x: Self & Component[C]) extends AnyVal {
      
      inline def setComponent(value: C): Self = StObject.set(x, "component", value.asInstanceOf[js.Any])
    }
  }
  
  trait Equals extends StObject {
    
    @JSName("equals")
    var equals_FEquals: js.UndefOr[Boolean] = js.undefined
    
    def finalize(other: js.Object): Boolean
    
    @JSName("ne")
    var ne_FEquals: js.UndefOr[js.Function1[/* other */ js.Object, Boolean]] = js.undefined
  }
  object Equals {
    
    inline def apply(finalize_ : js.Object => Boolean): Equals = {
      val __obj = js.Dynamic.literal()
      __obj.updateDynamic("finalize")(js.Any.fromFunction1(finalize_))
      __obj.asInstanceOf[Equals]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Equals] (val x: Self) extends AnyVal {
      
      inline def setEquals_(value: Boolean): Self = StObject.set(x, "equals", value.asInstanceOf[js.Any])
      
      inline def setEquals_Undefined: Self = StObject.set(x, "equals", js.undefined)
      
      inline def setFinalize_(value: js.Object => Boolean): Self = StObject.set(x, "finalize", js.Any.fromFunction1(value))
      
      inline def setNe_(value: /* other */ js.Object => Boolean): Self = StObject.set(x, "ne", js.Any.fromFunction1(value))
      
      inline def setNe_Undefined: Self = StObject.set(x, "ne", js.undefined)
    }
  }
  
  trait Href extends StObject {
    
    var href: String
  }
  object Href {
    
    inline def apply(href: String): Href = {
      val __obj = js.Dynamic.literal(href = href.asInstanceOf[js.Any])
      __obj.asInstanceOf[Href]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Href] (val x: Self) extends AnyVal {
      
      inline def setHref(value: String): Self = StObject.set(x, "href", value.asInstanceOf[js.Any])
    }
  }
  
  /* Inlined {  href :string} & componentstest.componentstest.FooProps */
  trait hrefstringFooProps extends StObject {
    
    var disabled: js.UndefOr[Boolean] = js.undefined
    
    var href: String
    
    var label: js.UndefOr[String] = js.undefined
  }
  object hrefstringFooProps {
    
    inline def apply(href: String): hrefstringFooProps = {
      val __obj = js.Dynamic.literal(href = href.asInstanceOf[js.Any])
      __obj.asInstanceOf[hrefstringFooProps]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: hrefstringFooProps] (val x: Self) extends AnyVal {
      
      inline def setDisabled(value: Boolean): Self = StObject.set(x, "disabled", value.asInstanceOf[js.Any])
      
      inline def setDisabledUndefined: Self = StObject.set(x, "disabled", js.undefined)
      
      inline def setHref(value: String): Self = StObject.set(x, "href", value.asInstanceOf[js.Any])
      
      inline def setLabel(value: String): Self = StObject.set(x, "label", value.asInstanceOf[js.Any])
      
      inline def setLabelUndefined: Self = StObject.set(x, "label", js.undefined)
    }
  }
}
