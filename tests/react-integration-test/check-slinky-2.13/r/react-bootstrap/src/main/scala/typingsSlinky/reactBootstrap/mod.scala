package typingsSlinky.reactBootstrap

import typingsSlinky.reactBootstrap.bootstrapUtilsMod.BSProps
import typingsSlinky.std.Pick
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("react-bootstrap", "ButtonGroup")
  @js.native
  class ButtonGroup ()
    extends typingsSlinky.reactBootstrap.libMod.ButtonGroup
  
  @JSImport("react-bootstrap", "ToggleButtonGroup")
  @js.native
  class ToggleButtonGroup ()
    extends typingsSlinky.reactBootstrap.libMod.ToggleButtonGroup
  
  object utils {
    
    @JSImport("react-bootstrap", "utils")
    @js.native
    val ^ : js.Any = js.native
    
    object bootstrapUtils {
      
      @JSImport("react-bootstrap", "utils.bootstrapUtils")
      @js.native
      val ^ : js.Any = js.native
      
      @scala.inline
      def getBsProps(props: js.Any): BSProps = ^.asInstanceOf[js.Dynamic].applyDynamic("getBsProps")(props.asInstanceOf[js.Any]).asInstanceOf[BSProps]
    }
    
    @scala.inline
    def createChainedFunction(funcs: js.Function*): js.Function = ^.asInstanceOf[js.Dynamic].applyDynamic("createChainedFunction")(funcs.asInstanceOf[js.Any]).asInstanceOf[js.Function]
  }
  
  type Omit[T, K /* <: /* keyof T */ String */] = Pick[
    T, 
    /* import warning: importer.ImportType#apply Failed type conversion: {[ P in keyof T ]: P} & {[ P in K ]: never} & {[x: string] : never, [x: number] : never}[keyof T] */ js.Any
  ]
  
  /* Rewritten from type alias, can be one of: 
    - typingsSlinky.reactBootstrap.reactBootstrapStrings.xs
    - typingsSlinky.reactBootstrap.reactBootstrapStrings.xsmall
    - typingsSlinky.reactBootstrap.reactBootstrapStrings.sm
    - typingsSlinky.reactBootstrap.reactBootstrapStrings.small
    - typingsSlinky.reactBootstrap.reactBootstrapStrings.medium
    - typingsSlinky.reactBootstrap.reactBootstrapStrings.lg
    - typingsSlinky.reactBootstrap.reactBootstrapStrings.large
  */
  trait Sizes extends StObject
  object Sizes {
    
    @scala.inline
    def large: typingsSlinky.reactBootstrap.reactBootstrapStrings.large = "large".asInstanceOf[typingsSlinky.reactBootstrap.reactBootstrapStrings.large]
    
    @scala.inline
    def lg: typingsSlinky.reactBootstrap.reactBootstrapStrings.lg = "lg".asInstanceOf[typingsSlinky.reactBootstrap.reactBootstrapStrings.lg]
    
    @scala.inline
    def medium: typingsSlinky.reactBootstrap.reactBootstrapStrings.medium = "medium".asInstanceOf[typingsSlinky.reactBootstrap.reactBootstrapStrings.medium]
    
    @scala.inline
    def sm: typingsSlinky.reactBootstrap.reactBootstrapStrings.sm = "sm".asInstanceOf[typingsSlinky.reactBootstrap.reactBootstrapStrings.sm]
    
    @scala.inline
    def small: typingsSlinky.reactBootstrap.reactBootstrapStrings.small = "small".asInstanceOf[typingsSlinky.reactBootstrap.reactBootstrapStrings.small]
    
    @scala.inline
    def xs: typingsSlinky.reactBootstrap.reactBootstrapStrings.xs = "xs".asInstanceOf[typingsSlinky.reactBootstrap.reactBootstrapStrings.xs]
    
    @scala.inline
    def xsmall: typingsSlinky.reactBootstrap.reactBootstrapStrings.xsmall = "xsmall".asInstanceOf[typingsSlinky.reactBootstrap.reactBootstrapStrings.xsmall]
  }
}
