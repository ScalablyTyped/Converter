package typings.bigint

import _root_.typings.bigint.BigInt.IRandom
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object global {
  
  object BigInt {
    
    @JSGlobal("BigInt")
    @js.native
    val ^ : js.Any = js.native
    
    inline def add(x: _root_.typings.bigint.BigInt.BigInt, y: _root_.typings.bigint.BigInt.BigInt): _root_.typings.bigint.BigInt.BigInt = (^.asInstanceOf[js.Dynamic].applyDynamic("add")(x.asInstanceOf[js.Any], y.asInstanceOf[js.Any])).asInstanceOf[_root_.typings.bigint.BigInt.BigInt]
    
    inline def setRandom(random: IRandom): Unit = ^.asInstanceOf[js.Dynamic].applyDynamic("setRandom")(random.asInstanceOf[js.Any]).asInstanceOf[Unit]
  }
}
