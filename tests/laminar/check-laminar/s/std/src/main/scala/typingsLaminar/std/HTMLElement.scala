package typingsLaminar.std

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait HTMLElement extends Element {
  
  var accessKey: String = js.native
  
  val accessKeyLabel: String = js.native
  
  var autocapitalize: String = js.native
  
  def click(): Unit = js.native
  
  var dir: String = js.native
  
  var draggable: Boolean = js.native
  
  var hidden: Boolean = js.native
  
  var innerText: String = js.native
  
  var lang: String = js.native
  
  val offsetHeight: Double = js.native
  
  val offsetLeft: Double = js.native
  
  val offsetParent: org.scalajs.dom.raw.Element | Null = js.native
  
  val offsetTop: Double = js.native
  
  val offsetWidth: Double = js.native
  
  var spellcheck: Boolean = js.native
  
  var title: String = js.native
  
  var translate: Boolean = js.native
}
object HTMLElement {
  
  @scala.inline
  def apply(
    accessKey: String,
    accessKeyLabel: String,
    autocapitalize: String,
    click: () => Unit,
    dir: String,
    draggable: Boolean,
    hidden: Boolean,
    innerText: String,
    lang: String,
    offsetHeight: Double,
    offsetLeft: Double,
    offsetTop: Double,
    offsetWidth: Double,
    spellcheck: Boolean,
    title: String,
    translate: Boolean
  ): org.scalajs.dom.raw.HTMLElement = {
    val __obj = js.Dynamic.literal(accessKey = accessKey.asInstanceOf[js.Any], accessKeyLabel = accessKeyLabel.asInstanceOf[js.Any], autocapitalize = autocapitalize.asInstanceOf[js.Any], click = js.Any.fromFunction0(click), dir = dir.asInstanceOf[js.Any], draggable = draggable.asInstanceOf[js.Any], hidden = hidden.asInstanceOf[js.Any], innerText = innerText.asInstanceOf[js.Any], lang = lang.asInstanceOf[js.Any], offsetHeight = offsetHeight.asInstanceOf[js.Any], offsetLeft = offsetLeft.asInstanceOf[js.Any], offsetTop = offsetTop.asInstanceOf[js.Any], offsetWidth = offsetWidth.asInstanceOf[js.Any], spellcheck = spellcheck.asInstanceOf[js.Any], title = title.asInstanceOf[js.Any], translate = translate.asInstanceOf[js.Any], offsetParent = null)
    __obj.asInstanceOf[org.scalajs.dom.raw.HTMLElement]
  }
  
  @scala.inline
  implicit class HTMLElementMutableBuilder[Self <: org.scalajs.dom.raw.HTMLElement] (val x: Self) extends AnyVal {
    
    @scala.inline
    def setAccessKey(value: String): Self = StObject.set(x, "accessKey", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setAccessKeyLabel(value: String): Self = StObject.set(x, "accessKeyLabel", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setAutocapitalize(value: String): Self = StObject.set(x, "autocapitalize", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setClick(value: () => Unit): Self = StObject.set(x, "click", js.Any.fromFunction0(value))
    
    @scala.inline
    def setDir(value: String): Self = StObject.set(x, "dir", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setDraggable(value: Boolean): Self = StObject.set(x, "draggable", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setHidden(value: Boolean): Self = StObject.set(x, "hidden", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setInnerText(value: String): Self = StObject.set(x, "innerText", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setLang(value: String): Self = StObject.set(x, "lang", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setOffsetHeight(value: Double): Self = StObject.set(x, "offsetHeight", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setOffsetLeft(value: Double): Self = StObject.set(x, "offsetLeft", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setOffsetParent(value: org.scalajs.dom.raw.Element): Self = StObject.set(x, "offsetParent", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setOffsetParentNull: Self = StObject.set(x, "offsetParent", null)
    
    @scala.inline
    def setOffsetTop(value: Double): Self = StObject.set(x, "offsetTop", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setOffsetWidth(value: Double): Self = StObject.set(x, "offsetWidth", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setSpellcheck(value: Boolean): Self = StObject.set(x, "spellcheck", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setTitle(value: String): Self = StObject.set(x, "title", value.asInstanceOf[js.Any])
    
    @scala.inline
    def setTranslate(value: Boolean): Self = StObject.set(x, "translate", value.asInstanceOf[js.Any])
  }
}
