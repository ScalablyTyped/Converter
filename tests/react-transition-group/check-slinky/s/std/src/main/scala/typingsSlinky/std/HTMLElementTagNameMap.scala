package typingsSlinky.std

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait HTMLElementTagNameMap extends js.Object {
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
  implicit class HTMLElementTagNameMapOps[Self <: HTMLElementTagNameMap] (val x: Self) extends AnyVal {
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
    def setA(value: org.scalajs.dom.raw.HTMLAnchorElement): Self = this.set("a", value.asInstanceOf[js.Any])
    @scala.inline
    def setAbbr(value: org.scalajs.dom.raw.HTMLElement): Self = this.set("abbr", value.asInstanceOf[js.Any])
    @scala.inline
    def setAddress(value: org.scalajs.dom.raw.HTMLElement): Self = this.set("address", value.asInstanceOf[js.Any])
    @scala.inline
    def setArea(value: org.scalajs.dom.raw.HTMLAreaElement): Self = this.set("area", value.asInstanceOf[js.Any])
    @scala.inline
    def setArticle(value: org.scalajs.dom.raw.HTMLElement): Self = this.set("article", value.asInstanceOf[js.Any])
    @scala.inline
    def setAside(value: org.scalajs.dom.raw.HTMLElement): Self = this.set("aside", value.asInstanceOf[js.Any])
    @scala.inline
    def setAudio(value: org.scalajs.dom.raw.HTMLAudioElement): Self = this.set("audio", value.asInstanceOf[js.Any])
  }
  
}

