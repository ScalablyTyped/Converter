package typingsSlinky.react.mod._Global_

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object JSX {
  // tslint:disable-next-line:no-empty-interface
  type Element = slinky.core.facade.ReactElement
  // tslint:disable-next-line:no-empty-interface
  type IntrinsicAttributes = typingsSlinky.react.mod.Attributes
  // tslint:disable-next-line:no-empty-interface
  type IntrinsicClassAttributes[T] = typingsSlinky.react.mod.ClassAttributes[T]
  // We can't recurse forever because `type` can't be self-referential;
  // let's assume it's reasonable to do a single React.lazy() around a single React.memo() / vice-versa
  type LibraryManagedAttributes[C, P] = typingsSlinky.react.mod.ReactManagedAttributes[js.Any | C, P]
}
