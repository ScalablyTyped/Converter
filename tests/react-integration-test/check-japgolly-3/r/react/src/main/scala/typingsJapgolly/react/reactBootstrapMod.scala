package typingsJapgolly.react

import typingsJapgolly.react.reactBootstrapLibUtilsBootstrapUtilsMod.BSProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object reactBootstrapMod {
  
  @JSImport("react/react-bootstrap", "ButtonGroup")
  @js.native
  open class ButtonGroup ()
    extends typingsJapgolly.react.reactBootstrapLibMod.ButtonGroup
  
  @JSImport("react/react-bootstrap", "ToggleButtonGroup")
  @js.native
  open class ToggleButtonGroup ()
    extends typingsJapgolly.react.reactBootstrapLibMod.ToggleButtonGroup
  
  object utils {
    
    @JSImport("react/react-bootstrap", "utils")
    @js.native
    val ^ : js.Any = js.native
    
    object bootstrapUtils {
      
      @JSImport("react/react-bootstrap", "utils.bootstrapUtils")
      @js.native
      val ^ : js.Any = js.native
      
      inline def getBsProps(props: Any): BSProps = ^.asInstanceOf[js.Dynamic].applyDynamic("getBsProps")(props.asInstanceOf[js.Any]).asInstanceOf[BSProps]
    }
    
    inline def createChainedFunction(funcs: js.Function*): js.Function = ^.asInstanceOf[js.Dynamic].applyDynamic("createChainedFunction")(funcs.asInstanceOf[Seq[js.Any]]*).asInstanceOf[js.Function]
  }
  
  type Omit[T, K /* <: /* keyof T */ String */] = Pick[
    T, 
    /* import warning: importer.ImportType#apply Failed type conversion: {[ P in keyof T ]: P} & {[ P in K ]: never} & {[x: string] : never, [x: number] : never}[keyof T] */ js.Any
  ]
  
  /* Rewritten from type alias, can be one of: 
    - typingsJapgolly.react.reactStrings.xs
    - typingsJapgolly.react.reactStrings.xsmall
    - typingsJapgolly.react.reactStrings.sm
    - typingsJapgolly.react.reactStrings.small
    - typingsJapgolly.react.reactStrings.medium
    - typingsJapgolly.react.reactStrings.lg
    - typingsJapgolly.react.reactStrings.large
  */
  trait Sizes extends StObject
  object Sizes {
    
    inline def large: typingsJapgolly.react.reactStrings.large = "large".asInstanceOf[typingsJapgolly.react.reactStrings.large]
    
    inline def lg: typingsJapgolly.react.reactStrings.lg = "lg".asInstanceOf[typingsJapgolly.react.reactStrings.lg]
    
    inline def medium: typingsJapgolly.react.reactStrings.medium = "medium".asInstanceOf[typingsJapgolly.react.reactStrings.medium]
    
    inline def sm: typingsJapgolly.react.reactStrings.sm = "sm".asInstanceOf[typingsJapgolly.react.reactStrings.sm]
    
    inline def small: typingsJapgolly.react.reactStrings.small = "small".asInstanceOf[typingsJapgolly.react.reactStrings.small]
    
    inline def xs: typingsJapgolly.react.reactStrings.xs = "xs".asInstanceOf[typingsJapgolly.react.reactStrings.xs]
    
    inline def xsmall: typingsJapgolly.react.reactStrings.xsmall = "xsmall".asInstanceOf[typingsJapgolly.react.reactStrings.xsmall]
  }
}
