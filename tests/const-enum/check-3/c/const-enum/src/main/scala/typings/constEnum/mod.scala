package typings.constEnum

import _root_.typings.constEnum.constEnumDoubles.`4294901760`
import _root_.typings.constEnum.constEnumInts.`0`
import _root_.typings.constEnum.constEnumInts.`16`
import _root_.typings.constEnum.constEnumInts.`1`
import _root_.typings.constEnum.constEnumInts.`22`
import _root_.typings.constEnum.constEnumInts.`65535`
import _root_.typings.constEnum.constEnumInts.`65536`
import _root_.typings.constEnum.constEnumStrings.C
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("const-enum", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  inline def bar(x: Foo_): `22` = ^.asInstanceOf[js.Dynamic].applyDynamic("bar")(x.asInstanceOf[js.Any]).asInstanceOf[`22`]
  
  inline def foo(x: `1` | C): Double = ^.asInstanceOf[js.Dynamic].applyDynamic("foo")(x.asInstanceOf[js.Any]).asInstanceOf[Double]
  
  inline def foo2(x: Foo2_): Double = ^.asInstanceOf[js.Dynamic].applyDynamic("foo2")(x.asInstanceOf[js.Any]).asInstanceOf[Double]
  
  object Foo2_ {
    
    inline def A: `0` = 0.asInstanceOf[`0`]
    
    inline def B: `22` = 22.asInstanceOf[`22`]
    
    inline def C: `1` = (0 + 1).asInstanceOf[`1`]
  }
  type Foo2_ = `0` | `22` | `1`
  
  object Foo_ {
    
    inline def A: `1` = 1.asInstanceOf[`1`]
    
    inline def B: `22` = 22.asInstanceOf[`22`]
    
    inline def C: _root_.typings.constEnum.constEnumStrings.C = "C".asInstanceOf[_root_.typings.constEnum.constEnumStrings.C]
  }
  type Foo_ = `1` | `22` | C
  
  object PreOrderHookFlags {
    
    /** The index of the next pre-order hook to be called in the hooks array, on the first 16
      bits */
    inline def IndexOfTheNextPreOrderHookMaskMask: `65535` = 65535.asInstanceOf[`65535`]
    
    /**
      * The number of init hooks that have already been called, on the last 16 bits
      */
    inline def NumberOfInitHooksCalledIncrementer: `65536` = 65536.asInstanceOf[`65536`]
    
    inline def NumberOfInitHooksCalledMask: `4294901760` = 4294901760d.asInstanceOf[`4294901760`]
    
    inline def NumberOfInitHooksCalledShift: `16` = 16.asInstanceOf[`16`]
  }
  type PreOrderHookFlags = `65535` | `65536` | `16` | `4294901760`
}
