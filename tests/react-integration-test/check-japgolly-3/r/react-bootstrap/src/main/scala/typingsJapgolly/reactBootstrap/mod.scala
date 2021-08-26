package typingsJapgolly.reactBootstrap

import typingsJapgolly.reactBootstrap.bootstrapUtilsMod.BSProps
import typingsJapgolly.std.Pick
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("react-bootstrap", "ButtonGroup")
  @js.native
  class ButtonGroup ()
    extends typingsJapgolly.reactBootstrap.libMod.ButtonGroup
  
  @JSImport("react-bootstrap", "ToggleButtonGroup")
  @js.native
  class ToggleButtonGroup ()
    extends typingsJapgolly.reactBootstrap.libMod.ToggleButtonGroup
  
  object utils {
    
    @JSImport("react-bootstrap", "utils")
    @js.native
    val ^ : js.Any = js.native
    
    object bootstrapUtils {
      
      @JSImport("react-bootstrap", "utils.bootstrapUtils")
      @js.native
      val ^ : js.Any = js.native
      
      inline def getBsProps(props: js.Any): BSProps = ^.asInstanceOf[js.Dynamic].applyDynamic("getBsProps")(props.asInstanceOf[js.Any]).asInstanceOf[BSProps]
    }
    
    inline def createChainedFunction(funcs: js.Function*): js.Function = ^.asInstanceOf[js.Dynamic].applyDynamic("createChainedFunction")(funcs.asInstanceOf[js.Any]).asInstanceOf[js.Function]
  }
  
  type Omit[T, K /* <: /* keyof T */ String */] = Pick[
    T, 
    /* import warning: importer.ImportType#apply Failed type conversion: {[ P in keyof T ]: P} & {[ P in K ]: never} & {[x: string] : never, [x: number] : never}[keyof T] */ js.Any
  ]
  
  object Sizes {
    
    inline def large: "large" = "large".asInstanceOf["large"]
    
    inline def lg: "lg" = "lg".asInstanceOf["lg"]
    
    inline def medium: "medium" = "medium".asInstanceOf["medium"]
    
    inline def sm: "sm" = "sm".asInstanceOf["sm"]
    
    inline def small: "small" = "small".asInstanceOf["small"]
    
    inline def xs: "xs" = "xs".asInstanceOf["xs"]
    
    inline def xsmall: "xsmall" = "xsmall".asInstanceOf["xsmall"]
  }
  type Sizes = "xs" | "xsmall" | "sm" | "small" | "medium" | "lg" | "large"
}
