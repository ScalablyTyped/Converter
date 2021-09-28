package typingsSlinky.stardustUiReactComponentRef.components

import slinky.core.facade.ReactRef
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@scala.inline
open class SharedBuilder_RefProps1237054395[R <: js.Object] (val args: js.Array[Any])
  extends AnyVal
     with StBuildingComponent[tag.type, R] {
  
  inline def innerRef(value: typingsSlinky.react.mod.Ref[Any]): this.type = set("innerRef", value.asInstanceOf[js.Any])
  
  inline def innerRefFunction1(value: /* instance */ Any | Null => Unit): this.type = set("innerRef", js.Any.fromFunction1(value))
  
  inline def innerRefNull: this.type = set("innerRef", null)
  
  inline def innerRefReactRef(value: ReactRef[Any]): this.type = set("innerRef", value.asInstanceOf[js.Any])
}
