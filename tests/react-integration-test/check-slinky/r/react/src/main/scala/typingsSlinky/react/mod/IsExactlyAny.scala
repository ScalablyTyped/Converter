package typingsSlinky.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

// naked 'any' type in a conditional type will short circuit and union both the then/else branches
// so boolean is only resolved for T = any
/* Rewritten from type alias, can be one of: 
  - typingsSlinky.react.reactBooleans.`false`
  - typingsSlinky.react.reactBooleans.`true`
*/
trait IsExactlyAny[T] extends js.Object

object IsExactlyAny {
  @scala.inline
  def `false`[T]: typingsSlinky.react.reactBooleans.`false` = false.asInstanceOf[typingsSlinky.react.reactBooleans.`false`]
  @scala.inline
  def `true`[T]: typingsSlinky.react.reactBooleans.`true` = true.asInstanceOf[typingsSlinky.react.reactBooleans.`true`]
}

