package typings.sax.mod

import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation._

@js.native
trait QualifiedAttribute extends QualifiedName {
  var value: String = js.native
}

object QualifiedAttribute {
  @scala.inline
  def apply(local: String, name: String, prefix: String, uri: String, value: String): QualifiedAttribute = {
    val __obj = js.Dynamic.literal(local = local.asInstanceOf[js.Any], name = name.asInstanceOf[js.Any], prefix = prefix.asInstanceOf[js.Any], uri = uri.asInstanceOf[js.Any], value = value.asInstanceOf[js.Any])
  
    __obj.asInstanceOf[QualifiedAttribute]
  }
}

