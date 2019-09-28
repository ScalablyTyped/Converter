package typings.chartDotJs.chartDotJsMod

import org.scalablytyped.runtime.StringDictionary
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.annotation.JSImport.Namespace
import typings.chartDotJs.Anon_Global
import typings.chartDotJs.TypeofClassChart
import typings.std.ArrayLike
import typings.std.CanvasRenderingContext2D
import typings.std.HTMLCanvasElement
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSImport("chart.js", Namespace)
@js.native
class ^ protected () extends Chart {
  def this(context: String, options: js.Any) = this()
  def this(context: ArrayLike[CanvasRenderingContext2D | HTMLCanvasElement], options: js.Any) = this()
  def this(context: CanvasRenderingContext2D, options: js.Any) = this()
  def this(context: HTMLCanvasElement, options: js.Any) = this()
}

@JSImport("chart.js", Namespace)
@js.native
object ^ extends js.Object {
  val Chart: TypeofClassChart = js.native
  var controllers: StringDictionary[js.Any] = js.native
  var defaults: Anon_Global = js.native
}

