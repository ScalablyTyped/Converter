package typingsSlinky.react.mod

import org.scalajs.dom.raw.HTMLAnchorElement
import org.scalajs.dom.raw.HTMLAreaElement
import org.scalajs.dom.raw.HTMLAudioElement
import org.scalajs.dom.raw.HTMLBaseElement
import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.raw.SVGViewElement
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  object JSX {
    
    // tslint:disable-next-line:no-empty-interface
    type Element = slinky.core.facade.ReactElement
    
    @js.native
    trait ElementAttributesProperty extends StObject
    
    @js.native
    trait ElementChildrenAttribute extends StObject
    
    @js.native
    trait ElementClass
      extends Component[js.Any, js.Object, js.Any]
    
    // tslint:disable-next-line:no-empty-interface
    type IntrinsicAttributes = Attributes
    
    // tslint:disable-next-line:no-empty-interface
    type IntrinsicClassAttributes[T] = ClassAttributes[T]
    
    @js.native
    trait IntrinsicElements extends StObject {
      
      // HTML
      var a: DetailedHTMLProps[AnchorHTMLAttributes[HTMLAnchorElement], HTMLAnchorElement] = js.native
      
      var abbr: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement] = js.native
      
      var address: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement] = js.native
      
      var area: DetailedHTMLProps[AreaHTMLAttributes[HTMLAreaElement], HTMLAreaElement] = js.native
      
      var article: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement] = js.native
      
      var aside: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement] = js.native
      
      var audio: DetailedHTMLProps[AudioHTMLAttributes[HTMLAudioElement], HTMLAudioElement] = js.native
      
      var b: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement] = js.native
      
      var base: DetailedHTMLProps[BaseHTMLAttributes[HTMLBaseElement], HTMLBaseElement] = js.native
      
      var bdi: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement] = js.native
      
      var bdo: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement] = js.native
      
      var big: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement] = js.native
      
      var view: SVGProps[SVGViewElement] = js.native
    }
    object IntrinsicElements {
      
      @scala.inline
      def apply(
        a: DetailedHTMLProps[AnchorHTMLAttributes[HTMLAnchorElement], HTMLAnchorElement],
        abbr: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement],
        address: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement],
        area: DetailedHTMLProps[AreaHTMLAttributes[HTMLAreaElement], HTMLAreaElement],
        article: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement],
        aside: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement],
        audio: DetailedHTMLProps[AudioHTMLAttributes[HTMLAudioElement], HTMLAudioElement],
        b: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement],
        base: DetailedHTMLProps[BaseHTMLAttributes[HTMLBaseElement], HTMLBaseElement],
        bdi: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement],
        bdo: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement],
        big: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement],
        view: SVGProps[SVGViewElement]
      ): IntrinsicElements = {
        val __obj = js.Dynamic.literal(a = a.asInstanceOf[js.Any], abbr = abbr.asInstanceOf[js.Any], address = address.asInstanceOf[js.Any], area = area.asInstanceOf[js.Any], article = article.asInstanceOf[js.Any], aside = aside.asInstanceOf[js.Any], audio = audio.asInstanceOf[js.Any], b = b.asInstanceOf[js.Any], base = base.asInstanceOf[js.Any], bdi = bdi.asInstanceOf[js.Any], bdo = bdo.asInstanceOf[js.Any], big = big.asInstanceOf[js.Any], view = view.asInstanceOf[js.Any])
        __obj.asInstanceOf[IntrinsicElements]
      }
      
      @scala.inline
      implicit class IntrinsicElementsMutableBuilder[Self <: IntrinsicElements] (val x: Self) extends AnyVal {
        
        @scala.inline
        def setA(value: DetailedHTMLProps[AnchorHTMLAttributes[HTMLAnchorElement], HTMLAnchorElement]): Self = StObject.set(x, "a", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setAbbr(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = StObject.set(x, "abbr", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setAddress(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = StObject.set(x, "address", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setArea(value: DetailedHTMLProps[AreaHTMLAttributes[HTMLAreaElement], HTMLAreaElement]): Self = StObject.set(x, "area", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setArticle(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = StObject.set(x, "article", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setAside(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = StObject.set(x, "aside", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setAudio(value: DetailedHTMLProps[AudioHTMLAttributes[HTMLAudioElement], HTMLAudioElement]): Self = StObject.set(x, "audio", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setB(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = StObject.set(x, "b", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setBase(value: DetailedHTMLProps[BaseHTMLAttributes[HTMLBaseElement], HTMLBaseElement]): Self = StObject.set(x, "base", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setBdi(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = StObject.set(x, "bdi", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setBdo(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = StObject.set(x, "bdo", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setBig(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = StObject.set(x, "big", value.asInstanceOf[js.Any])
        
        @scala.inline
        def setView(value: SVGProps[SVGViewElement]): Self = StObject.set(x, "view", value.asInstanceOf[js.Any])
      }
    }
    
    // We can't recurse forever because `type` can't be self-referential;
    // let's assume it's reasonable to do a single React.lazy() around a single React.memo() / vice-versa
    type LibraryManagedAttributes[C, P] = ReactManagedAttributes[js.Any | C, P]
  }
}
