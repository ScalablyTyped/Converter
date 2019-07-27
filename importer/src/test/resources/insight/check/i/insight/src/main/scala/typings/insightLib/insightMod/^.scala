package typings.insightLib.insightMod

import typings.insightLib.insightMod.insightNs.IConfigstore
import typings.insightLib.insightMod.insightNs.IOptions
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("insight", JSImport.Namespace)
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

