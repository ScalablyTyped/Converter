package ScalablyTyped

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object StdLib {
  /**
   * Exclude from T those types that are assignable to U
   */
  type Exclude[T, U] = T
  /**
   * Extract from T those types that are assignable to U
   */
  type Extract[T, U] = T
  /**
   * Obtain the return type of a constructor function type
   */
  type InstanceType[T /* <: /* import warning: Failed type conversion: TsTypeConstructor(TsTypeFunction(TsFunSig(NoComments,List(),List(TsFunParam(NoComments,TsIdentSimple(args),Some(TsTypeRepeated(TsTypeRef(TsQIdent(List(TsIdentSimple(any))),List()))),false)),Some(TsTypeRef(TsQIdent(List(TsIdentSimple(any))),List()))))) */js.Any */] = js.Any
  /**
   * Exclude null and undefined from T
   */
  type NonNullable[T] = T
  /**
   * Make all properties in T optional
   */
  type Partial[T] = StdLib.StdLibStrings.Partial with T
  /**
   * From T pick a set of properties K
   */
  type Pick[T, K /* <: java.lang.String */] = StdLib.StdLibStrings.Pick with T
  type Proxify[T] = StdLib.StdLibStrings.Proxify with T
  /**
   * Make all properties in T readonly
   */
  type Readonly[T] = StdLib.StdLibStrings.Readonly with T
  /**
   * Construct a type with a set of properties K of type T
   */
  type Record[K /* <: java.lang.String */, T] = StdLib.StdLibStrings.Record with js.Any
  /**
   * Make all properties in T required
   */
  type Required[T] = StdLib.StdLibStrings.Required with T
  /**
   * Obtain the return type of a function type
   */
  type ReturnType[T /* <: js.Function1[/* repeated */js.Any, _] */] = js.Any
}
