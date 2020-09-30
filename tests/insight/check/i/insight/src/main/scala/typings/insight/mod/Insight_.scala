package typings.insight.mod

import typings.insight.mod.insight.IConfigstore
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Insight_ extends js.Object {
  var clientId: String = js.native
  var config: IConfigstore = js.native
  var optOut: Boolean = js.native
  def track(args: String*): Unit = js.native
}

object Insight_ {
  @scala.inline
  def apply(clientId: String, config: IConfigstore, optOut: Boolean, track: /* repeated */ String => Unit): Insight_ = {
    val __obj = js.Dynamic.literal(clientId = clientId.asInstanceOf[js.Any], config = config.asInstanceOf[js.Any], optOut = optOut.asInstanceOf[js.Any], track = js.Any.fromFunction1(track))
    __obj.asInstanceOf[Insight_]
  }
  @scala.inline
  implicit class Insight_Ops[Self <: Insight_] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def set(key: String, value: js.Any): Self = {
        x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
        x
    }
    @scala.inline
    def setClientId(value: String): Self = this.set("clientId", value.asInstanceOf[js.Any])
    @scala.inline
    def setConfig(value: IConfigstore): Self = this.set("config", value.asInstanceOf[js.Any])
    @scala.inline
    def setOptOut(value: Boolean): Self = this.set("optOut", value.asInstanceOf[js.Any])
    @scala.inline
    def setTrack(value: /* repeated */ String => Unit): Self = this.set("track", js.Any.fromFunction1(value))
  }
  
}

