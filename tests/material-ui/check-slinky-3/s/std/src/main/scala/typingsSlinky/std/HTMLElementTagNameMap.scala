package typingsSlinky.std

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

trait HTMLElementTagNameMap extends StObject {
  
  var a: org.scalajs.dom.HTMLAnchorElement
  
  var abbr: org.scalajs.dom.HTMLElement
  
  var address: org.scalajs.dom.HTMLElement
  
  var area: org.scalajs.dom.HTMLAreaElement
  
  var article: org.scalajs.dom.HTMLElement
  
  var aside: org.scalajs.dom.HTMLElement
  
  var audio: org.scalajs.dom.HTMLAudioElement
}
object HTMLElementTagNameMap {
  
  inline def apply(
    a: org.scalajs.dom.HTMLAnchorElement,
    abbr: org.scalajs.dom.HTMLElement,
    address: org.scalajs.dom.HTMLElement,
    area: org.scalajs.dom.HTMLAreaElement,
    article: org.scalajs.dom.HTMLElement,
    aside: org.scalajs.dom.HTMLElement,
    audio: org.scalajs.dom.HTMLAudioElement
  ): HTMLElementTagNameMap = {
    val __obj = js.Dynamic.literal(a = a.asInstanceOf[js.Any], abbr = abbr.asInstanceOf[js.Any], address = address.asInstanceOf[js.Any], area = area.asInstanceOf[js.Any], article = article.asInstanceOf[js.Any], aside = aside.asInstanceOf[js.Any], audio = audio.asInstanceOf[js.Any])
    __obj.asInstanceOf[HTMLElementTagNameMap]
  }
  
  @scala.inline
  implicit open class MutableBuilder[Self <: HTMLElementTagNameMap] (val x: Self) extends AnyVal {
    
    inline def setA(value: org.scalajs.dom.HTMLAnchorElement): Self = StObject.set(x, "a", value.asInstanceOf[js.Any])
    
    inline def setAbbr(value: org.scalajs.dom.HTMLElement): Self = StObject.set(x, "abbr", value.asInstanceOf[js.Any])
    
    inline def setAddress(value: org.scalajs.dom.HTMLElement): Self = StObject.set(x, "address", value.asInstanceOf[js.Any])
    
    inline def setArea(value: org.scalajs.dom.HTMLAreaElement): Self = StObject.set(x, "area", value.asInstanceOf[js.Any])
    
    inline def setArticle(value: org.scalajs.dom.HTMLElement): Self = StObject.set(x, "article", value.asInstanceOf[js.Any])
    
    inline def setAside(value: org.scalajs.dom.HTMLElement): Self = StObject.set(x, "aside", value.asInstanceOf[js.Any])
    
    inline def setAudio(value: org.scalajs.dom.HTMLAudioElement): Self = StObject.set(x, "audio", value.asInstanceOf[js.Any])
  }
}
