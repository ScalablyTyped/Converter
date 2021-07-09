package typings.bigint

import typings.bigint.BigInt.IRandom
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  object BigInt {
    
    @JSGlobal("BigInt")
    @js.native
    val ^ : js.Any = js.native
    
    @scala.inline
    def add(x: typings.bigint.BigInt.BigInt, y: typings.bigint.BigInt.BigInt): typings.bigint.BigInt.BigInt = (^.asInstanceOf[js.Dynamic].applyDynamic("add")(x.asInstanceOf[js.Any], y.asInstanceOf[js.Any])).asInstanceOf[typings.bigint.BigInt.BigInt]
    
    @scala.inline
    def setRandom(random: IRandom): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("setRandom")(random.asInstanceOf[js.Any]).asInstanceOf[Unit]
  }
}
