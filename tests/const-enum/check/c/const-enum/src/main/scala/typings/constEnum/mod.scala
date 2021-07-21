package typings.constEnum

import typings.constEnum.constEnumNumbers._4294901760
import typings.constEnum.constEnumNumbers.`0`
import typings.constEnum.constEnumNumbers.`16`
import typings.constEnum.constEnumNumbers.`1`
import typings.constEnum.constEnumNumbers.`22`
import typings.constEnum.constEnumNumbers.`65535`
import typings.constEnum.constEnumNumbers.`65536`
import typings.constEnum.constEnumStrings.C
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("const-enum", JSImport.Namespace)
  @js.native
  val ^ : js.Any = js.native
  
  inline def bar(x: Foo_): `22` = ^.asInstanceOf[js.Dynamic].applyDynamic("bar")(x.asInstanceOf[js.Any]).asInstanceOf[`22`]
  
  inline def foo2(x: Foo2_): Double = ^.asInstanceOf[js.Dynamic].applyDynamic("foo2")(x.asInstanceOf[js.Any]).asInstanceOf[Double]
  
  inline def foo_1(x: `1`): Double = ^.asInstanceOf[js.Dynamic].applyDynamic("foo")(x.asInstanceOf[js.Any]).asInstanceOf[Double]
  
  inline def foo_C(x: C): Double = ^.asInstanceOf[js.Dynamic].applyDynamic("foo")(x.asInstanceOf[js.Any]).asInstanceOf[Double]
  
  /* Rewritten from type alias, can be one of: 
    - typings.constEnum.constEnumNumbers.`0`
    - typings.constEnum.constEnumNumbers.`22`
    - typings.constEnum.constEnumNumbers.`1`
  */
  trait Foo2_ extends StObject
  object Foo2_ {
    
    inline def A: `0` = 0.asInstanceOf[`0`]
    
    inline def B: `22` = 22.asInstanceOf[`22`]
    
    inline def C: `1` = (0 + 1).asInstanceOf[`1`]
  }
  
  /* Rewritten from type alias, can be one of: 
    - typings.constEnum.constEnumNumbers.`1`
    - typings.constEnum.constEnumNumbers.`22`
    - typings.constEnum.constEnumStrings.C
  */
  trait Foo_ extends StObject
  object Foo_ {
    
    inline def A: `1` = 1.asInstanceOf[`1`]
    
    inline def B: `22` = 22.asInstanceOf[`22`]
    
    inline def C: typings.constEnum.constEnumStrings.C = "C".asInstanceOf[typings.constEnum.constEnumStrings.C]
  }
  
  /* Rewritten from type alias, can be one of: 
    - typings.constEnum.constEnumNumbers.`65535`
    - typings.constEnum.constEnumNumbers.`65536`
    - typings.constEnum.constEnumNumbers.`16`
    - typings.constEnum.constEnumNumbers._4294901760
  */
  trait PreOrderHookFlags extends StObject
  object PreOrderHookFlags {
    
    /** The index of the next pre-order hook to be called in the hooks array, on the first 16
      bits */
    inline def IndexOfTheNextPreOrderHookMaskMask: `65535` = 65535.asInstanceOf[`65535`]
    
    /**
      * The number of init hooks that have already been called, on the last 16 bits
      */
    inline def NumberOfInitHooksCalledIncrementer: `65536` = 65536.asInstanceOf[`65536`]
    
    inline def NumberOfInitHooksCalledMask: _4294901760 = 4294901760.0.asInstanceOf[_4294901760]
    
    inline def NumberOfInitHooksCalledShift: `16` = 16.asInstanceOf[`16`]
  }
}
