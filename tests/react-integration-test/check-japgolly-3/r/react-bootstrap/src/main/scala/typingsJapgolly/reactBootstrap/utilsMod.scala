package typingsJapgolly.reactBootstrap

import typingsJapgolly.reactBootstrap.bootstrapUtilsMod.BSProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object utilsMod {
  
  @JSImport("react-bootstrap/lib/utils", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  object bootstrapUtils {
    
    @JSImport("react-bootstrap/lib/utils", "bootstrapUtils")
    @js.native
    val ^ : js.Any = js.native
    
    @scala.inline
    def getBsProps(props: js.Any): BSProps = ^.asInstanceOf[js.Dynamic].applyDynamic("getBsProps")(props.asInstanceOf[js.Any]).asInstanceOf[BSProps]
  }
  
  @scala.inline
  def createChainedFunction(funcs: js.Function*): js.Function = ^.asInstanceOf[js.Dynamic].applyDynamic("createChainedFunction")(funcs.asInstanceOf[js.Any]).asInstanceOf[js.Function]
}
