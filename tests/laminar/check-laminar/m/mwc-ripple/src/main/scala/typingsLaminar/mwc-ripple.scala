package typingsLaminar

import com.raquo.domtypes.generic.Modifier
import com.raquo.domtypes.generic.codecs.StringAsIsCodec
import com.raquo.laminar.api.L
import com.raquo.laminar.api.L.HtmlElement
import com.raquo.laminar.builders.HtmlTag
import com.raquo.laminar.keys.ReactiveHtmlAttr
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom.raw.HTMLElement
import typingsLaminar.mwcRipple.mod.Ripple
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object `mwc-ripple` {
  
  def apply(mods: ModFunction*): HtmlElement = tag(mods.map((mod: ModFunction) => mod(`mwc-ripple`)) :_*)
  
  type ModFunction = `mwc-ripple`.type => Modifier[ReactiveHtmlElement[Ref]]
  
  type Ref = Ripple with HTMLElement
  
  val accessKey: ReactiveHtmlAttr[String] = L.customHtmlAttr("accessKey", StringAsIsCodec)
  
  val accessKeyLabel: ReactiveHtmlAttr[String] = L.customHtmlAttr("accessKeyLabel", StringAsIsCodec)
  
  val autocapitalize: ReactiveHtmlAttr[String] = L.customHtmlAttr("autocapitalize", StringAsIsCodec)
  
  val dir: ReactiveHtmlAttr[String] = L.customHtmlAttr("dir", StringAsIsCodec)
  
  val fgScale: ReactiveHtmlAttr[String] = L.customHtmlAttr("fgScale", StringAsIsCodec)
  
  val fgSize: ReactiveHtmlAttr[String] = L.customHtmlAttr("fgSize", StringAsIsCodec)
  
  val innerText: ReactiveHtmlAttr[String] = L.customHtmlAttr("innerText", StringAsIsCodec)
  
  val lang: ReactiveHtmlAttr[String] = L.customHtmlAttr("lang", StringAsIsCodec)
  
  val leftPos: ReactiveHtmlAttr[String] = L.customHtmlAttr("leftPos", StringAsIsCodec)
  
  var tag: HtmlTag[Ref] = L.customHtmlTag("mwc-ripple")
  
  val title: ReactiveHtmlAttr[String] = L.customHtmlAttr("title", StringAsIsCodec)
  
  val topPos: ReactiveHtmlAttr[String] = L.customHtmlAttr("topPos", StringAsIsCodec)
  
  val translateEnd: ReactiveHtmlAttr[String] = L.customHtmlAttr("translateEnd", StringAsIsCodec)
  
  val translateStart: ReactiveHtmlAttr[String] = L.customHtmlAttr("translateStart", StringAsIsCodec)
}
