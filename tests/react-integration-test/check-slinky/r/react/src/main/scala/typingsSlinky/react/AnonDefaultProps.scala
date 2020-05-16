package typingsSlinky.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonDefaultProps extends js.Object {
  var defaultProps: /* import warning: importer.ImportType#apply Failed type conversion: infer D */ js.Any = js.native
  var propTypes: /* import warning: importer.ImportType#apply Failed type conversion: infer T */ js.Any = js.native
}

object AnonDefaultProps {
  @scala.inline
  def apply(
    defaultProps: /* import warning: importer.ImportType#apply Failed type conversion: infer D */ js.Any,
    propTypes: /* import warning: importer.ImportType#apply Failed type conversion: infer T */ js.Any
  ): AnonDefaultProps = {
    val __obj = js.Dynamic.literal(defaultProps = defaultProps.asInstanceOf[js.Any], propTypes = propTypes.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnonDefaultProps]
  }
  @scala.inline
  implicit class AnonDefaultPropsOps[Self <: AnonDefaultProps] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withDefaultProps(
      defaultProps: /* import warning: importer.ImportType#apply Failed type conversion: infer D */ js.Any
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("defaultProps")(defaultProps.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withPropTypes(propTypes: /* import warning: importer.ImportType#apply Failed type conversion: infer T */ js.Any): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        ret.updateDynamic("propTypes")(propTypes.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
  }
  
}

