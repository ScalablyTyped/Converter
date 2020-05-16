package typingsSlinky.stardustUiReactComponentRef.components

import slinky.core.facade.ReactRef
import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@scala.inline
class SharedBuilder_RefProps1237054395[R <: js.Object] (val args: js.Array[js.Any])
  extends AnyVal
     with StBuildingComponent[tag.type, R] {
  @scala.inline
  def innerRefRefObject(value: ReactRef[_]): this.type = set("innerRef", value.asInstanceOf[js.Any])
  @scala.inline
  def innerRefFunction1(value: /* instance */ _ | Null => Unit): this.type = set("innerRef", js.Any.fromFunction1(value))
  @scala.inline
  def innerRef(value: typingsSlinky.react.mod.Ref[_]): this.type = set("innerRef", value.asInstanceOf[js.Any])
  @scala.inline
  def innerRefNull: this.type = set("innerRef", null)
}

