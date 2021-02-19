package typingsJapgolly.react.mod

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait AnchorHTMLAttributes[T] extends HTMLAttributes[T] {
  
  var download: js.UndefOr[js.Any] = js.native
  
  var href: js.UndefOr[String] = js.native
  
  var hrefLang: js.UndefOr[String] = js.native
  
  var media: js.UndefOr[String] = js.native
  
  var ping: js.UndefOr[String] = js.native
  
  var referrerPolicy: js.UndefOr[String] = js.native
  
  var rel: js.UndefOr[String] = js.native
  
  var target: js.UndefOr[String] = js.native
  
  var `type`: js.UndefOr[String] = js.native
}
object AnchorHTMLAttributes {
  
  @scala.inline
  def apply[T](): AnchorHTMLAttributes[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[AnchorHTMLAttributes[T]]
  }
  
  @scala.inline
  implicit class AnchorHTMLAttributesMutableBuilder[Self <: AnchorHTMLAttributes[?], T] (val x: Self & AnchorHTMLAttributes[T]) extends AnyVal {
    
    @scala.inline
    def setDownload(value: js.Any): Self = StObject.set(x, "download", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setDownloadUndefined: Self = StObject.set(x, "download", ())
    
    @scala.inline
    def setHref(value: String): Self = StObject.set(x, "href", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setHrefLang(value: String): Self = StObject.set(x, "hrefLang", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setHrefLangUndefined: Self = StObject.set(x, "hrefLang", ())
    
    @scala.inline
    def setHrefUndefined: Self = StObject.set(x, "href", ())
    
    @scala.inline
    def setMedia(value: String): Self = StObject.set(x, "media", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setMediaUndefined: Self = StObject.set(x, "media", ())
    
    @scala.inline
    def setPing(value: String): Self = StObject.set(x, "ping", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setPingUndefined: Self = StObject.set(x, "ping", ())
    
    @scala.inline
    def setReferrerPolicy(value: String): Self = StObject.set(x, "referrerPolicy", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setReferrerPolicyUndefined: Self = StObject.set(x, "referrerPolicy", ())
    
    @scala.inline
    def setRel(value: String): Self = StObject.set(x, "rel", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setRelUndefined: Self = StObject.set(x, "rel", ())
    
    @scala.inline
    def setTarget(value: String): Self = StObject.set(x, "target", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setTargetUndefined: Self = StObject.set(x, "target", ())
    
    @scala.inline
    def setType(value: String): Self = StObject.set(x, "type", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setTypeUndefined: Self = StObject.set(x, "type", ())
  }
}
