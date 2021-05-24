package typingsLaminar

import com.raquo.domtypes.generic.Modifier
import com.raquo.domtypes.generic.codecs.StringAsIsCodec
import com.raquo.laminar.api.L
import com.raquo.laminar.api.L.HtmlElement
import com.raquo.laminar.builders.HtmlTag
import com.raquo.laminar.keys.ReactiveHtmlAttr
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom.raw.HTMLElement
import typingsLaminar.mwcButton.mod.Button
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object `mwc-button` {
  
  def apply(mods: ModFunction*): HtmlElement = tag(mods.map((mod: ModFunction) => mod(`mwc-button`)) :_*)
  
  type ModFunction = `mwc-button`.type => Modifier[ReactiveHtmlElement[Ref]]
  
  type Ref = Button with HTMLElement
  
  val accessKey: ReactiveHtmlAttr[String] = L.customHtmlAttr("accessKey", StringAsIsCodec)
  
  val accessKeyLabel: ReactiveHtmlAttr[String] = L.customHtmlAttr("accessKeyLabel", StringAsIsCodec)
  
  val autocapitalize: ReactiveHtmlAttr[String] = L.customHtmlAttr("autocapitalize", StringAsIsCodec)
  
  val dir: ReactiveHtmlAttr[String] = L.customHtmlAttr("dir", StringAsIsCodec)
  
  val icon: ReactiveHtmlAttr[String] = L.customHtmlAttr("icon", StringAsIsCodec)
  
  val innerText: ReactiveHtmlAttr[String] = L.customHtmlAttr("innerText", StringAsIsCodec)
  
  val label: ReactiveHtmlAttr[String] = L.customHtmlAttr("label", StringAsIsCodec)
  
  val lang: ReactiveHtmlAttr[String] = L.customHtmlAttr("lang", StringAsIsCodec)
  
  var tag: HtmlTag[Ref] = L.customHtmlTag("mwc-button")
  
  val title: ReactiveHtmlAttr[String] = L.customHtmlAttr("title", StringAsIsCodec)
}
