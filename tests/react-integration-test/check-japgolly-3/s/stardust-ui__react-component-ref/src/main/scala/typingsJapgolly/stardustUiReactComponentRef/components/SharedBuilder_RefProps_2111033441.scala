package typingsJapgolly.stardustUiReactComponentRef.components

import japgolly.scalajs.react.Callback
import typingsJapgolly.StBuildingComponent
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@scala.inline
open class SharedBuilder_RefProps_2111033441[R <: js.Object] (val args: js.Array[Any])
  extends AnyVal
     with StBuildingComponent[R] {
  
  inline def innerRef(value: typingsJapgolly.react.mod.Ref[Any]): this.type = set("innerRef", value.asInstanceOf[js.Any])
  
  inline def innerRefFunction1(value: /* instance */ Any | Null => Callback): this.type = set("innerRef", js.Any.fromFunction1((t0: /* instance */ Any | Null) => value(t0).runNow()))
  
  inline def innerRefNull: this.type = set("innerRef", null)
}
