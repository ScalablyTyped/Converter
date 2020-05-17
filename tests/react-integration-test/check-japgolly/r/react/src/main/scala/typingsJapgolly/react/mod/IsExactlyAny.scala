package typingsJapgolly.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// naked 'any' type in a conditional type will short circuit and union both the then/else branches
// so boolean is only resolved for T = any
/* Rewritten from type alias, can be one of: 
  - typingsJapgolly.react.reactBooleans.`false`
  - typingsJapgolly.react.reactBooleans.`true`
*/
trait IsExactlyAny[T] extends js.Object

object IsExactlyAny {
  @scala.inline
  def `false`[T]: typingsJapgolly.react.reactBooleans.`false` = false.asInstanceOf[typingsJapgolly.react.reactBooleans.`false`]
  @scala.inline
  def `true`[T]: typingsJapgolly.react.reactBooleans.`true` = true.asInstanceOf[typingsJapgolly.react.reactBooleans.`true`]
}

