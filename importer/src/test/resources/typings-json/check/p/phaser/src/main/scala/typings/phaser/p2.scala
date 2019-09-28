package typings.phaser

import scala.scalajs.js.annotation.JSGlobal
import typings.phaser.p2.AABB
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSGlobal("p2")
@js.native
object p2 extends js.Object {
  @js.native
  class AABB () extends js.Object {
    def this(options: Anon_LowerBound) = this()
    def copy(aabb: AABB): Unit = js.native
  }
  
}

