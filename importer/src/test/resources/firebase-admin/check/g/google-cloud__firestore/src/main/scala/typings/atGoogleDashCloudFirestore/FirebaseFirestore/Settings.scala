package typings.atGoogleDashCloudFirestore.FirebaseFirestore

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Settings extends js.Object {
  var projectId: js.UndefOr[String] = js.native
}

object Settings {
  @scala.inline
  def apply(projectId: String = null): Settings = {
    val __obj = js.Dynamic.literal()
    if (projectId != null) __obj.updateDynamic("projectId")(projectId.asInstanceOf[js.Any])
    __obj.asInstanceOf[Settings]
  }
}

