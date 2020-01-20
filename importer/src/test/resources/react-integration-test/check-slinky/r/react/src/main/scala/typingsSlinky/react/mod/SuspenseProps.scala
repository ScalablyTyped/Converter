package typingsSlinky.react.mod

import slinky.core.TagMod
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SuspenseProps extends js.Object {
  var children: js.UndefOr[TagMod[Any]] = js.native
  /** A fallback react tree to show when a Suspense child (like React.lazy) suspends */
  var fallback: (/* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify NonNullable<ReactNode> */ js.Any) | Null = js.native
}

object SuspenseProps {
  @scala.inline
  def apply(
    children: TagMod[Any] = null,
    fallback: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify NonNullable<ReactNode> */ js.Any = null
  ): SuspenseProps = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (fallback != null) __obj.updateDynamic("fallback")(fallback.asInstanceOf[js.Any])
    __obj.asInstanceOf[SuspenseProps]
  }
}

