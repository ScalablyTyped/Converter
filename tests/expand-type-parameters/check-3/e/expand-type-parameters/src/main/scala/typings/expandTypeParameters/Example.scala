package typings.expandTypeParameters

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

@js.native
trait Example extends StObject {
  
  @JSName("expandAlias")
  @scala.annotation.targetName("expandAlias_c")
  def expandAlias(bc: "c"): Any = js.native
  def expandAlias(bc: A): Any = js.native
  def expandAlias(bc: B): Any = js.native
  
  @JSName("expandBoth")
  @scala.annotation.targetName("expandBoth_b")
  def expandBoth(bc: B, key: "b", foo: String): B = js.native
  @JSName("expandBoth")
  @scala.annotation.targetName("expandBoth_a")
  def expandBoth(bc: B, key: "a", foo: Double): B = js.native
  @JSName("expandBoth")
  @scala.annotation.targetName("expandBoth_b")
  def expandBoth(bc: C, key: "b", foo: String): C = js.native
  @JSName("expandBoth")
  @scala.annotation.targetName("expandBoth_a")
  def expandBoth(bc: C, key: "a", foo: Double): C = js.native
  @JSName("expandBoth")
  @scala.annotation.targetName("expandBoth_b")
  def expandBoth[T /* <: js.Object */](bc: T, key: "b", foo: String): T = js.native
  @JSName("expandBoth")
  @scala.annotation.targetName("expandBoth_a")
  def expandBoth[T /* <: js.Object */](bc: T, key: "a", foo: Double): T = js.native
  
  @JSName("expandKeyOf")
  @scala.annotation.targetName("expandKeyOf_b")
  def expandKeyOf(key: "b", foo: String): Double = js.native
  @JSName("expandKeyOf")
  @scala.annotation.targetName("expandKeyOf_a")
  def expandKeyOf(key: "a", foo: Double): Double = js.native
  
  def expandUnion(bc: B): B = js.native
  def expandUnion(bc: C): C = js.native
}
