package typings.electron

import _root_.typings.electron.electronStrings.Bar
import _root_.typings.electron.electronStrings.bar_
import _root_.typings.node.NodeJS.EventEmitter
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object NodeJS {
  
  @js.native
  trait Process
    extends StObject
       with EventEmitter {
    
    var foo: bar_ | Bar = js.native
  }
}
