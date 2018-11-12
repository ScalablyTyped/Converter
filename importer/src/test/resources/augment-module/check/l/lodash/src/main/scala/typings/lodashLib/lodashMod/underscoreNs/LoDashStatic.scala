package typings
package lodashLib.lodashMod.underscoreNs

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// tslint:disable-next-line no-empty-interface (This will be augmented)
// add
// assign
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
  def add(augend: scala.Double, addend: scala.Double): scala.Double = js.native
  /**
       * @see _.at
       */
  def at[T /* <: js.Object */](`object`: T, props: Many[java.lang.String]*): js.Array[
    /* import warning: Failed type conversion: TsTypeLookup(TsTypeRef(TsQIdent(List(TsIdentSimple(T))),List()),Right(TsTypeKeyOf(TsTypeRef(TsQIdent(List(TsIdentSimple(T))),List())))) */js.Any
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
  /**
       * Creates an array of elements corresponding to the given keys, or indexes, of collection. Keys may be
       * specified as individual arguments or as arrays of keys.
       *
       * @param object The object to iterate over.
       * @param props The property names or indexes of elements to pick, specified individually or in arrays.
       * @return Returns the new array of picked elements.
       */
  def at[T](props: PropertyPath*): js.Array[T] = js.native
  /**
       * @see _.at
       */
  @JSName("at")
  def at_TObject[T /* <: js.Object */](props: Many[java.lang.String]*): js.Array[
    /* import warning: Failed type conversion: TsTypeLookup(TsTypeRef(TsQIdent(List(TsIdentSimple(T))),List()),Right(TsTypeKeyOf(TsTypeRef(TsQIdent(List(TsIdentSimple(T))),List())))) */js.Any
  ] = js.native
}

