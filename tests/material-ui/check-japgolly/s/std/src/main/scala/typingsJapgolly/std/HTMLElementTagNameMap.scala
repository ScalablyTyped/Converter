package typingsJapgolly.std

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait HTMLElementTagNameMap extends StObject {
  
  var a: org.scalajs.dom.raw.HTMLAnchorElement = js.native
  
  var abbr: org.scalajs.dom.raw.HTMLElement = js.native
  
  var address: org.scalajs.dom.raw.HTMLElement = js.native
  
  var area: org.scalajs.dom.raw.HTMLAreaElement = js.native
  
  var article: org.scalajs.dom.raw.HTMLElement = js.native
  
  var aside: org.scalajs.dom.raw.HTMLElement = js.native
  
  var audio: org.scalajs.dom.raw.HTMLAudioElement = js.native
}
object HTMLElementTagNameMap {
  
  @scala.inline
  def apply(
    a: org.scalajs.dom.raw.HTMLAnchorElement,
    abbr: org.scalajs.dom.raw.HTMLElement,
    address: org.scalajs.dom.raw.HTMLElement,
    area: org.scalajs.dom.raw.HTMLAreaElement,
    article: org.scalajs.dom.raw.HTMLElement,
    aside: org.scalajs.dom.raw.HTMLElement,
    audio: org.scalajs.dom.raw.HTMLAudioElement
  ): HTMLElementTagNameMap = {
    val __obj = js.Dynamic.literal(a = a.asInstanceOf[js.Any], abbr = abbr.asInstanceOf[js.Any], address = address.asInstanceOf[js.Any], area = area.asInstanceOf[js.Any], article = article.asInstanceOf[js.Any], aside = aside.asInstanceOf[js.Any], audio = audio.asInstanceOf[js.Any])
    __obj.asInstanceOf[HTMLElementTagNameMap]
  }
  
  @scala.inline
  implicit class HTMLElementTagNameMapMutableBuilder[Self <: HTMLElementTagNameMap] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setA(value: org.scalajs.dom.raw.HTMLAnchorElement): Self = StObject.set(x, "a", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setAbbr(value: org.scalajs.dom.raw.HTMLElement): Self = StObject.set(x, "abbr", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setAddress(value: org.scalajs.dom.raw.HTMLElement): Self = StObject.set(x, "address", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setArea(value: org.scalajs.dom.raw.HTMLAreaElement): Self = StObject.set(x, "area", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setArticle(value: org.scalajs.dom.raw.HTMLElement): Self = StObject.set(x, "article", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setAside(value: org.scalajs.dom.raw.HTMLElement): Self = StObject.set(x, "aside", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setAudio(value: org.scalajs.dom.raw.HTMLAudioElement): Self = StObject.set(x, "audio", value.asInstanceOf[js.Any])
  }
}
