package typings.expandTypeParameters

import typings.expandTypeParameters.expandTypeParametersStrings.a
import typings.expandTypeParameters.expandTypeParametersStrings.b
import typings.expandTypeParameters.expandTypeParametersStrings.c
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Example extends StObject {
  
  def expandAlias(bc: A): js.Any = js.native
  def expandAlias(bc: B): js.Any = js.native
  @JSName("expandAlias")
  def expandAlias_c(bc: c): js.Any = js.native
  
  @JSName("expandBoth")
  def expandBoth_a(bc: B, key: a, foo: Double): B = js.native
  @JSName("expandBoth")
  def expandBoth_a(bc: C, key: a, foo: Double): C = js.native
  @JSName("expandBoth")
  def expandBoth_a[T /* <: js.Object */](bc: T, key: a, foo: Double): T = js.native
  @JSName("expandBoth")
  def expandBoth_b(bc: B, key: b, foo: String): B = js.native
  @JSName("expandBoth")
  def expandBoth_b(bc: C, key: b, foo: String): C = js.native
  @JSName("expandBoth")
  def expandBoth_b[T /* <: js.Object */](bc: T, key: b, foo: String): T = js.native
  
  @JSName("expandKeyOf")
  def expandKeyOf_a(key: a, foo: Double): Double = js.native
  @JSName("expandKeyOf")
  def expandKeyOf_b(key: b, foo: String): Double = js.native
  
  def expandUnion(bc: B): B = js.native
  def expandUnion(bc: C): C = js.native
}
