package typings.react.reactMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("react", "lazy")
@js.native
object `lazy` extends js.Object {
  def apply[T /* <: ComponentType[_] */](
    factory: js.Function0[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Promise<{  default  :T}> */ _
    ]
  ): LazyExoticComponent[T] = js.native
}

