package typings.insight.insightMod

import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.annotation.JSImport.Namespace
import typings.insight.insightMod.insight.IConfigstore
import typings.insight.insightMod.insight.IOptions
import scala.scalajs.js
import scala.scalajs.js.`|`

@JSImport("insight", Namespace)
@js.native
class ^ protected () extends Insight {
  def this(options: IOptions) = this()
  /* CompleteClass */
  override var clientId: String = js.native
  /* CompleteClass */
  override var config: IConfigstore = js.native
  /* CompleteClass */
  override var optOut: Boolean = js.native
  /* CompleteClass */
  override def track(args: String*): Unit = js.native
}

