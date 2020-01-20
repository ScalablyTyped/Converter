package typings.webpackEnv

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object WebpackModuleApi {
  type ModuleId = String | Double
  type Require1 = js.Function1[/* id */ String, js.Any]
  type Require2 = js.Function1[/* id */ String, js.Any]
  type RequireLambda = Require1 with Require2
}
