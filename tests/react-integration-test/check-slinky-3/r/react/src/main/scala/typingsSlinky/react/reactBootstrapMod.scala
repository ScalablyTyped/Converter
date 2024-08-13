package typingsSlinky.react

import typingsSlinky.react.reactBootstrapLibUtilsBootstrapUtilsMod.BSProps
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object reactBootstrapMod {
  
  @JSImport("react/react-bootstrap", "ButtonGroup")
  @js.native
  open class ButtonGroup ()
    extends typingsSlinky.react.reactBootstrapLibMod.ButtonGroup
  
  @JSImport("react/react-bootstrap", "ToggleButtonGroup")
  @js.native
  open class ToggleButtonGroup ()
    extends typingsSlinky.react.reactBootstrapLibMod.ToggleButtonGroup
  
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
    - typingsSlinky.react.reactStrings.xs
    - typingsSlinky.react.reactStrings.xsmall
    - typingsSlinky.react.reactStrings.sm
    - typingsSlinky.react.reactStrings.small
    - typingsSlinky.react.reactStrings.medium
    - typingsSlinky.react.reactStrings.lg
    - typingsSlinky.react.reactStrings.large
  */
  trait Sizes extends StObject
  object Sizes {
    
    inline def large: typingsSlinky.react.reactStrings.large = "large".asInstanceOf[typingsSlinky.react.reactStrings.large]
    
    inline def lg: typingsSlinky.react.reactStrings.lg = "lg".asInstanceOf[typingsSlinky.react.reactStrings.lg]
    
    inline def medium: typingsSlinky.react.reactStrings.medium = "medium".asInstanceOf[typingsSlinky.react.reactStrings.medium]
    
    inline def sm: typingsSlinky.react.reactStrings.sm = "sm".asInstanceOf[typingsSlinky.react.reactStrings.sm]
    
    inline def small: typingsSlinky.react.reactStrings.small = "small".asInstanceOf[typingsSlinky.react.reactStrings.small]
    
    inline def xs: typingsSlinky.react.reactStrings.xs = "xs".asInstanceOf[typingsSlinky.react.reactStrings.xs]
    
    inline def xsmall: typingsSlinky.react.reactStrings.xsmall = "xsmall".asInstanceOf[typingsSlinky.react.reactStrings.xsmall]
  }
}
