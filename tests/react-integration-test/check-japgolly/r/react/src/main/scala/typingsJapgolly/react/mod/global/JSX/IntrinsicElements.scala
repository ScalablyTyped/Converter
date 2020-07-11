package typingsJapgolly.react.mod.global.JSX

import org.scalajs.dom.raw.HTMLAnchorElement
import org.scalajs.dom.raw.HTMLAreaElement
import org.scalajs.dom.raw.HTMLAudioElement
import org.scalajs.dom.raw.HTMLBaseElement
import org.scalajs.dom.raw.HTMLElement
import org.scalajs.dom.raw.SVGViewElement
import typingsJapgolly.react.mod.AnchorHTMLAttributes
import typingsJapgolly.react.mod.AreaHTMLAttributes
import typingsJapgolly.react.mod.AudioHTMLAttributes
import typingsJapgolly.react.mod.BaseHTMLAttributes
import typingsJapgolly.react.mod.DetailedHTMLProps
import typingsJapgolly.react.mod.HTMLAttributes
import typingsJapgolly.react.mod.SVGProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait IntrinsicElements extends js.Object {
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
  implicit class IntrinsicElementsOps[Self <: IntrinsicElements] (val x: Self) extends AnyVal {
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
    def setA(value: DetailedHTMLProps[AnchorHTMLAttributes[HTMLAnchorElement], HTMLAnchorElement]): Self = this.set("a", value.asInstanceOf[js.Any])
    @scala.inline
    def setAbbr(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = this.set("abbr", value.asInstanceOf[js.Any])
    @scala.inline
    def setAddress(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = this.set("address", value.asInstanceOf[js.Any])
    @scala.inline
    def setArea(value: DetailedHTMLProps[AreaHTMLAttributes[HTMLAreaElement], HTMLAreaElement]): Self = this.set("area", value.asInstanceOf[js.Any])
    @scala.inline
    def setArticle(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = this.set("article", value.asInstanceOf[js.Any])
    @scala.inline
    def setAside(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = this.set("aside", value.asInstanceOf[js.Any])
    @scala.inline
    def setAudio(value: DetailedHTMLProps[AudioHTMLAttributes[HTMLAudioElement], HTMLAudioElement]): Self = this.set("audio", value.asInstanceOf[js.Any])
    @scala.inline
    def setB(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = this.set("b", value.asInstanceOf[js.Any])
    @scala.inline
    def setBase(value: DetailedHTMLProps[BaseHTMLAttributes[HTMLBaseElement], HTMLBaseElement]): Self = this.set("base", value.asInstanceOf[js.Any])
    @scala.inline
    def setBdi(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = this.set("bdi", value.asInstanceOf[js.Any])
    @scala.inline
    def setBdo(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = this.set("bdo", value.asInstanceOf[js.Any])
    @scala.inline
    def setBig(value: DetailedHTMLProps[HTMLAttributes[HTMLElement], HTMLElement]): Self = this.set("big", value.asInstanceOf[js.Any])
    @scala.inline
    def setView(value: SVGProps[SVGViewElement]): Self = this.set("view", value.asInstanceOf[js.Any])
  }
  
}

