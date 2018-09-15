package ScalablyTyped
package VueDashScrolltoLib.VueDashScrolltoModule.VueScrollToNamespace

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._


trait Options extends js.Object {
  // Indicates if user can cancel the scroll or not. Default: true
  val cancelable: js.UndefOr[scala.Boolean] = js.undefined
  // The container that has to be scrolled. Default: body
  val container: js.UndefOr[java.lang.String | StdLib.Node] = js.undefined
  // The duration (in milliseconds) of the scrolling animation. Default: 500
  val duration: js.UndefOr[scala.Double] = js.undefined
  // The easing to be used when animating. Default: ease
  val easing: js.UndefOr[java.lang.String] = js.undefined
  // The element you want to scroll to.
  val el: js.UndefOr[java.lang.String | StdLib.Node] = js.undefined
  val element: js.UndefOr[java.lang.String | StdLib.Node] = js.undefined
  // The offset that should be applied when scrolling. Default: 0
  val offset: js.UndefOr[scala.Double] = js.undefined
  // A callback function that should be called when scrolling has been aborted by the user (user scrolled, clicked
  // etc.). Default: noop
  val onCancel: js.UndefOr[js.Function0[scala.Unit] | VueDashScrolltoLib.VueDashScrolltoLibNumbers.`false`] = js.undefined
  // A callback function that should be called when scrolling has ended. Default: noop
  val onDone: js.UndefOr[js.Function0[scala.Unit] | VueDashScrolltoLib.VueDashScrolltoLibNumbers.`false`] = js.undefined
  // Whether or not we want scrolling on the x axis. Default: true
  val x: js.UndefOr[scala.Boolean] = js.undefined
  // Whether or not we want scrolling on the y axis. Default: true
  val y: js.UndefOr[scala.Boolean] = js.undefined
}

