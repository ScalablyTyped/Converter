package typingsJapgolly.react.mod

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait IframeHTMLAttributes[T] extends HTMLAttributes[T] {
  
  var allow: js.UndefOr[String] = js.native
  
  var allowFullScreen: js.UndefOr[Boolean] = js.native
  
  var allowTransparency: js.UndefOr[Boolean] = js.native
  
  var frameBorder: js.UndefOr[Double | String] = js.native
  
  var height: js.UndefOr[Double | String] = js.native
  
  var marginHeight: js.UndefOr[Double] = js.native
  
  var marginWidth: js.UndefOr[Double] = js.native
  
  var name: js.UndefOr[String] = js.native
  
  var referrerPolicy: js.UndefOr[String] = js.native
  
  var sandbox: js.UndefOr[String] = js.native
  
  var scrolling: js.UndefOr[String] = js.native
  
  var seamless: js.UndefOr[Boolean] = js.native
  
  var src: js.UndefOr[String] = js.native
  
  var srcDoc: js.UndefOr[String] = js.native
  
  var width: js.UndefOr[Double | String] = js.native
}
object IframeHTMLAttributes {
  
  @scala.inline
  def apply[T](): IframeHTMLAttributes[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[IframeHTMLAttributes[T]]
  }
  
  @scala.inline
  implicit class IframeHTMLAttributesMutableBuilder[Self <: IframeHTMLAttributes[_], T] (val x: Self with IframeHTMLAttributes[T]) extends AnyVal {
    
    @scala.inline
    def setAllow(value: String): Self = StObject.set(x, "allow", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setAllowFullScreen(value: Boolean): Self = StObject.set(x, "allowFullScreen", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setAllowFullScreenUndefined: Self = StObject.set(x, "allowFullScreen", js.undefined)
    
    @scala.inline
    def setAllowTransparency(value: Boolean): Self = StObject.set(x, "allowTransparency", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setAllowTransparencyUndefined: Self = StObject.set(x, "allowTransparency", js.undefined)
    
    @scala.inline
    def setAllowUndefined: Self = StObject.set(x, "allow", js.undefined)
    
    @scala.inline
    def setFrameBorder(value: Double | String): Self = StObject.set(x, "frameBorder", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setFrameBorderUndefined: Self = StObject.set(x, "frameBorder", js.undefined)
    
    @scala.inline
    def setHeight(value: Double | String): Self = StObject.set(x, "height", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setHeightUndefined: Self = StObject.set(x, "height", js.undefined)
    
    @scala.inline
    def setMarginHeight(value: Double): Self = StObject.set(x, "marginHeight", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setMarginHeightUndefined: Self = StObject.set(x, "marginHeight", js.undefined)
    
    @scala.inline
    def setMarginWidth(value: Double): Self = StObject.set(x, "marginWidth", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setMarginWidthUndefined: Self = StObject.set(x, "marginWidth", js.undefined)
    
    @scala.inline
    def setName(value: String): Self = StObject.set(x, "name", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setNameUndefined: Self = StObject.set(x, "name", js.undefined)
    
    @scala.inline
    def setReferrerPolicy(value: String): Self = StObject.set(x, "referrerPolicy", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setReferrerPolicyUndefined: Self = StObject.set(x, "referrerPolicy", js.undefined)
    
    @scala.inline
    def setSandbox(value: String): Self = StObject.set(x, "sandbox", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setSandboxUndefined: Self = StObject.set(x, "sandbox", js.undefined)
    
    @scala.inline
    def setScrolling(value: String): Self = StObject.set(x, "scrolling", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setScrollingUndefined: Self = StObject.set(x, "scrolling", js.undefined)
    
    @scala.inline
    def setSeamless(value: Boolean): Self = StObject.set(x, "seamless", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setSeamlessUndefined: Self = StObject.set(x, "seamless", js.undefined)
    
    @scala.inline
    def setSrc(value: String): Self = StObject.set(x, "src", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setSrcDoc(value: String): Self = StObject.set(x, "srcDoc", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setSrcDocUndefined: Self = StObject.set(x, "srcDoc", js.undefined)
    
    @scala.inline
    def setSrcUndefined: Self = StObject.set(x, "src", js.undefined)
    
    @scala.inline
    def setWidth(value: Double | String): Self = StObject.set(x, "width", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setWidthUndefined: Self = StObject.set(x, "width", js.undefined)
  }
}
