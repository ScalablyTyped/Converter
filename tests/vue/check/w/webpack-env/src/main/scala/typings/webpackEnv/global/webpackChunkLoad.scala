package typings.webpackEnv.global

import typings.webpackEnv.WebpackModuleApi.RequireLambda
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSGlobal("__webpack_chunk_load__")
@js.native
object webpackChunkLoad extends js.Object {
  /**
    * The internal chunk loading function
    *
    * @param chunkId The id for the chunk to load.
    * @param callback A callback function called once the chunk is loaded.
    */
  def apply(chunkId: js.Any, callback: js.Function1[/* require */ RequireLambda, Unit]): Unit = js.native
}

