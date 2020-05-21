package typings.std

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait HTMLElementTagNameMap extends js.Object {
  var a: HTMLAnchorElement = js.native
  var abbr: HTMLElement = js.native
  var address: HTMLElement = js.native
  var area: HTMLAreaElement = js.native
  var article: HTMLElement = js.native
  var aside: HTMLElement = js.native
  var audio: HTMLAudioElement = js.native
}

object HTMLElementTagNameMap {
  @scala.inline
  def apply(
    a: HTMLAnchorElement,
    abbr: HTMLElement,
    address: HTMLElement,
    area: HTMLAreaElement,
    article: HTMLElement,
    aside: HTMLElement,
    audio: HTMLAudioElement
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
    def setA(value: HTMLAnchorElement): Self = this.set("a", value.asInstanceOf[js.Any])
    @scala.inline
    def setAbbr(value: HTMLElement): Self = this.set("abbr", value.asInstanceOf[js.Any])
    @scala.inline
    def setAddress(value: HTMLElement): Self = this.set("address", value.asInstanceOf[js.Any])
    @scala.inline
    def setArea(value: HTMLAreaElement): Self = this.set("area", value.asInstanceOf[js.Any])
    @scala.inline
    def setArticle(value: HTMLElement): Self = this.set("article", value.asInstanceOf[js.Any])
    @scala.inline
    def setAside(value: HTMLElement): Self = this.set("aside", value.asInstanceOf[js.Any])
    @scala.inline
    def setAudio(value: HTMLAudioElement): Self = this.set("audio", value.asInstanceOf[js.Any])
  }
  
}

