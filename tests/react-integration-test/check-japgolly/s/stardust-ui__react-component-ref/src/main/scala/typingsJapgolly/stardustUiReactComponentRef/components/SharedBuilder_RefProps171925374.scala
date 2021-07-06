package typingsJapgolly.stardustUiReactComponentRef.components

import japgolly.scalajs.react.Callback
import typingsJapgolly.StBuildingComponent
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@scala.inline
class SharedBuilder_RefProps171925374[R <: js.Object] (val args: js.Array[js.Any])
  extends AnyVal
     with StBuildingComponent[R] {
  
  @scala.inline
  def innerRef(value: typingsJapgolly.react.mod.Ref[js.Any]): this.type = set("innerRef", value.asInstanceOf[js.Any])
  
  @scala.inline
  def innerRefFunction1(value: /* instance */ js.Any | Null => Callback): this.type = set("innerRef", js.Any.fromFunction1((t0: /* instance */ js.Any | Null) => value(t0).runNow()))
  
  @scala.inline
  def innerRefNull: this.type = set("innerRef", null)
}
