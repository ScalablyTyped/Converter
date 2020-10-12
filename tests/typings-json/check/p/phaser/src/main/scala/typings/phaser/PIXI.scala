package typings.phaser

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object PIXI {
  
  @js.native
  sealed trait blendModes extends js.Object
  @JSGlobal("PIXI.blendModes")
  @js.native
  object blendModes extends js.Object {
    
    @js.native
    sealed trait ADD extends blendModes
    
    @js.native
    sealed trait NORMAL extends blendModes
  }
  
  @js.native
  sealed trait scaleModes extends js.Object
  @JSGlobal("PIXI.scaleModes")
  @js.native
  object scaleModes extends js.Object {
    
    @js.native
    sealed trait DEFAULT extends scaleModes
    
    @js.native
    sealed trait LINEAR extends scaleModes
    
    @js.native
    sealed trait NEAREST extends scaleModes
  }
}
