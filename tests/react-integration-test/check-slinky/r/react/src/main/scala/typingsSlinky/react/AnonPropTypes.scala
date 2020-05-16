package typingsSlinky.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonPropTypes extends js.Object {
  var propTypes: /* import warning: importer.ImportType#apply Failed type conversion: infer T */ js.Any = js.native
}

object AnonPropTypes {
  @scala.inline
  def apply(propTypes: /* import warning: importer.ImportType#apply Failed type conversion: infer T */ js.Any): AnonPropTypes = {
    val __obj = js.Dynamic.literal(propTypes = propTypes.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnonPropTypes]
  }
  @scala.inline
  implicit class AnonPropTypesOps[Self <: AnonPropTypes] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withPropTypes(propTypes: /* import warning: importer.ImportType#apply Failed type conversion: infer T */ js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("propTypes")(propTypes.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
  }
  
}

