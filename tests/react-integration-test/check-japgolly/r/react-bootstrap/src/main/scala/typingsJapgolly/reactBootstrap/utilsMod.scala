package typingsJapgolly.reactBootstrap

import typingsJapgolly.reactBootstrap.bootstrapUtilsMod.BSProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object utilsMod {
  
  @JSImport("react-bootstrap/lib/utils", "createChainedFunction")
  @js.native
  def createChainedFunction(funcs: js.Function*): js.Function = js.native
  
  object bootstrapUtils {
    
    @JSImport("react-bootstrap/lib/utils", "bootstrapUtils.getBsProps")
    @js.native
    def getBsProps(props: js.Any): BSProps = js.native
  }
}
