package typingsJapgolly.react

import japgolly.scalajs.react.facade.React.Node
import japgolly.scalajs.react.vdom.VdomNode
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  trait Children extends StObject {
    
    var children: js.UndefOr[Node] = js.undefined
  }
  object Children {
    
    inline def apply(children: js.UndefOr[Null | VdomNode] = js.undefined): Children = {
      val __obj = js.Dynamic.literal()
      if (!js.isUndefined(children)) __obj.updateDynamic("children")(if (children != null) children.asInstanceOf[VdomNode].rawNode.asInstanceOf[js.Any] else null)
      __obj.asInstanceOf[Children]
    }
  }
  
  trait Html extends StObject {
    
    var __html: String
  }
  object Html {
    
    inline def apply(__html: String): Html = {
      val __obj = js.Dynamic.literal(__html = __html.asInstanceOf[js.Any])
      __obj.asInstanceOf[Html]
    }
  }
}
