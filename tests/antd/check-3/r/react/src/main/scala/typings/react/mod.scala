package typings.react

import typings.react.anon.Html
import typings.react.reactStrings.button
import typings.react.reactStrings.reset
import typings.react.reactStrings.submit
import typings.std.Partial
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  trait AnchorHTMLAttributes[T]
    extends StObject
       with HTMLAttributes[T] {
    
    var download: js.UndefOr[Any] = js.undefined
    
    var href: js.UndefOr[String] = js.undefined
    
    var hrefLang: js.UndefOr[String] = js.undefined
    
    var media: js.UndefOr[String] = js.undefined
    
    var ping: js.UndefOr[String] = js.undefined
    
    var referrerPolicy: js.UndefOr[String] = js.undefined
    
    var target: js.UndefOr[String] = js.undefined
    
    var `type`: js.UndefOr[String] = js.undefined
  }
  object AnchorHTMLAttributes {
    
    inline def apply[T](): AnchorHTMLAttributes[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[AnchorHTMLAttributes[T]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: AnchorHTMLAttributes[?], T] (val x: Self & AnchorHTMLAttributes[T]) extends AnyVal {
      
      inline def setDownload(value: Any): Self = StObject.set(x, "download", value.asInstanceOf[js.Any])
      
      inline def setDownloadUndefined: Self = StObject.set(x, "download", js.undefined)
      
      inline def setHref(value: String): Self = StObject.set(x, "href", value.asInstanceOf[js.Any])
      
      inline def setHrefLang(value: String): Self = StObject.set(x, "hrefLang", value.asInstanceOf[js.Any])
      
      inline def setHrefLangUndefined: Self = StObject.set(x, "hrefLang", js.undefined)
      
      inline def setHrefUndefined: Self = StObject.set(x, "href", js.undefined)
      
      inline def setMedia(value: String): Self = StObject.set(x, "media", value.asInstanceOf[js.Any])
      
      inline def setMediaUndefined: Self = StObject.set(x, "media", js.undefined)
      
      inline def setPing(value: String): Self = StObject.set(x, "ping", value.asInstanceOf[js.Any])
      
      inline def setPingUndefined: Self = StObject.set(x, "ping", js.undefined)
      
      inline def setReferrerPolicy(value: String): Self = StObject.set(x, "referrerPolicy", value.asInstanceOf[js.Any])
      
      inline def setReferrerPolicyUndefined: Self = StObject.set(x, "referrerPolicy", js.undefined)
      
      inline def setTarget(value: String): Self = StObject.set(x, "target", value.asInstanceOf[js.Any])
      
      inline def setTargetUndefined: Self = StObject.set(x, "target", js.undefined)
      
      inline def setType(value: String): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
      
      inline def setTypeUndefined: Self = StObject.set(x, "type", js.undefined)
    }
  }
  
  /**
    * @internal You shouldn't need to use this type since you never see these attributes
    * inside your component or have to validate them.
    */
  trait Attributes extends StObject {
    
    var key: js.UndefOr[Key | Null] = js.undefined
  }
  object Attributes {
    
    inline def apply(): Attributes = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[Attributes]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Attributes] (val x: Self) extends AnyVal {
      
      inline def setKey(value: Key): Self = StObject.set(x, "key", value.asInstanceOf[js.Any])
      
      inline def setKeyNull: Self = StObject.set(x, "key", null)
      
      inline def setKeyUndefined: Self = StObject.set(x, "key", js.undefined)
    }
  }
  
  trait ButtonHTMLAttributes[T]
    extends StObject
       with HTMLAttributes[T] {
    
    var disabled: js.UndefOr[Boolean] = js.undefined
    
    var form: js.UndefOr[String] = js.undefined
    
    var formAction: js.UndefOr[String] = js.undefined
    
    var formEncType: js.UndefOr[String] = js.undefined
    
    var formMethod: js.UndefOr[String] = js.undefined
    
    var formNoValidate: js.UndefOr[Boolean] = js.undefined
    
    var formTarget: js.UndefOr[String] = js.undefined
    
    var name: js.UndefOr[String] = js.undefined
    
    var `type`: js.UndefOr[submit | reset | button] = js.undefined
    
    var value: js.UndefOr[String | js.Array[String] | Double] = js.undefined
  }
  object ButtonHTMLAttributes {
    
    inline def apply[T](): ButtonHTMLAttributes[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[ButtonHTMLAttributes[T]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: ButtonHTMLAttributes[?], T] (val x: Self & ButtonHTMLAttributes[T]) extends AnyVal {
      
      inline def setDisabled(value: Boolean): Self = StObject.set(x, "disabled", value.asInstanceOf[js.Any])
      
      inline def setDisabledUndefined: Self = StObject.set(x, "disabled", js.undefined)
      
      inline def setForm(value: String): Self = StObject.set(x, "form", value.asInstanceOf[js.Any])
      
      inline def setFormAction(value: String): Self = StObject.set(x, "formAction", value.asInstanceOf[js.Any])
      
      inline def setFormActionUndefined: Self = StObject.set(x, "formAction", js.undefined)
      
      inline def setFormEncType(value: String): Self = StObject.set(x, "formEncType", value.asInstanceOf[js.Any])
      
      inline def setFormEncTypeUndefined: Self = StObject.set(x, "formEncType", js.undefined)
      
      inline def setFormMethod(value: String): Self = StObject.set(x, "formMethod", value.asInstanceOf[js.Any])
      
      inline def setFormMethodUndefined: Self = StObject.set(x, "formMethod", js.undefined)
      
      inline def setFormNoValidate(value: Boolean): Self = StObject.set(x, "formNoValidate", value.asInstanceOf[js.Any])
      
      inline def setFormNoValidateUndefined: Self = StObject.set(x, "formNoValidate", js.undefined)
      
      inline def setFormTarget(value: String): Self = StObject.set(x, "formTarget", value.asInstanceOf[js.Any])
      
      inline def setFormTargetUndefined: Self = StObject.set(x, "formTarget", js.undefined)
      
      inline def setFormUndefined: Self = StObject.set(x, "form", js.undefined)
      
      inline def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
      
      inline def setNameUndefined: Self = StObject.set(x, "name", js.undefined)
      
      inline def setType(value: submit | reset | button): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
      
      inline def setTypeUndefined: Self = StObject.set(x, "type", js.undefined)
      
      inline def setValue(value: String | js.Array[String] | Double): Self = StObject.set(x, "value", value.asInstanceOf[js.Any])
      
      inline def setValueUndefined: Self = StObject.set(x, "value", js.undefined)
      
      inline def setValueVarargs(value: String*): Self = StObject.set(x, "value", js.Array(value*))
    }
  }
  
  trait DOMAttributes[T] extends StObject {
    
    var children: js.UndefOr[ReactNode] = js.undefined
    
    var dangerouslySetInnerHTML: js.UndefOr[Html] = js.undefined
    
    var onClick: js.UndefOr[Double | (js.Function1[/* x */ String, Unit])] = js.undefined
  }
  object DOMAttributes {
    
    inline def apply[T](): DOMAttributes[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[DOMAttributes[T]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: DOMAttributes[?], T] (val x: Self & DOMAttributes[T]) extends AnyVal {
      
      inline def setChildren(value: ReactNode): Self = StObject.set(x, "children", value.asInstanceOf[js.Any])
      
      inline def setChildrenUndefined: Self = StObject.set(x, "children", js.undefined)
      
      inline def setDangerouslySetInnerHTML(value: Html): Self = StObject.set(x, "dangerouslySetInnerHTML", value.asInstanceOf[js.Any])
      
      inline def setDangerouslySetInnerHTMLUndefined: Self = StObject.set(x, "dangerouslySetInnerHTML", js.undefined)
      
      inline def setOnClick(value: Double | (js.Function1[/* x */ String, Unit])): Self = StObject.set(x, "onClick", value.asInstanceOf[js.Any])
      
      inline def setOnClickFunction1(value: /* x */ String => Unit): Self = StObject.set(x, "onClick", js.Any.fromFunction1(value))
      
      inline def setOnClickUndefined: Self = StObject.set(x, "onClick", js.undefined)
    }
  }
  
  @js.native
  trait ExoticComponent[P] extends StObject {
    
    /**
      * **NOTE**: Exotic components are not callable.
      */
    def apply(props: P): ReactNode = js.native
    
    @JSName("$$typeof")
    val DollarDollartypeof: js.Symbol = js.native
  }
  
  @js.native
  trait ForwardRefExoticComponent[P]
    extends StObject
       with NamedExoticComponent[P] {
    
    var defaultProps: js.UndefOr[Partial[P]] = js.native
    
    var propTypes: js.UndefOr[js.Object] = js.native
  }
  
  trait HTMLAttributes[T]
    extends StObject
       with DOMAttributes[T] {
    
    var defaultChecked: js.UndefOr[Boolean] = js.undefined
  }
  object HTMLAttributes {
    
    inline def apply[T](): HTMLAttributes[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[HTMLAttributes[T]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: HTMLAttributes[?], T] (val x: Self & HTMLAttributes[T]) extends AnyVal {
      
      inline def setDefaultChecked(value: Boolean): Self = StObject.set(x, "defaultChecked", value.asInstanceOf[js.Any])
      
      inline def setDefaultCheckedUndefined: Self = StObject.set(x, "defaultChecked", js.undefined)
    }
  }
  
  type Key = String | Double
  
  @js.native
  trait NamedExoticComponent[P]
    extends StObject
       with ExoticComponent[P] {
    
    var displayName: js.UndefOr[String] = js.native
  }
  
  type ReactNode = js.UndefOr[String | Double | Boolean]
  
  type Ref[T] = RefCallback[T] | RefObject[T] | Null
  
  trait RefAttributes[T]
    extends StObject
       with Attributes {
    
    /**
      * Allows getting a ref to the component instance.
      * Once the component unmounts, React will set `ref.current` to `null` (or call the ref with `null` if you passed a callback ref).
      * @see https://react.dev/learn/referencing-values-with-refs#refs-and-the-dom
      */
    var ref: js.UndefOr[Ref[T]] = js.undefined
  }
  object RefAttributes {
    
    inline def apply[T](): RefAttributes[T] = {
      val __obj = js.Dynamic.literal()
      __obj.asInstanceOf[RefAttributes[T]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: RefAttributes[?], T] (val x: Self & RefAttributes[T]) extends AnyVal {
      
      inline def setRef(value: Ref[T]): Self = StObject.set(x, "ref", value.asInstanceOf[js.Any])
      
      inline def setRefFunction1(value: /* instance */ T | Null => Unit): Self = StObject.set(x, "ref", js.Any.fromFunction1(value))
      
      inline def setRefNull: Self = StObject.set(x, "ref", null)
      
      inline def setRefUndefined: Self = StObject.set(x, "ref", js.undefined)
    }
  }
  
  // Bivariance hack for consistent unsoundness with RefObject
  type RefCallback[T] = js.Function1[/* instance */ T | Null, Unit]
  
  trait RefObject[T] extends StObject {
    
    val current: T | Null
  }
  object RefObject {
    
    inline def apply[T](): RefObject[T] = {
      val __obj = js.Dynamic.literal(current = null)
      __obj.asInstanceOf[RefObject[T]]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: RefObject[?], T] (val x: Self & RefObject[T]) extends AnyVal {
      
      inline def setCurrent(value: T): Self = StObject.set(x, "current", value.asInstanceOf[js.Any])
      
      inline def setCurrentNull: Self = StObject.set(x, "current", null)
    }
  }
}
