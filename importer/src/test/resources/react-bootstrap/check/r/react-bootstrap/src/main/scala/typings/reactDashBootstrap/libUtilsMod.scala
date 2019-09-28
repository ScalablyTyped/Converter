package typings.reactDashBootstrap

import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.annotation.JSImport.Namespace
import typings.reactDashBootstrap.libUtilsBootstrapUtilsMod.BSProps
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSImport("react-bootstrap/lib/utils", Namespace)
@js.native
object libUtilsMod extends js.Object {
  def createChainedFunction(funcs: js.Function*): js.Function = js.native
  @js.native
  object bootstrapUtils extends js.Object {
    def getBsProps(props: js.Any): BSProps = js.native
  }
  
}

