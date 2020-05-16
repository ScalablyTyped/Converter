package typingsJapgolly.std

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
    def withA(value: org.scalajs.dom.raw.HTMLAnchorElement): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("a")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withAbbr(value: org.scalajs.dom.raw.HTMLElement): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("abbr")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withAddress(value: org.scalajs.dom.raw.HTMLElement): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("address")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withArea(value: org.scalajs.dom.raw.HTMLAreaElement): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("area")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withArticle(value: org.scalajs.dom.raw.HTMLElement): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("article")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withAside(value: org.scalajs.dom.raw.HTMLElement): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("aside")(value.asInstanceOf[js.Any])
        ret
    }
    @scala.inline
    def withAudio(value: org.scalajs.dom.raw.HTMLAudioElement): Self = {
        val ret = this.duplicate
        ret.asInstanceOf[js.Dynamic].updateDynamic("audio")(value.asInstanceOf[js.Any])
        ret
    }
  }
  
}

