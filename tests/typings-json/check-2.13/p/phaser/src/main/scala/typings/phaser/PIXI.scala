package typings.phaser

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object PIXI {
  
  @js.native
  sealed trait blendModes extends StObject
  @JSGlobal("PIXI.blendModes")
  @js.native
  object blendModes extends StObject {
    
    @js.native
    sealed trait ADD
      extends StObject
         with blendModes
    
    @js.native
    sealed trait NORMAL
      extends StObject
         with blendModes
  }
  
  @js.native
  sealed trait scaleModes extends StObject
  @JSGlobal("PIXI.scaleModes")
  @js.native
  object scaleModes extends StObject {
    
    @js.native
    sealed trait DEFAULT
      extends StObject
         with scaleModes
    
    @js.native
    sealed trait LINEAR
      extends StObject
         with scaleModes
    
    @js.native
    sealed trait NEAREST
      extends StObject
         with scaleModes
  }
}
