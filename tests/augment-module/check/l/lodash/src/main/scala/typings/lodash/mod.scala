package typings.lodash

import typings.std.ArrayLike
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object mod {
  
  @JSImport("lodash", JSImport.Namespace)
  @js.native
  val ^ : LoDashStatic = js.native
  
  /* Syntax to write `mod` instead of `mod.^` */
  @scala.inline
  implicit def __is(ignored: mod.type): LoDashStatic = typings.lodash.mod.^
  
  @js.native
  trait CurriedFunction1[T1, R] extends js.Object {
    
    def apply(): CurriedFunction1[T1, R] = js.native
    def apply(t1: T1): R = js.native
  }
  
  @js.native
  trait CurriedFunction2[T1, T2, R] extends js.Object {
    
    def apply(): CurriedFunction2[T1, T2, R] = js.native
    def apply(t1: T1): CurriedFunction1[T2, R] = js.native
    def apply(t1: T1, t2: T2): R = js.native
  }
  
  // tslint:disable-next-line no-empty-interface (This will be augmented)
  // add
  // assign
  @js.native
  trait LoDashStatic extends js.Object {
    
    /**
      * Adds two numbers.
      *
      * @param augend The first number to add.
      * @param addend The second number to add.
      * @return Returns the sum.
      */
    def add(augend: Double, addend: Double): Double = js.native
    
    /**
      * @see _.at
      */
    def at[T /* <: js.Object */](`object`: T, props: (Many[/* keyof T */ String])*): js.Array[
        /* import warning: importer.ImportType#apply Failed type conversion: T[keyof T] */ js.Any
      ] = js.native
    def at[T /* <: js.Object */](`object`: js.UndefOr[scala.Nothing], props: (Many[/* keyof T */ String])*): js.Array[
        /* import warning: importer.ImportType#apply Failed type conversion: T[keyof T] */ js.Any
      ] = js.native
    def at[T /* <: js.Object */](`object`: Null, props: (Many[/* keyof T */ String])*): js.Array[
        /* import warning: importer.ImportType#apply Failed type conversion: T[keyof T] */ js.Any
      ] = js.native
    /**
      * Creates an array of elements corresponding to the given keys, or indexes, of collection. Keys may be
      * specified as individual arguments or as arrays of keys.
      *
      * @param object The object to iterate over.
      * @param props The property names or indexes of elements to pick, specified individually or in arrays.
      * @return Returns the new array of picked elements.
      */
    def at[T](`object`: List[T], props: PropertyPath*): js.Array[T] = js.native
    @JSName("at")
    def at_T[T](`object`: js.UndefOr[scala.Nothing], props: PropertyPath*): js.Array[T] = js.native
    @JSName("at")
    def at_T[T](`object`: Null, props: PropertyPath*): js.Array[T] = js.native
  }
  
  // Backward compatibility with --target es5
  object global {
    
    // tslint:disable-next-line:no-empty-interface
    @js.native
    trait Map[K, V] extends js.Object
    
    // tslint:disable-next-line:no-empty-interface
    @js.native
    trait Set[T] extends js.Object
    
    // tslint:disable-next-line:no-empty-interface
    @js.native
    trait WeakMap[K /* <: js.Object */, V] extends js.Object
    
    // tslint:disable-next-line:no-empty-interface
    @js.native
    trait WeakSet[T] extends js.Object
  }
  
  type List[T] = ArrayLike[T]
  
  type Many[T] = T | js.Array[T]
  
  type PartialObject[T] = GlobalPartial[T]
  
  type PropertyName = String | Double | js.Symbol
  
  type PropertyPath = Many[PropertyName]
}
