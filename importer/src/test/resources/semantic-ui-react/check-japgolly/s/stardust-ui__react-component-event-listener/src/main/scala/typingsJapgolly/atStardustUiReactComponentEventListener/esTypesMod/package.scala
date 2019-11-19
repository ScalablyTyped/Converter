package typingsJapgolly.atStardustUiReactComponentEventListener

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object esTypesMod {
  import typingsJapgolly.react.reactMod.RefObject

  type EventHandler[T /* <: EventTypes */] = js.Function1[
    /* import warning: importer.ImportType#apply Failed type conversion: / * import warning: QualifyReferences.resolveTypeRef many Couldn't qualify DocumentEventMap * / any[T] */ /* e */ js.Any, 
    Unit
  ]
  type EventTypes = String
  type TargetRef = RefObject[
    /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Node */ js.Any
  ]
}
