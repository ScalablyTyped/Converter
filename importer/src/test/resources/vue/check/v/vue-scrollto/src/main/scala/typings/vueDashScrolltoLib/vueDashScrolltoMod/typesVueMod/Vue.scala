package typings.vueDashScrolltoLib.vueDashScrolltoMod.typesVueMod

import typings.stdLib.Element
import typings.vueDashScrolltoLib.vueDashScrolltoMod.Options
import typings.vueDashScrolltoLib.vueDashScrolltoMod.VueStatic
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Vue extends js.Object {
  @JSName("$scrollTo")
  var $scrollTo_Original: VueStatic = js.native
  @JSName("$scrollTo")
  def $scrollTo(element: String): Unit = js.native
  @JSName("$scrollTo")
  def $scrollTo(element: String, duration: Double): Unit = js.native
  @JSName("$scrollTo")
  def $scrollTo(element: String, duration: Double, options: Options): Unit = js.native
  @JSName("$scrollTo")
  def $scrollTo(element: String, options: Options): Unit = js.native
  @JSName("$scrollTo")
  def $scrollTo(element: Element): Unit = js.native
  @JSName("$scrollTo")
  def $scrollTo(element: Element, duration: Double): Unit = js.native
  @JSName("$scrollTo")
  def $scrollTo(element: Element, duration: Double, options: Options): Unit = js.native
  @JSName("$scrollTo")
  def $scrollTo(element: Element, options: Options): Unit = js.native
  @JSName("$scrollTo")
  def $scrollTo(options: Options): Unit = js.native
}

