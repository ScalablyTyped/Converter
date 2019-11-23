package typings.react.reactMod

import slinky.core.TagMod
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait SuspenseProps extends js.Object {
  var children: js.UndefOr[TagMod[Any]] = js.undefined
  /** A fallback react tree to show when a Suspense child (like React.lazy) suspends */
  var fallback: (/* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify NonNullable<ReactNode> */ js.Any) | Null
}

object SuspenseProps {
  @scala.inline
  def apply(
    children: TagMod[Any] = null,
    fallback: /* import warning: QualifyReferences.resolveTypeRef many Couldn't qualify NonNullable<ReactNode> */ js.Any = null
  ): SuspenseProps = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (fallback != null) __obj.updateDynamic("fallback")(fallback)
    __obj.asInstanceOf[SuspenseProps]
  }
}

