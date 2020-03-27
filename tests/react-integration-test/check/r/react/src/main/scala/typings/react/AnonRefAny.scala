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
}

