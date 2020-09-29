package typingsSlinky.inheritanceWithIntersection.components

import slinky.web.html.`*`.tag
import typingsSlinky.StBuildingComponent
import typingsSlinky.inheritanceWithIntersection.anon.Href
import typingsSlinky.inheritanceWithIntersection.inheritanceWithIntersectionStrings.a
import typingsSlinky.inheritanceWithIntersection.inheritanceWithIntersectionStrings.button
import typingsSlinky.inheritanceWithIntersection.mod.ButtonTypeMap
import typingsSlinky.inheritanceWithIntersection.mod.ExtendButtonBaseTypeMap
import typingsSlinky.inheritanceWithIntersection.mod.OverrideProps
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

object Button {
  @JSImport("inheritance-with-intersection", "Button")
  @js.native
  object component extends js.Object
  
  @scala.inline
  class Builder (val args: js.Array[js.Any])
    extends AnyVal
       with StBuildingComponent[tag.type, js.Object] {
    @scala.inline
    def a(value: String): this.type = set("a", value.asInstanceOf[js.Any])
    @scala.inline
    def b(value: String): this.type = set("b", value.asInstanceOf[js.Any])
    @scala.inline
    def disabled(value: Boolean): this.type = set("disabled", value.asInstanceOf[js.Any])
  }
  
  def withProps(
    p: /* props */ Href with (OverrideProps[ExtendButtonBaseTypeMap[ButtonTypeMap[js.Object, button]], a])
  ): Builder = new Builder(js.Array(this.component, p.asInstanceOf[js.Any]))
  @scala.inline
  def apply(href: String): Builder = {
    val __props = js.Dynamic.literal(href = href.asInstanceOf[js.Any])
    new Builder(js.Array(this.component, __props.asInstanceOf[/* props */ Href with (OverrideProps[ExtendButtonBaseTypeMap[ButtonTypeMap[js.Object, button]], a])]))
  }
}

