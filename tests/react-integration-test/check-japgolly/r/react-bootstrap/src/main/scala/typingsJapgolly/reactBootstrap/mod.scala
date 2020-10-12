package typingsJapgolly.reactBootstrap

import typingsJapgolly.reactBootstrap.bootstrapUtilsMod.BSProps
import typingsJapgolly.std.Pick
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("react-bootstrap", "ButtonGroup")
  @js.native
  class ButtonGroup ()
    extends typingsJapgolly.reactBootstrap.libMod.ButtonGroup
  
  /* Rewritten from type alias, can be one of: 
    - typingsJapgolly.reactBootstrap.reactBootstrapStrings.xs
    - typingsJapgolly.reactBootstrap.reactBootstrapStrings.xsmall
    - typingsJapgolly.reactBootstrap.reactBootstrapStrings.sm
    - typingsJapgolly.reactBootstrap.reactBootstrapStrings.small
    - typingsJapgolly.reactBootstrap.reactBootstrapStrings.medium
    - typingsJapgolly.reactBootstrap.reactBootstrapStrings.lg
    - typingsJapgolly.reactBootstrap.reactBootstrapStrings.large
  */
  trait Sizes extends js.Object
  object Sizes {
    
    @scala.inline
    def large: typingsJapgolly.reactBootstrap.reactBootstrapStrings.large = "large".asInstanceOf[typingsJapgolly.reactBootstrap.reactBootstrapStrings.large]
    
    @scala.inline
    def lg: typingsJapgolly.reactBootstrap.reactBootstrapStrings.lg = "lg".asInstanceOf[typingsJapgolly.reactBootstrap.reactBootstrapStrings.lg]
    
    @scala.inline
    def medium: typingsJapgolly.reactBootstrap.reactBootstrapStrings.medium = "medium".asInstanceOf[typingsJapgolly.reactBootstrap.reactBootstrapStrings.medium]
    
    @scala.inline
    def sm: typingsJapgolly.reactBootstrap.reactBootstrapStrings.sm = "sm".asInstanceOf[typingsJapgolly.reactBootstrap.reactBootstrapStrings.sm]
    
    @scala.inline
    def small: typingsJapgolly.reactBootstrap.reactBootstrapStrings.small = "small".asInstanceOf[typingsJapgolly.reactBootstrap.reactBootstrapStrings.small]
    
    @scala.inline
    def xs: typingsJapgolly.reactBootstrap.reactBootstrapStrings.xs = "xs".asInstanceOf[typingsJapgolly.reactBootstrap.reactBootstrapStrings.xs]
    
    @scala.inline
    def xsmall: typingsJapgolly.reactBootstrap.reactBootstrapStrings.xsmall = "xsmall".asInstanceOf[typingsJapgolly.reactBootstrap.reactBootstrapStrings.xsmall]
  }
  
  @JSImport("react-bootstrap", "ToggleButtonGroup")
  @js.native
  class ToggleButtonGroup ()
    extends typingsJapgolly.reactBootstrap.libMod.ToggleButtonGroup
  
  object utils {
    
    @JSImport("react-bootstrap", "utils.createChainedFunction")
    @js.native
    def createChainedFunction(funcs: js.Function*): js.Function = js.native
    
    object bootstrapUtils {
      
      @JSImport("react-bootstrap", "utils.bootstrapUtils.getBsProps")
      @js.native
      def getBsProps(props: js.Any): BSProps = js.native
    }
  }
  
  type Omit[T, K /* <: /* keyof T */ String */] = Pick[
    T, 
    /* import warning: importer.ImportType#apply Failed type conversion: {[ P in keyof T ]: P} & {[ P in K ]: never} & {[x: string] : never, [x: number] : never}[keyof T] */ js.Any
  ]
}
