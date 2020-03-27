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
}

