package typings
package reactLib.reactMod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait ReactSVG extends js.Object {
  @JSName("animate")
  var animate_Original: SVGFactory = js.native
  @JSName("circle")
  var circle_Original: SVGFactory = js.native
  @JSName("clipPath")
  var clipPath_Original: SVGFactory = js.native
  def animate(): ReactSVGElement = js.native
  def animate(
    props: ClassAttributes[reactLib.SVGElement] with (SVGAttributes[reactLib.SVGElement] | scala.Null),
    children: ReactNode*
  ): ReactSVGElement = js.native
  def circle(): ReactSVGElement = js.native
  def circle(
    props: ClassAttributes[reactLib.SVGElement] with (SVGAttributes[reactLib.SVGElement] | scala.Null),
    children: ReactNode*
  ): ReactSVGElement = js.native
  def clipPath(): ReactSVGElement = js.native
  def clipPath(
    props: ClassAttributes[reactLib.SVGElement] with (SVGAttributes[reactLib.SVGElement] | scala.Null),
    children: ReactNode*
  ): ReactSVGElement = js.native
}

