package typingsJapgolly.react.mod

import org.scalablytyped.runtime.Instantiable1
import org.scalablytyped.runtime.Instantiable2
import typingsJapgolly.std.Partial
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait ComponentClass[P, S]
  extends StObject
     with StaticLifecycle[P, S]
     with Instantiable1[
      /* props */ P, 
      japgolly.scalajs.react.raw.React.Component[P & js.Object, js.Object]
    ]
     with Instantiable2[
      /* props */ P, 
      /* context */ js.Any, 
      japgolly.scalajs.react.raw.React.Component[P & js.Object, js.Object]
    ] {
  
  var childContextTypes: js.UndefOr[ValidationMap[js.Any]] = js.native
  
  var contextType: js.UndefOr[Context[js.Any]] = js.native
  
  var contextTypes: js.UndefOr[ValidationMap[js.Any]] = js.native
  
  var defaultProps: js.UndefOr[Partial[P]] = js.native
  
  var displayName: js.UndefOr[String] = js.native
  
  var propTypes: js.UndefOr[WeakValidationMap[P]] = js.native
}
