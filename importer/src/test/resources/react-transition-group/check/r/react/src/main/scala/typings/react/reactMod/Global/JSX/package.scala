package typings.react.reactMod.Global

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

package object JSX {
  import typings.react.reactMod.Attributes
  import typings.react.reactMod.ClassAttributes
  import typings.react.reactMod.ReactElement

  // tslint:disable-next-line:no-empty-interface
  type Element = ReactElement
  // tslint:disable-next-line:no-empty-interface
  type IntrinsicAttributes = Attributes
  // tslint:disable-next-line:no-empty-interface
  type IntrinsicClassAttributes[T] = ClassAttributes[T]
}
