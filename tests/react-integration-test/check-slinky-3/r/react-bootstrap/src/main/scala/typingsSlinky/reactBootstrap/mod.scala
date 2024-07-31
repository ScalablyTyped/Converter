package typingsSlinky.reactBootstrap

import _root_.typingsSlinky.reactBootstrap.libUtilsBootstrapUtilsMod.BSProps
import _root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.large
import _root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.lg
import _root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.medium
import _root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.sm
import _root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.small
import _root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.xs
import _root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.xsmall
import _root_.typingsSlinky.std.Pick
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("react-bootstrap", "ButtonGroup")
  @js.native
  open class ButtonGroup ()
    extends _root_.typingsSlinky.reactBootstrap.libMod.ButtonGroup
  
  @JSImport("react-bootstrap", "ToggleButtonGroup")
  @js.native
  open class ToggleButtonGroup ()
    extends _root_.typingsSlinky.reactBootstrap.libMod.ToggleButtonGroup
  
  object utils {
    
    @JSImport("react-bootstrap", "utils")
    @js.native
    val ^ : js.Any = js.native
    
    object bootstrapUtils {
      
      @JSImport("react-bootstrap", "utils.bootstrapUtils")
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
  
  object Sizes {
    
    inline def large: _root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.large = "large".asInstanceOf[_root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.large]
    
    inline def lg: _root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.lg = "lg".asInstanceOf[_root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.lg]
    
    inline def medium: _root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.medium = "medium".asInstanceOf[_root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.medium]
    
    inline def sm: _root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.sm = "sm".asInstanceOf[_root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.sm]
    
    inline def small: _root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.small = "small".asInstanceOf[_root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.small]
    
    inline def xs: _root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.xs = "xs".asInstanceOf[_root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.xs]
    
    inline def xsmall: _root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.xsmall = "xsmall".asInstanceOf[_root_.typingsSlinky.reactBootstrap.reactBootstrapStrings.xsmall]
  }
  type Sizes = xs | xsmall | sm | small | medium | lg | large
}
