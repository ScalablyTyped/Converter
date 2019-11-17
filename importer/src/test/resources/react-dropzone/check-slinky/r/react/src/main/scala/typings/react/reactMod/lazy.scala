package typings.react.reactMod

import slinky.core.ReactComponentClass
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("react", "lazy")
@js.native
object `lazy` extends js.Object {
  def apply[T /* <: ReactComponentClass[_] */](
    factory: js.Function0[
      /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Promise<{  default  :T}> */ _
    ]
  ): ReactComponentClass[T] = js.native
}

