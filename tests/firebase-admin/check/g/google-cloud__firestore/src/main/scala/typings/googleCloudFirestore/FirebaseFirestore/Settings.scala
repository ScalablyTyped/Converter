package typings.googleCloudFirestore.FirebaseFirestore

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
  @scala.inline
  implicit class SettingsOps[Self <: Settings] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withProjectId(projectId: String): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (projectId != null) ret.updateDynamic("projectId")(projectId.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutProjectId: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "projectId")
        ret.asInstanceOf[Self]
    }
  }
  
}

