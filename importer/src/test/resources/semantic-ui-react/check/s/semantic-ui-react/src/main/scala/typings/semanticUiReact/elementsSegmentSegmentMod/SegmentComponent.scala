package typings.semanticUiReact.elementsSegmentSegmentMod

import typings.react.reactMod.FunctionComponent
import typings.react.reactMod.StatelessComponent
import typings.semanticUiReact.elementsSegmentSegmentGroupMod.SegmentGroupProps
import typings.semanticUiReact.elementsSegmentSegmentInlineMod.SegmentInlineComponent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait SegmentComponent extends FunctionComponent[SegmentProps] {
  var Group: StatelessComponent[SegmentGroupProps] = js.native
  var Inline: SegmentInlineComponent = js.native
}

