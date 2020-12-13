package typings

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.`|`
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

package object unionToInheritance {
  
  /* Rewritten from type alias, can be one of: 
    - typings.unionToInheritance.unionToInheritanceStrings.a1
    - typings.unionToInheritance.unionToInheritanceStrings.a2
    - java.lang.String
  */
  type A = typings.unionToInheritance._A | java.lang.String
  
  /* Rewritten from type alias, can be one of: 
    - typings.unionToInheritance.unionToInheritanceStrings.b1
    - typings.unionToInheritance.unionToInheritanceStrings.b2
    - scala.Double
    - typings.unionToInheritance.A
  */
  type B = typings.unionToInheritance._B | scala.Double | java.lang.String
  
  /* Rewritten from type alias, can be one of: 
    - typings.unionToInheritance.unionToInheritanceNumbers.`1`
    - typings.unionToInheritance.unionToInheritanceNumbers.`2`
    - typings.std.HTMLInputElement
    - js.Array[typings.unionToInheritance.B]
    - typings.unionToInheritance.B
  */
  type C = typings.unionToInheritance._C | js.Array[typings.unionToInheritance.B] | typings.std.HTMLInputElement | scala.Double | java.lang.String
  
  /* Rewritten from type alias, can be one of: 
    - typings.unionToInheritance.unionToInheritanceStrings.foo
    - typings.unionToInheritance.unionToInheritanceStrings.bar
    - typings.unionToInheritance.Foo[java.lang.String]
  */
  type Illegal1 = typings.unionToInheritance._Illegal1 | typings.unionToInheritance.Foo[java.lang.String]
  
  /* Rewritten from type alias, can be one of: 
    - typings.unionToInheritance.unionToInheritanceStrings.foo
    - typings.unionToInheritance.unionToInheritanceStrings.bar
    - typings.unionToInheritance.Foo[typings.unionToInheritance.A]
  */
  type Illegal2 = typings.unionToInheritance._Illegal2 | typings.unionToInheritance.Foo[typings.unionToInheritance.A]
  
  /* Rewritten from type alias, can be one of: 
    - typings.unionToInheritance.unionToInheritanceStrings.foo
    - typings.unionToInheritance.unionToInheritanceStrings.bar
    - typings.unionToInheritance.Foo2[T, T]
  */
  type Illegal3[T] = typings.unionToInheritance._Illegal3[T] | (typings.unionToInheritance.Foo2[T, T])
  
  /* Rewritten from type alias, can be one of: 
    - typings.unionToInheritance.unionToInheritanceStrings.foo
    - typings.unionToInheritance.unionToInheritanceStrings.bar
    - typings.std.TwoFoo[T3, T1]
    - typings.unionToInheritance.Either[T2, T3]
    - typings.unionToInheritance.Foo2[T1, T3]
  */
  type Test[T1, T2, T3] = (typings.unionToInheritance._Test[T1, T2, T3]) | (typings.std.TwoFoo[T3, T1])
  
  /* Rewritten from type alias, can be one of: 
    - typings.unionToInheritance.Test[O1, O1, O2]
    - typings.unionToInheritance.Either[O2, O1]
    - typings.unionToInheritance.Legal1[O2]
  */
  type Test2[O1, O2] = (typings.unionToInheritance._Test2[O1, O2]) | (typings.unionToInheritance.Test[O1, O1, O2])
}
