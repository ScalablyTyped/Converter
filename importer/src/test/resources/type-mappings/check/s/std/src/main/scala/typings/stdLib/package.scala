package typings

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object stdLib {
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
  type InstanceType[T /* <: org.scalablytyped.runtime.Instantiable1[/* args (repeated) */ js.Any, js.Any] */] = js.Any
  /**
   * Exclude null and undefined from T
   */
  type NonNullable[T] = T
  /**
   * Make all properties in T optional
   */
  type Partial[T] = stdLib.stdLibStrings.Partial with T
  /**
   * From T pick a set of properties K
   */
  type Pick[T, K /* <: java.lang.String */] = stdLib.stdLibStrings.Pick with T
  type Proxify[T] = stdLib.stdLibStrings.Proxify with T
  /**
   * Make all properties in T readonly
   */
  type Readonly[T] = stdLib.stdLibStrings.Readonly with T
  /**
   * Construct a type with a set of properties K of type T
   */
  type Record[K /* <: java.lang.String */, T] = org.scalablytyped.runtime.StringDictionary[K]
  /**
   * Make all properties in T required
   */
  type Required[T] = stdLib.stdLibStrings.Required with T
  /**
   * Obtain the return type of a function type
   */
  type ReturnType[T /* <: js.Function1[/* repeated */js.Any, _] */] = js.Any
}
