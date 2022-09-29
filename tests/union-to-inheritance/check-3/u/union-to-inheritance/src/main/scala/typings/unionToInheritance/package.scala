package typings.unionToInheritance

import typings.std.HTMLInputElement
import typings.std.TwoFoo
import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}


/* Rewritten from type alias, can be one of: 
  - typings.unionToInheritance.unionToInheritanceStrings.a1
  - typings.unionToInheritance.unionToInheritanceStrings.a2
  - java.lang.String
*/
type A = _A | String

/* Rewritten from type alias, can be one of: 
  - typings.unionToInheritance.unionToInheritanceStrings.b1
  - typings.unionToInheritance.unionToInheritanceStrings.b2
  - scala.Double
  - typings.unionToInheritance.A
*/
type B = _B | Double | String

/* Rewritten from type alias, can be one of: 
  - typings.unionToInheritance.unionToInheritanceInts.`1`
  - typings.unionToInheritance.unionToInheritanceInts.`2`
  - typings.std.HTMLInputElement
  - js.Array[typings.unionToInheritance.B]
  - typings.unionToInheritance.B
*/
type C = _C | js.Array[B] | HTMLInputElement | Double | String

/* Rewritten from type alias, can be one of: 
  - typings.unionToInheritance.unionToInheritanceStrings.foo
  - typings.unionToInheritance.unionToInheritanceStrings.bar
  - typings.unionToInheritance.Foo[java.lang.String]
*/
type Illegal1 = _Illegal1 | Foo[String]

/* Rewritten from type alias, can be one of: 
  - typings.unionToInheritance.unionToInheritanceStrings.foo
  - typings.unionToInheritance.unionToInheritanceStrings.bar
  - typings.unionToInheritance.Foo[typings.unionToInheritance.A]
*/
type Illegal2 = _Illegal2 | Foo[A]

/* Rewritten from type alias, can be one of: 
  - typings.unionToInheritance.unionToInheritanceStrings.foo
  - typings.unionToInheritance.unionToInheritanceStrings.bar
  - typings.unionToInheritance.Foo2[T, T]
*/
type Illegal3[T] = _Illegal3[T] | (Foo2[T, T])

/* Rewritten from type alias, can be one of: 
  - typings.unionToInheritance.unionToInheritanceStrings.foo
  - typings.unionToInheritance.unionToInheritanceStrings.bar
  - typings.std.TwoFoo[T3, T1]
  - typings.unionToInheritance.Either[T2, T3]
  - typings.unionToInheritance.Foo2[T1, T3]
*/
type Test[T1, T2, T3] = (_Test[T1, T2, T3]) | (TwoFoo[T3, T1])

/* Rewritten from type alias, can be one of: 
  - typings.unionToInheritance.Test[O1, O1, O2]
  - typings.unionToInheritance.Either[O2, O1]
  - typings.unionToInheritance.Legal1[O2]
*/
type Test2[O1, O2] = (_Test2[O1, O2]) | (Test[O1, O1, O2])
