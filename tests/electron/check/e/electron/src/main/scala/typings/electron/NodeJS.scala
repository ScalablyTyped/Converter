package typings.electron

import typings.electron.electronStrings.Bar
import typings.electron.electronStrings.bar_
import typings.node.NodeJS.EventEmitter
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object NodeJS {
  
  @js.native
  trait Process extends EventEmitter {
    
    var foo: bar_ | Bar = js.native
  }
}
