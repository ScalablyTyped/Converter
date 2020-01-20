package typingsJapgolly.react.mod._Global_

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object JSX {
  // tslint:disable-next-line:no-empty-interface
  type Element = japgolly.scalajs.react.raw.React.Element
  // tslint:disable-next-line:no-empty-interface
  type IntrinsicAttributes = typingsJapgolly.react.mod.Attributes
  // tslint:disable-next-line:no-empty-interface
  type IntrinsicClassAttributes[T] = typingsJapgolly.react.mod.ClassAttributes[T]
  // We can't recurse forever because `type` can't be self-referential;
  // let's assume it's reasonable to do a single React.lazy() around a single React.memo() / vice-versa
  type LibraryManagedAttributes[C, P] = typingsJapgolly.react.mod.ReactManagedAttributes[js.Any | C, P]
}
