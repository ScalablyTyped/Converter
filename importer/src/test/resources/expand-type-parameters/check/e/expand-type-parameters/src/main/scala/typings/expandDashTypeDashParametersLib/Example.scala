package typings
package expandDashTypeDashParametersLib

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Example extends js.Object {
  def expandAlias(bc: A): js.Any = js.native
  def expandAlias(bc: B): js.Any = js.native
  @JSName("expandAlias")
  def expandAlias_c(bc: expandDashTypeDashParametersLib.expandDashTypeDashParametersLibStrings.c): js.Any = js.native
  @JSName("expandBoth")
  def expandBoth_a(
    bc: B,
    key: expandDashTypeDashParametersLib.expandDashTypeDashParametersLibStrings.a,
    foo: scala.Double
  ): B = js.native
  @JSName("expandBoth")
  def expandBoth_a(
    bc: C,
    key: expandDashTypeDashParametersLib.expandDashTypeDashParametersLibStrings.a,
    foo: scala.Double
  ): C = js.native
  @JSName("expandBoth")
  def expandBoth_a[T /* <: js.Object */](
    bc: T,
    key: expandDashTypeDashParametersLib.expandDashTypeDashParametersLibStrings.a,
    foo: scala.Double
  ): T = js.native
  @JSName("expandBoth")
  def expandBoth_b(
    bc: B,
    key: expandDashTypeDashParametersLib.expandDashTypeDashParametersLibStrings.b,
    foo: java.lang.String
  ): B = js.native
  @JSName("expandBoth")
  def expandBoth_b(
    bc: C,
    key: expandDashTypeDashParametersLib.expandDashTypeDashParametersLibStrings.b,
    foo: java.lang.String
  ): C = js.native
  @JSName("expandBoth")
  def expandBoth_b[T /* <: js.Object */](
    bc: T,
    key: expandDashTypeDashParametersLib.expandDashTypeDashParametersLibStrings.b,
    foo: java.lang.String
  ): T = js.native
  @JSName("expandKeyOf")
  def expandKeyOf_a(key: expandDashTypeDashParametersLib.expandDashTypeDashParametersLibStrings.a, foo: scala.Double): scala.Double = js.native
  @JSName("expandKeyOf")
  def expandKeyOf_b(
    key: expandDashTypeDashParametersLib.expandDashTypeDashParametersLibStrings.b,
    foo: java.lang.String
  ): scala.Double = js.native
  def expandUnion(bc: B): B = js.native
  def expandUnion(bc: C): C = js.native
}

