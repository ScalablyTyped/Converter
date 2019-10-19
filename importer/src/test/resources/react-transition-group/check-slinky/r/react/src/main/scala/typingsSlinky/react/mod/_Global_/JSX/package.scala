package typingsSlinky.react.mod._Global_

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object JSX {
  import slinky.core.facade.ReactElement
  import typingsSlinky.react.mod.Attributes
  import typingsSlinky.react.mod.ClassAttributes

  // tslint:disable-next-line:no-empty-interface
  type Element = ReactElement
  // tslint:disable-next-line:no-empty-interface
  type IntrinsicAttributes = Attributes
  // tslint:disable-next-line:no-empty-interface
  type IntrinsicClassAttributes[T] = ClassAttributes[T]
}
