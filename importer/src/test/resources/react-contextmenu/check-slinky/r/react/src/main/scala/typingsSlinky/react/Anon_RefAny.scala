package typingsSlinky.react

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait Anon_RefAny extends js.Object {
  var ref: js.UndefOr[
    /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Exclude<R, string> */ js.Any
  ] = js.undefined
}

object Anon_RefAny {
  @scala.inline
  def apply(
    ref: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify Exclude<R, string> */ js.Any = null
  ): Anon_RefAny = {
    val __obj = js.Dynamic.literal()
    if (ref != null) __obj.updateDynamic("ref")(ref.asInstanceOf[js.Any])
    __obj.asInstanceOf[Anon_RefAny]
  }
}

