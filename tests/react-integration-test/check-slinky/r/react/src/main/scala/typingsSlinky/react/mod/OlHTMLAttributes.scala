package typingsSlinky.react.mod

import typingsSlinky.react.reactStrings.A
import typingsSlinky.react.reactStrings.I
import typingsSlinky.react.reactStrings.`1`
import typingsSlinky.react.reactStrings.a_
import typingsSlinky.react.reactStrings.i_
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait OlHTMLAttributes[T] extends HTMLAttributes[T] {
  
  var reversed: js.UndefOr[Boolean] = js.native
  
  var start: js.UndefOr[Double] = js.native
  
  var `type`: js.UndefOr[`1` | a_ | A | i_ | I] = js.native
}
object OlHTMLAttributes {
  
  @scala.inline
  def apply[T](): OlHTMLAttributes[T] = {
    val __obj = js.Dynamic.literal()
    __obj.asInstanceOf[OlHTMLAttributes[T]]
  }
  
  @scala.inline
  implicit class OlHTMLAttributesOps[Self <: OlHTMLAttributes[_], T] (val x: Self with OlHTMLAttributes[T]) extends AnyVal {
    
    @scala.inline
    def duplicate: Self = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x)).asInstanceOf[Self]
    
    @scala.inline
    def combineWith[Other <: js.Any](other: Other): Self with Other = (js.Dynamic.global.Object.assign(js.Dynamic.literal(), x, other.asInstanceOf[js.Any])).asInstanceOf[Self with Other]
    
    @scala.inline
    def set(key: String, value: js.Any): Self = {
      x.asInstanceOf[js.Dynamic].updateDynamic(key)(value)
      x
    }
    
    @scala.inline
    def setReversed(value: Boolean): Self = this.set("reversed", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteReversed: Self = this.set("reversed", js.undefined)
    
    @scala.inline
    def setStart(value: Double): Self = this.set("start", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteStart: Self = this.set("start", js.undefined)
    
    @scala.inline
    def setType(value: `1` | a_ | A | i_ | I): Self = this.set("type", value.asInstanceOf[js.Any])
    
    @scala.inline
    def deleteType: Self = this.set("type", js.undefined)
  }
}
