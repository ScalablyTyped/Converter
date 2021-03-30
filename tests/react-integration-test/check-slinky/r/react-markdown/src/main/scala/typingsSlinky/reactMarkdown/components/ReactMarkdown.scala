package typingsSlinky.reactMarkdown.components

import slinky.core.facade.ReactElement
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.reactMarkdown.mod.LinkTargetResolver
import typingsSlinky.reactMarkdown.mod.ReactMarkdownProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object ReactMarkdown {
  
  @JSImport("react-markdown", JSImport.Namespace)
  @js.native
  val component: js.Object = js.native
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[tag.type, js.Object] {
    
    @scala.inline
    def allowNode(value: /* index */ Double => Boolean): this.type = set("allowNode", js.Any.fromFunction1(value))
    
    @scala.inline
    def className(value: String): this.type = set("className", value.asInstanceOf[js.Any])
    
    @scala.inline
    def linkTarget(value: String | LinkTargetResolver): this.type = set("linkTarget", value.asInstanceOf[js.Any])
    
    @scala.inline
    def linkTargetFunction3(value: (/* uri */ String, /* text */ String, /* title */ js.UndefOr[String]) => String): this.type = set("linkTarget", js.Any.fromFunction3(value))
    
    @scala.inline
    def transformLinkUri(
      value: (/* uri */ String, /* children */ js.UndefOr[ReactElement], /* title */ js.UndefOr[String]) => String
    ): this.type = set("transformLinkUri", js.Any.fromFunction3(value))
    
    @scala.inline
    def transformLinkUriNull: this.type = set("transformLinkUri", null)
  }
  
  implicit def make(companion: ReactMarkdown.type): Builder = new Builder(js.Array(this.component, js.Dictionary.empty))()
  
  def withProps(p: ReactMarkdownProps): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
}
