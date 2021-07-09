package typings.keyof

import typings.keyof.keyofStrings.a
import typings.keyof.keyofStrings.b
import typings.keyof.keyofStrings.c
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait B extends StObject {
  
  def foo2[T](p: /* keyof T */ String): String = js.native
  
  @JSName("foo")
  def foo_a(p: a): String = js.native
  @JSName("foo")
  def foo_b(p: b): String = js.native
  @JSName("foo")
  def foo_c(p: c): String = js.native
}
