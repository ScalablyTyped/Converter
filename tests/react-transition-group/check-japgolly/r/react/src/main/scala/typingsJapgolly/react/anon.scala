package typingsJapgolly.react

import japgolly.scalajs.react.raw.React.Node
import japgolly.scalajs.react.vdom.VdomNode
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  @js.native
  trait Children extends js.Object {
    
    var children: js.UndefOr[Node] = js.native
  }
  object Children {
    
    @scala.inline
    def apply(children: VdomNode = null): Children = {
      val __obj = js.Dynamic.literal()
      if (children != null) __obj.updateDynamic("children")(children.rawNode.asInstanceOf[js.Any])
      __obj.asInstanceOf[Children]
    }
  }
  
  @js.native
  trait Html extends js.Object {
    
    var __html: String = js.native
  }
  object Html {
    
    @scala.inline
    def apply(__html: String): Html = {
      val __obj = js.Dynamic.literal(__html = __html.asInstanceOf[js.Any])
      __obj.asInstanceOf[Html]
    }
  }
}
