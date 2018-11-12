package typings
package insightLib.insightMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@JSImport("insight", JSImport.Namespace)
@js.native
class namespaced protected () extends Insight {
  def this(options: insightLib.insightMod.insightNs.IOptions) = this()
  /* CompleteClass */
  override var clientId: java.lang.String = js.native
  /* CompleteClass */
  override var config: insightLib.insightMod.insightNs.IConfigstore = js.native
  /* CompleteClass */
  override var optOut: scala.Boolean = js.native
  /* CompleteClass */
  override def track(args: java.lang.String*): scala.Unit = js.native
}

