package typings.semanticUiReact.elementsHeaderHeaderMod

import typings.react.reactMod.FunctionComponent
import typings.react.reactMod.StatelessComponent
import typings.semanticUiReact.elementsHeaderHeaderContentMod.HeaderContentProps
import typings.semanticUiReact.elementsHeaderHeaderSubheaderMod.HeaderSubheaderProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait HeaderComponent extends FunctionComponent[HeaderProps] {
  var Content: StatelessComponent[HeaderContentProps] = js.native
  var Subheader: StatelessComponent[HeaderSubheaderProps] = js.native
}

