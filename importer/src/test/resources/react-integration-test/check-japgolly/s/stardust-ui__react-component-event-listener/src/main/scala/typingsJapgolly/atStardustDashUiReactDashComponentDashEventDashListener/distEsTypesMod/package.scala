package typingsJapgolly.atStardustDashUiReactDashComponentDashEventDashListener

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object distEsTypesMod {
  import japgolly.scalajs.react.raw.React.RefHandle

  type EventHandler[T /* <: EventTypes */] = js.Function1[
    /* import warning: importer.ImportType#apply Failed type conversion: / * import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify DocumentEventMap * / any[T] */ /* e */ js.Any, 
    Unit
  ]
  type EventTypes = String
  type TargetRef = RefHandle[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Node */ js.Any
  ]
}
