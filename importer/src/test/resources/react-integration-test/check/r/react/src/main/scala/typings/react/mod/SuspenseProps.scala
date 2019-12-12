package typings.react.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

trait SuspenseProps extends js.Object {
  var children: js.UndefOr[ReactNode] = js.undefined
  /** A fallback react tree to show when a Suspense child (like React.lazy) suspends */
  var fallback: (/* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify NonNullable<ReactNode> */ js.Any) | Null
}

object SuspenseProps {
  @scala.inline
  def apply(
    children: ReactNode = null,
    fallback: /* import warning: transforms.QualifyReferences#resolveTypeRef many Couldn't qualify NonNullable<ReactNode> */ js.Any = null
  ): SuspenseProps = {
    val __obj = js.Dynamic.literal()
    if (children != null) __obj.updateDynamic("children")(children.asInstanceOf[js.Any])
    if (fallback != null) __obj.updateDynamic("fallback")(fallback.asInstanceOf[js.Any])
    __obj.asInstanceOf[SuspenseProps]
  }
}

