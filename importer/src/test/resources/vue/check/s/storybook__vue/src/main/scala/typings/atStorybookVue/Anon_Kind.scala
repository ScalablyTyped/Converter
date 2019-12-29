package typings.atStorybookVue

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait Anon_Kind extends js.Object {
  var kind: String = js.native
  var story: String = js.native
}

object Anon_Kind {
  @scala.inline
  def apply(kind: String, story: String): Anon_Kind = {
    val __obj = js.Dynamic.literal(kind = kind.asInstanceOf[js.Any], story = story.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[Anon_Kind]
  }
}

