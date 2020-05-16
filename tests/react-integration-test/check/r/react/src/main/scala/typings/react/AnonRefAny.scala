package typings.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait AnonRefAny extends js.Object {
  var ref: js.UndefOr[
    /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<R, string> */ js.Any
  ] = js.native
}

object AnonRefAny {
  @scala.inline
  def apply(
    ref: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<R, string> */ js.Any = null
  ): AnonRefAny = {
    val __obj = js.Dynamic.literal()
    if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
    __obj.asInstanceOf[AnonRefAny]
  }
  @scala.inline
  implicit class AnonRefAnyOps[Self <: AnonRefAny] (val x: Self) extends AnyVal {
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    @scala.inline
    def combineWith[Other /* <: js.Any */](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    @scala.inline
    def withRef(
      ref: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify Exclude<R, string> */ js.Any
    ): Self = {
        val ret = this.duplicate.asInstanceOf[js.Dynamic]
        if (ref != null) ret.updateDynamic("ref")(ref.asInstanceOf[js.Any])
        ret.asInstanceOf[Self]
    }
    @scala.inline
    def withoutRef: Self = {
        val ret = this.duplicate
        js.special.delete(ret, "ref")
        ret.asInstanceOf[Self]
    }
  }
  
}

