package typings
package mongooseDashSimpleDashRandomLib.mongooseDashSimpleDashRandomMod.mongooseMod

import mongooseLib.mongooseMod.Document
import mongooseLib.mongooseMod.ModelProperties
import nodeLib.NodeJSNs.EventEmitter
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Model[T /* <: Document */]
  extends EventEmitter
     with ModelProperties {
  def findRandom(conditions: js.Object): Unit = js.native
  def findRandom(conditions: js.Object, projection: js.Object): Unit = js.native
  def findRandom(conditions: js.Object, projection: js.Object, options: js.Object): Unit = js.native
  def findRandom(
    conditions: js.Object,
    projection: js.Object,
    options: js.Object,
    callback: js.Function2[/* err */ js.Any, /* res */ js.UndefOr[js.Array[T]], Unit]
  ): Unit = js.native
  def findRandom(
    conditions: js.Object,
    projection: js.Object,
    options: Null,
    callback: js.Function2[/* err */ js.Any, /* res */ js.UndefOr[js.Array[T]], Unit]
  ): Unit = js.native
  def findRandom(conditions: js.Object, projection: Null, options: js.Object): Unit = js.native
  def findRandom(
    conditions: js.Object,
    projection: Null,
    options: js.Object,
    callback: js.Function2[/* err */ js.Any, /* res */ js.UndefOr[js.Array[T]], Unit]
  ): Unit = js.native
  def findRandom(
    conditions: js.Object,
    projection: Null,
    options: Null,
    callback: js.Function2[/* err */ js.Any, /* res */ js.UndefOr[js.Array[T]], Unit]
  ): Unit = js.native
}

